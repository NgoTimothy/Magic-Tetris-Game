package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

public class IShape extends AbstractShape{
	
	
	/**
	 * Creates a "I Shape" with given position 
	 * Creates block with a cell array
	 * Sets the instance variables for the super class
	 * @param position
	 * @param magic
	 */
	public IShape(Position position, boolean magic){
	Position position1 = new Position(position.row()+1, position.col());
	Position position2 = new Position(position.row()+2, position.col());
	
		
	Cell[] cells = new Cell[3];
	cells[0] = new Cell(new Block(Color.CYAN, magic), position);
	cells[1] = new Cell(new Block(Color.CYAN, false), position1);
	cells[2] = new Cell(new Block(Color.CYAN, false), position2);
	super.setMethod(position, cells);
	}

}
