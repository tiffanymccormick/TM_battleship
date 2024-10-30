    package battleship;

public class BoatTest {
	public static void main(String[] args) {
        //check valid inputs
		checkBoat("Aircraft Carrier", new Position('A', 1), "horizontal");
		System.out.println();
        checkBoat("Battleship", new Position('B',2), "vertical");
        System.out.println();
        checkBoat("Cruiser", new Position('D', 3), "horizontal");
        System.out.println();
        checkBoat("Submarine", new Position('F', 6), "vertical");
        System.out.println();
        checkBoat("Destroyer", new Position('C', 4), "horizontal");
        System.out.println();
        
        //check invalid name, row, col, and direction
        checkBoat("Airplane", new Position('X', 111), "diagonal");
        System.out.println();
	}
	
	public static void checkBoat(String s, Position p, String d) {
		//Test valid input
		 Boat boat = new Boat(s, p, d);
		// Check if the name is valid and matches
		try {
			if (!boat.name().equals(s)) {
	            System.err.println("Incorrect boat name");
	        }else {
	        	System.out.println(boat.name());
	        }
		}catch(Exception e) {
			System.err.println("Invalid name " + s);
			Boat b = new Boat("", new Position(-1,-1), "");
			System.out.println(b.name());
		}

        // Check if the position is valid and matches
		try {
			if (boat.position().row() != p.row() || boat.position().column() != p.column()) {
	            System.err.println("Incorrect boat position");
	        }else {
	        	System.out.println(boat.position());
	        }
		}catch(Exception e) {
			System.err.println("Invalid position at " + p.toString());
			Boat b = new Boat("", new Position(-1,-1), "");
			System.out.println(b.position());
		}
        

        // Check if the direction is valid and matches
		try {
			if (!boat.direction().equals(d)) {
	            System.err.println("Incorrect boat direction");
	        }else {
	        	System.out.println(boat.direction());	
	        }
		}catch(Exception e) {
			System.out.println("Invalid direction at "+ d);
			Boat b = new Boat("", new Position(-1,-1), "");
			System.out.println(b.direction());
		}
        
	}
}