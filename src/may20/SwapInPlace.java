package may20;

public class SwapInPlace {

	public static void main(String[] args) {
/*		System.out.println(swap(1));
		System.out.println(swap(11));
		System.out.println(swap(12));
		System.out.println(swap(1234));
		System.out.println(swap(12334));*/


		System.out.println(maximumSwap(1234));
		System.out.println(maximumSwap(12334));
		System.out.println(maximumSwap(1993));
		System.out.println(maximumSwap(2736));
		System.out.println(maximumSwap(9973));
		System.out.println(maximumSwap(98368));

	}

	static int swap(int num) {
		String s = "";

		while (num > 10) {
			int div = num % 10;
			s += (div + "");
			num = num / 10;
		}
		s += (num + "");
		return Integer.parseInt(s);
	}

	static int maximumSwap(int num) {
		String s = String.valueOf(num);
		s = bubbleSort(s);
		return Integer.valueOf(s);
	}

	private static String bubbleSort(String s) {
		boolean swapped = false;
		for (int i = 0; i < s.length(); i++) {
			Integer lastSwapIndex = null;
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) < s.charAt(j)) {
					if (lastSwapIndex == null || s.charAt(lastSwapIndex) <= s.charAt(j)) {
						lastSwapIndex = j;
					}
				}
			}
			if (lastSwapIndex != null) {
				s = swap(s, i, lastSwapIndex);
				swapped = true;
			}
			if (swapped)
				break;
		}
		return s;
	}

	private static String swap(String s, int i, int j) {
		StringBuilder sb = new StringBuilder(s);

		sb.setCharAt(i, s.charAt(j));
		sb.setCharAt(j, s.charAt(i));

		return sb.toString();

	}

}
