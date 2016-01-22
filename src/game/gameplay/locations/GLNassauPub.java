package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GIBarTender;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauPub extends GLocation {
    public GLNassauPub(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Pub";
        this.xPos = 0;
        this.yPos = 0;
        addItems();
    }

    private void addItems() {
        items.add(new GIBarTender());
    }

    @Override
    public void makeConnections() {

    }
}
