package game.gameplay.combat;

/**
 * Created by Ramon on 1/26/16.
 */
public class GCombat {

    public String lastCommand = null;

    public GCombat(){

    }

    public String getInput(){
        while(lastCommand == null){

        }
        String temp = lastCommand;
        lastCommand = null;
        return temp;
    }

}
