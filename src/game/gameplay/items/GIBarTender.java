package game.gameplay.items;

/**
 * Created by Ramon on 1/18/16.
 *
 * A uniique bartender class needs to be created for each bartender in order to have the correct speech.
 *
 */
public class GIBarTender extends GItem {

    public GIBarTender() {
        names =  new String[] {"bartender"};
        pickupAble = true;
    }

    @Override
    public void pickUp(GItem with) {
        System.out.println("You can't pick up a person!");
    }

    @Override
    public void talkTo(GItem with) {
        System.out.println("Bartender: Wat ya want? \n\ta) Nothing...\n\tb) A beer!\n\tc) What do you know about this missing schedule " +
                "everyone is talking about?\n\td) Never mind... Im leaving.");
        // if buy blabla
        // TODO: Buy items, separate command input
    }
}
