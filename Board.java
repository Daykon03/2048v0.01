package tp.pr1;

public class Board {
	private Cell board[][];
	private int dim;
	private static final String NEWLINE = System.getProperty("line.separator");
	
	public Board(int dim)
	{
		this.dim=dim;
		this.board = new Cell[dim][dim];
		//int k = 0;
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++)
			{
				this.board[i][j] = new Cell(0);
				//k++;
			}
		this.board[0][1].setValue(2);
		this.board[0][3].setValue(2);
		this.board[2][1].setValue(2);
		this.board[2][3].setValue(4);
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
		case DOWN:
			this.transpose();
			break;
		case UP:
			this.transpose();
			this.invert();
		default:
			break;
			
		}
	}
	
	private void transformBack(Direction dir)
	{
		if (dir == Direction.UP)
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
					{
						if (board[row][i].doMerge(board[row][j]))
						{
							results.setMoved(true);
							results.setScore(board[row][i].getValue());
							results.setMax(board[row][i].getValue());
						}
					i--;
					}
			}
		}
		
		return results;
	}
	
	private void swap(int i1, int j1, int i2, int j2)
	{
		Cell aux = new Cell(0);
		aux.duplicate(this.board[i1][j1]); 
		this.board[i1][j1].duplicate(this.board[i2][j2]);
		this.board[i2][j2].duplicate(aux);
	}
	
	private void invert()
	{
		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim/2; j++)
			{
				swap(i, j, i, dim - 1 - j);
			}
	}//Hacer con ArrayAsList
	
	private void transpose()
	{
		for (int i = 0; i < dim; i++)
			for (int j = 0; j <= i; j++)
			{
				swap(i, j, j, i);
			}
	}//Hacer con ArrayAsList
	
	public static void main(String args[])
	{
		Board board = new Board(4);
		MoveResults res = new MoveResults();
		System.out.print(board);
		System.out.print(res);
		res = board.executeMove(Direction.DOWN);
		System.out.print(board);
		System.out.print(res);
		res = board.executeMove(Direction.RIGHT);
		System.out.print(board);
		System.out.print(res);
		
	}
}
