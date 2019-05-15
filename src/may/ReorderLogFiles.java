package may;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

	static String[] reorderLogFiles(String[] logs) {
		System.out.println(Arrays.toString(logs));

		Arrays.sort(logs, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int oi = o1.indexOf(' ');
				char oj = o1.charAt(oi + 1);

				int o2i = o2.indexOf(' ');
				char o2j = o2.charAt(o2i + 1);

				if (o2j >= 'a' && oj >= 'a') {
					if (o1.substring(oi).compareTo(o2.substring(o2i)) == 0) {
						return o1.substring(0, oi).compareTo(o2.substring(0, o2i));
					}
					return o1.substring(oi).compareTo(o2.substring(o2i));
				}
				if (o2j < 'a' && oj < 'a') {
					return 0;
				}
				if (o2j < 'a')
					return -1;
				if (oj < 'a')
					return 1;
				return 0;
			}
		});

		System.out.println(Arrays.toString(logs));

		return logs;

	}

	public static void main(String[] args) {
		reorderLogFiles(new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" });
		reorderLogFiles(new String[] { "1 n u", "r 527", "j 893", "6 14", "6 82" });

	}
}
