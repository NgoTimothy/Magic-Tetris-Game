package hw4;

import java.awt.Color;


import api.Block;
import api.Cell;
import api.Position;

public class SZShape extends AbstractShape {
	
	
	/**
	 * Creates a "SZ Shape" with given position 
	 * Creates block with a cell array
	 * Sets the instance variables for the super class
	 * @param position
	 * @param magic
	 */
	public SZShape(Position position, boolean magic){
	
		
		Position position1 = new Position(position.row() +1, position.col());
		Position position2 = new Position(position.row() +1, position.col() +1);
		Position position3 = new Position(position.row() +2, position.col() + 1);
		
		Cell[] cells = new Cell[4];
		cells[0] = new Cell(new Block(Color.GREEN, magic), position);
		cells[1] = new Cell(new Block(Color.GREEN, false), position1);
		cells[2] = new Cell(new Block(Color.GREEN, false), position2);
		cells[3] = new Cell(new Block(Color.GREEN, false), position3);
		super.setMethod(position, cells);
	}

	/**
	 * Flips the shape on the vertical axis based on what color it is currently
	 */
	@Override
	public void transform() {
		Cell[] newCells = super.getCells();
		if (newCells[0].getBlock().getColorHint() == Color.GREEN) {
			newCells[0].setBlock(new Block(Color.RED, newCells[0].getBlock().isMagic()));
			newCells[1].setBlock(new Block(Color.RED, newCells[1].getBlock().isMagic()));
			newCells[2].setBlock(new Block(Color.RED, newCells[2].getBlock().isMagic()));
			newCells[3].setBlock(new Block(Color.RED, newCells[3].getBlock().isMagic()));
			newCells[0].setCol(newCells[0].getCol() + 1);
			newCells[1].setCol(newCells[1].getCol() + 1);
			newCells[2].setCol(newCells[2].getCol() - 1);
			newCells[3].setCol(newCells[3].getCol() -1);
			super.setMethod(new Position(newCells[0].getRow(), newCells[0].getCol()-1) , newCells);
		}
		else {
			newCells[0].setBlock(new Block(Color.GREEN, newCells[0].getBlock().isMagic()));
			newCells[1].setBlock(new Block(Color.GREEN, newCells[1].getBlock().isMagic()));
			newCells[2].setBlock(new Block(Color.GREEN, newCells[2].getBlock().isMagic()));
			newCells[3].setBlock(new Block(Color.GREEN, newCells[3].getBlock().isMagic()));
			newCells[0].setCol(newCells[0].getCol() - 1);
			newCells[1].setCol(newCells[1].getCol() - 1);
			newCells[2].setCol(newCells[2].getCol() + 1);
			newCells[3].setCol(newCells[3].getCol() +1);
			super.setMethod(new Position(newCells[0].getRow(), newCells[0].getCol()) , newCells);
		}
		
		
	}
}
