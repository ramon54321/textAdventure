package game.gameplay;

import java.util.HashSet;

/**
 * Created by Ramon on 1/29/16.
 *
 * World data
 */

public class GWorldData {

    public GPlayer mainPlayer = new GPlayer();
    public HashSet<GFlags> worldFlags = new HashSet<>();

    public GWorldData(){

    }

    public enum GFlags {
        visitedPub,
        visitedPub_GivenNameToBartender,
        visitedPub_AskedForShipRepairs,
        metCharlesVane,
        metHume,
        metJohnSilver,
        metEleanorGuthrie,
        metRichardGuthrie,
        metMrScott,
        metJackRackham,
        metMax,
        metBillyBones,
        metMirandaBarlow,
        metDeGroot,
        metBenjaminHornigold,
        pub_HasAccessToHelp,
        pub_SpokenToPoolPlayers,
        pub_SpokenToEleanorAboutDeal,
        other_FixedShip,
        mission1_TalkToPoolPlayers,
        mission2_TellStoryToEleanorAboutSpaniard,
        mission3_TalkToGatesAtPubAndSetOffToFindTheCook
    }
}
