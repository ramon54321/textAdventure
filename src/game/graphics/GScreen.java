package game.graphics;

import game.GGame;

/**
 * Created by Ramon on 1/17/16.
 */
public class GScreen {

    private GGame GGame;

    public GScreen(GGame GGame) {
        this.GGame = GGame;
    }

    public void clear() {
        for (int i = 0; i < GGame.pixels.length; i++) {
            GGame.pixels[i] = 0x000000;
        }
    }

    public void renderEntities() {
        for (int i = 0; i < GGame.gEntities.size(); i++) {
            GGame.gEntities.get(i).render();
        }
    }

}
