package game.graphics;

import game.Game;

/**
 * Created by Ramon on 1/17/16.
 */
public class GScreen {

    private Game game;

    public GScreen(Game game) {
        this.game = game;
    }

    public void clear() {
        for (int i = 0; i < game.pixels.length; i++) {
            game.pixels[i] = 0x000000;
        }
    }

    public void renderEntities() {
        for (int i = 0; i < game.gEntities.size(); i++) {
            game.gEntities.get(i).render();
        }
    }

}
