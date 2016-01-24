package game.gameplay;

import game.GGame;
import game.gameplay.items.GItem;

import java.util.ArrayList;

/**
 * Created by Ramon on 1/18/16.
 *
 * GGame.GMain player class
 * Stores data about player state and abilities
 *
 */
public class GPlayer {

    private GGame gGame;
    public ArrayList<GItem> inventory = new ArrayList<GItem>();

    // TODO: Fix inventory

    public GPlayer(GGame gGame) {
        this.gGame = gGame;
    }

    public boolean hasItemInInventoryByName(String name){
        for(GItem item : inventory){
            for(String itemName : item.names)
            {
                if(itemName.equals(name)){
                    return true;
                }
            }
        }
        return false;
    }

    public GItem getItemInInventoryByName(String name){
        for(GItem item : inventory){
            for(String itemName : item.names)
            {
                if(itemName.equals(name)){
                    return item;
                }
            }
        }
        return null;
    }

}
