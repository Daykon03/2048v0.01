/*package tp.pr1.util;

import java.util.Random;

public class ArrayAsList {
	// The rest of the code for the ArrayAsList class is to be added here.
	// The other methods of this class will not be static .
	
	
	// This method is static in order to be similar to the "shuffle () "
	// method of the standard library class "Collections ".
	public static void shuffle(ArrayAsList list, Random random) {
	for (int i = list.size(); i > 1; i--) {
	swap(list.arrayAsList, i - 1, random.nextInt(i));
	}
	}
	// This method is static in order to be similar to the "shuffle () " method.
	public static Object choice(ArrayAsList list, Random random) {
	return list.get(random.nextInt(list.size()));
	}
	private static void swap(Object[] anArray, int i, int j) {
	Object temp = anArray[i];
	anArray[i] = anArray[j];
	anArray[j] = temp;
	}
}*/