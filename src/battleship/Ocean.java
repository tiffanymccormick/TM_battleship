package battleship;

//Throw exceptions resource - https://blog.jetbrains.com/idea/2024/03/easy-hacks-how-to-throw-java-exceptions/#:~:text=To%20throw%20an%20exception%2C%20you,not%20checked%20at%20compile%20time.
//https://www.tutorialspoint.com/java/java_basic_operators.htm
import java.util.ArrayList;
import java.util.Random;

public class Ocean {
	private ArrayList<Boat> boats;
	private BattleshipGrid grid;

	public Ocean() {
		boats = new ArrayList<Boat>();
		grid = new BattleshipGrid();
	}

	public int size() {
		return boats.size();
	}

	public void placeBoat(String boatName, String direction, Position pos) throws Exception {

		if (!isValidPlacement(pos, boatName, direction)) {
			throw new Exception("Boat placement is out of bounds of the ocean");
		}else {
			boats.add(new Boat(boatName, pos, direction));
	        System.out.println("Placed " + boatName + " at " + pos.toString() + " going " + direction);

		}

	}

	public void shootAt(Position pos) {
		for (Boat boat : boats) {
			if (boat.onBoat(pos)) {
				boat.hit(pos);
				return;
			}
		}
	}

	public boolean hit(Position pos) {
		if (!grid.empty(pos)) {
            grid.shotAt(pos, true, grid.boatInitial(pos)); // Mark as hit
            return true;
        } else {
            grid.shotAt(pos, false, ' '); // Mark as miss
            return false;
        }
	}

	public char boatInitial(Position pos) {
		for (Boat boat : boats) {
			if (boat.onBoat(pos) && boat.isHit(pos)) {
				return boat.abbreviation();
			}
		}
		return ' ';
	}

	public String boatName(Position pos) {
		for (Boat boat : boats) {
			if (boat.onBoat(pos) && boat.isHit(pos)) {
				return boat.name();
			}
		}
		return "";
	}

	public boolean sunk(Position pos) {
		for (Boat boat : boats) {
			if (boat.onBoat(pos) && boat.sunk()) {
				return true;
			}
		}
		return false;
	}

	public boolean allSunk() {
		for (Boat boat : boats) {
			if (!boat.sunk()) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidPlacement(Position pos, String boatName, String direction) {
		Boat boat = new Boat(boatName, pos, direction);
		int boatSize = boat.getSize(boatName);
		int maxRow = pos.rowIndex() + (direction.equals("vertical") ? boatSize - 1 : 0);
		int maxCol = pos.columnIndex() + (direction.equals("horizontal") ? boatSize - 1 : 0);

		return maxRow < 10 && maxCol < 10 && pos.rowIndex() >= 0 && pos.columnIndex() >= 0;
	}

	// 1.6 placeAllBoats using Math.random() and try-catch inside a while loop
	public void placeAllBoats() {
		String[] boatTypes = { "aircraft carrier", "battleship", "cruiser", "submarine", "destroyer" };
		Random rand = new Random(); 
		

		for (String boatType : boatTypes) {
			boolean placed = false; 
			while (!placed) {
				int row = (int) (Math.random() * 10);
				int col = (int) (Math.random() * 10);

				String direction = rand.nextBoolean() ? "horizontal" : "vertical";

				Position randomPos = new Position(row, col);
				
				try {
					placeBoat(boatType, direction, randomPos);
					placed = true; 
				} catch (Exception e) {
//					System.out.println("Failed to place " + boatType + " at " + randomPos.toString() + " due to: " + e.getMessage());
		             
				}
			}
		}
	}
	
	
}
