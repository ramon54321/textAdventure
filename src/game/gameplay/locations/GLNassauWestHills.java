package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauWestHills extends GLocation {
    public GLNassauWestHills(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau West Hills";
        this.xPos = 0;
        this.yPos = 0;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Marsh", true);
        makeConnectionTo("Nassau Old Lighthouse", true);
        makeConnectionTo("Nassau Clifton Point", true);
    }
}
