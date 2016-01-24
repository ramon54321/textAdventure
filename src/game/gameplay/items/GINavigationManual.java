package game.gameplay.items;

import game.GMain;

/**
 * Created by Ramon on 1/18/16.
 */
public class GINavigationManual extends GItem {

    public GINavigationManual() {
        names =  new String[] {"nav book", "navigation book", "navigation manual"};
        pickupAble = true;
    }

    @Override
    public void pickUp(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("You picked up the spoon. Could come in handy.");
    }

    @Override
    public void read(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("This is a very interesting book, I should keep reading!");
    }

    @Override
    public void throwItem(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("Pretty pointless...");
    }
}
