package game.gameplay.events;

import game.GMain;
import game.gameplay.GPerson;

/**
 * Created by Ramon on 2/6/16.
 */
public class GCombatant {

    public GLEFight fight;
    public GWeapon weapon;
    public int hitPoints;
    public int defendConst;
    public int defendBonus = 0;
    public GCombatant targetCom;
    public String name;

    public GCombatant(GLEFight fight, int hitPoints, int defendConst){
        this.fight = fight;
        this.hitPoints = hitPoints;
        this.defendConst = defendConst;
    }

    public GCombatant(GLEFight fight, GPerson person){
        this.fight = fight;
        this.hitPoints = person.getHealthCurrent();
        this.defendConst = person.getDefenceConst();
    }

    public void addNewTarget(GCombatant target){
        this.targetCom = target;
    }

    public void addNewWeapon(GWeapon weapon){
        this.weapon = weapon;
    }

    public void hitPointCheck(){
        if(hitPoints < 0){
            GMain.mainGGame.mainGFrame.consoleAddLine("Fight over because hitpoints at " + hitPoints);
            fight.finishFight(this);
        }
        else{
            GMain.mainGGame.mainGFrame.consoleAddLine(name + " Hitpoints -> " + hitPoints);
        }
    }

}
