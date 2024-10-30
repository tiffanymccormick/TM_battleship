package battleship;

public class Tester {
	public static void main(String[] args) {
		/**
		 * Test results of Position class
		 */
		Position p1 = new Position(); //test default Position constructor
		System.out.println(p1.row() + "\n" + p1.column());
		System.out.println(p1.toString());
		
		Position p2 = new Position('D',2); //test char and integer input
		System.out.println(p2.row() + "\n" + p2.column());
		System.out.println(p2.toString());
		
		/**
		 * Test the PositionChecker class and positionChecker method
		 */
		//test checkPosition with valid String input
		Position p3 = PositionChecker.checkPosition("B-3");
		System.out.println(p3.toString());
		
		//row out of range
		Position p4 = PositionChecker.checkPosition("Z-6");
		System.out.println(p4.toString());
		
		//column out of range
		Position p5 = PositionChecker.checkPosition("A-14");
		System.out.println(p5.toString());
		
		//no hyphen
		Position p6 = PositionChecker.checkPosition("F1");
		System.out.println(p6.toString());
		
		//blank line
		Position p7 = PositionChecker.checkPosition("");
		System.out.println(p7.toString());
		
		//missing row
		Position p8 = PositionChecker.checkPosition("-6");
		System.out.println(p8.toString());
		
		//missing column
		Position p9 = PositionChecker.checkPosition("F-");
		System.out.println(p9.toString());
		
		//non-integer column
		Position p10 = PositionChecker.checkPosition("E-M");
		System.out.println(p10.toString());
	}
}
