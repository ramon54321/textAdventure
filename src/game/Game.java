package game;

import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ramon on 20.12.2015.
 */

public class Game extends Canvas {

    private final int width = 300;
    private final int height = width / 16 * 9;
    private final int scale = 1;

    private JFrame mainFrame;

    public Game() {
        System.out.println("Started...");
        initGame();
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

        //TODO: Start this class in own thread.
    }
}