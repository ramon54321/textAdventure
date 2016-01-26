package game.gameplay.events;

import game.GMain;

/**
 * Created by Ramon on 1/24/16.
 */
public class GEPublicFight extends GEvent {

    GEventNode event_0A = new GEventNode(){
        @Override
        public void execute() {
            GMain.mainGGame.currentEventNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite(
                    "FIGHT!!!!\n\t" +
                            "a) Do nothing, try to step aside...\n\t" +
                            "b) A beer!\n\t" +
                            "c) What do you know about this missing schedule everyone is talking about?\n\t" +
                            "d) Never mind... Im leaving.");
        }
    };

    // Level 1
    GEventNode event_1AA = new GEventNode(event_0A, 0){
        @Override
        public void execute() {
            GMain.mainGGame.currentEventNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("This is 1a");
        }
    };
    GEventNode event_1AB = new GEventNode(event_0A, 1){
        @Override
        public void execute() {
            GMain.mainGGame.currentEventNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("This is 1b");
        }
    };
    GEventNode event_1AC = new GEventNode(event_0A, 2){
        @Override
        public void execute() {
            GMain.mainGGame.currentEventNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("This is 1c");
        }
    };
    GEventNode event_1AD = new GEventNode(event_0A, 3){
        @Override
        public void execute() {
            GMain.mainGGame.currentEventNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("Bog off then!");

            // Exit event
            eventEnd();
        }
    };

    public GEPublicFight(){
        eventInit();
        event_0A.execute();
    }
}
