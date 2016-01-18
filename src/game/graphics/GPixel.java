package game.graphics;

import game.utilities.GVector2;

/**
 * Created by Ramon on 1/18/16.
 */
public class GPixel {

    public int color = 0xFF00FF;
    public GVector2 position;

    public GPixel(int xPos, int yPos, int color) {
        position = new GVector2(xPos, yPos);
        this.color = color;
    }

    public GPixel(int xPos, int yPos) {
        position = new GVector2(xPos, yPos);
    }

    public GPixel() {
        position = new GVector2(0,0);
    }
}
