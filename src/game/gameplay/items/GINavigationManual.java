package game.gameplay.items;

import game.GMain;

/**
 * Created by Ramon on 1/18/16.
 *
 * Basic book that will orient the player
 *
 */
public class GINavigationManual extends GItem {

    public GINavigationManual() {
        names =  new String[] {"nav book", "navigation book", "navigation manual"};
        pickupAble = true;
        pages.add("Welcome to the island of New Providence, and the gold rich town of Nassau." +
                " Lets start with a little overview of the area.\nYou can move around by typing 'go to' + 'location', such as 'go to nassau pub'." +
                " You can only move along the paths shown on the map... mostly.\nYou can pick up and interact with items in your inventory and items " +
                "in the location you are currently in.\nYou can see what there is in your location and inventory by typing 'what is here' and " +
                "'what do I have' respectively.\n\n\n\ta) Previous Page\td) Next Page\t\tq) Quit Reading");
        pages.add("Pirate book, page 2");
        pages.add("Pirate book, page 3");
        pages.add("Pirate book, page 4");
        pages.add("Pirate book, page 5");
        pages.add("Pirate book, page 6");
    }

    @Override
    public void pickUp(GItem with) {
        super.pickUp(with);
        GMain.mainGGame.mainGFrame.consoleAdd("\nA navigation manual, could always come in handy.");
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
