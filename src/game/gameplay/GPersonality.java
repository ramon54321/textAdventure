package game.gameplay;

/**
 * Created by Ramon on 1/25/16.
 *
 * Main personality class for NPC
 *
 */
public class GPersonality {

    public String name;
    private int moodLevel;
    private int friendLevel;
    private int drunkLevel;

    // TODO: fight characteristics

    public GPersonality (String name) {
        this.name = name;
    }

    public void moodLevelUp(){
        this.moodLevel++;
    }

    public void friendLevelUp(){
        this.friendLevel++;
    }

    public void DrunkLevelUp(){
        this.drunkLevel++;
    }

    public void moodLevelDown(){
        this.moodLevel--;
    }

    public void friendLevelDown(){
        this.friendLevel--;
    }

    public void drunkLevelDown(){
        this.drunkLevel--;
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = moodLevel;
    }

    public void setFriendLevel(int friendLevel) {
        this.friendLevel = friendLevel;
    }

    public void setDrunkLevel(int drunkLevel) {
        this.drunkLevel = drunkLevel;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public int getFriendLevel(){
        return friendLevel;
    }

    public int getDrunkLevel(){
        return drunkLevel;
    }
}
