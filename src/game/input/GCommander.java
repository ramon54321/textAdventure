package game.input;

import game.GCommandMode;
import game.GGame;
import game.GMain;
import game.gameplay.items.GItem;
import game.gameplay.locations.GLocation;

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

    private GGame gGame;

    public GCommander(GGame GGame) {
        this.gGame = GGame;
        //keyListenThread = new Thread(this);
        //keyListenThread.start();
    }

    public void parseCommand(String command) {

        // TODO: Improve text parser
        //System.out.println("Received command: " + command);

        // Preset Commands that do not need parsing
        if(command.equals("where am i") || command.equals("where am I") || command.equals("where am i?") || command.equals("where am I?")){
            showLocation();
            return;
        }
        if(command.equals("what do i have") || command.equals("what do I have") || command.equals("what do i have?") || command.equals("what do I have?") || command.equals("inventory")){
            showInventory();
            return;
        }

        if(GMain.mainGGame.commandMode == GCommandMode.NORMAL) {
            String[] commands = command.split(" with ");
            String mainCommand = commands[0];

            String verb = "";
            String noun = "";
            String with = "";

            String[] availableVerbs = GItem.availableActions;
            String[] availableNouns = gGame.currentLocation.getAllItemNames();

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
                    GMain.mainGGame.mainGFrame.consoleWrite("I don't know how to do that.");
                    return;
                }
                //System.out.println("Verb: " + verb);


                // special cases
                if(verb.equals("go to")) {
                    noun = mainCommand.split("go to ")[1];
                    goTo(noun);
                    return;
                }

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
                    GMain.mainGGame.mainGFrame.consoleWrite("I don't know what that is.");
                    return;
                }
                //System.out.println("Noun: " + noun);

                // WITH CHECK
                if (commands.length > 1) {
                    with = commands[1];
                }

                // TODO: Make general "DO I HAVE" function to check for items in location and inventory

                if (!with.equals("")) {
                    if (gGame.currentLocation.containsItem(with)) {
                        sendAction(verb, noun, gGame.currentLocation.getItem(with));
                    } else {
                        GMain.mainGGame.mainGFrame.consoleWrite("With that? Can't find that here?");
                    }
                } else {
                    sendAction(verb, noun, null);
                }
            }
        }
        else if (GMain.mainGGame.commandMode == GCommandMode.TALKING) {
            // TODO: Command mode for talking and buying, gets turned on from eg. Bar Tender.
            if(command.equals("a")) {
                if(GMain.mainGGame.currentTalkNode.children.size() < 1)
                    return;
                // run the a function for the current inteaction
                GMain.mainGGame.currentTalkNode.children.get(0).execute();
            }
            else if(command.equals("b")) {
                if(GMain.mainGGame.currentTalkNode.children.size() < 2)
                    return;
                // run the a function for the current inteaction
                GMain.mainGGame.currentTalkNode.children.get(1).execute();
            }
            else if(command.equals("c")) {
                if(GMain.mainGGame.currentTalkNode.children.size() < 3)
                    return;
                // run the a function for the current inteaction
                GMain.mainGGame.currentTalkNode.children.get(2).execute();
            }
            else if(command.equals("d")) {
                if(GMain.mainGGame.currentTalkNode.children.size() < 4)
                    return;
                // run the a function for the current inteaction
                GMain.mainGGame.currentTalkNode.children.get(3).execute();
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
        System.out.println("Verb: " + verb + " ... Noun: " + noun);
        if(gGame.currentLocation.containsItem(noun)) {
            //TODO: Complete switch with all interactables
            switch (verb) {
                case "pick up":
                    gGame.currentLocation.getItem(noun).pickUp(with);
                    break;
                case "break":
                    gGame.currentLocation.getItem(noun).breakItem(with);
                    break;
                case "throw":
                    gGame.currentLocation.getItem(noun).throwItem(with);
                    break;
                case "look at":
                    gGame.currentLocation.getItem(noun).lookAt(with);
                    break;
                case "eat":
                    gGame.currentLocation.getItem(noun).eat(with);
                    break;
                case "drink":
                    gGame.currentLocation.getItem(noun).drink(with);
                    break;
                case "kill":
                    gGame.currentLocation.getItem(noun).kill(with);
                    break;
                case "read":
                    gGame.currentLocation.getItem(noun).read(with);
                    break;
                case "talk to":
                    gGame.currentLocation.getItem(noun).talkTo(with);
                    break;
                default:
                    GMain.mainGGame.mainGFrame.consoleWrite("Can't do that...");
                    break;
            }
        }
        else {
            GMain.mainGGame.mainGFrame.consoleWrite("There is no such item here...");
        }
    }

    private void goTo(String locationName){
        GLocation gLocation = GMain.mainGGame.getLocationByName(locationName);
        if(gLocation == null) {
            GMain.mainGGame.mainGFrame.consoleWrite("I don't know where that is...");
            return;
        }
        if(!GMain.mainGGame.currentLocation.connections.contains(gLocation)){
            GMain.mainGGame.mainGFrame.consoleWrite("I can't go there from here, I will have to find another way around.");
            return;
        }
        GMain.mainGGame.mainGFrame.consoleWrite("I am on my way!");
        // TODO: Random event will happen here.
        GMain.mainGGame.currentLocation = gLocation;
    }

    private void showLocation(){
        GMain.mainGGame.mainGFrame.consoleWrite("I am in " + GMain.mainGGame.currentLocation.name + "\n\tConnections:");
        for(GLocation child : GMain.mainGGame.currentLocation.connections){
            GMain.mainGGame.mainGFrame.consoleAdd("\n\t\t" + child.name);
        }
    }

    private void showInventory(){
        GMain.mainGGame.mainGFrame.consoleWrite("I have:");
        // TODO: add nothing message
        for(GItem child : GMain.mainGGame.mainGPlayer.inventory){
            GMain.mainGGame.mainGFrame.consoleAdd("\n\t" + child.names[0]);
        }
    }
}
