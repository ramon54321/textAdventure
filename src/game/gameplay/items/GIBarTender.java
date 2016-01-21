package game.gameplay.items;

/**
 * Created by Ramon on 1/18/16.
 */
public class GIBarTender extends GItem {

    public GIBarTender() {
        names =  new String[] {"spoon", "metal spoon", "old spoon"};
        pickupAble = true;
    }

    @Override
    public void pickUp(GItem with) {
        System.out.println("You picked up the spoon. Could come in handy.");
    }

    @Override
    public void eat(GItem with) {
        System.out.println("I can't chew metal.");
    }

    @Override
    public void drink(GItem with) {
        System.out.println("Its metal, not drinking that.");
    }

    @Override
    public void throwItem(GItem with) {
        System.out.println("Pretty pointless...");
    }
}
