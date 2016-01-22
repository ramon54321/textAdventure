package game;

import game.entity.GEntity;
import game.gameplay.GPlayer;
import game.gameplay.items.GISmallBird;
import game.gameplay.items.GISmallWoodenBox;
import game.gameplay.items.GISpoon;
import game.gameplay.items.GItem;
import game.gameplay.locations.GLNassauPort;
import game.gameplay.locations.GLNassauPub;
import game.gameplay.locations.GLNassauTownMarket;
import game.gameplay.locations.GLocation;
import game.graphics.GFrame;
import game.graphics.GScreen;
import game.input.GCommander;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ramon on 20.12.2015.
 * Main GGame class, constructing a new GGame class creates a full new GGame and window.
 */

public class GGame extends Canvas implements Runnable{

    //TODO: Add static reference to game thread.

    // Global variables
    public final int WIDTH = 200;
    public final int HEIGHT = WIDTH / 16 * 9;
    public final int SCALE = 4;
    private final int targetFPS = 144;
    private final int targetTPS = 60;

    // Reference Variables
    public GFrame mainFrame;
    public GScreen mainGScreen;
    public GCommander mainGCommander;
    public GPlayer mainGPlayer;

    public ArrayList<GEntity> gEntities = new ArrayList<GEntity>();

    // Gameplay
    public ArrayList<GLocation> gLocations = new ArrayList<GLocation>();

    public GLocation currentLocation;

    public GCommandMode commandMode = GCommandMode.NORMAL;

    // Management variables
    private int framesRendered = 0;
    private int framesTicked = 0;
    public long tickDeltaTime = 0;
    private int lastFPS;
    private int lastTPS;

    // Graphics
    private BufferedImage mainRenderImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    public int[] pixels = ((DataBufferInt)mainRenderImage.getRaster().getDataBuffer()).getData();

    public GGame() {
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
            long newTickTime = System.nanoTime();
            if(newTickTime - lastTimeTick > ((1 * 1000000000) / targetTPS)){
                tickDeltaTime = (newTickTime - lastTimeTick) / 1000;
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
                //System.out.println("FPS: " + lastFPS);
                //System.out.println("TPS: " + lastTPS);
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
        mainGScreen.clear();

        // Render Order
        // TODO: Change to screen.render so its managed
        if(gEntities.size() > 0) {
            for (int i = 0; i < gEntities.size(); i++) {
                gEntities.get(i).render();
            }
        }

        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
        g2d.drawImage(mainRenderImage, 0, 0, getWidth(), getHeight(), null);
        g2d.dispose();

        bs.show();
    }

    private void tick(){

        try {
            //gEntities.get(0).move(6, 3);
            //gEntities.get(0).rotate(0.05);
        }
        catch (Exception e) {

        }

    }

    //TODO: Add Render and Tick behaviour
    //TODO: Add tiles and render tiles

    private void initGame(){
        mainFrame = new GFrame(this);
        mainGScreen = new GScreen(this);
        mainGCommander = new GCommander(this);
        mainGPlayer = new GPlayer(this);

        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setPreferredSize(size);
        mainFrame.setResizable(false);
        mainFrame.setTitle("Black Flags of the West Indies");
        mainFrame.add(this);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        Thread renderThread = new Thread(this);
        renderThread.start();

        setupGameplay();

        //gEntities.add(new GEntity(this, 40, 40, 1, 0xFF00FF));
    }

    private void setupGameplay() {
        // TODO: Set up all locations and items
        gLocations.add(new GLNassauPort(this));
        gLocations.add(new GLNassauTownMarket(this));
        gLocations.add(new GLNassauPub(this));

        // TODO: Set up all connections
        for(GLocation location : gLocations) {
            location.makeConnections();
        }

        //currentLocation = getLocationByName("Nassau City Market");
        currentLocation = getLocationByName("Nassau Pub");
    }

    // Management Functions
    public GLocation getLocationByName(String locationName) {
        for(GLocation location : gLocations) {
            if(location.name.equals(locationName)) {
                return location;
            }
        }
        return null;
    }

}

/*

Add Entity
gEntities.add(new GEntity(this, 40, 14, 1, 0xFFFFFF));

Move Entity
gEntities.get(0).move(10, 0.25);

 */