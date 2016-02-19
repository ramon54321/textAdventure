package game.graphics;

import game.GGame;
import game.GMain;
import game.gameplay.events.GLiveEvent;
import game.input.GCommander;

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
    public JTextArea sideLabelOut = new JTextArea();
    public int linesWritten = 0;

    Border border = BorderFactory.createLineBorder(Color.BLACK);

    public GFrame(GGame GGame) {
        this.GGame = GGame;
        container = getContentPane();
        container.add(mainTextField, BorderLayout.NORTH);
        container.add(mainLabelOut, BorderLayout.SOUTH);
        container.add(sideLabelOut, BorderLayout.EAST);

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
                "\t'what is here'\n\t'what do I have'\n\t'go to ___'\n\t'pick up ___'\n\nType 1, 2 or 3 and enter, for quick information at any time." +
                "\n\nYou feel thirsty. You should go get a drink somewhere. \nThere is a pub nearby...");

        sideLabelOut.setBackground(Color.BLACK);
        sideLabelOut.setForeground(Color.ORANGE);
        sideLabelOut.setFont(new Font("Courier New", Font.PLAIN, 12));
        sideLabelOut.setBorder(border);
        sideLabelOut.setBorder(BorderFactory.createCompoundBorder(
                sideLabelOut.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        sideLabelOut.setEditable(false);
        sideLabelOut.setLineWrap(true);
        sideLabelOut.setMinimumSize(new Dimension(200, 100));
        sideLabelOut.setPreferredSize(new Dimension(200, 300));
        sideLabelOut.setMaximumSize(new Dimension(200, 800));
        sideLabelOut.setText("");
    }

    public void instantWrite(String string){
        sideLabelOut.setText(string);
    }

    public void consoleWrite(String string){
        mainLabelOut.setText(string + "\n");
    }

    public void consoleClear(){
        mainLabelOut.setText("");
        linesWritten = 0;
    }

    public void consoleAdd(String string){
        String current = mainLabelOut.getText();
        mainLabelOut.setText(current + string);
    }

    public void consoleAddLine(String string){
        if(linesWritten >= 12)
            consoleClear();
        for(char ch : string.toCharArray()){
            consoleAdd(Character.toString(ch));
            try{Thread.sleep(16);}catch (Exception e){}
        }
        consoleAdd("\n");
        linesWritten++;
    }

    public static String getInput(){
        while(GCommander.lastCommand == null){
            try{Thread.sleep(50);}catch (Exception e){}
        }
        String temp = GCommander.lastCommand;
        GCommander.lastCommand = null;
        return temp;
    }
    public static String getInput(GLiveEvent loopBreakerEvent){
        while(GCommander.lastCommand == null && loopBreakerEvent.isRunning && !loopBreakerEvent.timedout){
            //System.out.println("Loop breaker now at " + loopBreakerEvent.timedout);
            try{Thread.sleep(50);}catch (Exception e){}
        }
        if(loopBreakerEvent.timedout){
            System.out.println("Loop breaker triggered and set back to false.");
            loopBreakerEvent.timedout = false;
        }
        String temp = GCommander.lastCommand;
        GCommander.lastCommand = null;
        return temp;
    }
    public static String getInput(GLiveEvent loopBreakerEvent, double timeout){
        boolean doCommand = true;
        long startTime = System.nanoTime();
        while(GCommander.lastCommand == null && loopBreakerEvent.isRunning){
            try{Thread.sleep(50);}catch (Exception e){}
            if(System.nanoTime() - startTime > (timeout * 1000000)){
                doCommand = false;
                break;
            }
        }
        if(doCommand) {
            String temp = GCommander.lastCommand;
            GCommander.lastCommand = null;
            return temp;
        }
        else {
            return "999";
        }
    }

    public void consoleAddLineNT(String string){
        Thread myThread = new Thread(){
            @Override
            public void run() {
                for(char ch : string.toCharArray()){
                    consoleAdd(Character.toString(ch));
                    try{Thread.sleep(16);}catch (Exception e){}
                }
                consoleAdd("\n");

                GMain.mainGGame.printInfo("Print Thread has completed.");
            }
        };
        myThread.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 10) {

            Thread myThread = new Thread(){
                @Override
                public void run() {

                    String temp = mainTextField.getText();
                    mainTextField.setText("");
                    GGame.mainGCommander.parseCommand(temp);

                }
            };

            myThread.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
