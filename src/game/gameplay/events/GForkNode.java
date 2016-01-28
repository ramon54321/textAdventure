package game.gameplay.events;

import game.GMain;

import java.util.ArrayList;

/**
 * Created by Ramon on 1/26/16.
 */
public class GForkNode extends GNavigator{

    public ArrayList<GActionNode> actionNodes = new ArrayList<GActionNode>();
    public GLiveEvent parentEvent;

    public GForkNode (GLiveEvent parentEvent, String... optionTexts) {
        this.parentEvent = parentEvent;
        for (String option : optionTexts)
            actionNodes.add(new GActionNode(option, null));
    }

    public void showOptions() {
        GMain.mainGGame.mainGFrame.consoleAddLine("");
        for (int i = 0 ; i < actionNodes.size() ; ++i)
            GMain.mainGGame.mainGFrame.consoleAddLine((i+1) + " .. " + actionNodes.get(i).optionText);
    }

    public void runOption(int index) {
        actionNodes.get(index).executeAction();
    }

    public GActionNode getActionNodeByOptionText(String optionText){
        for(GActionNode node : actionNodes){
            if(node.optionText.equalsIgnoreCase(optionText)){
                return node;
            }
        }
        return null;
    }

}
