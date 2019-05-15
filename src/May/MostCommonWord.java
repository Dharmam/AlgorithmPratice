package may;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;

public class MostCommonWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
System.out.println(mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"}));

	}

	static String mostCommonWord(String paragraph, String[] banned) {
		HashSet<String> set = new HashSet<>();
		for(String s : banned){
			set.add(s.trim().toLowerCase());
		}
		
		HashMap<String, Integer> map = new HashMap<>();
		int maxCount = 0 ;
		String result = null;
		paragraph = paragraph.replaceAll("[^a-zA-Z]"," ");
		paragraph = paragraph.toLowerCase();


        for(String s : paragraph.split(" ")){
        	System.out.println("String - s = " + s);
        	if(set.contains(s.trim()) || s.isEmpty() || s.equals(" "))continue;
        	int count = 0 ;
        	if(map.get(s) != null){
        		count=map.get(s);
        	}
        	count++;
        	map.put(s, count);
        	if(count > maxCount){
        		maxCount = count;
        		result = s;
        	}
        }
        
        return result;
    }
}
