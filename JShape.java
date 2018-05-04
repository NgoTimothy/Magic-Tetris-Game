package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

public class JShape extends AbstractShape {
	
	/**
	 * Creates a "J Shape" with given position 
	 * Creates block with a cell array
	 * Sets the instance variables for the super class
	 * @param position
	 * @param magic
	 */
	public JShape(Position position, boolean magic){
		
		Position position0 = new Position(position.row(), position.col() -1);
		Position position1 = new Position(position.row() +1, position.col() - 1);
		Position position2 = new Position(position.row() +1, position.col());
		Position position3 = new Position(position.row() +1, position.col() + 1);
		
		Cell[] cells = new Cell[4];
		cells[0] = new Cell(new Block(Color.BLUE, magic), position0);
		cells[1] = new Cell(new Block(Color.BLUE, false), position1);
		cells[2] = new Cell(new Block(Color.BLUE, false), position2);
		cells[3] = new Cell(new Block(Color.BLUE, false), position3);
		super.setMethod(position, cells);
	}

}
