package game.input;

import game.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Ramon on 1/18/16.
 */
public class GCommander implements KeyListener, Runnable {

    public Thread keyListenThread;
    private Game game;

    public GCommander(Game game) {
        this.game = game;
        keyListenThread = new Thread(this);
        keyListenThread.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

    }
}
