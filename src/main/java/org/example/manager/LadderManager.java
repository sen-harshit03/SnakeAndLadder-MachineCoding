package org.example.manager;

import java.util.HashMap;
import java.util.Map;

public class LadderManager {

    static Map<Integer, Integer> ladderDB;

    private LadderManager() {

    }

    public static Map<Integer, Integer> getLadderDB() {
        if(ladderDB == null) {
           synchronized (LadderManager.class) {
               if(ladderDB == null){
                   ladderDB = new HashMap<>();
               }
           }
        }
        return ladderDB;
    }
}
