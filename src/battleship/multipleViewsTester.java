package battleship;

public class multipleViewsTester {
	public static void main(String[] args) {
		//Test int constructor
		Position pos1 = new Position(3, 4);
		System.out.println("Int constructor \nrow " + pos1.row()+" column " + pos1.column()+ " rowIndex "+ pos1.rowIndex() +" columnIndex " + pos1.columnIndex() + " toString " + pos1.toString());
		
		//Test original constructor
		Position pos2 = new Position('F', 5);
		System.out.println("Original constructor \nrow " + pos2.row()+" column " + pos2.column()+ " rowIndex "+ pos2.rowIndex() +" columnIndex " + pos2.columnIndex() + " toString " + pos2.toString());
		
		//Test valid position for 0 parameter
		Position pos3 = new Position();
		System.out.println("No parameter valid \nrow " + pos3.row()+" column " + pos3.column()+ " rowIndex "+ pos3.rowIndex() +" columnIndex " + pos3.columnIndex() + " toString " + pos3.toString());
		
		//Row out of range
		Position pos4 = new Position();
		System.out.println("Row out of range \nrow " + pos4.row()+" column " + pos4.column()+ " rowIndex "+ pos4.rowIndex() +" columnIndex " + pos4.columnIndex() + " toString " + pos4.toString());
		
		//Column out of range
		Position pos5 = new Position();
		System.out.println("Col out of range \nrow " + pos5.row()+" column " + pos5.column()+ " rowIndex "+ pos5.rowIndex() +" columnIndex " + pos5.columnIndex() + " toString " + pos5.toString());
		
		//No hyphen
		Position pos6 = new Position();
		System.out.println("No hyphen \nrow " + pos6.row()+" column " + pos6.column()+ " rowIndex "+ pos6.rowIndex() +" columnIndex " + pos6.columnIndex() + " toString " + pos6.toString());
				
		//Blank line(null input)
		Position pos7 = new Position();
		System.out.println("Blank line\nrow " + pos7.row()+" column " + pos7.column()+ " rowIndex "+ pos7.rowIndex() +" columnIndex " + pos7.columnIndex() + " toString " + pos7.toString());	
		
		//Missing row
		Position pos8 = new Position();
		System.out.println("Missing row \nrow " + pos8.row()+" column " + pos8.column()+ " rowIndex "+ pos8.rowIndex() +" columnIndex " + pos8.columnIndex() + " toString " + pos8.toString());
			
		//Missing col
		Position pos9 = new Position();
		System.out.println("Missing col\nrow " + pos9.row()+" column " + pos9.column()+ " rowIndex "+ pos9.rowIndex() +" columnIndex " + pos9.columnIndex() + " toString " + pos9.toString());
		
		//Non number col
		Position pos10 = new Position();
		System.out.println("Non number column\nrow " + pos10.row()+" column " + pos10.column()+ " rowIndex "+ pos10.rowIndex() +" columnIndex " + pos10.columnIndex() + " toString " + pos10.toString());
	}
}
