package Jun20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwoCityScheduling {

	public static void main(String[] args) {
		int[][] cost = new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
		System.out.println(twoCitySchedCost(cost));
	}

	static int twoCitySchedCost(int[][] costs) {
		
		int aSum = 0 ;
		
		for (int i = 0; i < costs.length; i++) {
			aSum+=costs[i][0];
		}
		
		System.out.println(aSum);
		
		
		int[] refundArray = new int[costs.length];
		
		for (int i = 0; i < costs.length; i++) {
			refundArray[i] = costs[i][1]-costs[i][0];
		}
		
		
		Arrays.sort(refundArray);
		
		for(int i =0 ; i < costs.length/2 ; i++) {
			aSum+=refundArray[i];
		}
		
		return aSum;

	}
	
	static class CityComparator1 implements Comparator<City>
	 {
	     public int compare(City c1, City c2)
	     {
	         return Integer.compare(c1.costA, c2.costA);
	     }
	 }
	
	static class CityComparator2 implements Comparator<City>
	 {
	     public int compare(City c1, City c2)
	     {
	         return Integer.compare(c1.costB, c2.costB);
	     }
	 }

	static class City {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + costA;
			result = prime * result + costB;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			City other = (City) obj;
			if (costA != other.costA)
				return false;
			if (costB != other.costB)
				return false;
			return true;
		}
		public City(int i, int j) {
			this.costA = i;
			this.costB = j;
		}

		int costA;
		int costB;
		
		
		
	}

}
