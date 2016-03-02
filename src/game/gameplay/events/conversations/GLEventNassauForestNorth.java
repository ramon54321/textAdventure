package game.gameplay.events.conversations;

import game.GMain;
import game.gameplay.GWorldData;
import game.gameplay.events.GActionNode;
import game.gameplay.events.GForkNode;
import game.gameplay.events.GLiveEvent;
import game.gameplay.events.GNarrator;

/**
 * Created by Santeri on 2/10/16.
 */
public class GLEventNassauForestNorth extends GLiveEvent implements Runnable{

    GForkNode entryFork = new GForkNode(this, "Examine your surroundings.");

    GForkNode tavernEntry = new GForkNode(this, "Ask about business.", "Tell her a story of a Spaniard named Vasquez.");

    public GLEventNassauForestNorth(boolean useNewThread){
        if(useNewThread) {
            Thread newThread = new Thread(this);
            newThread.start();
        }
        else{
            run();
        }
    }

    private void lookForCook(){
        GMain.mainGGame.mainGDatabase.conversations.get("mission4_cookInForest.txt").narrateConversation();
        GMain.mainGGame.mainWorldData.worldFlags.add(GWorldData.GFlags.mission4_FoundTheCook);
        entryFork.actionNodes.remove(1);
    }

    private void examineSurroundings(){
        try{Thread.sleep(1200);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You look around.)");
        try{Thread.sleep(1200);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(The air is chilly and moist.)");
        try{Thread.sleep(1200);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You notice the lack of animal sounds. It is completely quiet.)");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(Cold shivers run through your body.)");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(The atmosphere is eerily quiet, as if something was going to happen very soon....)");
        try{Thread.sleep(2500);}catch (Exception e){}
    }

    @Override
    public void run() {
        eventStart(this);

        currentObject = entryFork;

        GMain.mainGGame.mainGFrame.consoleAddLine("** Nassau Forest North **");
        GMain.mainGGame.mainGFrame.consoleAddLine(" - It's eerily quiet...");

        // Entry
        entryFork.actionNodes.get(0).setOptionAction(() -> examineSurroundings());
        if(GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission3_TalkToGatesAtPubAndSetOffToFindTheCook) && !GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission4_FoundTheCook)){
            entryFork.actionNodes.add(new GActionNode("Look for cook.", null));
            entryFork.actionNodes.get(1).setOptionAction(() -> lookForCook());
        }


        /* Tavern Entry
        tavernEntry.actionNodes.get(0).setOptionAction(() -> askAboutBusiness());
        if(GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission6_ReqHelpFromPoolPlayersToRepairShip) && !GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission7_TalkToEleanorAboutWoodSupply)) {
            tavernEntry.actionNodes.get(1).setOptionText("Ask Eleanor about wood supply.");
            tavernEntry.actionNodes.get(1).setOptionAction(() -> askForWood());
        }
        else if(GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission4_FoundTheCook) && !GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission5_FoughtSingleton)) {
            tavernEntry.actionNodes.get(1).setOptionText("Propose deal to Eleanor.");
            tavernEntry.actionNodes.get(1).setOptionAction(() -> proposeDeal());
        }
        else if(GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission1_TalkToPoolPlayers) && !GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission2_TellStoryToEleanorAboutSpaniard)) {
            tavernEntry.actionNodes.get(1).setOptionText("Tell her a story of a Spaniard named Vasquez.");
            tavernEntry.actionNodes.get(1).setOptionAction(() -> tellStoryOfSpaniard());
        }
        else {
            tavernEntry.actionNodes.remove(1);
        }
        */
        while(isRunning) {
            GNarrator.narrate(currentObject);
        }

        GMain.mainGGame.printInfo("LiveEvent Thread complete.");
    }
}
