package game.gameplay.locations;

import game.gameplay.items.GItem;

import java.util.ArrayList;

/**
 * Created by Ramon on 1/18/16.
 */
public class GLocation {

    public String name = "Unnamed";
    public ArrayList<GItem> items = new ArrayList<GItem>();
    public ArrayList<GLocation> connections = new ArrayList<GLocation>();

    public GLocation(String name, GItem[] items) {
        this.name = name;
        for(GItem item : items) {
            this.items.add(item);
        }
    }

    public boolean containsItem(String itemName) {
        for(GItem item : items) {
            if(item.name.equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    public GItem getItem(String itemName) {
        for(GItem item : items) {
            if(item.name.equals(itemName)) {
                return item;
            }
        }
        return null;
    }
}
