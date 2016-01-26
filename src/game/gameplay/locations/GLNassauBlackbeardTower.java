package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauBlackbeardTower extends GLocation {
    public GLNassauBlackbeardTower(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Blackbeards Tower";
        this.xPos = 14;
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
