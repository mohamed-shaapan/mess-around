package commonsModule;

import java.util.ArrayList;

public class GenericPrinter {

	public static void printValidLocations(ArrayList<int[]> validLocations){
		
		for(int[] cell:validLocations){
			System.out.printf("Row : %d, Col : %d\n", cell[0], cell[1]);
		}
		System.out.println("*************************");
		
	}
	
	
}
