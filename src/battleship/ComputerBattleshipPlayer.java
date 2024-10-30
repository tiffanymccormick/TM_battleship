package battleship;

import java.util.Random;

public class ComputerBattleshipPlayer extends BattleshipPlayer {

    private Random random;
    private Ocean ocean;

    public ComputerBattleshipPlayer(Ocean ocean) {
        this.random = new Random();
        this.ocean = ocean;
    }

    public void displayGrid(){
        super.displayGrid();
    }

    @Override
    public void startGame() {
        initializeGrid();
        System.out.println("Computer Player Mode Selected");
    }

    @Override
    public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns) {
        updateGrid(pos, hit, initial);

    }

    @Override
    public String playerName() {
        return "Computer Player";
    }

    @Override
    public Position shoot() {
        Position pos = null;
        boolean validInput = false;
        if(ocean.allSunk()){
            System.out.println("All ships sunk, game over");
            return null;
        }
        while (!validInput) {
            int row = random.nextInt(10);
            int col = random.nextInt(10);
            pos = new Position(row, col);

            // Check if the target position wasn't already hit
            if (getGrid().empty(pos)) {
                validInput = true;  
            }
        }
        System.out.println("Computer shoots at: " + pos.toString());
        return pos;
    }
}
