package org.example.game;

import org.example.manager.LadderManager;
import org.example.manager.PlayerManager;
import org.example.manager.SnakeManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadder {

    static int MAX = 6;
    static int MIN = 1;


    static Map<Integer, Integer> snakeDB = SnakeManager.getSnakeDB();
    static Map<Integer, Integer> ladderDB = LadderManager.getLadderDB();
    static List<String> playerDB = PlayerManager.getPlayerDB();
    static Map<String, Integer> playerTrackingMap = new HashMap<>();

    public String startGame() {

        // Keep players at 0
        keepPlayersAtStart();

        int i = -1;
        do{
            i++;
            if(i >= playerDB.size()){  // 2
                i = 0;
            }

            // Roll the dice - one by one each player will roll the dice
            String playerName = playerDB.get(i);
            int rolledDiceValue = rollDice();
            System.out.println();
            System.out.println("Value on dice " + rolledDiceValue );

            int oldPosition = playerTrackingMap.get(playerName);
            int playerNewPosition = oldPosition + rolledDiceValue;


            // If the playerNewPosition is greater than 100
            if(playerNewPosition > 100) {
                playerNewPosition = oldPosition;
                System.out.println( playerName + " couldn't move as its new position is greater than 100");
                continue;
            }


            System.out.println(playerName + " moved from " + oldPosition + " to " + playerNewPosition);
            // Check if the new Position lies on the tail of the ladder
            if(isLadderAvailable(playerNewPosition)) {
                int ladderEnd = ladderDB.get(playerNewPosition);
                System.out.println(playerName + " moved from " + playerNewPosition + " to " + ladderEnd + " via ladder ");
                playerNewPosition = ladderEnd;
            }


            // Check if the newPosition is on snake Head
            if(isSnakeAvailable(playerNewPosition)) {
                int snakeTail = snakeDB.get(playerNewPosition);
                System.out.println(playerName + " moved from " + playerNewPosition + " to " + snakeTail + " due to snake bite ");
                playerNewPosition = snakeTail;
            }



            playerTrackingMap.put(playerName, playerNewPosition);

        } while (!isDestinationReached(playerTrackingMap.get(playerDB.get(i))));

        return playerDB.get(i);
    }


    private void keepPlayersAtStart() {
        for(int i = 0; i<playerDB.size(); i++) {
            playerTrackingMap.put(playerDB.get(i), 0);
        }
    }

    private int rollDice() {
        return (int) (Math.random() * (MAX - MIN + 1) + MIN);
    }

    private boolean isLadderAvailable(int index) {
        return ladderDB.get(index) != null;
    }

    private boolean isSnakeAvailable(int index) {
        return snakeDB.get(index) != null;
    }

    private boolean isDestinationReached(int index) {
        return index == 100;
    }

}
