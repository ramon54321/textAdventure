package game.gameplay.events.conversations;

import game.GMain;
import game.gameplay.events.*;

/**
 * Created by Ramon on 1/26/16.
 */
public class GLEventNassauPub extends GLiveEvent implements Runnable{

    public GLEventNassauPub(boolean useNewThread){
        if(useNewThread) {
            Thread newThread = new Thread(this);
            newThread.start();
        }
        else{
            run();
        }
    }

    @Override
    public void run() {
        eventStart();

        GForkNode bar = new GForkNode("Ask for a beer.", "Go to pool table.", "Leave bar.");
        GForkNode barPool = new GForkNode("Just watch and chat.");
        GForkNode barMatch = new GForkNode("Talk about the pirate situation in Nassau.", "Go back to bar counter.");

        currentObject = bar;

        bar.actionNodes.get(0).setOptionAction(() -> {
            GMain.mainGGame.mainGFrame.consoleAddLine("Bartender: A beer eh? I'l get ya one.");
            try{Thread.sleep(600);}catch (Exception e){}
            GMain.mainGGame.mainGFrame.consoleAddLine("(The bartender goes to pour you a beer)");
            try{Thread.sleep(1500);}catch (Exception e){}
            GMain.mainGGame.mainGFrame.consoleAddLine("Bartender: Here you go!");
            bar.actionNodes.add(new GActionNode("Drink beer.", () -> {
                try{Thread.sleep(900);}catch (Exception e){}
                GMain.mainGGame.mainGFrame.consoleAddLine("(You drink the beer in a giant gulp)");
                try{Thread.sleep(1500);}catch (Exception e){}
                GMain.mainGGame.mainGFrame.consoleAddLine("(You start to feel a little light headed actually)");
                bar.actionNodes.remove(bar.getActionNodeByOptionText("Drink beer."));
            }));

            // Change this action for next round
            bar.actionNodes.get(0).setOptionText("Ask for another beer!");
            bar.actionNodes.get(0).setOptionAction(() -> {
                GMain.mainGGame.mainGFrame.consoleAddLine("Bartender: Another one? Going for it tonight are we...");
                try{Thread.sleep(600);}catch (Exception e){}
                GMain.mainGGame.mainGFrame.consoleAddLine("(The bartender goes to pour you another beer)");
                try{Thread.sleep(1500);}catch (Exception e){}
                GMain.mainGGame.mainGFrame.consoleAddLine("Bartender: Here you go matey!");
                bar.actionNodes.add(new GActionNode("Drink beer.", () -> {
                    try{Thread.sleep(900);}catch (Exception e){}
                    GMain.mainGGame.mainGFrame.consoleAddLine("(You drink the beer in a giant gulp)");
                    try{Thread.sleep(1500);}catch (Exception e){}
                    GMain.mainGGame.mainGFrame.consoleAddLine("(You start to feel a little light headed actually)");
                    bar.actionNodes.remove(bar.getActionNodeByOptionText("Drink beer."));
                }));
            });
        });

        bar.actionNodes.get(1).setOptionAction(() -> {
            GMain.mainGGame.mainGFrame.consoleAddLine("(You walk to the pool table)");
            try{Thread.sleep(800);}catch (Exception e){}
            GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: Here to play or watch mate?");
            currentObject = barPool;
        });

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
                GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: Still about them eh? You want to become one?");
                try{Thread.sleep(300);}catch (Exception e){}
                GMain.mainGGame.mainGFrame.consoleAddLine("Pool players: Hahahaha (The players laugh at the joke.)");
                try{Thread.sleep(1500);}catch (Exception e){}
                GMain.mainGGame.mainGFrame.consoleAddLine("Pool player: Go talk to that Guthrie woman in the tavern, she has a lot to do with them.");
                barMatch.actionNodes.remove(0);
            });
        });

        barMatch.actionNodes.get(1).setOptionAction(() -> {
            GMain.mainGGame.mainGFrame.consoleAddLine("Later mate.");
            try{Thread.sleep(200);}catch (Exception e){}
            GMain.mainGGame.mainGFrame.consoleAddLine("(You walk to the bar counter)");
            try{Thread.sleep(800);}catch (Exception e){}
            currentObject = bar;
        });

        bar.actionNodes.get(2).setOptionAction(() -> {
            GMain.mainGGame.mainGFrame.consoleAddLine("Cheers!");
            try{Thread.sleep(600);}catch (Exception e){}
            //leave bar
            isRunning = false;
        });

        currentObject = bar;

        while(isRunning) {
            GNarrator.narrate(currentObject);
        }

        eventEnd();
        GMain.mainGGame.printInfo("LiveEvent completed.");
    }
}
