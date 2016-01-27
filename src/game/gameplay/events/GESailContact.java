package game.gameplay.events;

import game.GCommandMode;
import game.GMain;
import game.gameplay.combat.GCSeaBattle;

/**
 * Created by Ramon on 1/24/16.
 */
public class GESailContact extends GEvent{// implements Runnable{
/*
    GEventNode event_0A = new GEventNode(){
        @Override
        public void execute() {
            GMain.mainGGame.currentEventNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite(
                    "\"SAIL!!!\" *Your lookout has spotted a sail on the horizon! You must decide what to do!*\n\t" +
                            "a) Do nothing, continue as planned.\n\t" +
                            "b) Try to avoid contact, could delay the trip a little.\n\t" +
                            "c) Approach directly and fight!\n\t");
        }
    };

    // Level 1
    GEventNode event_1AA = new GEventNode(event_0A, 0){
        @Override
        public void execute() { // do nothing, continue as planned
            GMain.mainGGame.currentEventNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("\"Continue as planned! We won't let a petty vessel bother us!\" *Type 'a' to continue*");
        }
    };
    GEventNode event_1AAA = new GEventNode(event_1AA, 0){
        @Override
        public void execute() { // do nothing, continue as planned -> check luck
            GMain.mainGGame.currentEventNode = this;
            double luck = Math.random();
            if(luck < 0.6){
                event_1AAAA.execute();
            }
            else {
                event_1AAAB.execute();
            }
        }
    };
    GEventNode event_1AAAA = new GEventNode(event_1AAA, 0){
        @Override
        public void execute() { // do nothing, continue as planned -> success, she passed
            GMain.mainGGame.currentEventNode = this;

            GMain.mainGGame.mainGFrame.consoleWrite("*Successfully evaded conflict* Quatermaster: \"We passed her by!\" *Type 'a' to continue*");
        }
    };
    GEventNode event_1AAAAA = new GEventNode(event_1AAAA, 0){
        @Override
        public void execute() { // do nothing, continue as planned -> success, she passed
            GMain.mainGGame.currentEventNode = this;
            eventEnd();
        }
    };
    GEventNode event_1AAAB = new GEventNode(event_1AAA, 1){
        @Override
        public void execute() { // do nothing, continue as planned -> failed, shes coming
            GMain.mainGGame.currentEventNode = this;

            GMain.mainGGame.mainGFrame.consoleWrite("Rigger: \"Shes coming for us captain!!!\"\n" +
                    "Quatermaster: \"20 to Port!, turn and fight!\" *Type 'a' to continue*");
        }
    };
    GEventNode event_1AAABA = new GEventNode(event_1AAAB, 0){
        @Override
        public void execute() { // do nothing, continue as planned -> success, she passed
            GMain.mainGGame.currentEventNode = this;
            eventEnd();
        }
    };


    // TODO: try avoid, fight
    GEventNode event_1AB = new GEventNode(event_0A, 1){
        @Override
        public void execute() { // try to avoid contact
            GMain.mainGGame.currentEventNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("\"15 to Starboard! She should let us past.\" *Type 'a' to continue*");
        }
    };
    GEventNode event_1AC = new GEventNode(event_0A, 2){
        @Override
        public void execute() { // fight
            GMain.mainGGame.currentEventNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("This is 1c");
            System.out.println("This is 1c console");
            event_0E.execute();
        }
    };


    //Fight
    GEventNode event_0E = new GEventNode(){
        @Override
        public void execute() { // fight
            GMain.mainGGame.currentEventNode = this;
            GMain.mainGGame.mainGFrame.consoleWrite("Battle");
            GMain.mainGGame.commandMode = GCommandMode.FIGHT;
            GMain.mainGGame.currentCombat = new GCSeaBattle();
            System.out.println("Done with sea battle...");
        }
    };


    public GESailContact(){
        //eventInit();

        Thread newThread = new Thread(this);
        newThread.start();

        //event_0A.execute();
    }

    @Override
    public void run() {
        eventInit();
        event_0A.execute();
    }
    */
}
