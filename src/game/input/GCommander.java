package game.input;

import game.GCommandMode;
import game.GGame;
import game.GMain;
import game.gameplay.combat.GCSeaBattle;
import game.gameplay.events.GEPublicFight;
import game.gameplay.events.GESailContact;
import game.gameplay.items.GItem;
import game.gameplay.locations.GLocation;

import java.net.SocketTimeoutException;

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

    public static String lastCommand;

    public GCommander(GGame GGame) {
        this.gGame = GGame;
        //keyListenThread = new Thread(this);
        //keyListenThread.start();
    }

    public void parseCommand(String command) {

        // TODO: Improve text parser
        //System.out.println("Received command: " + command);

        // Preset Commands that do not need parsing
        // TODO: Use ignore case instead
        if(GMain.mainGGame.commandMode == GCommandMode.NORMAL) {
            if (command.equalsIgnoreCase("1") || command.equalsIgnoreCase("where am i") || command.equalsIgnoreCase("where am i?")) {
                showLocation();
                return;
            }
            if (command.equalsIgnoreCase("2") || command.equalsIgnoreCase("what do i have") || command.equalsIgnoreCase("what do i have?")) {
                showInventory();
                return;
            }
            if (command.equalsIgnoreCase("3") || command.equalsIgnoreCase("what is here") || command.equalsIgnoreCase("what is here?")) {
                showItemsInLocation();
                return;
            }
        }

        if(GMain.mainGGame.commandMode == GCommandMode.NORMAL) {
            String[] commands = command.split(" with ");
            String mainCommand = commands[0];

            String verb = "";
            String noun = "";
            String with = "";

            String[] availableVerbs = GItem.availableActions;
            String[] availableNouns = GMain.mainGGame.currentLocation.getAllItemNames();

            // If there is an error above ... make sure current location is not null by having incorrect name in get location.

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
                if(verb.equalsIgnoreCase("go to")) {
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

                if (!with.equalsIgnoreCase("")) {
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
        else if (GMain.mainGGame.commandMode == GCommandMode.LIVE) {
            // TODO: Command mode for talking and buying, gets turned on from eg. Bar Tender.
            lastCommand = command;
        }
    }

    private boolean arrayHasString(String[] arrayToCheck, String stringToFind) {
        for(String str : arrayToCheck) {
            if (stringToFind.equalsIgnoreCase(str)) {
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
        GMain.mainGGame.setLocation(gLocation);
    }


    public void waitInConsole(int ticks, GLocation gLocation){
        Thread myThread = new Thread(){
            @Override
            public void run() {

                String myString = "";
                for(int i = 0; i < ticks; i++){
                    String adder = "";
                    for(int x = 0; x < (ticks - i); x++){
                        adder = adder + "--";
                    }
                    adder = adder + "|";
                    myString = (myString + " >");
                    GMain.mainGGame.mainGFrame.consoleWrite("|-" + myString + adder);
                    try {
                        this.sleep(80);
                    }
                    catch(Exception e){

                    }
                    // Random event happens here
                    // TODO: Random event will happen here.
                    // calc random
                    double dice = Math.random();
                    if(dice < 0) {
                        if(ticks > 20) { //Sea voyage
                            //new GE
                            new GESailContact();
                        }
                        else {
                            new GEPublicFight();
                        }
                        while(GMain.mainGGame.currentEvent != null){
                            System.out.println("waiting in waitinconsole");
                            try {
                                this.sleep(1);
                            }
                            catch(Exception e){

                            }
                        }
                    }
                }

                GMain.mainGGame.currentLocation = gLocation;
                GMain.mainGGame.setRegionToRender();
                GMain.mainGGame.mainGCommander.showLocation();
                GMain.mainGGame.currentLocation.showEntryInfo();

                GMain.mainGGame.printInfo("Location change Thread has completed.");
            }
        };

        myThread.start();
    }

    public void showLocation(){
        GMain.mainGGame.mainGFrame.consoleWrite("I am in " + GMain.mainGGame.currentLocation.name + "\n\tConnections:");
        for(GLocation child : GMain.mainGGame.currentLocation.connections){
            GMain.mainGGame.mainGFrame.consoleAdd("\n\t\t" + child.name);
        }
    }

    public void showInventory(){
        GMain.mainGGame.mainGFrame.consoleWrite("I have:");
        // TODO: add nothing message
        for(GItem child : GMain.mainGGame.mainGPlayer.inventory){
            GMain.mainGGame.mainGFrame.consoleAdd("\n\t" + child.names[0]);
        }
    }

    public void showItemsInLocation(){
        GMain.mainGGame.mainGFrame.consoleWrite("Items here:");
        // TODO: add nothing message
        for(GItem child : GMain.mainGGame.currentLocation.items){
            GMain.mainGGame.mainGFrame.consoleAdd("\n\t" + child.names[0]);
        }
    }
}
