package game.gameplay.items;

import game.GMain;
import game.gameplay.GPersonality;
import game.gameplay.events.conversations.GLEventNassauPub;

/**
 * Created by Ramon on 1/18/16.
 *
 * A unique bartender class needs to be created for each bartender in order to have the correct speech.
 *
 */
public class GIBarTenderNassauPub extends GItem {

    public GPersonality personality = new GPersonality("William");

    public GIBarTenderNassauPub() {
        names =  new String[] {"bartender"};
        pickupAble = true;
    }

    @Override
    public void pickUp(GItem with) {
        GMain.mainGGame.mainGFrame.consoleAddLine("You can't pick up a person!");
    }

    @Override
    public void talkTo(GItem with) {
        new GLEventNassauPub(true);
    }
}
