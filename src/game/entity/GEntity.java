package game.entity;

import game.GGame;
import game.graphics.GPixel;
import game.interfaces.GRenderable;
import game.utilities.GVector2;

/**
 * Created by Ramon on 1/17/16.
 */
public class GEntity implements GRenderable {

    private GGame GGame;

    boolean active = true;
    boolean visible = true;
    boolean inBounds = false;

    GVector2 position = new GVector2(0,0);
    int scale = 1;

    int width = 25;
    int height = 25;

    GPixel[] pixels = new GPixel[width * height];

    // TODO: Constructor with sprite

    public GEntity(GGame GGame, int xPos, int yPos, int scale, int color) {
        this.GGame = GGame;
        this.position.x = xPos;
        this.position.y = yPos;
        this.scale = scale;

        // Set up pixels
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[x + (y * width)] = new GPixel(x, y);
            }
        }
    }

    /*
    public void move(double x, double y) {
        position.x += (x * ((double) GGame.tickDeltaTime)) / 1000000;
        position.y += (y * ((double) GGame.tickDeltaTime)) / 1000000;
    }
    */

    public void moveTo(int x, int y) {
        position.x = x;
        position.y = y;
    }

    public void rotate(double theta) {
        for (GPixel pixel : pixels) {
            //Matrix Rotation
            double newX = (pixel.position.x * Math.cos(theta)) - (pixel.position.y * Math.sin(theta));
            double newY = (pixel.position.x * Math.sin(theta)) + (pixel.position.y * Math.cos(theta));
            pixel.position.x = newX;
            pixel.position.y = newY;
        }
    }

    @Override
    public void render() {
        // TODO: If in region check
        inBounds = true;

        if(active && visible && inBounds) {
            // TODO: Render on screen (sprite)
            /*
                For each pixel in pixels, render at origin + offset.
             */
            for (GPixel pixel : pixels) {
                int x = ((int) position.x) + (int) Math.round(pixel.position.x);
                int y = ((int) position.y) + (int) Math.round(pixel.position.y);
                GGame.pixels[x + (y * GGame.WIDTH)] = pixel.color;
            }
        }
    }
}
