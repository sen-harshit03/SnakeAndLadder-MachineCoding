package org.example.manager;

import java.util.HashMap;
import java.util.Map;

public class SnakeManager {

    static Map<Integer, Integer> snakeDB;

    private SnakeManager() {

    }

    public static Map<Integer, Integer> getSnakeDB() {
        if(snakeDB == null) {
            synchronized (LadderManager.class) {
                if(snakeDB == null){
                    snakeDB = new HashMap<>();
                }
            }
        }
        return snakeDB;
    }
}
