package game.gameplay.items;

import game.GCommandMode;
import game.GMain;
import game.interfaces.GInteractable;

import java.util.ArrayList;

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
    public ArrayList<String> pages = new ArrayList<String>();
    public int currentPage = 1;

    public static String[] availableActions = new String[] {
            "break", "throw", "look at", "eat", "drink", "pick up", "kill", "read", "talk to", "go to"
    };

    @Override
    public void breakItem(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("Broken...");
    }

    @Override
    public void throwItem(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("Thrown...");
    }

    @Override
    public void lookAt(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("Can't see that to well actually...");
    }

    @Override
    public void eat(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("Not useful...");
    }

    @Override
    public void drink(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("Can't do that, sorry.");
    }

    @Override
    public void pickUp(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        if(!pickupAble) {
            GMain.mainGGame.mainGFrame.consoleAddLine("Can't pick that up.");
        }
        else {
            GMain.mainGGame.mainGFrame.consoleAddLine("Picking up " + names[0] + ".");
            GMain.mainGGame.mainGPlayer.pickUpItem(this);
        }
    }

    @Override
    public void kill(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("I can't kill that...");
    }

    @Override
    public void read(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("I can't read that...");
    }

    @Override
    public void talkTo(GItem with) {
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("Can't talk to that.");
    }





    @Override
    public void previousPage() {
        if(currentPage > 1){
            currentPage--;
            GMain.mainGGame.mainGFrame.consoleWrite(pages.get(currentPage - 1));
        }
    }

    @Override
    public void nextPage() {
        if(currentPage < pages.size()){
            currentPage++;
            GMain.mainGGame.mainGFrame.consoleWrite(pages.get(currentPage - 1));
        }
    }

    public void readInit() {
        //GMain.mainGGame.commandMode = GCommandMode.READING;
        GMain.mainGGame.currentInteraction = this;
        currentPage = 1;
        GMain.mainGGame.mainGFrame.consoleWrite(pages.get(currentPage - 1));
    }

    @Override
    public void readEnd() {
        GMain.mainGGame.currentInteraction = null;
        //GMain.mainGGame.commandMode = GCommandMode.NORMAL;
        GMain.mainGGame.mainGCommander.showLocation();
    }
}
