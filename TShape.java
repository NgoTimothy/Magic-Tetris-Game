package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

public class TShape extends AbstractShape{
	
	/**
	 * Creates a "T Shape" with given position 
	 * Creates block with a cell array
	 * Sets the instance variables for the super class
	 * @param position
	 * @param magic
	 */
	public TShape(Position position, boolean magic){
		
		Position position1 = new Position(position.row() -1, position.col());
		Position position2 = new Position(position.row(), position.col() -1);
		Position position3 = new Position(position.row(), position.col() + 1);
		
		Cell[] cells = new Cell[4];
		cells[0] = new Cell(new Block(Color.MAGENTA, magic), position1);
		cells[1] = new Cell(new Block(Color.MAGENTA, false), position2);
		cells[2] = new Cell(new Block(Color.MAGENTA, false), position);
		cells[3] = new Cell(new Block(Color.MAGENTA, false), position3);
		super.setMethod(position, cells);
	}



}
