package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauFlamingoLagoon extends GLocation {
    public GLNassauFlamingoLagoon(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Flamingo Lagoon";
        this.xPos = 0;
        this.yPos = 0;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Forrest North", true);
    }
}
