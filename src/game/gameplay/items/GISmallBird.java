package game.gameplay.items;

/**
 * Created by Ramon on 1/18/16.
 */
public class GISmallBird extends GItem {

    public GISmallBird() {
        names =  new String[] {"small bird", "bird", "blue bird"};
        pickupAble = true;
    }

    @Override
    public void pickUp(GItem with) {
        System.out.println("You picked up the bird! Now what?");
    }

    @Override
    public void eat(GItem with) {
        if(with instanceof GISpoon) {
            System.out.println("Gosh, that tastes bad! Spoon was useful though.");
        }
        else {
            System.out.println("Eww! It tastes horrible! At least its a little protein. Hard eating with hands!");
        }
    }

    @Override
    public void drink(GItem with) {
        System.out.println("Drink? What? Its blood? No thanks!");
    }

    @Override
    public void throwItem(GItem with) {
        System.out.println("Wow, that was harsh!");
    }

    @Override
    public void kill(GItem with) {
        if(with instanceof GISpoon) {
            System.out.println("A Spoon! You killed the bird with a spoon!");
        }
        else if(with instanceof GISmallWoodenBox) {
            System.out.println("You crushed the bird with the box!");
        }
        else {
            System.out.println("That was gruesome, you killed the bird with your bare hands.");
        }
    }
}
