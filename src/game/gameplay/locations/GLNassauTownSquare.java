package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauTownSquare extends GLocation {
    public GLNassauTownSquare(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Town Square";
        this.xPos = 1;
        this.yPos = -2;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Blacksmith", true);
        makeConnectionTo("Nassau Town Market", true);
        makeConnectionTo("Nassau Bank", true);
        makeConnectionTo("Nassau Pub", true);
        makeConnectionTo("Nassau Marsh", true);
    }
}
