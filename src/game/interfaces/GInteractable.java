package game.interfaces;

import game.gameplay.items.GItem;

/**
 * Created by Ramon on 1/18/16.
 */
public interface GInteractable {

    void pickUp(GItem with);
    void breakItem(GItem with);
    void throwItem(GItem with);
    void lookAt(GItem with);
    void eat(GItem with);
    void drink(GItem with);
    void kill(GItem with);
    void read(GItem with);

}
