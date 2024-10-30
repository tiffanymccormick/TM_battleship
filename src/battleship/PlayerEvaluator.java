package battleship;

public class PlayerEvaluator {

    public ComputerBattleshipPlayer player;
    public int runs;
    public int maxTurns;
    public int minTurns;
    public float totalTurns;

    public PlayerEvaluator(ComputerBattleshipPlayer player, int runs) {
        this.player = player;
        this.runs = runs;
        this.maxTurns = Integer.MIN_VALUE;
        this.minTurns = Integer.MAX_VALUE;
        this.totalTurns = 0;
        evaluatePlayer();
    }

    public void evaluatePlayer() {
        for (int i = 0; i < runs; i++) {
            BattleshipGame game = new BattleshipGame(player); 
            int turnsTaken = game.play();
            
            if (turnsTaken > maxTurns) {
                maxTurns = turnsTaken;
            }
            if (turnsTaken < minTurns) {
                minTurns = turnsTaken;
            }
            totalTurns += turnsTaken;
        }
    }

    public int maxTurns() {
        return maxTurns;
    }

    public int minTurns() {
        return minTurns;
    }

    public float averageTurns() {
        return totalTurns / runs;
    }
}
