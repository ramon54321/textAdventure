package game.gameplay.locations;

import game.GGame;
import game.gameplay.events.conversations.GLEventNassauForestNorth;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauForrestNorth extends GLocation {
    public GLNassauForrestNorth(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Forest North";
        this.xPos = 8;
        this.yPos = 0;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Flamingo Lagoon", true);
    }

    @Override
    public void startEntryEvent() {
        new GLEventNassauForestNorth(true);
    }
}
