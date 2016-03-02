package game.gameplay.events;

import game.GMain;
import game.gameplay.GPerson;
import game.gameplay.GWorldData;
import game.gameplay.events.weapons.GWSword;

import javax.swing.plaf.metal.MetalTheme;

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

    public GLEFight(boolean useNewThread, GPerson enemy){
        this.enemy = enemy;
        this.isFight  = true;
        if(useNewThread) {
            Thread newThread = new Thread(this);
            newThread.start();
        }
        else{
            run();
        }
    }

    private void switchTurns(){
        if(playerTurn) { // becomes enemy turn -> keep defence but loose attack -> enemny keeps attack looses defence
            playerTurn = false;
            player1.resetAdvantageAttack();
            player2.resetAdvantageDefence();
        }
        else{
            playerTurn = true;
            player2.resetAdvantageAttack();
            player1.resetAdvantageDefence();
        }
    }

    public void showFightStats(){
        GMain.mainGGame.mainGFrame.instantWrite(player1.person.getName() + "\nHitpoints: " + player1.person.getHealthCurrent()
                + "\nAttack Constant: " + player1.weapon.attackConst
                + "\nAttack Bonus: " + player1.weapon.attackBonus +
                "\nAttack Advantage: " + player1.weapon.attackAdvantage +
                "\nDefence Constant: " + player1.person.getDefenceConst() +
                "\nDefence Bonus: " + player1.person.getDefenceBonus() +
                "\nDefence Advantage: " + player1.person.getDefenceAdvantage()

                + "\n\n" + player2.person.getName() + "\nHitpoints: " + player2.person.getHealthCurrent() +
                "\nAttack Constant: " + player2.weapon.attackConst +
                "\nAttack Bonus: " + player2.weapon.attackBonus +
                "\nAttack Advantage: " + player2.weapon.attackAdvantage +
                "\nDefence Constant: " + player2.person.getDefenceConst() +
                "\nDefence Bonus: " + player2.person.getDefenceBonus() +
                "\nDefence Advantage: " + player2.person.getDefenceAdvantage()


        );
    }

    public void finishTurn(){
        // do AI combat moves here
        switchTurns();
        //prints

        showFightStats();

        if(isRunning) {
            if (playerTurn) {
                //player1.resetBonuses();

            } else {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                }

                // Ai Contol

                // attack player
                int rand = Math.round((float)Math.random() * 1);
                player2.weapon.attackFork.actionNodes.get(rand).executeAction();
            }
        }
    }

    public void finishFight(GCombatant losingPlayer){
        showFightStats();
        GMain.mainGGame.mainGFrame.consoleAddLine("Time to go to the pub!");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
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
        player1 = new GCombatant(this);
        player2 = new GCombatant(this, enemy, false);

        player1.addNewTarget(player2);
        player2.addNewTarget(player1);

        player1.addNewWeapon(new GWSword(this, player1));
        player2.addNewWeapon(new GWSword(this, player2));

        GMain.mainGGame.mainGFrame.consoleAddLine("** Fight! **");

        currentObject = player1.weapon.attackFork;

        showFightStats();

        while(isRunning) {
            GNarrator.narrate(currentObject);
        }

        GMain.mainGGame.printInfo("LiveEvent Thread complete.");
    }
}
