package game.gameplay.items;

import game.GMain;

/**
 * Created by Ramon on 1/18/16.
 */
public class GISpoon extends GItem {

    public GISpoon() {
        names =  new String[] {"spoon", "metal spoon", "old spoon"};
        pickupAble = true;
    }

    @Override
    public void pickUp(GItem with) {
        super.pickUp(with);
        GMain.mainGGame.mainGFrame.consoleAddLine("Could come in handy.");
    }

    @Override
    public void eat(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("I can't chew metal.");
    }

    @Override
    public void drink(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("Its metal, not drinking that.");
    }

    @Override
    public void throwItem(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("Pretty pointless...");
    }
}
