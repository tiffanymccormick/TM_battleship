package battleship;
import java.util.Scanner;

//Creates a position in battleship that represents a square on the board
public class Position {
	private char row;
	private int col;
	
    public Position() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter position formatted row-col: ");
        String input = scan.nextLine();
        Position p = PositionChecker.checkPosition(input);
        this.row = p.row();
        this.col = p.column();
    }
	
	//User sets position
	public Position(char r, int c) {
		row=r;
		col=c;
	}
	
	//Integer constructor
    public Position(int rowIndex, int colIndex) {
        this.row = (char) ('A' + rowIndex);
        this.col = colIndex + 1;
    }
	
	//return current row 
	public char row() {
		return Character.toUpperCase(row);
	}
		
	//return current column
	public int column() {
		return col;
	}
	
	//return row index
	public int rowIndex() {
		return (int)row-'A';
	}
	
	//return row index
	public int columnIndex() {
		return col-1;
	}
	
	@Override
    public String toString() {
		return row + "-" + col;
    }

	
	
}