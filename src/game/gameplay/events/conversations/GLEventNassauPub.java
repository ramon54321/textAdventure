package game.gameplay.events.conversations;

import game.GMain;
import game.gameplay.GWorldData;
import game.gameplay.events.*;

/**
 * Created by Ramon on 1/26/16.
 */
public class GLEventNassauPub extends GLiveEvent implements Runnable{

    GForkNode barEntry = new GForkNode(this, "Talk to Bartender.", "Go to pool table.");
    GForkNode bar = new GForkNode(this, "Ask for a beer.", "Go to pool table.");
    GForkNode barPool = new GForkNode(this, "Just watch and chat.");
    GForkNode barMatch = new GForkNode(this, "Talk about the pirate situation in Nassau.", "Go back to bar counter.");

    GForkNode barHelp1 = new GForkNode(this, "Ask pool players for help to repair ship.", "Go back to bar counter.");

    public GLEventNassauPub(boolean useNewThread){
        if(useNewThread) {
            Thread newThread = new Thread(this);
            newThread.start();
        }
        else{
            run();
        }
    }

    // Walk to pool table
    private void toPool(){
        GMain.mainGGame.mainGFrame.consoleAddLine("(You walk to the pool table)");
        try{Thread.sleep(800);}catch (Exception e){}
        if(GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.pub_HasAccessToHelp)) {//flag has access to help from pub members
            currentObject = barHelp1;
        }
        else {
            GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: Here to play or watch mate?");
            currentObject = barPool;
        }
    }
    private void drinkBeer(){
        try{Thread.sleep(900);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You drink the beer in a giant gulp)");
        try{Thread.sleep(1500);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You start to feel a little light headed actually)");
        bar.actionNodes.remove(bar.getActionNodeByOptionText("Drink beer."));
    }
    private void getBeer(){
        GMain.mainGGame.mainGFrame.consoleAddLine("Bartender: A beer eh? I'l get ya one.");
        try{Thread.sleep(600);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(The bartender goes to pour you a beer)");
        try{Thread.sleep(1500);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Bartender: Here you go!");
        bar.actionNodes.add(new GActionNode("Drink beer.", () -> drinkBeer()));

        // Change this action for next round
        bar.actionNodes.get(0).setOptionText("Ask for another beer!");
        bar.actionNodes.get(0).setOptionAction(() -> getAnotherBeer());
    }
    private void getAnotherBeer(){
        GMain.mainGGame.mainGFrame.consoleAddLine("Bartender: Another one? Going for it tonight are we...");
        try{Thread.sleep(600);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(The bartender goes to pour you another beer)");
        try{Thread.sleep(1500);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Bartender: Here you go matey!");
        bar.actionNodes.add(new GActionNode("Drink beer.", () -> drinkBeer()));
    }

    private void goToCounter(){
        GMain.mainGGame.mainGFrame.consoleAddLine("(You walk to the bar counter)");
        try{Thread.sleep(800);}catch (Exception e){}
        currentObject = bar;
    }

    @Override
    public void run() {
        eventStart(this);

        currentObject = barEntry;

        GMain.mainGGame.mainGFrame.consoleAddLine("** Nassau Pub **");
        GMain.mainGGame.mainGFrame.consoleAddLine(" - Pirates always come to the pub to rest, always makes for good conversation.");
        GMain.mainGGame.mainGFrame.consoleAddLine(" - The pub often contains hints and the latest information on whats happening.");

        barEntry.actionNodes.get(0).setOptionAction(() -> {
            GMain.mainGGame.mainGFrame.consoleAddLine("Bartender: How ar' ya.");
            // Flags here for information

            currentObject = bar;
        });

        barHelp1.actionNodes.get(0).setOptionAction(() -> {
            GMain.mainGGame.mainGFrame.consoleAddLine("Pool player 2: We will be glad to help!");
            try{Thread.sleep(700);}catch (Exception e){}
            GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: We will be there.");
            try{Thread.sleep(700);}catch (Exception e){}
            GMain.mainGGame.mainGFrame.consoleAddLine("(The men will now help you repair the ship)");
            GMain.mainGGame.mainWorldData.worldFlags.add(GWorldData.GFlags.visitedPub_AskedForShipRepairs);
            barHelp1.actionNodes.remove(0);
        });
        barHelp1.actionNodes.get(1).setOptionAction(() -> goToCounter());

        barEntry.actionNodes.get(1).setOptionAction(() -> toPool());

        bar.actionNodes.get(0).setOptionAction(() -> getBeer());

        bar.actionNodes.get(1).setOptionAction(() -> toPool());

        barPool.actionNodes.get(0).setOptionAction(() -> {
            GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: Well watch me pot this one in.");
            currentObject = barMatch;
        });

        barMatch.actionNodes.get(0).setOptionAction(() -> {
            GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: Ah the pirates, we don't mind them, as long as they leave us alone.\n" +
                    "I heard some of them are talking about some grand prize.");

            // Change this action for next round
            barMatch.actionNodes.get(0).setOptionText("Ask more about the pirates in the town.");
            barMatch.actionNodes.get(0).setOptionAction(() -> {
                if(GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.pub_SpokenToPoolPlayers)) {//flag has spoken to pool players before
                    GMain.mainGGame.mainGFrame.consoleAddLine("Pool player 3: Ah the laddy is back!");
                    try{Thread.sleep(300);}catch (Exception e){}
                    GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: You spoken to Eleanor yet?");
                }
                else {
                    GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: Still about them eh? You want to become one?");
                    try{Thread.sleep(300);}catch (Exception e){}
                    GMain.mainGGame.mainGFrame.consoleAddLine("Pool players: Hahahaha (The players laugh at the joke.)");
                    try{Thread.sleep(1500);}catch (Exception e){}
                    GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: Go talk to that Guthrie woman in the tavern, she has a lot to do with them.");
                    // set flag of spoken to pool players here so upper block will run next time
                    GMain.mainGGame.mainWorldData.worldFlags.add(GWorldData.GFlags.pub_SpokenToPoolPlayers);
                }
                if(GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.pub_SpokenToEleanorAboutDeal)) {//Flag has spoken to eleanor
                    barMatch.actionNodes.get(0).setOptionText("Tell them about your conversation with Eleanor Guthrie.");
                    barMatch.actionNodes.get(0).setOptionAction(() -> {
                        GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: Seems like you have a rather promising story there capt.");
                        try{Thread.sleep(700);}catch (Exception e){}
                        GMain.mainGGame.mainGFrame.consoleAddLine("Pool player 2: Il sail with ya.");
                        try{Thread.sleep(800);}catch (Exception e){}
                        if(GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission_FixedShip)) {//Flag sailable has ship
                            GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: So would I! If ya need a crew man, Il be ya lad!");
                        }
                        else {// has broken ship
                            GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: So would I! Just get your ship seaworthy!");
                        }
                        try{Thread.sleep(1600);}catch (Exception e){}
                        GMain.mainGGame.mainGFrame.consoleAddLine("Pool player 3: We are at your service captain, anything you need, you know where to find us!");
                        //flag set help available in pub
                        GMain.mainGGame.mainWorldData.worldFlags.add(GWorldData.GFlags.pub_HasAccessToHelp);
                    });
                }
                else {
                    barMatch.actionNodes.remove(0);
                }
            });
        });

        barMatch.actionNodes.get(1).setOptionAction(() -> {
            GMain.mainGGame.mainGFrame.consoleAddLine("Later mate.");
            try{Thread.sleep(200);}catch (Exception e){}
            goToCounter();
        });

        while(isRunning) {
            GNarrator.narrate(currentObject);
        }

        GMain.mainGGame.printInfo("LiveEvent Thread complete.");
    }
}
