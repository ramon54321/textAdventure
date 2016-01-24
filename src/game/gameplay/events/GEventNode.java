package game.gameplay.events;

import java.util.ArrayList;

/**
 * Created by Ramon on 1/24/16.
 */
public class GEventNode {
    public ArrayList<GEventNode> children = new ArrayList<GEventNode>();
    private GEventNode parent = null;

    public GEventNode() {

    }

    public GEventNode(GEventNode parent, int index) {
        this.parent = parent;
        parent.addChild(this, index);
    }

    public void addChild(GEventNode child, int index) {
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
