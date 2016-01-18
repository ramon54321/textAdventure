package game.graphics;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Ramon on 1/18/16.
 */
public class GFrame extends JFrame implements KeyListener{

    private Game game;
    public Container container;
    public JTextField mainTextField = new JTextField(10);

    public GFrame(Game game) {
        this.game = game;
        container = getContentPane();
        container.add(mainTextField, BorderLayout.SOUTH);
        mainTextField.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Key Typed: " + e.getKeyCode());
        if(e.getKeyCode() == 10) {
            game.mainGCommander.parseCommand(mainTextField.getText());
            mainTextField.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
