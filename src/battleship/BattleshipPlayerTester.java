package battleship;

import java.util.Scanner;

public class BattleshipPlayerTester {
    public static void main(String[] args) {
        BattleshipPlayer player = new BattleshipPlayer();
        
        System.out.println("Welcome to Battleship");
        player.startGame();
        
        System.out.println("Player name: " + player.playerName());
        
        Position pos = new Position(2, 3);  
        boolean hit = true;  
        char initial = 'B';  
        
        player.updatePlayer(pos, hit, initial, "Battleship", false, false, false, 1);

        Position pos2 = new Position(4, 5);  
        boolean hit2 = false; 
        
        // Update grid with shot and display result
        player.updatePlayer(pos2, hit2, ' ', "", false, false, false, 2);
        
        // Simulate a hit that sinks a ship
        Position pos3 = new Position(6, 7);
        boolean hit3 = true;
        char initial3 = 'D';  // Assume the ship has initial 'D'
        
        // Update grid with shot and display result, this time sinking a ship
        player.updatePlayer(pos3, hit3, initial3, "Destroyer", true, false, false, 3);
        
        // Simulate game over
        Position pos4 = new Position(8, 9);
        boolean hit4 = true;
        char initial4 = 'C'; 
        
        // Update grid with shot and display result, triggering game over
        player.updatePlayer(pos4, hit4, initial4, "Carrier", true, true, false, 4);


    }
}
