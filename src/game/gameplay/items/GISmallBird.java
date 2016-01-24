package game.gameplay.items;

import game.GMain;

/**
 * Created by Ramon on 1/18/16.
 */
public class GISmallBird extends GItem {

    public GISmallBird() {
        names =  new String[] {"small bird", "bird", "blue bird"};
        pickupAble = true;
    }

    @Override
    public void pickUp(GItem with) {
        super.pickUp(with);
        GMain.mainGGame.mainGFrame.consoleAdd("\nUnfortunately it is dead, maybe you can eat it.");
    }

    @Override
    public void eat(GItem with) {
        if(with instanceof GISpoon) {
            GMain.mainGGame.mainGFrame.consoleWrite("Gosh, that tastes bad! Spoon was useful though.");
        }
        else {
            GMain.mainGGame.mainGFrame.consoleWrite("Eww! It tastes horrible! At least its a little protein. Hard eating with hands!");
        }
    }

    @Override
    public void drink(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("Drink? What? Its blood? No thanks!");
    }

    @Override
    public void throwItem(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("Wow, that was harsh!");
    }

    @Override
    public void kill(GItem with) {
        if(with instanceof GISpoon) {
            GMain.mainGGame.mainGFrame.consoleWrite("A Spoon! You killed the bird with a spoon!");
        }
        else if(with instanceof GISmallWoodenBox) {
            GMain.mainGGame.mainGFrame.consoleWrite("You crushed the bird with the box!");
        }
        else {
            GMain.mainGGame.mainGFrame.consoleWrite("That was gruesome, you killed the bird with your bare hands.");
        }
    }
}
