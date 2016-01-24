package game.gameplay.items;

import game.GCommandMode;
import game.GMain;

import java.util.ArrayList;

/**
 * Created by Ramon on 1/18/16.
 */
public class GINavigationManual extends GItem {

    public GINavigationManual() {
        names =  new String[] {"nav book", "navigation book", "navigation manual"};
        pickupAble = true;
        pages.add("Welcome to the book of the Pirate.\n\nStep 1: How to shoot the cannon!\n\tFire!!!");
        pages.add("Pirate book, page 2!\n\nStep 2: Bang!!!");
        pages.add("Pirate book, page 3");
        pages.add("Pirate book, page 4");
        pages.add("Pirate book, page 5");
        pages.add("Pirate book, page 6");
    }

    @Override
    public void pickUp(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("You picked up the spoon. Could come in handy.");
    }

    @Override
    public void read(GItem with) {
        readInit();
    }

    @Override
    public void throwItem(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("Pretty pointless...");
    }
}
