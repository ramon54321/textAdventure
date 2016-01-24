package game.graphics;

import game.GGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Ramon on 1/18/16.
 */
public class GFrame extends JFrame implements KeyListener{

    private GGame GGame;
    public Container container;
    public JTextField mainTextField = new JTextField(10);
    public JTextArea mainLabelOut = new JTextArea();

    public GFrame(GGame GGame) {
        this.GGame = GGame;
        container = getContentPane();
        container.add(mainTextField, BorderLayout.NORTH);
        container.add(mainLabelOut, BorderLayout.SOUTH);
        mainLabelOut.setLineWrap(true);
        mainLabelOut.setMinimumSize(new Dimension(500, 180));
        mainLabelOut.setPreferredSize(new Dimension(500, 180));
        mainLabelOut.setMaximumSize(new Dimension(500, 180));
        mainLabelOut.setText("");
        mainTextField.addKeyListener(this);
    }

    public void consoleWrite(String string){
        mainLabelOut.setText(string);
    }

    public void consoleAdd(String string){
        String current = mainLabelOut.getText();
        mainLabelOut.setText(current + string);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Key Typed: " + e.getKeyCode());
        if(e.getKeyCode() == 10) {
            GGame.mainGCommander.parseCommand(mainTextField.getText());
            mainTextField.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
