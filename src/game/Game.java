package game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ramon on 20.12.2015.
 * Main game class, constructing a new game class creates a full new game and window.
 */

public class Game extends Canvas implements Runnable{

    public static Thread gameThread;

    private final int width = 300;
    private final int height = width / 16 * 9;
    private final int scale = 1;

    private JFrame mainFrame;

    public Game() {
        System.out.println("Started...");
        initGame();
    }

    public void run(){
        //TODO: Calculate Tick and Update loops, and call corresponding functions.
    }

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