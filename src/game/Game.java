package game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by ramon on 20.12.2015.
 * Main game class, constructing a new game class creates a full new game and window.
 */

public class Game extends Canvas implements Runnable{

    //TODO: Add static reference to game thread.

    // Global variables
    private final int width = 300;
    private final int height = width / 16 * 9;
    private final int scale = 1;
    private final int targetFPS = 144;
    private final int targetTPS = 60;

    // Reference Variables
    private JFrame mainFrame;

    // Management variables
    private int framesRendered = 0;
    private int framesTicked = 0;
    private int lastFPS;
    private int lastTPS;
    private BufferedImage mainRenderImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    public Game() {
        System.out.println("Started...");
        initGame();
    }

    public void run(){
        // This method is run in a new thread and loops constantly in while.
        long lastTimeTick = System.nanoTime();
        long lastTimeRender = System.nanoTime();
        long lastTimeClock = System.nanoTime();
        while(true){
            long currentTime = System.nanoTime();

            // Render
            if(currentTime - lastTimeRender > ((1 * 1000000000) / targetFPS)){
                render();
                framesRendered++;
                lastTimeRender = currentTime;
            }

            // Tick
            if(currentTime - lastTimeTick > ((1 * 1000000000) / targetTPS)){
                tick();
                framesTicked++;
                lastTimeTick = currentTime;
            }

            // Clock
            if(currentTime - lastTimeClock > (1 * 1000000000)){
                lastFPS = framesRendered;
                lastTPS = framesTicked;
                framesRendered = 0;
                framesTicked = 0;
                System.out.println("FPS: " + lastFPS);
                System.out.println("TPS: " + lastTPS);
                lastTimeClock = currentTime;
            }
        }
    }

    private void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(mainRenderImage, 0, 0, getWidth(), getHeight(), null);
        g.dispose();

        bs.show();
    }

    private void tick(){

    }

    //TODO: Add Render and Tick behaviour
    //TODO: Add tiles and render tiles

    private void initGame(){
        mainFrame = new JFrame();

        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
        mainFrame.setResizable(false);
        mainFrame.setTitle("Island Adventure");
        mainFrame.add(this);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        new Thread(this).start();
    }
}