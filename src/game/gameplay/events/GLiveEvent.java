package game.gameplay.events;

import game.GCommandMode;
import game.GMain;

/**
 * Created by Ramon on 1/26/16.
 *
 * All events not started during movement need to start in own thread!!!
 *
 */
public class GLiveEvent {

    public boolean isRunning = true;
    public GNavigator currentObject;

    public GLiveEvent(){

    }

    public void eventStart(){
        GMain.mainGGame.commandMode = GCommandMode.LIVE;
        GMain.mainGGame.mainGFrame.consoleClear();
    }

    public void eventEnd(){
        GMain.mainGGame.commandMode = GCommandMode.NORMAL;
        if(!GMain.mainGGame.isMoving) {
            GMain.mainGGame.mainGCommander.showLocation();
            GMain.mainGGame.currentLocation.showEntryInfo();
        }
    }

}
