package tp.pr1;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getx()
	{
		return this.x;
	}
	
	public int gety()
	{
		return this.y;
	}
	
	public boolean isValid(int dim)
	{
		return (this.getx() >= 0 && this.getx() < dim) && (this.gety() >= 0 && this.gety() < dim);
	}
	
	public Position CalculatePosition(Direction direccion){
		Position pos;
		switch (direccion)
		{
		case UP:
			pos = new Position(this.x, this.y+1);
			break;
		case DOWN:
			pos = new Position(this.x, this.y-1);
			break;
		case LEFT:
			pos = new Position(this.x-1, this.y);
			break;
		case RIGHT:
			pos = new Position(this.x+1, this.y);
			break;
		default:
			pos = new Position(x, y);
		}
		return pos;
	}
	
}
