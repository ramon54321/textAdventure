package game.gameplay.events;

import game.graphics.GFrame;

/**
 * Created by Ramon on 1/26/16.
 */
public class GNarrator {

    public static void narrate(GNavigator navObject) {
        switch (classOf(navObject)) {
            case "fork" :
                ((GForkNode) navObject).showOptions();
                int choiceIndex;
                while (((GForkNode) navObject).parentEvent.isRunning) {
                    try {
                        if(((GForkNode) navObject).parentEvent.isTimed) {
                            // this one is delayed and will complete in delay time regardless of input
                            choiceIndex = Integer.parseInt(GFrame.getInput(((GForkNode) navObject).parentEvent, 1000)) - 1;
                        }
                        else{
                            choiceIndex = Integer.parseInt(GFrame.getInput(((GForkNode) navObject).parentEvent)) - 1;
                        }
                        if(choiceIndex == 998){
                            if(((GLEFight)((GForkNode) navObject).parentEvent).isFight){
                                ((GLEFight)((GForkNode) navObject).parentEvent).finishTurn();
                                ((GLEFight)((GForkNode) navObject).parentEvent).isTimed = false;
                                ((GLEFight)((GForkNode) navObject).parentEvent).currentObject = ((GLEFight)((GForkNode) navObject).parentEvent).player1.weapon.attackFork;
                            }
                            break;
                        }
                        if(((GForkNode) navObject).parentEvent.isRunning) {
                            ((GForkNode) navObject).runOption(choiceIndex);
                        }
                        else{
                            System.out.println("Command received when no longer running, ignoring...");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Caught exception trying input again.");
                        continue;
                    }
                }
                break;
            case "action" :
                ((GActionNode) navObject).executeAction();
                break;
            case "null" :
                System.out.println("Encountered null NavigatorObject");
                break;
        }
    }

    public static String classOf(GNavigator currentObject) {
        if(GForkNode.class.isAssignableFrom(currentObject.getClass()))
            return "fork" ;

        else if(GActionNode.class.isAssignableFrom(currentObject.getClass()))
            return "action" ;

        return "null" ;
    }
}
