package Apr20;

import java.util.HashSet;
import java.util.Set;

public class Demo {

	public static void main(String[] args) {
        Boolean emailsUploaded = false;
        Set<String> dbRecordSetForAccessList = new HashSet<>();

        for(int i = 0 ; i < 10 ; i++) {
        	
        	if(uploadToBox(dbRecordSetForAccessList, i) && !emailsUploaded) {
                emailsUploaded = true;
            }
        }
        
        for (String string : dbRecordSetForAccessList) {
			System.out.println(string);
		}
	}

	private static boolean uploadToBox(Set<String> dbRecordSetForAccessList, int i) {
		return dbRecordSetForAccessList.add(i+"");
	}

}
