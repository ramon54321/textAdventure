package game.gameplay.items;

/**
 * Created by Ramon on 1/18/16.
 */
public class GISmallWoodenBox extends GItem {

    public GISmallWoodenBox() {
        name = "box";
    }

    @Override
    public void pickUp() {
        System.out.println("You picked up the wooden box!");
    }
}
