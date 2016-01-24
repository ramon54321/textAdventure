package game;

import game.entity.GEntity;
import game.gameplay.GPlayer;
import game.gameplay.items.GItem;
import game.gameplay.locations.*;
import game.gameplay.talking.GTalkNode;
import game.graphics.GFrame;
import game.graphics.GScreen;
import game.input.GCommander;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

/**
 * Created by ramon on 20.12.2015.
 * Main GGame class, constructing a new GGame class creates a full new GGame and window.
 */

public class GGame extends Canvas implements Runnable{

    //TODO: Add static reference to game thread.

    // Global variables
    public final int WIDTH = 1000;
    public final int HEIGHT = 486;// WIDTH / 16 * 9;
    public final int SCALE = 1;
    private final int targetFPS = 144;
    private final int targetTPS = 60;

    // Reference Variables
    public GFrame mainGFrame;
    public GScreen mainGScreen;
    public GCommander mainGCommander;
    public GPlayer mainGPlayer;

    public ArrayList<GEntity> gEntities = new ArrayList<GEntity>();

    // Assets
    public BufferedImage map_Nassau;
    public BufferedImage map_Charleston;

    // Gameplay
    public ArrayList<GLocation> gLocations = new ArrayList<GLocation>();

    public GLocation currentLocation;
    public GItem currentInteraction;
    public GTalkNode currentTalkNode;

    public GCommandMode commandMode = GCommandMode.NORMAL;

    // Management variables
    private int framesRendered = 0;
    private int framesTicked = 0;
    public long tickDeltaTime = 0;
    private int lastFPS;
    private int lastTPS;

    // Graphics
    private BufferedImage mainRenderImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    public BufferedImage currentRegionImage = map_Nassau;
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

        /*
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
        */

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
        //g2d.drawImage(mainRenderImage, 0, 0, getWidth(), getHeight(), null);
        g2d.drawImage(currentRegionImage, 0, 0, getWidth(), getHeight(), null);
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
        mainGFrame = new GFrame(this);
        mainGScreen = new GScreen(this);
        mainGCommander = new GCommander(this);
        mainGPlayer = new GPlayer(this);

        //Assets
        try {
            map_Nassau = ImageIO.read(this.getClass().getResource("/game/resources/images/Nassau.jpg"));
            map_Charleston = ImageIO.read(this.getClass().getResource("/game/resources/images/Charleston.jpg"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setPreferredSize(size);
        mainGFrame.setResizable(false);
        mainGFrame.setTitle("Black Flags of the West Indies");
        mainGFrame.add(this);
        mainGFrame.pack();
        mainGFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainGFrame.setVisible(true);

        Thread renderThread = new Thread(this);
        renderThread.start();

        setupGameplay();

        setRegionToRender();

        //gEntities.add(new GEntity(this, 40, 40, 1, 0xFF00FF));
    }

    private void setupGameplay() {
        // TODO: Set up all locations and items
        gLocations.add(new GLNassauPort(this)); // >> pub >> boatyard >> fort >> charleston port
        gLocations.add(new GLNassauTownMarket(this)); // >> blacksmith >> townsquare >> suburb north >> suburb east
        gLocations.add(new GLNassauPub(this)); // >> port >> marsh > townsquare
        gLocations.add(new GLNassauBank(this)); // >> townsquare >> southbeach
        gLocations.add(new GLNassauBlackbeardTower(this)); // >>
        gLocations.add(new GLNassauBlacksmith(this)); // >> townmarket >> townsquare
        gLocations.add(new GLNassauBoatYard(this)); // >> port >> suburb north
        gLocations.add(new GLNassauCaptainFlintCove(this)); // >> forrest south
        gLocations.add(new GLNassauCliftonPoint(this)); // >> west hills
        gLocations.add(new GLNassauFlamingoLagoon(this)); // >> forrest north
        gLocations.add(new GLNassauForrestNorth(this)); // >> flamingo lagoon
        gLocations.add(new GLNassauForrestSouth(this)); // >> suburb east >> cap flint cove
        gLocations.add(new GLNassauFort(this)); // >> port
        gLocations.add(new GLNassauMarsh(this)); // >> pub >> square >> west hills
        gLocations.add(new GLNassauOldLighthouse(this)); // >> west hills
        gLocations.add(new GLNassauSouthBeach(this)); // >> bank
        gLocations.add(new GLNassauSuburbEast(this)); // >> market >> forrest south
        gLocations.add(new GLNassauSuburbNorth(this)); // >> forrest north >> boat yard >> market
        gLocations.add(new GLNassauTownSquare(this)); // >> blacksmith >> market >> bank >> pub >> marsh
        gLocations.add(new GLNassauWestHills(this)); // >> marsh >> old lighthouse >> clifton point

        gLocations.add(new GLCharlestonPort(this)); // >> nassau port


        // TODO: Set up all connections
        for(GLocation location : gLocations) {
            location.makeConnections();
        }

        currentLocation = getLocationByName("Nassau Port");
    }

    // Management Functions
    public GLocation getLocationByName(String locationName) {
        // TODO: Remove case sensitivity
        for(GLocation location : gLocations) {
            if(location.name.equalsIgnoreCase(locationName)) {
                return location;
            }
        }
        return null;
    }

    public void setRegionToRender(){
        if(currentLocation.name.contains("Nassau")){
            currentRegionImage = map_Nassau;
        }
        else if(currentLocation.name.contains("Charleston")){
            currentRegionImage = map_Charleston;
        }
        for(int i = 0; i < 5; i++) {
            render();
        }
    }
}

/*

Add Entity
gEntities.add(new GEntity(this, 40, 14, 1, 0xFFFFFF));

Move Entity
gEntities.get(0).move(10, 0.25);

 */