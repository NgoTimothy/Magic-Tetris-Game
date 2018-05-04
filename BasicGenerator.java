
package hw4;

import api.Generator;
import api.Position;
import api.Shape;


import java.util.Random;

/**
 * Generator for Shape objects in MagicTetris.  All six shapes
 * are equally likely, and the generated shape is magic with
 * 20% probability.
 */
public class BasicGenerator implements Generator
{
  @Override
  public Shape getNext(int width)
  {
	Random seed = new Random();
	boolean magic = false;
	if(seed.nextInt(5) == 0) {
		magic = true;
	}
		
	switch (seed.nextInt(6)) {
	case 0:
		return new LShape(new Position(-1, (width / 2) +1), magic);
	case 1:
		return new JShape(new Position(-1, (width / 2)), magic);
	case 2:
		return new IShape(new Position(-2, (width / 2)), magic);
	case 3:
		return new OShape(new Position(-1, (width / 2)), magic);
	case 4:
		return new TShape(new Position(0, (width / 2)), magic);
	case 5:
		return new SZShape(new Position(-1, (width / 2)), magic);
	default:
		return new LShape(new Position(-1, (width / 2) +1), magic);
	}
  }
}
