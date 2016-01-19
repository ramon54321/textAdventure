package game.gameplay.locations;

import game.Game;
import game.gameplay.items.GItem;

import java.util.ArrayList;

/**
 * Created by Ramon on 1/18/16.
 */
public class GLocation {

    protected Game game;

    public String name = "Unnamed";
    public ArrayList<GItem> items = new ArrayList<GItem>();
    public ArrayList<GLocation> connections = new ArrayList<GLocation>();

    public int xPos = 0;
    public int yPos = 0;

    public GLocation() {

    }

    public GLocation(Game game, int xPos, int yPos, String name, GItem[] items) {
        this.game = game;
        this.xPos = xPos;
        this.yPos = yPos;
        this.name = name;
        for(GItem item : items) {
            this.items.add(item);
        }
    }

    public boolean containsItem(String itemName) {
        for(GItem item : items) {
            for(String name : item.names) {
                if (name.equals(itemName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public GItem getItem(String itemName) {
        for(GItem item : items) {
            for(String name : item.names) {
                if (name.equals(itemName)) {
                    return item;
                }
            }
        }
        return null;
    }

    public String[] getAllItemNames() {
        ArrayList<String> itemNames = new ArrayList<String>();
        for(GItem item : items) {
            for(String name : item.names) {
                itemNames.add(name);
            }
        }
        return itemNames.toArray(new String[itemNames.size()]);
    }

    public void makeConnectionTo(String to, boolean isTwoWay) {
        GLocation toLoc =  game.getLocationByName(to);

        this.connections.add(toLoc);
        if(isTwoWay) {
            toLoc.connections.add(this);
        }
    }

    public void makeConnections() {

    }
}
