package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetInputObject {
	static ArrayList<Integer> arr = new ArrayList<>() ;
	
	public static ArrayList<Integer> getList(){
		System.out.println("Please enter integer values : ");
		arr.clear();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			arr.add(sc.nextInt());
			System.out.println("Press * for exit the input stream.");
		}
		return arr;
	}

	public static Integer[] getArray(String string) {
		getList();
		Integer[] result = new Integer[arr.size()];
		return arr.toArray(result);
	}
}
