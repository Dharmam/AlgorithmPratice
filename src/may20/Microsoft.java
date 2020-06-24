package may20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Microsoft {
	public static void main(String[] args) {
		
		System.out.println(solution(new int[] {3,8,2,3,3,2}));
		System.out.println(solution(new int[] {7,1,2,8,2}));
		System.out.println(solution(new int[] {3,1,4,1,5}));
		System.out.println(solution(new int[] {5,5,5,5,5}));

		
		System.out.println(solution1(new int[] {3,8,2,3,3,2}));
		System.out.println(solution1(new int[] {7,1,2,8,2}));
		System.out.println(solution1(new int[] {3,1,4,1,5}));
		System.out.println(solution1(new int[] {5,5,5,5,5}));
		
		String[] string = solution(10, 100);
		printResult(string);

		string = solution(3, 20);
		printResult(string);

		string = solution(2, 4);
		printResult(string);
	}

	private static void printResult(String[] string) {
		for (int i = 0; i < string.length; i++) {
			System.out.print(string[i] + "---->>>");
		}
		System.out.println();
	}

	public static String[] solution(int N, int K) {
		if (N == 0) {
			return new String[] { "" };
		}
		ArrayList<String> result = new ArrayList<String>();
		for (String p : solution(N - 1, K)) {
			for (char l : new char[] { 'a', 'b', 'c' }) {
				int pLen = p.length();
				if (pLen == 0 || p.charAt(pLen - 1) != l) {
					result.add(p + l);
				}
			}
		}
		int prefSize = Math.min(result.size(), K);
		return result.subList(0, prefSize).toArray(new String[prefSize]);
	}

	static int solution(int N) {
		int digit = 5;
		if (N == 0) {
			return digit * 10;
		}
		int nagate = N / Math.abs(N);

		N = Math.abs(N);
		int n = N;
		int counter = 0;

		while (n > 0) {
			counter++;
			n = n / 10;
		}

		int index = 1;
		int maxVal = Integer.MIN_VALUE;
		for (int i = 0; i <= counter; i++) {
			int newVal = ((N / index) * (index * 10)) + (digit * index) + (N % index);
			if (newVal * nagate > maxVal) {
				maxVal = newVal * nagate;
			}
			index = index * 10;
		}
		return maxVal;
	}
	
	public static int solution(int[] A) {
		// Extra space but run time will be o(n)
		   Map<Integer, Integer> map = new HashMap<>();
		   for (Integer i: A) {
		       if (map.containsKey(i)) {
		           map.put(i, map.get(i)+1);
		       } else {
		           map.put(i, 1);
		       }
		   }
		   int max = 0;
		   for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
		       if (entry.getKey() == entry.getValue() && entry.getValue()>max) {
		           max = entry.getKey();
		       }
		   }
		   return max;
		}
	
	public static int solution1(int[] A) {
		Arrays.sort(A);
		
		int max = 0 ;
		int result = 0;
		int cur = 0 ;
		Integer last = null ;
		
		for (int i = 0; i < A.length; i++) {
			if(last == null || last == A[i]) {
				cur++;
				last = A[i];
			}else {
				if(cur >= max) {
					result = A[i];
					max = cur;
				}
				cur = 0;
			}
		}
		   return result;
		}

}