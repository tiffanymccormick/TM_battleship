package battleship;

public class Boat {
    private String name;
    private Position startPosition;
    private String direction;
    private int size;
    private boolean[] hits;
    
    public Boat(String name, Position startPosition, String direction) {
        this.name = name;
        this.startPosition = startPosition;
        this.direction = direction.toLowerCase(); // Ensure direction is lowercase
        this.size = getSize(name); // Call helper method to get size based on name
        this.hits = new boolean[size]; // Initialize hits array with size of the boat
    }
    
    public String name() {
        return name;
    }

    public char abbreviation() {
        return name.charAt(0);
    }
    
    public int getSize(String name) {
    	
        switch (name) {
            case "Aircraft Carrier":
                return 5;
            case "Battleship":
                return 4;
            case "Cruiser":
            case "Submarine":
                return 3;
            case "Destroyer":
                return 2;
            default:
            	return 0;
        }
    }
    
    public int size() {
    	return size;
    }
    
    public boolean onBoat(Position p) {
        int rowDiff = Math.abs(p.rowIndex() - startPosition.rowIndex());
        int colDiff = Math.abs(p.columnIndex() - startPosition.columnIndex());

        if (direction.equals("horizontal") && rowDiff == 0 && colDiff < size) {
            return true;
        } else if (direction.equals("vertical") && colDiff == 0 && rowDiff < size) {
            return true;
        }
        return false;
    }
    
    public boolean isHit(Position p) {
        if (onBoat(p)) {
        	//had to google ternary operators
            int index = direction.equals("horizontal") ? p.columnIndex() - startPosition.columnIndex() : p.rowIndex() - startPosition.rowIndex();
            return hits[index];
        }
        return false;
    }

    public void hit(Position p) {
        if (onBoat(p)) {
            int index = direction.equals("horizontal") ? p.columnIndex() - startPosition.columnIndex() : p.rowIndex() - startPosition.rowIndex();
            hits[index] = true;
        }
    }
    
    public boolean sunk() {
        for (boolean hit : hits) {
            if (!hit) {
                return false;
            }
        }
        return true;
    }

    public Position position() {
    	Position p = PositionChecker.checkPosition(startPosition.toString());
        return p;
    }

    public String direction() {
    	if(direction.equals("horizontal".toLowerCase()) || direction.equals("vertical".toLowerCase()))
    		return direction;
    	return "Invalid";
    }
}