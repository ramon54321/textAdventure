package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauBlacksmith extends GLocation {
    public GLNassauBlacksmith(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Blacksmith";
        this.xPos = 0;
        this.yPos = 0;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Town Market", true);
        makeConnectionTo("Nassau Town Square", true);
    }
}
