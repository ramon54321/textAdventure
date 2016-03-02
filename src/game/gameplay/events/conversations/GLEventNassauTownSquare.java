package game.gameplay.events.conversations;

import game.GMain;
import game.gameplay.GWorldData;
import game.gameplay.events.*;

/**
 * Created by Ramon on 1/26/16.
 */
public class GLEventNassauTownSquare extends GLiveEvent implements Runnable{

    GForkNode entryFork = new GForkNode(this, "Go to Eleanor's Tavern.", "Go to Max's room.", "Talk to The Punmaster of Nassau.");

    GForkNode tavernEntry = new GForkNode(this, "Ask about business.", "Tell her a story of a Spaniard named Vasquez.");
    GForkNode maxEntry = new GForkNode(this, "Have a chat.");

    public GLEventNassauTownSquare(boolean useNewThread){
        if(useNewThread) {
            Thread newThread = new Thread(this);
            newThread.start();
        }
        else{
            run();
        }
    }

    private void goToTavern(){
        GMain.mainGGame.mainGFrame.consoleAddLine("(You walk past all the people and go into the Tavern)");
        try{Thread.sleep(700);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(People are drinking and talking and having a good time)");
        try{Thread.sleep(700);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You reach Eleanor Guthrie)");
        try{Thread.sleep(400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor Guthrie: Hello James, what are you doing here?");
        currentObject = tavernEntry;
    }

    private void goToMaxRoom(){
        GMain.mainGGame.mainGFrame.consoleAddLine("(You push past the people and up the stairs to Max's room)");
        try{Thread.sleep(700);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You open the door and Max is lying on the bed)");
        try{Thread.sleep(400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Max: Bonjour monsieur, très bien? Mon ami?");
        currentObject = maxEntry;
    }

    private void talkToPunmaster(){
        GMain.mainGGame.mainGFrame.consoleAddLine("(You see the most legendary person of Nassau - The Punmaster - standing in a corner.)");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You approach Him.)");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Oy, you almighty Punmaster. I challenge thee to an ocean pun battle.");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(Ship just got real!)");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Punmaster: I don't quite sea what you mean... I definitely never make ocean puns on porpoise.");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Water you talking about, you just did it again!");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Punmaster: That's a load of carp! It was just a fluke.");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: You're just fishing for compliments!");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Punmaster: Well you’re a little lake to be starting now.");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Stop being so shellfish!");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Punmaster: Astern attitude doesn't befit you.");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: These puns seem rather hoki, if you ask me.");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Punmaster: You think? I sure am jella about how long this list of puns is!");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: *hic* I think someone piked the punch!");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Punmaster: I think the waiter sprat in your soup.");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Did I say that? I’m such a slipmouth.");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Punmaster: That was quite the snapper comeback.");
        try{Thread.sleep(5000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: ...");
        try{Thread.sleep(3000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You lost the battle.)");
        currentObject = entryFork;
    }

    private void askForWood(){

    }

    private void proposeDeal(){
        GMain.mainGGame.mainGFrame.consoleAddLine("(You are in the tavern with Eleanor)");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Here's the cook!");
        try{Thread.sleep(1600);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: He played it dumb and burned the damn schedule!");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: WHAT?! Kill him!");
        try{Thread.sleep(600);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: No! That's the last thing we can do. We must spare his life, or else there goes our only chance at L'Urca de Lima.");
        try{Thread.sleep(3200);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: That motherfuc-");
        try{Thread.sleep(600);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Cook: The name's John, actually. John Silver. For your fortune, I memorized the schedule.");
        //Cook has told his name to you, Eleanor, and Gates.
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Cook: So your only chance to get to Lima's treasures is by taking me with you.");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Or then we just make you write the schedule down!");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: That sounds good. Here's some paper for you. Start writing now, you..!");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(John Silver is writing down the schedule...");
        try{Thread.sleep(6000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("John: There you go! (John gives the schedule to you)");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You read the schedule...)");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Where's the rest of it? This leads to a rather large chunk of ocean. We can't find the ship without the rest of the schedule.");
        try{Thread.sleep(3200);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: Go on, write it down now!");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("John: That wouldn't be very smart for my part, would it?");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("What's to say you wouldn't kill me right after I give it to you? This is my insurance.");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("John: Take me with you, and I'll tell you the rest when we reach the point where we need it.");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: And what's to say we don't kill you then?");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("John: Well, we have a few weeks until that. We might become friends by then!");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Alright, you're coming with us then. But no tricks, or you're dead!");
        try{Thread.sleep(3200);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Gates: Eleanor, we have another issue. The ship's crew is planning a vote to promote Singleton as our captain, and get rid of Captain Flint!");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Gates: We can't let that happen, or we never get to L'Urca de Lima!");
        try{Thread.sleep(3200);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: Oh no, we have to do something...");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: With a bit of money, I could inspire our men to vote for me.");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: You want to buy your crew's votes?");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: That's the only thing we can do right now. The voting happens today, so we need their votes right now!");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: How much do you need? One hundred? Two hundred?");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Actually...");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: I was thinking more like a thousand.");
        try{Thread.sleep(1200);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: A THOUSAND pieces of eight just to inspire your crew?! That's bullsh-");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Gates: Think of it as an investment for the future.");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Gates: With just a thousand pieces of eight we will earn you five million dollars by taking down L'Urca de Lima.");
        try{Thread.sleep(2400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: ...");
        try{Thread.sleep(4000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: Well, I guess you're right. Here's your money.");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Thank you ma'am!");
        try{Thread.sleep(4000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Singleton (from outside): YOU MOTHERFU@*€R, COME 'ERE YOU LITTLE D*£K AND I'LL F*£K YOU SIDEWAYS!!");
        try{Thread.sleep(4000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: What the...");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You rush outside to see what's going on)");
        try{Thread.sleep(4000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You see Singleton, face red with anger, yelling at you.)");
        try{Thread.sleep(4000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(Singleton swings a punch at you.)");

        //Set flag, mission 5 fought Singleton
        tavernEntry.actionNodes.remove(1);
        GMain.mainGGame.mainWorldData.worldFlags.add(GWorldData.GFlags.mission5_FoughtSingleton);

        //TODO: New fight with Singleton
        new GLEFight(true, GMain.mainGGame.person_singleton);
    }

    private void askAboutBusiness(){
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor Guthrie: Business eh? Since when do you care about my business...");
        try{Thread.sleep(1200);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: You know me, testing the waters wherever I may be.");
        try{Thread.sleep(800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor Guthrie: As usual. Why don't you come talk to me when you can earn me money!");
        tavernEntry.actionNodes.remove(0);
    }

    private void tellStoryOfSpaniard(){
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Let me tell you a story, about a Spaniard, named Vasquez...");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: A few weeks ago he staggers into a tavern on Port Royal.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Takes a seat next to an English merchant captain.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Vazquez, it turns out, is dying. Bleeding to death from a knife wound to the belly.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: The knife wound was courtesy of his former employer, La Casa del Contratacion, in Seville.");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: Colonial intelligence.");
        try{Thread.sleep(1000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Naval, more specifically. One of their top agents in the Americas.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Responsible for the security of one particular ship. A ship with a cargo so rich, the king of Spain is very anxious to see it launched.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Vazquez warned that it was too late.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Storm season was upon them and no escort could be mustered to guard her.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: But his superiors demanded that he sign off.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: They advised him that if he couldn't arrange for an escort, he should plot a course for the ship unknown to anyone but her captain.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: And consider that route to be a state secret of the highest order.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: When Vazquez refused and threatened to report his concerns to the court, things got ugly.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: The ship in question...");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: L'Urca de Lima...");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: The largest Spanish treasure galleon in the Americas.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: According to Vazquez, total cargo in excess of 5 million spanish dollars.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: Fascinating story... but how exactly did you come to hear it?");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: A spy in my employ in Port Royal who overheard the conversation.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: I must admit, I harbored my doubts to its authenticity right up until yesterday when I took the merchant captain's ship.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: And found Vazquez's story neatly written into his log.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: Most impressive, It sounds like your plan is neatly resolved. What could you possibly want of me?");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Not quite entirely resolved.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: A page was torn from the log with the Urca's course and schedule written on it.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Now I could recreate it from what's left, but I'd need help.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Someone with expert knowledge of Spanish operations.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Your man in Havana. I need you to make an introduction.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: Absolutely not!");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: I need that schedule! Think of the riches it will bring to this place!");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: You're talking about a floating castle!");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: No one has ever taken a treasure galleon like that as a prize.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Let me worry about hunting her");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: It's what comes after for which I'll need your help.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: After? Why return at all to Nassau? With money like that and my father out of business, why not run?");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: What's coming our way can't be outrun.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: But with the money I strip from the Hulk, we could add 50 guns to the fort.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: We could build ships to defend our shores and train new men to sail them.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: We could work the land, grow crops and raise cattle.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Then whoever arrives on our shores first, be it England or Spain, will be in for a most unwelcome surprise.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: A nation of thieves!");
        try{Thread.sleep(400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(Mr. Scott barges in from the door!)");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Mr. Scott: You want to turn pirates into farmers and soldiers?");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Mr. Scott: Captain Flint, I believe you have no idea how to handle these pirates!");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: They're not animals, Mr. Scott. They're men starved of hope.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Give that back to them, who's to say what could happen?");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: Why do this? Why here?");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Odysseus, on his journey home to Ithaca, was visited by a ghost.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: The ghost tells him that once he reaches his home, once he slays all his enemies and sets his house in order,");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: he must do one last thing before he can rest.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: The ghost tells him to pick up an oar and walk inland,");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: and keep walking until somebody mistakes that oar for a shovel.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: For that would be the place that no man had ever been troubled by the sea.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: And that's where he'd find peace.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: In the end, that's all I want. To walk away from the sea and find some peace.");
        try{Thread.sleep(3400);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(Billy Bones bursts into the room!)");
        try{Thread.sleep(800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Billy: I think we found it..");
        try{Thread.sleep(700);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Found what?");
        try{Thread.sleep(800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Billy: The Urca's schedule was taken from me!");
        try{Thread.sleep(1200);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: From you? What could you possibly mean by that!");
        try{Thread.sleep(1600);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Billy: Well not exactly from me, but I know who has it.");
        try{Thread.sleep(1000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Who?!.");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Billy: The cook! He was never searched.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: You mean that cook that asked to join our crew from our last prize?");
        try{Thread.sleep(1600);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: And you didn't mention this before, the blinding fact that you don't have the schedule.");
        try{Thread.sleep(1200);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Billy: Yes, him!");
        try{Thread.sleep(1000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: It wasn't important, everything is under control, and as you can see, we are close!");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Billy: You must come now! We must find him.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Eleanor, if I get this schedule, will you give me the finances I need to inspire my men?");
        try{Thread.sleep(1500);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: Get the schedule, come talk to me again.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Mr. Scott: You cannot actually be considering this Eleanor, the man is deranged!");
        try{Thread.sleep(300);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Billy: We must leave and find him!");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: It's my money Mr. Scott.");
        try{Thread.sleep(1000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Mr. Scott: It's your father's!");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: Well, good thing he isn't here then...");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: I will see you soon Eleanor.");
        try{Thread.sleep(1800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Eleanor: Get me that schedule.");
        try{Thread.sleep(600);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Billy: WE MUST LEAVE!");
        try{Thread.sleep(800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Damnit Billy! I am coming!");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You leave the Tavern with Billy)");
        try{Thread.sleep(2000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Billy: Let's go ask the men in the market if they know where he went.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: We don't even know the man's name yet.");
        try{Thread.sleep(2100);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Billy: We will ask them.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("You: Let's ask Gates first, he was there when they found him.");
        try{Thread.sleep(1800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("Billy: I'm coming with you captain.");
        try{Thread.sleep(2800);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleAddLine("(You and Billy rustle out the people)");
        try{Thread.sleep(4000);}catch (Exception e){}
        GMain.mainGGame.mainGFrame.consoleClear();
        GMain.mainGGame.mainGFrame.consoleAddLine("** Find the cook **");
        GMain.mainGGame.mainGFrame.consoleAddLine("** Ask Gates -> He is usually in either the Pub or Town Market **");

        GMain.mainGGame.mainWorldData.worldFlags.add(GWorldData.GFlags.mission2_TellStoryToEleanorAboutSpaniard);

        tavernEntry.actionNodes.remove(0);

    }

    @Override
    public void run() {
        eventStart(this);

        currentObject = entryFork;

        GMain.mainGGame.mainGFrame.consoleAddLine("** Nassau Town Square **");
        GMain.mainGGame.mainGFrame.consoleAddLine(" - Eleanor Guthrie is usually in the Tavern.");
        GMain.mainGGame.mainGFrame.consoleAddLine(" - She is a key asset to trade in Nassau.");

        // Entry
        entryFork.actionNodes.get(0).setOptionAction(() -> goToTavern());
        entryFork.actionNodes.get(1).setOptionAction(() -> goToMaxRoom());
        entryFork.actionNodes.get(2).setOptionAction(() -> talkToPunmaster());

        // Tavern Entry
        tavernEntry.actionNodes.get(0).setOptionAction(() -> askAboutBusiness());
        if(GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission6_ReqHelpFromPoolPlayersToRepairShip) && !GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission7_TalkToEleanorAboutWoodSupply)) {
            tavernEntry.actionNodes.get(1).setOptionText("Ask Eleanor about wood supply.");
            tavernEntry.actionNodes.get(1).setOptionAction(() -> askForWood());
        }
        else if(GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission4_FoundTheCook) && !GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission5_FoughtSingleton)) {
            tavernEntry.actionNodes.get(1).setOptionText("Propose deal to Eleanor.");
            tavernEntry.actionNodes.get(1).setOptionAction(() -> proposeDeal());
        }
        else if(GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission1_TalkToPoolPlayers) && !GMain.mainGGame.mainWorldData.worldFlags.contains(GWorldData.GFlags.mission2_TellStoryToEleanorAboutSpaniard)) {
            tavernEntry.actionNodes.get(1).setOptionText("Tell her a story of a Spaniard named Vasquez.");
            tavernEntry.actionNodes.get(1).setOptionAction(() -> tellStoryOfSpaniard());
        }
        else {
            tavernEntry.actionNodes.remove(1);
        }

        // Max Entry
        //maxEntry.actionNodes.get(0).setOptionAction(() -> chatWithMax());

        while(isRunning) {
            GNarrator.narrate(currentObject);
        }

        GMain.mainGGame.printInfo("LiveEvent Thread complete.");
    }
}
