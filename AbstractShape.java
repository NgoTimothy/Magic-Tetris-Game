
package hw4;

import api.Shape;


import api.Position;
import api.Block;
import api.Cell;

/**
 * Abstract superclass for implementations of the Shape interface.
 */
public abstract class AbstractShape implements Shape
{
  
  // TODO - add the methods and constructors you want
  // (constructors must be declared protected)
	
  /**
   * Array of type cells that are each block in a shape
   */
  private Cell[] cells;
  
  /**
   * Position of rotating point of a shape
   */
  private Position currentPosition;
  
  
  /**
   * Method to set instance variables from subclasses
   * @param givenPosition
   * @param givenCells
   */
  protected void setMethod(Position givenPosition, Cell[] givenCells) {
	  currentPosition = givenPosition;
	  cells = givenCells;
  }
  
  @Override
  public Cell[] getCells() {
		Cell[] copy = new Cell[cells.length];
		for(int i = 0; i < cells.length; ++i) {
			copy[i] = new Cell(cells[i]);
		}
		return copy;
  }
  
  @Override
  public void shiftDown() {
	  currentPosition.setRow(currentPosition.row() + 1);
	  for(int i = 0; i < cells.length; ++i) {
		  cells[i].setRow(cells[i].getRow() + 1);
	   	}
	}

  @Override
  public void shiftLeft() {
		currentPosition.setCol(currentPosition.col() - 1);
	    for(int i = 0; i < cells.length; ++i) {
	    	 cells[i].setCol(cells[i].getCol() - 1);
	    }
		
	}

  @Override
  public void shiftRight() {
		currentPosition.setCol(currentPosition.col() + 1);
	    for(int i = 0; i < cells.length; ++i) {
	    	 cells[i].setCol(cells[i].getCol() + 1);
	    }
		
	}
  
  @Override
	public void transform() {
		int temp;
		for(int i = 0; i < cells.length; ++i) {
			cells[i].setRow(cells[i].getRow() - currentPosition.row());
			cells[i].setCol(cells[i].getCol() - currentPosition.col());
			temp = cells[i].getRow();
			cells[i].setRow(cells[i].getCol() * -1);
			cells[i].setCol(temp);
			cells[i].setRow(cells[i].getRow() + currentPosition.row());
			cells[i].setCol(cells[i].getCol() + currentPosition.col());
		}
	}
  
  @Override
  public void cycle() {
    int index = -1; 
    for(int i = 0; i < cells.length; ++i) {
  	  if(cells[i].getBlock().isMagic()) {
  		  index = i;
  		  break;
  	  }
    }
    if(index < 0) {
  	  
    }
    else {
  	  if(index == cells.length-1) {
  		  cells[0].setBlock(new Block(cells[0].getBlock().getColorHint(), true));
  		  cells[cells.length-1].setBlock(new Block(cells[cells.length-1].getBlock().getColorHint(), false));
  	  }
  	  else {
  		  cells[index+1].setBlock(new Block(cells[index+1].getBlock().getColorHint(), true));
  		  cells[index].setBlock(new Block(cells[index].getBlock().getColorHint(), false));
  	  }
    }
  	
  }

  @Override
  public Shape clone()
  {
    try
    {
      AbstractShape s = (AbstractShape) super.clone();
      s.cells = new Cell[cells.length];
      s.currentPosition = new Position(currentPosition);
      for(int i = 0; i < cells.length; ++i) {
    	  s.cells[i] = new Cell(cells[i]);
      }
      return s;
    }
    catch (CloneNotSupportedException e)
    {
      // can't happen
      return null;
    }
  }
}
