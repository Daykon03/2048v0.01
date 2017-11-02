package tp.pr1;

import java.util.Random;

public class Game2048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long seed;
		if (args.length == 3) 
			seed = new Random().nextInt(1000); // Si sólo hay 2 argumentos
		else 
			seed = Long.parseLong(args[2]); // Si hay un tercer argumento
	
		Random rand = new Random(seed);
		// Para crear la misma secuencia de
		// números aleatorios
	}
	
	

}
