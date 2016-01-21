package game.input;

import game.GGame;
import game.GMain;
import game.gameplay.items.GItem;

/**
 * Created by Ramon on 1/18/16.
 *
 * GCommander sends commands to the program based on input from the user.
 * This is where the textParsing happens.
 *
 * TextParser V 0.2
 *      Text parser now supports with statement.
 *      Text parser now replies correctly when an unparsable statement is given. IN MOST CASES (Needs work)
 *
 */

public class GCommander{

    private GGame GGame;

    public GCommander(GGame GGame) {
        this.GGame = GGame;
        //keyListenThread = new Thread(this);
        //keyListenThread.start();
    }

    public void parseCommand(String command) {

        // TODO: Improve text parser
        //System.out.println("Received command: " + command);

        if(GMain.mainGGame.commandMode == 0) {
            String[] commands = command.split(" with ");
            String mainCommand = commands[0];

            String verb = "";
            String noun = "";
            String with = "";

            String[] availableVerbs = GItem.availableActions;
            String[] availableNouns = GGame.currentLocation.getAllItemNames();

            String[] words = mainCommand.split(" ");

            if (words.length > 1) {
                // VERB CHECK
                // Check for double word verb
                if (arrayHasString(availableVerbs, words[0] + " " + words[1])) {
                    verb = (words[0] + " " + words[1]);
                }
                // Check for single word verb
                else if (arrayHasString(availableVerbs, words[0])) {
                    verb = words[0];
                }
                // Cant find any verb
                else {
                    System.out.println("I don't know how to do that.");
                    return;
                }
                //System.out.println("Verb: " + verb);

                // NOUN CHECK
                // Check for double word noun
                if (arrayHasString(availableNouns, words[words.length - 2] + " " + words[words.length - 1])) {
                    noun = (words[words.length - 2] + " " + words[words.length - 1]);
                }
                // Check for single word noun
                else if (arrayHasString(availableNouns, words[words.length - 1])) {
                    noun = words[words.length - 1];
                }
                // Cant find any noun
                else {
                    System.out.println("I don't know what that is.");
                    return;
                }
                //System.out.println("Noun: " + noun);

                // WITH CHECK
                if (commands.length > 1) {
                    with = commands[1];
                }

                // TODO: Make general "DO I HAVE" function to check for items in location and inventory

                if (!with.equals("")) {
                    if (GGame.currentLocation.containsItem(with)) {
                        sendAction(verb, noun, GGame.currentLocation.getItem(with));
                    } else {
                        System.out.println("With that? Can't find that here?");
                    }
                } else {
                    sendAction(verb, noun, null);
                }
            }
        }
        else if (GMain.mainGGame.commandMode == 1) {
            // TODO: Command mode for talking and buying, gets turned on from eg. Bar Tender.
        }
    }

    private boolean arrayHasString(String[] arrayToCheck, String stringToFind) {
        for(String str : arrayToCheck) {
            if (stringToFind.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void sendAction(String verb, String noun, GItem with) {
        if(GGame.currentLocation.containsItem(noun)) {
            //TODO: Complete switch with all interactables
            switch (verb) {
                case "pick up":
                    GGame.currentLocation.getItem(noun).pickUp(with);
                    break;
                case "break":
                    GGame.currentLocation.getItem(noun).breakItem(with);
                    break;
                case "throw":
                    GGame.currentLocation.getItem(noun).throwItem(with);
                    break;
                case "look at":
                    GGame.currentLocation.getItem(noun).lookAt(with);
                    break;
                case "eat":
                    GGame.currentLocation.getItem(noun).eat(with);
                    break;
                case "drink":
                    GGame.currentLocation.getItem(noun).drink(with);
                    break;
                case "kill":
                    GGame.currentLocation.getItem(noun).kill(with);
                    break;
                case "read":
                    GGame.currentLocation.getItem(noun).read(with);
                    break;
                case "talk to":
                    GGame.currentLocation.getItem(noun).talkTo(with);
                    break;
                default:
                    System.out.println("Can't do that...");
                    break;
            }
        }
        else {
            System.out.println("There is no such item here...");
        }
    }
}
