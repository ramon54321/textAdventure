package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GIBarTenderNassauPub;

/**
 * Created by Ramon on 1/19/16.
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
}
