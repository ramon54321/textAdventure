package game.gameplay.events;

import game.GCommandMode;
import game.GMain;

/**
 * Created by Ramon on 1/24/16.
 */
public class GEvent {

    public GEvent(){

    }

    public void eventInit() {
        GMain.mainGGame.commandMode = GCommandMode.EVENT;
        GMain.mainGGame.currentEvent = this;
    }

    public void eventEnd() {
        GMain.mainGGame.currentEvent = null;
        GMain.mainGGame.currentEventNode = null;
        GMain.mainGGame.commandMode = GCommandMode.NORMAL;
    }

}
