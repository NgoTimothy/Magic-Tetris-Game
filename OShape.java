package hw4;

import java.awt.Color;




import api.Block;
import api.Cell;
import api.Position;
import api.Shape;
import api.Block;

public class OShape extends AbstractShape {
	
	/**
	 * Creates a "O Shape" with given position 
	 * Creates block with a cell array
	 * Sets the instance variables for the super class
	 * @param position
	 * @param magic
	 */
	public OShape(Position position, boolean magic){
	
		
		Position position1 = new Position(position.row() + 1, position.col());
		Position position2 = new Position(position.row(), position.col() + 1);
		Position position3 = new Position(position.row() + 1, position.col() + 1);
		
		Cell[] cells = new Cell[4];
		cells[0] = new Cell(new Block(Color.YELLOW, magic), position);
		cells[1] = new Cell(new Block(Color.YELLOW, false), position2);
		cells[2] = new Cell(new Block(Color.YELLOW, false), position1);
		cells[3] = new Cell(new Block(Color.YELLOW, false), position3);
		super.setMethod(position, cells);
	}

	/**
	 * Makes it so the transform method does nothing
	 */
	@Override
	public void transform() {
		// Do nothing
		
	}
	
}