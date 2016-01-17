package game.entity;

import game.interfaces.GRenderable;

/**
 * Created by Ramon on 1/17/16.
 */
public class GEntity implements GRenderable {

    boolean active = true;
    boolean visible = true;
    boolean inBounds = false;

    int xPos = 0;
    int yPos = 0;
    int scale = 1;

    public GEntity(int xPos, int yPos, int scale) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.scale = scale;
    }

    @Override
    public void render() {
        // TODO: If in region check

        if(active && visible && inBounds) {
            // TODO: Render on screen
        }
    }
}
