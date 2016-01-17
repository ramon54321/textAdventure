package game;

import game.entity.GEntity;
import game.graphics.GScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by ramon on 20.12.2015.
 * Main game class, constructing a new game class creates a full new game and window.
 */

public class Game extends Canvas implements Runnable{

    //TODO: Add static reference to game thread.

    // Global variables
    private final int WIDTH = 100;
    private final int HEIGHT = WIDTH / 16 * 9;
    private final int SCALE = 9;
    private final int targetFPS = 144;
    private final int targetTPS = 60;

    // Reference Variables
    public JFrame mainFrame;
    public GScreen mainGScreen;
    public GEntity[] gEntities;

    // Management variables
    private int framesRendered = 0;
    private int framesTicked = 0;
    private int lastFPS;
    private int lastTPS;

    // Graphics
    private BufferedImage mainRenderImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    public int[] pixels = ((DataBufferInt)mainRenderImage.getRaster().getDataBuffer()).getData();

    public Game() {
        System.out.println("Started...");
        initGame();
    }

    // Game Loop
    public void run(){
        // This method is run in a new thread and loops constantly in while.
        long lastTimeTick = System.nanoTime();
        long lastTimeRender = System.nanoTime();
        long lastTimeClock = System.nanoTime();
        while(true){

            // Render
            if(System.nanoTime() - lastTimeRender > ((1 * 1000000000) / targetFPS)){
                render();
                framesRendered++;
                lastTimeRender = System.nanoTime();
            }


            // Tick
            if(System.nanoTime() - lastTimeTick > ((1 * 1000000000) / targetTPS)){
                tick();
                framesTicked++;
                lastTimeTick = System.nanoTime();
            }


            // Clock
            if(System.nanoTime() - lastTimeClock > (1 * 1000000000)){
                lastFPS = framesRendered;
                lastTPS = framesTicked;
                framesRendered = 0;
                framesTicked = 0;
                System.out.println("FPS: " + lastFPS);
                System.out.println("TPS: " + lastTPS);
                lastTimeClock = System.nanoTime();
            }
        }
    }

    private void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(2);
            return;
        }

        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
        g2d.drawImage(mainRenderImage, 0, 0, getWidth(), getHeight(), null);
        g2d.dispose();

        bs.show();
    }

    private void tick(){

    }

    //TODO: Add Render and Tick behaviour
    //TODO: Add tiles and render tiles

    private void initGame(){
        mainFrame = new JFrame();
        mainGScreen = new GScreen(this);

        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setPreferredSize(size);
        mainFrame.setResizable(false);
        mainFrame.setTitle("Island Adventure");
        mainFrame.add(this);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        Thread renderThread = new Thread(this);
        renderThread.start();

        try {
            Thread.sleep(2500);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Action...");

        pixels[30 + (14 * WIDTH)] = 0xCCFF33;

        mainGScreen.clear();

    }

    // Management Functions

}