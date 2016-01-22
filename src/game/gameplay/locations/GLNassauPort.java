package game.gameplay.locations;

import game.GGame;
import game.gameplay.items.GISmallBird;
import game.gameplay.items.GISmallWoodenBox;
import game.gameplay.items.GISpoon;

/**
 * Created by Ramon on 1/19/16.
 */
public class GLNassauPort extends GLocation {
    public GLNassauPort(GGame gGame) {
        this.gGame = gGame;
        this.name = "Nassau Port";
        this.xPos = 0;
        this.yPos = 0;
        addItems();
    }

    private void addItems() {
        items.add(new GISmallWoodenBox());
        items.add(new GISmallBird());
        items.add(new GISpoon());
    }

    @Override
    public void makeConnections() {
        makeConnectionTo("Nassau Town Market", true);
    }
}
