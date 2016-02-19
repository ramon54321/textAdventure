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
        attackAdvantage = 0;
        attackFork = new GForkNode(event, "Slash (More Reliable : Less Damage)", "Stab (Less Reliable : More Damage)");
        defendFork = new GForkNode(event, "Block (Increased Defence x2 : Decreased Attack x2)", "Dodge" +
                " (Temporary Defence)", "Parry (Decreased Defence : Increased Attack)");

        attackFork.actionNodes.get(0).setOptionAction(() -> attack0());
        attackFork.actionNodes.get(1).setOptionAction(() -> attack1());
        defendFork.actionNodes.get(0).setOptionAction(() -> defend0());
        defendFork.actionNodes.get(1).setOptionAction(() -> defend1());
        defendFork.actionNodes.get(2).setOptionAction(() -> defend2());
    }

    private void attack0(){ // slash
        currentFight.showFightStats();
        GMain.mainGGame.mainGFrame.consoleAddLine("Slash!");

        int A = 60 + (int)(Math.random() * 40);
        int B = owner.targetCom.person.getDefenceConst() + owner.targetCom.person.getDefenceBonus() + owner.targetCom.person.getDefenceAdvantage();
        int C = A - B;
        int D = (int)(Math.random() * 100);

        GMain.mainGGame.mainGFrame.consoleAddLine("A Baseline           60 - 160      -> " + A);
        GMain.mainGGame.mainGFrame.consoleAddLine("B Defence                          -> " + B);
        GMain.mainGGame.mainGFrame.consoleAddLine("C Hit Chance : Baseline - Defence  -> " + C);
        GMain.mainGGame.mainGFrame.consoleAddLine("D Random Score        0 - 100      -> " + D);

        if(D < C){
            // Hit
            int E = (((((attackConst * (B / 100)) + attackBonus + attackAdvantage) / 5)));
            int F = (int)(((Math.random() - 0.5) * 2) * (E));

            int G = (E + (F < 0 ? 0 : F)) < 0 ? 0 : (E + (F < 0 ? 0 : F));

            GMain.mainGGame.mainGFrame.consoleAddLine("E Attack - Op Defence % on Const   -> " + E);
            GMain.mainGGame.mainGFrame.consoleAddLine("F Random Offset  +/- (0 - Attack)  -> " + F);
            GMain.mainGGame.mainGFrame.consoleAddLine("Hit -> Damage -> " + G);
            owner.targetCom.inflictDamage(G);
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

    private void attack1(){ // stab
        currentFight.showFightStats();
        GMain.mainGGame.mainGFrame.consoleAddLine("Stab!");

        int A = 20 + (int)(Math.random() * 40);
        int B = owner.targetCom.person.getDefenceConst() + owner.targetCom.person.getDefenceBonus() + owner.targetCom.person.getDefenceAdvantage();
        int C = A - B;
        int D = (int)(Math.random() * 100);

        GMain.mainGGame.mainGFrame.consoleAddLine("A Baseline           60 - 160      -> " + A);
        GMain.mainGGame.mainGFrame.consoleAddLine("B Defence                          -> " + B);
        GMain.mainGGame.mainGFrame.consoleAddLine("C Hit Chance : Baseline - Defence  -> " + C);
        GMain.mainGGame.mainGFrame.consoleAddLine("D Random Score        0 - 100      -> " + D);

        if(D < C){
            // Hit
            int E = (((((attackConst * ((B / 5) / 100)) + attackBonus + attackAdvantage) / 5)));
            int F = (int)(((Math.random() - 0.5) * 2) * (E * 1.5));

            int G = (E + (F < 0 ? 0 : F)) < 0 ? 0 : (E + (F < 0 ? 0 : F));

            GMain.mainGGame.mainGFrame.consoleAddLine("E Attack - Op Defence % on Const   -> " + E);
            GMain.mainGGame.mainGFrame.consoleAddLine("F Random Offset  +/- (0 - Attack)  -> " + F);
            GMain.mainGGame.mainGFrame.consoleAddLine("Hit -> Damage -> " + G);
            owner.targetCom.inflictDamage(G);
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

    private void defend0(){ //block
        currentFight.showFightStats();

        owner.increaseDefenceBonus(4);

        backToAttack();
    }

    private void defend1(){ //dodge
        currentFight.showFightStats();

        owner.person.setDefenceAdvantage(10);

        backToAttack();
    }

    private void defend2(){ //parry
        currentFight.showFightStats();

        owner.increaseAttackBonus(6);

        backToAttack();
    }

    private void backToAttack(){
        currentFight.isTimed = false;
        currentFight.currentObject = attackFork;
        currentFight.finishTurn();
    }


}
