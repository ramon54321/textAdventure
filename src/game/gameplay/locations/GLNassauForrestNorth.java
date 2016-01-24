package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauForrestNorth extends GLocation {
    public GLNassauForrestNorth(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Forrest North";
        this.xPos = 0;
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
}
