package game.gameplay.locations;

import game.GGame;
import game.GMain;
import game.gameplay.items.GItem;

import java.util.ArrayList;

/**
 * Created by Ramon on 1/18/16.
 *
 * Each location is a derived class.
 * Connections will follow a hierarchy, where the parent adds to connection to the child, unless
 * a one way specific connection that requires the child to make the connection.
 *
 * Adding new location
 * Duplicate location subclass and amend constructor, add location in GGame class.
 *
 * Items are now added to the locations from the location class itself.
 *
 *  +->  Nassau Port
 *      +-> Nassau Town Market
 *          --> Nassau Town Market Under Banner
 *          --> Nassau Town Market Food Stall
 *          --> Nassau Town Market General Stall
 *          --> Nassau Town Market Tailor
 *      --> Nassau Town Square
 *          --> Nassau Town Square Fountain
 *          --> Nassau Town Square Behind Barrels
 *      +-> Nassau Pub
 *          --> Nassau Pub Backroom
 *          --> Nassau Pub Lavatory
 *      --> Nassau Captain Flint's Cove
 *      --> Nassau Flamingo Lagoon
 *      --> Nassau Forrest North
 *          --> Nassau Forrest North Cave Entrance
 *          --> Nassau Forrest North Cave
 *          --> Nassau Forrest North Cave Back Room
 *      --> Nassau Forrest South
 *      --> Nassau Fort
 *      --> Nassau Fort Pathway
 *      --> Nassau Suburb East
 *      --> Nassau Suburb North
 *      --> Nassau Boat Yard
 *      --> Nassau Town Blacksmith
 *      --> Nassau Town Bank
 *      --> Nassau West Hills
 *      --> Nassau Marsh
 *      --> Nassau South Beach
 *      --> Nassau Black Beard Tower
 *      --> Nassau Clifton Point
 *      --> Nassau Old Lighthouse
 *  --> Boston Harbour
 *      --> Boston City Hall
 *      --> Boston City Jail
 *
 *
 *
 *
 *
 *
 */
public class GLocation {
    
    protected GGame gGame;

    public String name = "Unnamed";
    public ArrayList<GItem> items = new ArrayList<GItem>();
    public ArrayList<GLocation> connections = new ArrayList<GLocation>();

    public int xPos = 0;
    public int yPos = 0;

    public GLocation() {

    }

    public GLocation(GGame gGame, int xPos, int yPos, String name, GItem[] items) {
        this.gGame = gGame;
        this.xPos = xPos;
        this.yPos = yPos;
        this.name = name;
        for(GItem item : items) {
            this.items.add(item);
        }
    }

    public void showEntryInfo(){
        GMain.mainGGame.mainGCommander.showLocation();
        GMain.mainGGame.mainGFrame.consoleAddLine("\nStrange area this is...");
    }

    public void startEntryEvent() {
        showEntryInfo();
    }

    public boolean containsItem(String itemName) {
        for(GItem item : items) {
            for(String name : item.names) {
                if (name.equalsIgnoreCase(itemName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public GItem getItem(String itemName) {
        for(GItem item : items) {
            for(String name : item.names) {
                if (name.equalsIgnoreCase(itemName)) {
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
        GLocation toLoc =  gGame.getLocationByName(to);

        if(!this.connections.contains(toLoc)) {
            this.connections.add(toLoc);
        }
        if(isTwoWay) {
            if(!toLoc.connections.contains(this)) {
                toLoc.connections.add(this);
            }
        }
    }

    public void makeConnections() {

    }
}
