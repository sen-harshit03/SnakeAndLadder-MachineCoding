package org.example.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerManager {
    static List<String> playerDB;


    private PlayerManager() {

    }

    public static List<String> getPlayerDB() {
        if(playerDB == null) {

            synchronized (LadderManager.class) {
                if(playerDB == null){
                    playerDB = new ArrayList<>();
                }
            }
        }
        return playerDB;
    }

}
