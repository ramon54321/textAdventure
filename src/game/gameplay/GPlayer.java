package game.gameplay;

import game.GGame;
import game.GMain;
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

    public ArrayList<GItem> inventory = new ArrayList<GItem>();
    private int hitPoints = 180;
    private int maxHitPoints = 180;

    // TODO: Fix inventory

    public GPlayer() {

    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }

    public void maxOutHitPoints(){
        hitPoints = maxHitPoints;
    }

    public void increaseHitPoints(){
        if(hitPoints < maxHitPoints){
            hitPoints++;
        }
    }

    public boolean hasItemInInventoryByName(String name){
        for(GItem item : inventory){
            for(String itemName : item.names)
            {
                if(itemName.equalsIgnoreCase(name)){
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
                if(itemName.equalsIgnoreCase(name)){
                    return item;
                }
            }
        }
        return null;
    }

    public void pickUpItem(GItem item){
        inventory.add(item);
        GMain.mainGGame.currentLocation.items.remove(item);
    }

}
