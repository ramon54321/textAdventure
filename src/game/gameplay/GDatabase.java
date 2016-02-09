package game.gameplay;

import game.gameplay.events.conversations.GConversation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ramon on 2/6/16.
 * Main Database class -> Holds all external data
 */
public class GDatabase {

    public HashMap<String, GConversation> conversations = new HashMap<>();

    // Constructor
    public GDatabase(){
        loadFilesInDirectoryToHashmap(new File("src/game/resources/conversations"), conversations);
    }

    // Load all files in directory into target hashmap
    public void loadFilesInDirectoryToHashmap(File directory, HashMap<String, GConversation> targetMap){
        for(File file : directory.listFiles()){
            if(!file.isDirectory()){
                loadFileIntoHashmap(file, targetMap);
            }
        }
    }

    // Load parameter file into target hashmap
    public void loadFileIntoHashmap(File file, HashMap<String, GConversation> targetMap){
        ArrayList<String>  linesInFile = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                linesInFile.add(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        targetMap.put(file.getName(), new GConversation(linesInFile.toArray(new String[linesInFile.size()])));
    }

}
