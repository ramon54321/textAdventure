package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauCliftonPoint extends GLocation {
    public GLNassauCliftonPoint(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Clifton Point";
        this.xPos = -17;
        this.yPos = -7;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau West Hills", true);
    }
}
