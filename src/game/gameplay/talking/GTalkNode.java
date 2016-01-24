package game.gameplay.talking;

import java.util.ArrayList;

/**
 * Created by Ramon on 1/22/16.
 *
 *
 * EXAMPLE:
 *
 GTalkNode talk_0A = new GTalkNode(){
@Override
public void execute() {
GMain.mainGGame.currentTalkNode = this;
GMain.mainGGame.mainGFrame.consoleWrite(
"Bartender: Waddya want?\n\t" +
"a) Nothing...\n\t" +
"b) A beer!\n\t" +
"c) What do you know about this missing schedule everyone is talking about?\n\t" +
"d) Never mind... Im leaving.");
}
};

 // Level 1
 GTalkNode talk_1A = new GTalkNode(talk_0A, 0){
@Override
public void execute() {
GMain.mainGGame.currentTalkNode = this;
GMain.mainGGame.mainGFrame.consoleWrite("This is 1a");
}
};
 GTalkNode talk_1B = new GTalkNode(talk_0A, 1){
@Override
public void execute() {
GMain.mainGGame.currentTalkNode = this;
GMain.mainGGame.mainGFrame.consoleWrite("This is 1b");
}
};
 GTalkNode talk_1C = new GTalkNode(talk_0A, 2){
@Override
public void execute() {
GMain.mainGGame.currentTalkNode = this;
GMain.mainGGame.mainGFrame.consoleWrite("This is 1c");
}
};
 GTalkNode talk_1D = new GTalkNode(talk_0A, 3){
@Override
public void execute() {
GMain.mainGGame.currentTalkNode = this;
GMain.mainGGame.mainGFrame.consoleWrite("Bog off then!\n\t");

// Exit talking
talkEnd();
}
};


 *
 *
 * For each node, create a node reference and create a new node with parameters( parent node, option )
 *
 * so if I want a child node to be created.
 *
 * GTalkNode talk_3ADB = new GTalkNode(talk_2AD, 1) {
 *     exe
 * }
 *
 * Remember 0 -> A, 1 -> B, 2 -> C and 3 -> D
 * Remember to specify the parent in the parameters or it wont work!
 *
 *
 */
public class GTalkNode {
    public ArrayList<GTalkNode> children = new ArrayList<GTalkNode>();
    private GTalkNode parent = null;

    public GTalkNode() {

    }

    public GTalkNode(GTalkNode parent, int index) {
        this.parent = parent;
        parent.addChild(this, index);
    }

    public void addChild(GTalkNode child, int index) {
        this.children.add(index ,child);
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if(this.children.size() == 0)
            return true;
        else
            return false;
    }

    public void removeParent() {
        this.parent = null;
    }

    public void execute() {
        // Do something

    }

}
