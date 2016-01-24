package game.gameplay.items;

import game.GMain;
import game.interfaces.GInteractable;

/**
 * Created by Ramon on 1/18/16.
 *
 * Adding an item...
 * Copy an existing item subclass, adjust overrides and change values in constructor
 *
 * Adding an action...
 * Add action to GInteractable, add dafault func to this class, add verb to verb list in this class, add function call to GCommander.
 *
 */
public class GItem implements GInteractable {

    public String[] names = new String[] {"Unnamed"};
    public boolean pickupAble = false;

    public static String[] availableActions = new String[] {
            "break", "throw", "look at", "eat", "drink", "pick up", "kill", "read", "talk to", "go to"
    };

    @Override
    public void breakItem(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("Broken...");
    }

    @Override
    public void throwItem(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("Thrown...");
    }

    @Override
    public void lookAt(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("Can't see that to well actually...");
    }

    @Override
    public void eat(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("Not useful...");
    }

    @Override
    public void drink(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("Can't do that, sorry.");
    }

    @Override
    public void pickUp(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("Can't pick that up.");
    }

    @Override
    public void kill(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("I can't kill that...");
    }

    @Override
    public void read(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("I can't read that...");
    }

    @Override
    public void talkTo(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("Can't talk to that.");
    }
}
