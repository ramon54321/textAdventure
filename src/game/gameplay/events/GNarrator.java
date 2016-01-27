package game.gameplay.events;

import java.util.Scanner;

/**
 * Created by Ramon on 1/26/16.
 */
public class GNarrator {

    public static void narrate(GNavigator navObject) {
        switch (classOf(navObject)) {
            case "fork" :
                ((GForkNode) navObject).showOptions();
                int choiceIndex;

                while (true) {
                    try {
                        Scanner reader = new Scanner(System.in);
                        choiceIndex = Integer.parseInt(reader.nextLine()) - 1;

                        break;

                    } catch (NumberFormatException ne) {
                        continue;
                    }
                }

                ((GForkNode) navObject).runOption( choiceIndex );
                break;
            case "action" :
                ((GActionNode) navObject).executeAction();
                break;
            case "null" :
                System.out.println("encountered null NavigatorObject");
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
