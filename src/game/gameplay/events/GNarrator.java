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
                        choiceIndex = Integer.parseInt(GFrame.getInput(((GForkNode) navObject).parentEvent)) - 1;
                        if(((GForkNode) navObject).parentEvent.isRunning) {
                            ((GForkNode) navObject).runOption(choiceIndex);
                        }
                        else{
                            System.out.println("Command received when no longer running, ignoring...");
                        }
                        break;
                    } catch (Exception e) {
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
