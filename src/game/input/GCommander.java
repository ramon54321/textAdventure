package game.input;

import game.Game;

import java.lang.reflect.Method;

/**
 * Created by Ramon on 1/18/16.
 */
public class GCommander{

    private Game game;
    public Thread keyListenThread;

    public GCommander(Game game) {
        this.game = game;
        //keyListenThread = new Thread(this);
        //keyListenThread.start();
    }

    public void parseCommand(String command) {

        // TODO: Improve text parser
        System.out.println("Received command: " + command);

        String verb = "";
        String noun = "";

        String[] parts = command.split(" ");
        if(parts.length > 1) {
            verb = parts[0];
            noun = parts[1];
        }

        sendAction(verb, noun);
    }

    private void sendAction(String verb, String noun) {
        if(game.currentLocation.containsItem(noun)) {
            //TODO: Complete switch with all interactables
            switch (verb) {
                case "pickup":
                    game.currentLocation.getItem(noun).pickUp();
                    break;
                case "break":
                    game.currentLocation.getItem(noun).breakItem();
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
