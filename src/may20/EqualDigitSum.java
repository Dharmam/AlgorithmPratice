package may20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class EqualDigitSum {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 51, 71, 17, 42 }));
		System.out.println(solution(new int[] { 42, 33, 60 }));
		System.out.println(solution(new int[] { 51, 32, 43 }));

	}

	private static int solution(int[] A) {
		HashMap<Integer, ArrayList<Integer>> sumPair = new HashMap<>();
		Integer maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			int sum = sumOfDigits(A[i]);
			if (!sumPair.containsKey(sum)) {
				sumPair.put(sum, new ArrayList<>());
			}
			sumPair.get(sum).add(A[i]);
		}

		for (int i : sumPair.keySet()) {
			ArrayList<Integer> results = sumPair.get(i);
			int size = results.size();
			if( size > 2)Collections.sort(results);
			else if(size < 2)break;
			if (maxSum < results.get(size-1) + results.get(size-2)) {
				maxSum = results.get(size-1) + results.get(size-2);
			}

		}
		if (maxSum == Integer.MIN_VALUE)
			return -1;
		return maxSum;

	}

	private static int sumOfDigits(int num) {
		int sum = 0;
		while (num > 9) {
			sum += num % 10;
			num = num / 10;
		}
		return sum += num;
	}

}
