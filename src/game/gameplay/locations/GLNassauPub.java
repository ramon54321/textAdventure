package game.gameplay.locations;

import game.GGame;
import game.GMain;
import game.gameplay.items.GIBarTenderNassauPub;

/**
 * Created by Ramon and Santeri on 1/19/16.
 */
public class GLNassauPub extends GLocation {
    public GLNassauPub(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Pub";
        this.xPos = 0;
        this.yPos = -1;
        addItems();
    }

    private void addItems() {
        items.add(new GIBarTenderNassauPub());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Port", true);
        makeConnectionTo("Nassau Marsh", true);
        makeConnectionTo("Nassau Town Square", true);
    }

    @Override
    public void showEntryInfo() {
        GMain.mainGGame.mainGFrame.consoleAdd("\n\nThe pub is mostly empty, except for the quirky-looking bartender. \nYou should probably talk to him...");
    }
}
