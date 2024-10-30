package battleship;
// Resource for assert keyword https://w3schools.com/java/ref_keyword_assert.asp
public class BattleshipGridTester {
	public static void main(String[] args) {
		BattleshipGrid grid = new BattleshipGrid();

		Position pos1 = new Position('A', 1); // A-1
		Position pos2 = new Position('B', 2); // B-2
		Position pos3 = new Position('C', 3); // C-3

		// all positions should be empty
		assert grid.empty(pos1) : "pos1 should be empty";
		assert grid.empty(pos2) : "pos2 should be empty";
		assert grid.empty(pos3) : "pos3 should be empty";

		// record hit at position A
		grid.shotAt(pos1, true, 'A');

		// check if pos was hit
		assert grid.hit(pos1) : "pos1 should be a hit";
		assert !grid.empty(pos1) : "pos1 should not be empty";
		assert !grid.miss(pos1) : "pos1 should not be a miss";
		assert grid.boatInitial(pos1) == 'A' : "pos1 should have boat initial 'A'";

		// Miss shot
		grid.shotAt(pos2, false, ' ');

		// pos2 should now be a miss
		assert grid.miss(pos2) : "pos2 should be a miss";
		assert !grid.empty(pos2) : "pos2 should not be empty";
		assert !grid.hit(pos2) : "pos2 should not be a hit";

		// pos3 should still be empty
		assert grid.empty(pos3) : "pos3 should be empty";
		assert !grid.hit(pos3) : "pos3 should not be a hit";
		assert !grid.miss(pos3) : "pos3 should not be a miss";

		// Print results
		System.out.println("Current Grid State:");
		System.out.println("Expected hit at " + pos1.toString() + ": " + grid.hit(pos1));
		System.out.println("Expected miss at " + pos2.toString() + ": " + grid.miss(pos2));
		System.out.println("Expected miss at " + pos3.toString() + ": " + grid.empty(pos3));
		
	}
}
