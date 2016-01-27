package game.gameplay.events;

import game.GMain;

/**
 * Created by Ramon on 1/26/16.
 */
public class GActionNode extends GNavigator{

    public interface Action {
        void doAction();
    }

    public String optionText;
    public Action actionContent;

    public void executeAction() {
        if (actionContent == null)
            return ;
        else
            GMain.mainGGame.mainGFrame.consoleClear();
            actionContent.doAction();
    }

    public GActionNode (String text, Action function) {
        optionText = text;
        actionContent = function;
    }

    public GActionNode (String text) {
        this(text, null);
    }

    public GActionNode (Action function) {
        this(null, function);
    }

    public void setOptionText(String newText) {
        optionText = newText ;
    }

    public void setOptionAction(Action action) {
        actionContent = action;
    }


}
