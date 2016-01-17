package game.entity;

import game.Game;
import game.interfaces.GRenderable;

/**
 * Created by Ramon on 1/17/16.
 */
public class GEntity implements GRenderable {

    private Game game;

    boolean active = true;
    boolean visible = true;
    boolean inBounds = false;

    double xPos = 0;
    double yPos = 0;
    int scale = 1;

    int width = 1;
    int height = 1;

    int[] pixels = new int[width * height];

    public GEntity(Game game, int xPos, int yPos, int scale, int color) {
        this.game = game;
        this.xPos = xPos;
        this.yPos = yPos;
        this.scale = scale;

        // Set color to all pixels
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

    public void move(double x, double y) {
        xPos += (x * ((double) game.tickDeltaTime)) / 1000000;
        yPos += (y * ((double) game.tickDeltaTime)) / 1000000;
        System.out.println("Xpos is now " + xPos);
    }

    public void moveTo(int x, int y) {
        xPos = x;
        yPos = y;
    }

    @Override
    public void render() {
        // TODO: If in region check
        inBounds = true;

        if(active && visible && inBounds) {
            // TODO: Render on screen
            game.pixels[((int) xPos) + (((int) yPos) * game.WIDTH)] = pixels[0];
        }
    }
}
