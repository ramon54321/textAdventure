package game.gameplay.events;

import game.GMain;

/**
 * Created by Ramon on 1/26/16.
 *
 * All events not started during movement need to start in own thread!!!
 *
 */
public class GLiveEvent {

    public boolean isRunning = true;
    public boolean timedout = false;
    public boolean pressedInTime = false;
    public boolean isTimed = false;
    public boolean isFight = false;
    public GNavigator currentObject;

    public GLiveEvent(){

    }

    public void eventStart(GLiveEvent liveEvent){
        while(GMain.mainGGame.currentLiveEvent != null) {
            GMain.mainGGame.currentLiveEvent.eventKill();
            System.out.println("Killing other event.");
        }
        System.out.println("Other event killed.");
        GMain.mainGGame.currentLiveEvent = liveEvent;
        GMain.mainGGame.mainGFrame.consoleClear();
    }

    // Used for normal ending of event in event itself
    public void eventEnd(){
        isRunning = false;
        GMain.mainGGame.currentLiveEvent = null;
        if(!GMain.mainGGame.isMoving) {
            //GMain.mainGGame.mainGCommander.showLocation();
            GMain.mainGGame.currentLocation.showEntryInfo();
        }
    }

    // Used to stop thread quietly in background, will NOT inform user
    public void eventKill(){
        isRunning = false;
        GMain.mainGGame.currentLiveEvent = null;
    }

}
