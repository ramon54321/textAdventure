package game.gameplay.items;

import game.interfaces.GInteractable;

/**
 * Created by Ramon on 1/18/16.
 *
 * Adding an item...
 * Copy an existing item subclass, adjust overrides and change values in constructor
 *
 * Adding an action...
 * Add action to GInteractable, add dafault func to this class, add verb to verb list in this class, add function call to GCommander.
 *
 */
public class GItem implements GInteractable {

    public String[] names = new String[] {"Unnamed"};
    public boolean pickupAble = false;

    public static String[] availableActions = new String[] {
            "break", "throw", "look at", "eat", "drink", "pick up", "kill", "read"
    };

    @Override
    public void breakItem(GItem with) {
        System.out.println("Broken...");
    }

    @Override
    public void throwItem(GItem with) {
        System.out.println("Thrown...");
    }

    @Override
    public void lookAt(GItem with) {
        System.out.println("Can't see that to well actually...");
    }

    @Override
    public void eat(GItem with) {
        System.out.println("Not useful...");
    }

    @Override
    public void drink(GItem with) {
        System.out.println("Can't do that, sorry.");
    }

    @Override
    public void pickUp(GItem with) {
        System.out.println("Can't pick that up.");
    }

    @Override
    public void kill(GItem with) {
        System.out.println("I can't kill that...");
    }

    @Override
    public void read(GItem with) {
        System.out.println("I can't read that...");
    }
}
