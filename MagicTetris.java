
package hw4;

import java.util.ArrayList;
import java.util.List;



import api.AbstractGame;
import api.Block;
import api.Position;

/**
 * MagicTetris implementation.
 */
public class MagicTetris extends AbstractGame
{

  private boolean gravityMode;
  
  private int score;
  /**
   * Constructs a game with the given width (columns) and height (rows).
   * This game will use a new instance of BasicGenerator to 
   * generate new shapes.
   * @param width
   *   width of the game grid (number of columns)
   * @param height
   *   height of the game grid (number of rows)
   */
  public MagicTetris(int width, int height)
  {
    super(width, height, new BasicGenerator());
  }

  @Override
  public List<Position> determinePositionsToCollapse()
  {
	int rows = super.getHeight();
	int cols = super.getWidth();
	List<Position> positions = new ArrayList<>();
	for(int i = 0; i < rows; ++i) { //Loop through each row
	  int filledBlocks = 0;
	  int magicBlocks = 0;
		for(int j = 0; j < cols; ++j) { //Loop through each column
			 Block b = super.getBlock(i, j); //Creates a block at grid position
			 if(gravityMode == true) {
				 if(i == 0) {
					 gravityMode = false;
					 break;
				 }
				 if(b == null) {
					 Block c = super.getBlock(i-1, j);
					 if(c != null) {
						 positions.add(new Position(i, j));
					 }
				 }
			 }
			 else {
			 if(b != null) {
			 filledBlocks++;
			 if(b.isMagic()) {
				 magicBlocks++;
			 }
			 }
			 if(filledBlocks == cols) {
			 for(int k = 0; k < cols; ++k) {
			 positions.add(new Position(i, k)); 
			 }
			 score += 2 + Math.pow(2, magicBlocks);
			 if(magicBlocks >= 3) {
			 gravityMode = true;
			 }
			 } 
			 }
		}
	}
    return positions;
  }

  @Override
  public int determineScore()
  {
    return score;
  }

}
