package battleship;

public class PositionChecker {
	//error checks keyboard input to see if its in the format of R-C
	public static Position checkPosition(String inputPos) {
		//check for empty input to return default Position
		if (inputPos == null) {
			System.out.println("Invalid position at " + inputPos);
	        return new Position();
	    }
		
		//check if the input contains a hyphen
		if(!inputPos.contains("-")) {
			System.out.println("Invalid input at " + inputPos);
			return new Position(-1,-1);
		}
		
		//Split formatted input by the hyphen (had to google how to split string and looked at ATCS slides)
		String[] temp = inputPos.split("-");
		
		// Check if the input has both the row and the part
	    if (temp.length != 2) {
	    	System.out.println("Invalid input at " + inputPos);
	        return new Position(-1,-1);
	    }
	    
		
	    // Separate the row and column from the input String
	    String rowPart = temp[0];
	    String columnPart = temp[1];
	
	    // Convert String to integer to represent the column, and String to char for the row (had to google how to catch the multiple exception errors)
	    char row;
	    int column;
	    try {
	    	
	    	row = Character.toUpperCase(rowPart.charAt(0));
	        column = Integer.parseInt(columnPart);
	        
	    } catch (Exception e) {
	    	System.out.println("Invalid input at " + rowPart + " " + columnPart);
	        return new Position(-1,-1);
	        
	    }
	    
	    
	    // Validate that the row is in range(should be a single letter A-J)
	    //had to google isEmpty to check if an array index is empty
	    if (rowPart == null || rowPart.length() != 1 || !Character.isLetter(row)) {
	    	System.out.println("Invalid position at " + row + " " + column);
	        return new Position(-1,-1);
	    }
	    
	    if (row < 'A' || row > 'J') {
	    	System.out.println("Invalid position at " + row + " " + column);
	        return new Position(-1,-1);
	    }
	
		    // Validate column (should be a number between 1 and 10) (had to google it)
		    if (columnPart.isEmpty() || column < 1 || column > 10) {
		    	System.out.println("Invalid position at " + row + " " + column);
		        return new Position(-1,-1);
		    }
		    
		    // If both row and column are valid, create and return the position
		    return new Position(row, column);		
		}
	}