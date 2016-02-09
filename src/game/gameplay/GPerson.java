package game.gameplay;

import game.GMain;

/**
 * Created by Ramon on 2/8/16.
 *
 * Main person class. All person objects derive from this.
 *
 */
public class GPerson {

    private String name;
    private int healthMax;
    private int healthCurrent;
    private int defenceConst;
    private int defenceBonus;

    public GPerson ( String name, int healthMax, int healthCurrent, int defenceConst ) {
        this.name = name;
        this.healthMax = healthMax;
        this.healthCurrent = healthCurrent;
        this.defenceConst = defenceConst;
        this.defenceBonus = 0;
    }

    public String getName() {
        return name;
    }

    public int getDefenceConst() {
        return defenceConst;
    }

    public int getDefenceBonus() {
        return defenceBonus;
    }

    public int getHealthCurrent() {
        return healthCurrent;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public void setDefenceConst(int defenceConst) {
        this.defenceConst = defenceConst;
    }

    public void setDefenceBonus(int defenceBonus) {
        this.defenceBonus = defenceBonus;
    }

    public void setHealthCurrent(int healthCurrent) {
        this.healthCurrent = healthCurrent;
    }

    public void setHealthMax(int healthMax) {
        this.healthMax = healthMax;
    }

    public void setHealthIncrement(){
        if(healthCurrent < healthMax)
            this.healthCurrent++;
    }

    public void setHealthDecrement(){
        if(healthCurrent > GMain.mainGGame.person_health_minimumBleedingLevel)
            this.healthCurrent--;
    }
}
