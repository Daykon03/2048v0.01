package tp.pr1;

public class Board {
	private Cell board[][];
	private int dim;
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public Board(int dim)
	{
		this.dim=dim;
		this.board = new Cell[dim][dim];
		int k = 0;
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
			{
				this.board[i][j] = new Cell(k);
				k++;
			}
				
	}
	
	
	public String toString()
	{
		String board = " ";
		board += MyStringUtils.repeat("-" ,8 * dim);
		board += NEWLINE;
		for (int i = 0; i < this.dim; i++)
		{
			for (int j = 0; j < this.dim; j++)
			{
				board += "|";
				if (this.board[i][j].getValue() != 0)
					board += MyStringUtils.centre(this.board[i][j].toString(), 7);
				else 
					board += "       ";
			}
			board += "|";
			board += NEWLINE;
			
		}
		board += " ";
		board += MyStringUtils.repeat("-",8 * dim);
		board += NEWLINE;
		
		return board;
	}

	
	public void setCells(Position pos, int value)
	{
		board[pos.getx()][pos.gety()].setValue(value);
	}
	
	private void transform(Direction dir)
	{
		switch (dir)
		{
		case LEFT: 
			this.invert();
			break;
		case UP:
			this.transpose();
			break;
		case DOWN:
			this.transpose();
			this.invert();
		default:
			break;
			
		}
	}
	
	private void transformBack(Direction dir)
	{
		if (dir == Direction.DOWN)
		{
			this.invert();
			this.transpose();
		}
		else transform(dir);
	}
	
	public MoveResults executeMove(Direction dir)
	{
		MoveResults results = new MoveResults();
		transform(dir);
		for (int i = 0; i < this.dim; i++)
			results = this.moveRowRight(i);
		transformBack(dir);
		return results;
	}
	
	private MoveResults moveRowRight(int row)
	{
		MoveResults results = new MoveResults();
		boolean end = false;
		int i = dim - 1, j;
		
		while (i >= 0 && !end)
		{
			j = i - 1;
			while (j >= 0 && board[row][j].getValue() == 0 )
				j--;
			end = j == -1;
			if (!end)
			{
				if (board[row][i].getValue() == 0)
				{
					board[row][i].setValue(board[row][j].getValue());
					board[row][j].setValue(0);
					results.setMoved(true);
				}
				else
					if (board[row][i].doMerge(board[row][j]))
					{
						results.setMoved(true);
						results.setScore(board[row][i].getValue());
						results.setMax(board[row][i].getValue());
					}
			}
			i--;
		}
		
		return results;
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
	}//Sin probar //Hacer con ArrayAsList
	
	private Board transpose()
	{
		Board newBoard = new Board(this.dim);
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
			{
				newBoard.board[j][i] = this.board[i][j];
			}
		return newBoard;
	}//Tampoco //Hacer con ArrayAsList
	
	public static void main(String args[])
	{
		Board board = new Board(3);
		System.out.print(board);
		board = board.transpose();
		System.out.print(board);
	}
}
