package game.gameplay.locations;

import game.Game;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauPub extends GLocation {
    public GLNassauPub(Game game) {
        this.game = game;
        this.name = "Nassau Town Market";
        this.xPos = 0;
        this.yPos = 0;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {

    }
}
