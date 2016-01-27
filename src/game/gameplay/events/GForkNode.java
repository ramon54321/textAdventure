package game.gameplay.events;

import java.util.ArrayList;

/**
 * Created by Ramon on 1/26/16.
 */
public class GForkNode extends GNavigator{

    public ArrayList<GActionNode> actionNodes = new ArrayList<GActionNode>();

    public GForkNode (String... optionTexts) {
        for (String option : optionTexts)
            actionNodes.add(new GActionNode(option, null));
    }

    public void showOptions() {
        for (int i = 0 ; i < actionNodes.size() ; ++i)
            System.out.println((i+1) + " .. " + actionNodes.get(i).optionText);
    }

    public void runOption(int index) {
        actionNodes.get(index).executeAction();
    }

}
