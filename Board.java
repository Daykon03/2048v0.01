package tp.pr1;

public class Board {
	private Cell board[][];
	private int dim;
	
	public Board(int dim)
	{
		this.dim=dim;
		this.board[dim][dim] = new Cell(); //I seriously doubt this
	}
	
	public void toString()
	{
		
	}
	
	public void setCells(Position pos, int value)
	{
		board[pos.getx()][pos.gety()].setValue(value);
	}
	
	public MoveResults executeMove(Direction dir)
	{
		Board transformedBoard = new Board(this.dim);
		MoveResults results = new MoveResults();
		switch (dir)
		{
		case RIGHT:
			break;
		case LEFT: 
			transformedBoard.invert();
			break;
		case UP:
			transformedBoard.transpose();
			break;
		case DOWN:
			transformedBoard.transpose();
			transformedBoard.invert();
			
		}
		results = MoveRowRight();
	}
	
	private MoveResults MoveRowRight()
	{

	}
	
	private Board invert()
	{
		Board newBoard = new Board(this.dim);
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
			{
				newBoard.board[dim - 1 - i][j] = this.board[i][j];
			}
		return newBoard;
	}//Sin probar
	
	private Board transpose()
	{
		Board newBoard = new Board(this.dim);
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
			{
				newBoard.board[j][i] = this.board[i][j];
			}
		return newBoard;
	}//Tampoco
}
