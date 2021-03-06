package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauSuburbNorth extends GLocation {
    public GLNassauSuburbNorth(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Suburb North";
        this.xPos = 4;
        this.yPos = 0;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Forest North", true);
        makeConnectionTo("Nassau Boat Yard", true);
        makeConnectionTo("Nassau Town Market", true);
    }
}
