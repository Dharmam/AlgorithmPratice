package may;

public class ValidPallindrome {

	public static void main(String[] args) {
		String s = " ";
		System.out.println(reverseWords(s));
		s = "A bc def EDcba";
		System.out.println(reverseWords(s));
		s="race a car";
		System.out.println(reverseWords(s));
		s="a good   example";
		System.out.println(reverseWords(s));
	}

	static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toLowerCase().toCharArray()) {
			if ((c >= 'a' && c <= 'z')|| (c >= '0' && c <= '9') )
				sb.append(c);
		}
		System.out.println(sb.toString());
		if(sb.length() == 0) return true;

		int i = 0 ;
		while(i <= sb.length()/2) {
			if(sb.charAt(i) != sb.charAt(sb.length()-i-1)) return false;
			i++;
		}
		
		return true;
	}
	
	static char[] reverseString(char[] word) {
        if(word.length <= 1) return word;
        else{
            for(int i = 0 , j = word.length-1; i < word.length/2 ; i++,j--){
                char temp = word[j];
                word[j] = word[i];
                word[i]=temp;
            }
        }
        return word;
    }
	
	static String reverseWords2(String s) {
		String[] words = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			char[] c = reverseString(words[i].toCharArray());
			for(char ch : c) {
				sb.append(ch);
			}
			sb.append(" ");
		}
		return sb.toString();
	}
	
	static String reverseWords(String s) {
		String[] words = s.trim().split(" ");

		StringBuilder sb = new StringBuilder();
        for(int j = words.length-1; j >=0 ; j--){
                if(words[j].trim().length()>0){
                    sb.append(words[j].trim());
                    sb.append(" ");
                }
		}
        
		return sb.length()>1 ? sb.deleteCharAt(sb.length()-1).toString() : sb.toString();
	}

}
