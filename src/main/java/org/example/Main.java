package org.example;

import org.example.game.SnakeAndLadder;
import org.example.manager.LadderManager;
import org.example.manager.PlayerManager;
import org.example.manager.SnakeManager;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Integer> snakeDB = SnakeManager.getSnakeDB();
        Map<Integer, Integer> ladderDB = LadderManager.getLadderDB();
        List<String> playerDB = PlayerManager.getPlayerDB();

        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the number of snakes : ");

        int noOfSnakes = sc.nextInt();
        while(noOfSnakes > 0) {
            int head = sc.nextInt();
            int tail = sc.nextInt();
            snakeDB.put(head, tail);
            noOfSnakes--;
        }

//        System.out.println("Enter the number of ladders : ");
        int noOfLadders = sc.nextInt();
        while(noOfLadders > 0) {
            int tail = sc.nextInt();
            int head = sc.nextInt();
            ladderDB.put(tail, head);
            noOfLadders--;
        }

//        System.out.println("Enter the number of players : ");
        int noOfPlayers = sc.nextInt();
        while(noOfPlayers > 0) {
            playerDB.add(sc.next());
            noOfPlayers--;
        }

        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
        System.out.println(snakeAndLadder.startGame() + " wins the game!!!");

    }

}