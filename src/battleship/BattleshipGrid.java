package battleship;

public class BattleshipGrid {
	private static final char empty = '~';
	private static final char miss = ' ';

	public char[][] grid;

	public BattleshipGrid() {
		grid = new char[10][10];
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				grid[row][col] = empty;
			}
		}
	}

	public void shotAt(Position pos, boolean hit, char initial) {
		int row = pos.rowIndex();
		int col = pos.columnIndex();

		if (hit) {
			grid[row][col] = initial; // Record the ship's initial
		} else {
			grid[row][col] = miss; // Record a miss
		}
	}

	public boolean hit(Position pos) {
		int row = pos.rowIndex();
		int col = pos.columnIndex();
		char cell = grid[row][col];
		return cell != empty && cell != miss;
	}

	public boolean miss(Position pos) {
		int row = pos.rowIndex();
		int col = pos.columnIndex();
		return grid[row][col] == miss;
	}

	public boolean empty(Position pos) {
		int row = pos.rowIndex();
		int col = pos.columnIndex();
		return grid[row][col] == empty;
	}

	public char boatInitial(Position pos) {
		if (hit(pos)) {
			int row = pos.rowIndex();
			int col = pos.columnIndex();
			return grid[row][col];
		} else {
			return ' ';
		}
	}

	
        
}
