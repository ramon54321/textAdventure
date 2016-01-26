package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauTownMarket extends GLocation {
    public GLNassauTownMarket(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Town Market";
        this.xPos = 2;
        this.yPos = -1;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Blacksmith", true);
        makeConnectionTo("Nassau Town Square", true);
        makeConnectionTo("Nassau Suburb North", true);
        makeConnectionTo("Nassau Suburb East", true);
    }
}
