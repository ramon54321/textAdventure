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

    boolean hasHadBeer = false;

    GTalkNode talk_0A = new GTalkNode(){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite(
                    "Bartender: \"Whaddya want?\"\n\t" +
                    "a) \"Nothing...\"\n\t" +
                    "b) \"A beer!\" *Pay 5 silver coins*\n\t" +
                    "c) \"What do you know about this missing schedule everyone is talking about?\"\n\t" +
                    "d) \"Never mind... I'm leaving.\" *Leave pub*");
        }
    };

    GTalkNode talk_1AA = new GTalkNode(talk_0A, 0){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("Bartender: \"Come on, open your filthy mouth and start talking!\"\n\t"
            + "a) \"Alright. Beer.\" *Pay 5 silver coins*\n\t"
            + "b) \"I'm here to find out what is this missing schedule everyone's talking about.\"\n\t"
            + "c) \"Never mind... I'm leaving.\" *Leave pub*");
        }
    };

    //Here begins the consequence of saying a) "Alright. Beer."
    GTalkNode talk_2AAA = new GTalkNode(talk_1AA, 0){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            if (!hasHadBeer) {
                GMain.mainGGame.mainGFrame.consoleWrite("Bartender: \"Alright matey, here's your beer.\" *Beer drank. Type 'a' to continue*");
                //reduce amount of silver coins by 5
            }
            else {
                GMain.mainGGame.mainGFrame.consoleWrite("Bartender: \"Yo nigger I ain't giving you no beer no more, " +
                        "you're drunk as shit!\" *Type 'a' to continue*");
                //don't reduce the amount of coins
            }
            hasHadBeer = true;
            //TODO: GMain.mainGGame.mainGPlayer.personality.drunklevel += 1;
        }
    };

    GTalkNode talk_3AAAA = new GTalkNode(talk_2AAA, 0){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            talk_0A.execute();
        }
    };

    //Here begins the consequence of saying b) "I'm here to find out what is this missing schedule everyone's talking about."
    GTalkNode talk_2AAB = new GTalkNode(talk_1AA, 1){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("Bartender: \"Oh, that. You shouldn't be talking about that here. " +
                    "Go talk to Captain Hume outside.\n Fuck off now!!\" \n*The bartender kicked you out. Type 'a' to continue*");
        }
    };

    GTalkNode talk_3AABA = new GTalkNode(talk_2AAB, 0) {
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            talkEnd();
        }
    };

    //Here begins the consequence of saying c) "Never mind... I'm leaving."
    GTalkNode talk_2AAC = new GTalkNode(talk_1AA, 2){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("Bartender: \"Fuck off then!\" *Type 'a' to leave*");
        }
    };

    GTalkNode talk_3AACA = new GTalkNode(talk_2AAC, 0) {
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            talkEnd();
        }
    };

    GTalkNode talk_1AB = new GTalkNode(talk_0A, 1){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            if (!hasHadBeer) {
                GMain.mainGGame.mainGFrame.consoleWrite("Bartender: \"Alright matey, here's your beer.\" *Beer drank. Type 'a' to continue*");
                //reduce the amount of coins by 5
            }
            else {
                GMain.mainGGame.mainGFrame.consoleWrite("Bartender: \"Yo nigger I ain't giving you no beer no more, " +
                        "you're drunk as shit!\" *Type 'a' to continue*");
                //don't  reduce the amount of coins by 5
            }
            hasHadBeer = true;
            //GMain.mainGGame.mainGPlayer.personality.drunklevel += 1;
        }
    };
    GTalkNode talk_2ABA = new GTalkNode(talk_1AB, 0){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            talk_0A.execute();
        }
    };
    GTalkNode talk_1AC = new GTalkNode(talk_0A, 2){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("Bartender: \"Oh, that. You shouldn't be talking about that here. " +
                    "Go talk to Captain Hume outside.\n Fuck off now!!\" \n*The bartender kicked you out. Type 'a' to continue*");
        }
    };

    GTalkNode talk_2ACA = new GTalkNode(talk_1AC, 0) {
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            talkEnd();
        }
    };

    GTalkNode talk_1AD = new GTalkNode(talk_0A, 3){
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("Bartender: \"Fuck off then!\" *Type 'a' to leave*");
        }
    };

    GTalkNode talk_2ADA = new GTalkNode(talk_1AD, 0) {
        @Override
        public void execute() {
            GMain.mainGGame.currentTalkNode = this;
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
