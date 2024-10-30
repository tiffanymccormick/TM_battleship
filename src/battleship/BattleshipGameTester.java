package battleship;

public class BattleshipGameTester {

    public static void main(String[] args) {
        // Initialize a BattleshipPlayer instance
        BattleshipPlayer player = new BattleshipPlayer();

        // Initialize a BattleshipGame instance with the player
        BattleshipGame game = new BattleshipGame(player);

        // Simulate playing the game
        System.out.println("Game started!");
        int turnsTaken = game.play(); 

        // Display the final result of the game
        System.out.println("Game over! Total turns taken: " + turnsTaken); 
        }
}
