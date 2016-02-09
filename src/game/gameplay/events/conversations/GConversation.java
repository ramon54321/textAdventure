package game.gameplay.events.conversations;

import game.GMain;

/**
 * Created by Ramon on 2/6/16.
 */
public class GConversation {

    private String[] convoLines;

    public GConversation(String[] convoLines){
        this.convoLines = convoLines;
    }

    public void narrateConversation(){
        for(String line : convoLines){
            GMain.mainGGame.mainGFrame.consoleAddLine(line.split("-")[1]);
            int delay = Integer.parseInt(line.split("-")[0]);
            try{Thread.sleep(delay);}catch (Exception e){}
        }
    }

}
