package game.graphics;

import game.GGame;

import javax.swing.*;
import javax.swing.border.Border;
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

    Border border = BorderFactory.createLineBorder(Color.BLACK);

    public GFrame(GGame GGame) {
        this.GGame = GGame;
        container = getContentPane();
        container.add(mainTextField, BorderLayout.NORTH);
        container.add(mainLabelOut, BorderLayout.SOUTH);

        mainTextField.setBackground(Color.BLACK);
        mainTextField.setForeground(Color.ORANGE);
        mainTextField.setFont(new Font("Courier New", Font.ITALIC, 16));
        //mainTextField.setEditable(false);
        mainTextField.addKeyListener(this);
        mainTextField.setBorder(border);
        mainTextField.setBorder(BorderFactory.createCompoundBorder(
                mainTextField.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        mainLabelOut.setBackground(Color.BLACK);
        mainLabelOut.setForeground(Color.ORANGE);
        mainLabelOut.setFont(new Font("Courier New", Font.PLAIN, 12));
        mainLabelOut.setBorder(border);
        mainLabelOut.setBorder(BorderFactory.createCompoundBorder(
                mainLabelOut.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        mainLabelOut.setEditable(false);
        mainLabelOut.setLineWrap(true);
        mainLabelOut.setMinimumSize(new Dimension(500, 2100));
        mainLabelOut.setPreferredSize(new Dimension(500, 210));
        mainLabelOut.setMaximumSize(new Dimension(500, 210));
        mainLabelOut.setText("Welcome to Black Flags of the West Indies. To get started, use the basic commands.\n\n" +
                "\t'what is here'\n\t'what do I have'\n\t'go to ___'\n\t'pick up ___'\n\nType 1, 2 or 3 and enter, for quick information at any time.");
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
        //else{
        //    mainTextField.setText(mainTextField.getText() + new Character(e.getKeyChar()));
        //}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
