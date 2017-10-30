package tp.pr1;
import java.util.Scanner;
import java.util.Random;

public class Controller {
	private Game game;
	private Scanner in;
	
	private void showHelp()
	{
		
	}
	
	public Controller(int size,int initcells, Random random){
		game = new Game(size, initcells, random);
		in = new Scanner(System.in);
	}
	
	public void run()
	{
		boolean truth = true;
		String command = in.next();
		System.out.print(game);
		System.out.print(command);
		while (command == "exit")
		{
			if (command == "move")
			{
				command = in.next();
				if (Direction.isDirection(command))
				{
					game.move(Direction.string2Dir(command));
					System.out.print(game);
				}
			}
			else if (command == "help")
			{
				showHelp();
			}
		}
		System.out.print(command);
	}
	public static void main(String args[])
	{
		Random ran = new Random();
		Controller con = new Controller(4, 0, ran);
		con.run();
	}
}
