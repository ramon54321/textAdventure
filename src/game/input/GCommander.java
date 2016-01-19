package game.input;

import game.Game;
import game.gameplay.items.GItem;

/**
 * Created by Ramon on 1/18/16.
 */
public class GCommander{

    private Game game;

    public GCommander(Game game) {
        this.game = game;
        //keyListenThread = new Thread(this);
        //keyListenThread.start();
    }

    public void parseCommand(String command) {

        // TODO: Improve text parser
        //System.out.println("Received command: " + command);

        String[] commands = command.split(" with ");
        String mainCommand = commands[0];

        String verb = "";
        String noun = "";
        String with = "";

        String[] availableVerbs = GItem.availableActions;
        String[] availableNouns = game.currentLocation.getAllItemNames();

        String[] words = mainCommand.split(" ");

        if(words.length > 1) {
            // VERB CHECK
            // Check for double word verb
            if(arrayHasString(availableVerbs, words[0] + " " + words[1])) {
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
            if(arrayHasString(availableNouns, words[words.length - 2] + " " + words[words.length - 1])) {
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
            if(commands.length > 1) {
                with = commands[1];
            }

            // TODO: Make general "DO I HAVE" function to check for items in location and inventory

            if(!with.equals("")) {
                if(game.currentLocation.containsItem(with)) {
                    sendAction(verb, noun, game.currentLocation.getItem(with));
                }
                else {
                    System.out.println("With that? Can't find that here?");
                }
            }
            else {
                sendAction(verb, noun, null);
            }
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
        if(game.currentLocation.containsItem(noun)) {
            //TODO: Complete switch with all interactables
            switch (verb) {
                case "pick up":
                    game.currentLocation.getItem(noun).pickUp(with);
                    break;
                case "break":
                    game.currentLocation.getItem(noun).breakItem(with);
                    break;
                case "throw":
                    game.currentLocation.getItem(noun).throwItem(with);
                    break;
                case "look at":
                    game.currentLocation.getItem(noun).lookAt(with);
                    break;
                case "eat":
                    game.currentLocation.getItem(noun).eat(with);
                    break;
                case "drink":
                    game.currentLocation.getItem(noun).drink(with);
                    break;
                case "kill":
                    game.currentLocation.getItem(noun).kill(with);
                    break;
                case "read":
                    game.currentLocation.getItem(noun).read(with);
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
