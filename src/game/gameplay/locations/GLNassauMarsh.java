package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauMarsh extends GLocation {
    public GLNassauMarsh(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Marsh";
        this.xPos = -4;
        this.yPos = -1;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Pub", true);
        makeConnectionTo("Nassau Town Square", true);
        makeConnectionTo("Nassau West Hills", true);
    }
}
