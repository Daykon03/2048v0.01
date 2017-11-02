package tp.pr1;

import java.util.Random;

public class Game {
	private Board _board;
	private int _size;
	private int _initCells;
	private Random _myRandom;

	
	
	public Game(int size,int initcells, Random random){
		_board = new Board(size);
		//usar la semilla
		_size = size;
	}
	
	public Game(int size,int initcells){
		_board = new Board(size);
		_size = size;
	}
	
	public void move(Direction dir)
	{
		_board.executeMove(dir);
	}
	
	public String toString()
	{
		return _board.toString();
	}

}
