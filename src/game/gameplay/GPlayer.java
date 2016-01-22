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
    private ArrayList<GItem> inventory = new ArrayList<GItem>();

    // TODO: Fix inventory

    public GPlayer(GGame gGame) {
        this.gGame = gGame;
    }


}
