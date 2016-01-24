package game.gameplay.items;

import game.GCommandMode;
import game.GMain;
import game.gameplay.talking.GTalkNode;

/**
 * Created by Ramon on 1/18/16.
 *
 * A unique bartender class needs to be created for each bartender in order to have the correct speech.
 *
 */
public class GIBarTenderNassauPub extends GItem {

    GTalkNode talk_0A = new GTalkNode(){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite(
                    "Bartender: Waddya want?\n\t" +
                    "a) Nothing...\n\t" +
                    "b) A beer!\n\t" +
                    "c) What do you know about this missing schedule everyone is talking about?\n\t" +
                    "d) Never mind... Im leaving.");
        }
    };

    // Level 1
    GTalkNode talk_1AA = new GTalkNode(talk_0A, 0){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("This is 1a");
        }
    };
    GTalkNode talk_1AB = new GTalkNode(talk_0A, 1){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("This is 1b");
        }
    };
    GTalkNode talk_1AC = new GTalkNode(talk_0A, 2){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("This is 1c");
        }
    };
    GTalkNode talk_1AD = new GTalkNode(talk_0A, 3){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("Bog off then!");

            // Exit talking
            talkEnd();
        }
    };



    public GIBarTenderNassauPub() {
        names =  new String[] {"bartender"};
        pickupAble = true;
    }

    @Override
    public void pickUp(GItem with) {
        GMain.mainGGame.mainGFrame.consoleWrite("You can't pick up a person!");
    }

    @Override
    public void talkTo(GItem with) {
        // Init talking
        talkInit();

        talk_0A.execute();

        // TODO: Buy items, separate command input
    }

    private void talkInit() {
        GMain.mainGGame.commandMode = GCommandMode.TALKING;
        GMain.mainGGame.currentInteraction = this;
    }

    private void talkEnd() {
        GMain.mainGGame.currentInteraction = null;
        GMain.mainGGame.currentTalkNode = null;
        GMain.mainGGame.commandMode = GCommandMode.NORMAL;
        GMain.mainGGame.mainGCommander.showLocation();
    }

}
