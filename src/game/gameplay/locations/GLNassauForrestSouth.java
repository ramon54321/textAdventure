package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauForrestSouth extends GLocation {
    public GLNassauForrestSouth(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Forrest South";
        this.xPos = 0;
        this.yPos = 0;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Suburb East", true);
        makeConnectionTo("Nassau Captain Flints Cove", true);
    }
}
