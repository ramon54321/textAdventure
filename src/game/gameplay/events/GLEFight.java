package game.gameplay.events;

import game.GMain;
import game.gameplay.GPerson;
import game.gameplay.GWorldData;
import game.gameplay.events.weapons.GWSword;

/**
 * Created by Ramon on 1/26/16.
 */
public class GLEFight extends GLiveEvent implements Runnable{

    public enum combatState {
        attack,
        defend
    }

    private combatState currentCombatState = combatState.attack;

    public GCombatant player1;
    public GCombatant player2;

    public boolean playerTurn = true;
    private GPerson enemy;
    private String enemyName;

    public GLEFight(boolean useNewThread, GPerson enemy){
        this.enemy = enemy;
        if(useNewThread) {
            Thread newThread = new Thread(this);
            newThread.start();
        }
        else{
            run();
        }
    }

    private void switchTurns(){
        if(playerTurn) {
            playerTurn = false;
        }
        else{
            playerTurn = true;
        }
    }

    public void finishTurn(){
        // do AI combat moves here
        switchTurns();
        if(isRunning) {
            if (playerTurn) {

            } else {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                }
                player2.weapon.attackFork.actionNodes.get(0).executeAction();
            }
        }
    }

    public void finishFight(GCombatant losingPlayer){
        if(losingPlayer == player2){
            // You win
            GMain.mainGGame.mainGFrame.consoleAddLine("(You won)");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            eventEnd();
        }
        else {
            // You lose
            GMain.mainGGame.mainGFrame.consoleAddLine("(You lost)");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            eventEnd();
        }
    }

    @Override
    public void run() {
        eventStart(this);
        player1 = new GCombatant(this, GMain.mainGGame.mainGPlayer.getHitPoints(), 30);
        player2 = new GCombatant(this, enemy);

        player1.addNewTarget(player2);
        player2.addNewTarget(player1);

        player1.addNewWeapon(new GWSword(this, player1));
        player2.addNewWeapon(new GWSword(this, player2));

        player1.name = "Captain Flint";
        player2.name = enemy.getName();

        GMain.mainGGame.mainGFrame.consoleAddLine("** Fight! **");

        currentObject = player1.weapon.attackFork;

        while(isRunning) {
            GNarrator.narrate(currentObject);
        }

        GMain.mainGGame.printInfo("LiveEvent Thread complete.");
    }
}
