package game.gameplay.items;

import game.GMain;

/**
 * Created by Ramon on 1/18/16.
 */
public class GISmallWoodenBox extends GItem {

    public GISmallWoodenBox() {
        names = new String[] {"box", "wooden box"};
        pickupAble = true;
    }

    @Override
    public void pickUp(GItem with) {
        super.pickUp(with);
        GMain.mainGGame.mainGFrame.consoleAddLine("A wooden box... could put things in it maybe.");
        System.out.println("Final print");
    }

    @Override
    public void breakItem(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("Well done, you broke it, now what is it useful for?");
    }

    @Override
    public void eat(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("A Box? Sorry I can't eat a box...");
    }

    @Override
    public void drink(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("You want me to drink the box? Really? Nah sorry not doing that.");
    }

    @Override
    public void lookAt(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("Ooohh pretty... a box...");
    }
}
