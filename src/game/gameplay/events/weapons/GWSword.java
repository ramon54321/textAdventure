package game.gameplay.events.weapons;

import game.GMain;
import game.gameplay.events.GCombatant;
import game.gameplay.events.GForkNode;
import game.gameplay.events.GLEFight;
import game.gameplay.events.GWeapon;

/**
 * Created by Ramon on 2/6/16.
 */
public class GWSword extends GWeapon{

    private GLEFight currentFight;
    private GCombatant owner;

    public GWSword(GLEFight event, GCombatant owner){
        currentFight = event;
        this.owner = owner;
        attackConst = 100;
        attackBonus = 0;
        attackFork = new GForkNode(event, "Slash", "Stab");
        defendFork = new GForkNode(event, "Block", "Duck");

        attackFork.actionNodes.get(0).setOptionAction(() -> attack0());
        //attackFork.actionNodes.get(1).setOptionAction(() -> attack1());
        defendFork.actionNodes.get(0).setOptionAction(() -> defend0());
        //defendFork.actionNodes.get(1).setOptionAction(() -> defend1());
    }

    private void attack0(){
        GMain.mainGGame.mainGFrame.consoleAddLine("Slash!");

        int A = 60 + (int)(Math.random() * 100);
        int B = owner.targetCom.defendConst + owner.targetCom.defendBonus;
        //GMain.mainGGame.mainGFrame.consoleAddLine("What...");
        int C = A - B;
        int D = (int)(Math.random() * 100);

        if(D < C){
            // Hit
            int E = (int)((attackConst / 5) + ((Math.random() - 0.5) * (attackConst / 10)));
            GMain.mainGGame.mainGFrame.consoleAddLine("Hit -> Damage -> " + E);
            owner.targetCom.inflictDamage(E);
        }
        else{
            GMain.mainGGame.mainGFrame.consoleAddLine("Countered!");
        }

        if(owner.isPlayer) {
            currentFight.isTimed = true;
            currentFight.currentObject = defendFork;
        }
        else {
            currentFight.finishTurn();
        }

    }

    private void defend0(){

        owner.increaseDefenceBonus(500);

        backToAttack();
    }

    private void backToAttack(){
        currentFight.isTimed = false;
        currentFight.currentObject = attackFork;
        currentFight.finishTurn();
    }

}
