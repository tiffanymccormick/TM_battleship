package battleship;

import java.util.Scanner;

public class BattleshipPlayer {
	private String name;
	private BattleshipGrid grid;
	private Scanner scanner;

	public BattleshipPlayer() {
		this.name = null;
		this.scanner = new Scanner(System.in);
	}

	// Creates BattleshipGrid when the game starts
	public void startGame() {
		initializeGrid();
		if (name == null) {
			System.out.print("Please enter your name: ");
			name = scanner.nextLine();
			System.out.println("Welcome to Battleship, " + name + "!");
		}
	}

	public String playerName() {
		return name;
	}

	// User enters position to shoot at
	public Position shoot() {
		Position pos = null;
		boolean validInput = false;
		while (!validInput) {
			System.out.print("Enter target position row A-J col 1-10 (ie. A-1): ");
			pos = new Position();
			if (pos.rowIndex() == -1 || pos.columnIndex() == -1) {
				System.out.println("Invalid position. Please try again.");
			} else {
				validInput = true;
			}
		}
		return pos;
	}

	// Update grid based on results
	public void updateGrid(Position pos, boolean hit, char initial) {
		grid.shotAt(pos, hit, initial);
	}

	public BattleshipGrid getGrid() {
		return grid;
	}

	//Reset/Initialize grid
	public void initializeGrid() {
		grid = new BattleshipGrid();
	}

	//Informs user of whether the shot was a hit or miss, which ship was hit, sunk, if the game is over, number of turns taken
	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver,
			boolean tooManyTurns, int turns) {
		updateGrid(pos, hit, initial);

		// Output the grid
		displayGrid();

		// Output result of the shot
		System.out.print(
				"Turn #" + turns + ": Your shot at " + pos.toString() + " was a " + (hit ? "hit" : "miss") + ".");
		if (hit) {
			System.out.println();
			System.out.println("You hit the " + boatName + ".");
			if (sunk) {
				System.out.println("You sunk the " + boatName + "!");
			}
		} else {
			System.out.println();
		}
		if (gameOver) {
			System.out.println("Game Over! You have sunk all the ships!");
		}
		if (tooManyTurns) {
			System.out.println("Game Over! You have taken too many turns.");
		}
	}

	public void displayGrid() {
		// Display columns
		System.out.print("   ");
		for (int col = 1; col <= 10; col++) {
			System.out.print(col + " ");
		}
		System.out.println("\n");

		// Display rows
		for (int row = 0; row < 10; row++) {
			System.out.print((char) ('A' + row) + "  ");
			for (int col = 0; col < 10; col++) {
				Position pos = new Position(row, col);
				if (grid.hit(pos)) {
					
					System.out.print(grid.boatInitial(pos) + " ");
					
				} else if (grid.miss(pos)) {
					System.out.print("* ");
				} else if (grid.empty(pos)) {
					System.out.print(". ");
				}
			}
			System.out.print("\n");
		}
	}
}
