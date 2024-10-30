package battleship;

public class ComputerBattleshipTest {

    public static void main(String[] args) {
        // Test 1: Run a single game with the computer player
        System.out.println("Test 1: Running a single game with ComputerBattleshipPlayer...");
        Ocean ocean = new Ocean();
        ComputerBattleshipPlayer computerPlayer = new ComputerBattleshipPlayer(ocean);
        BattleshipGame game = new BattleshipGame(computerPlayer);

        int turnsTaken = game.play();
        System.out.println("Game over! Total turns taken: " + turnsTaken);

        // Test 2: Run multiple games using PlayerEvaluator
        System.out.println("\nTest 2: Evaluating ComputerBattleshipPlayer over 5 games...");
        int numGames = 5;
        PlayerEvaluator evaluator = new PlayerEvaluator(computerPlayer, numGames);

        System.out.println("Max turns taken in " + numGames + " games: " + evaluator.maxTurns());
        System.out.println("Min turns taken in " + numGames + " games: " + evaluator.minTurns());
        System.out.println("Average turns taken in " + numGames + " games: " + evaluator.averageTurns());
    }
}
