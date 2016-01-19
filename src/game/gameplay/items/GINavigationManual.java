package game.gameplay.items;

/**
 * Created by Ramon on 1/18/16.
 */
public class GINavigationManual extends GItem {

    public GINavigationManual() {
        names =  new String[] {"nav book", "navigation book", "navigation manual"};
        pickupAble = true;
    }

    @Override
    public void pickUp(GItem with) {
        System.out.println("You picked up the spoon. Could come in handy.");
    }

    @Override
    public void read(GItem with) {
        System.out.println("This is a very interesting book, I should keep reading!");
    }

    @Override
    public void throwItem(GItem with) {
        System.out.println("Pretty pointless...");
    }
}
