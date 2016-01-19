package game.gameplay.items;

/**
 * Created by Ramon on 1/18/16.
 */
public class GISmallWoodenBox extends GItem {

    public GISmallWoodenBox() {
        names = new String[] {"box", "wooden box"};
        pickupAble = true;
    }

    @Override
    public void pickUp(GItem with) {
        System.out.println("You picked up the wooden box!");
    }

    @Override
    public void breakItem(GItem with) {
        System.out.println("Well done, you broke it, now what is it useful for?");
    }

    @Override
    public void eat(GItem with) {
        System.out.println("A Box? Sorry I can't eat a box...");
    }

    @Override
    public void drink(GItem with) {
        System.out.println("You want me to drink the box? Really? Nah sorry not doing that.");
    }

    @Override
    public void lookAt(GItem with) {
        System.out.println("Ooohh pretty... a box...");
    }
}
