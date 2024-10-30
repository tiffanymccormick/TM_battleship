package battleship;

public class TestPlan {

	 public static void main(String[] args) {
	        System.out.println("Check Aircraft Carrier: ");
	        testBoat("Aircraft Carrier", new Position('A',1), "horizontal");
	        
	        System.out.println("\nCheck Battleship:");
	        testBoat("Battleship", new Position('B', 2), "vertical");
	        
	        System.out.println("\nCheck Cruiser: ");
	        testBoat("Cruiser", new Position('C', 3), "horizontal");
	        
	        System.out.println("\nCheck Destroyer: ");
	        testBoat("Destroyer", new Position('D', 4), "vertical");
	        
	        System.out.println("\nCheck Submarine: ");
	        testBoat("Submarine", new Position('E', 5), "horizontal");
	        
	        System.out.println("\n\nVertical Boat: ");
	        testBoat("Destroyer", new Position('F', 6), "vertical");
	        
	        System.out.println("\nHorizontal Boat: ");
	        testBoat("Cruiser", new Position('G', 7), "horizontal");
	        
	        System.out.println("\nTop Row Boat:");
	        testBoat("Aircraft Carrier", new Position('A', 1), "horizontal");
	        
	        System.out.println("\nBottom Row Boat:");
	        testBoat("Submarine", new Position('J', 10), "vertical");
	        
	        System.out.println("\nFirst Column Boat:");
	        testBoat("Aircraft Carrier", new Position('A', 1), "horizontal");
	        
	        System.out.println("\nLast Column Boat:");
	        testBoat("Cruiser", new Position('A', 10), "horizontal");
	        
	        System.out.println("\nCenter Boat:");
	        testBoat("Destroyer", new Position('E', 5), "horizontal");
	        
	 }
	 public static void testBoat(String s, Position p, String d) {
		 Boat boat = new Boat(s,p, d);
		 System.out.println("Name: " + boat.name());
	     System.out.println("Abbreviation: " + boat.abbreviation());
	     System.out.println("Size: " + boat.size());
	     System.out.println("Before hit: "  + boat.isHit(p)); 
	     boat.hit(p);
	     System.out.println("After hit: " + boat.isHit(p)); 
	 }
	 
	 

}