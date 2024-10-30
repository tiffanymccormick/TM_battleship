package battleship;

public class BattleshipGame {

    private BattleshipPlayer player;
    private Ocean ocean;
    private int turns;

    // Constructor to initialize the game
    public BattleshipGame(BattleshipPlayer player) {
        this.player = player;
        this.ocean = new Ocean(); // Initialize the ocean
        this.turns = 0;

        // Place all boats on the ocean
        ocean.placeAllBoats();
        
        // Start the game for the player
        player.startGame();
    }

    // Play method to conduct the game and return the number of turns taken
    public int play() {
        boolean gameOver = false;

        while (!gameOver && turns < 100) {
            // Get the player's shot position
            Position shotPosition = player.shoot();

            // Check if the shot position is valid
            if (shotPosition == null) {
                break;
            }

            // Process the shot and determine hit status
            boolean hit = ocean.hit(shotPosition);

            // Determine if all boats are sunk
            gameOver = ocean.allSunk();

            // Update the player with the result of the shot
            player.updatePlayer(
                shotPosition,
                hit,
                hit ? ocean.boatInitial(shotPosition) : ' ',
                hit ? ocean.boatName(shotPosition) : "",
                hit && ocean.sunk(shotPosition),
                gameOver,
                turns >= 100,
                ++turns
            );
        }

        return turns;
    }
}
