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
	
	public static boolean isDirection(String str)
	{
		boolean ret = false;
		switch (str.toLowerCase())
		{
		case "up":
		case "down":
		case "right":
		case "left":
			ret = true;
			break;
		default:
			ret = false;
			break;
		}
		return ret;
	}
		
	public static Direction string2Dir(String str)
	{
		Direction dir;
		switch (str)
		{
		case "up":
			dir = UP;
			break;
		case "down":
			dir = DOWN;
			break;
		case "right":
			dir = RIGHT;
			break;
		case "left":
			dir = LEFT;
			break;
		default:
			dir = RIGHT;
		}
		return dir;
	}
	
	
}
