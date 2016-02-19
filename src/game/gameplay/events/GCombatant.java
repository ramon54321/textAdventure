package game.gameplay.events;

import game.GMain;
import game.gameplay.GPerson;

/**
 * Created by Ramon on 2/6/16.
 */
public class GCombatant {

    public GLEFight fight;
    public GWeapon weapon;
    public GCombatant targetCom;
    public boolean isPlayer;
    public GPerson person;

    public GCombatant(GLEFight fight){
        this.fight = fight;
        this.person = GMain.mainGGame.mainGPlayer.person;
        this.isPlayer = true;
    }

    public GCombatant(GLEFight fight, GPerson person, boolean isPlayer){
        this.fight = fight;
        this.isPlayer = isPlayer;
        this.person = person;
    }

    public void addNewTarget(GCombatant target){
        this.targetCom = target;
    }

    public void addNewWeapon(GWeapon weapon){
        this.weapon = weapon;
    }

    public void hitPointCheck(){
        if(person.getHealthCurrent() < 0){
            GMain.mainGGame.mainGFrame.consoleAddLine("Fight over because hitpoints at " + person.getHealthCurrent());
            fight.finishFight(this);
        }
        else{
            GMain.mainGGame.mainGFrame.consoleAddLine(person.getName() + " Hitpoints -> " + person.getHealthCurrent());
        }
    }

    public void resetAdvantageDefence(){
        person.setDefenceAdvantage(0);
    }

    public void resetAdvantageAttack(){
        weapon.attackAdvantage = 0;
    }

    public void increaseDefenceBonus(int num){
        person.setDefenceBonus(person.getDefenceBonus() + num);
        weapon.attackBonus -= num;
    }

    public void increaseAttackBonus(int num){
        weapon.attackBonus += num;
        person.setDefenceBonus(person.getDefenceBonus() - num);
    }

    public void inflictDamage(int damage){
        person.setHealthCurrent(person.getHealthCurrent() - damage);
        hitPointCheck();
    }

}
