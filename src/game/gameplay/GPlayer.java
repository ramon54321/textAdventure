package game.gameplay;

import game.Game;
import game.gameplay.items.GItem;

import java.util.ArrayList;

/**
 * Created by Ramon on 1/18/16.
 */
public class GPlayer {

    private Game game;
    private ArrayList<GItem> inventory = new ArrayList<GItem>();

    // TODO: Fix inventory

    public GPlayer(Game game) {
        this.game = game;
    }


}
