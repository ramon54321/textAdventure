package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GINavigationManual;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauBoatYard extends GLocation {
    public GLNassauBoatYard(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Boat Yard";
        this.xPos = 3;
        this.yPos = 1;
        addItems();
    }

    private void addItems() {
        items.add(new GINavigationManual());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Port", true);
        makeConnectionTo("Nassau Suburb North", true);
    }
}
