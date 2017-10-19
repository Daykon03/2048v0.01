package tp.pr1;

public enum Direction {
	UP,	DOWN, LEFT, RIGHT;
	
	/*public boolean isValid(Position pos, Direction direccion, int dim){
		boolean ret = true;
		switch (direccion)
		{
		case UP:
			if (pos.gety() == 0) ret = false;
			break;
		case DOWN:
			if (pos.gety() == dim - 1) ret = false;
			break;
		case LEFT:
			if (pos.getx() == 0) ret = false;
			break;
		case RIGHT:
			if (pos.getx() == dim - 1) ret = false;
			break;
		}
		return ret;
	} Por si hace falta en un futuro*/
	
	
}
