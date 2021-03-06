package april;

import java.util.Arrays;

/**
 * 
 * @author dbuch 287. Find the Duplicate Number
 * 
 *         Given an array nums containing n + 1 integers where each integer is
 *         between 1 and n (inclusive), prove that at least one duplicate number
 *         must exist. Assume that there is only one duplicate number, find the
 *         duplicate one.
 * 
 *         Example 1:
 * 
 *         Input: [1,3,4,2,2] Output: 2 Example 2:
 * 
 *         Input: [3,1,3,4,2] Output: 3 Note:
 * 
 *         You must not modify the array (assume the array is read only). You
 *         must use only constant, O(1) extra space. Your runtime complexity
 *         should be less than O(n2). There is only one duplicate number in the
 *         array, but it could be repeated more than once.
 */
public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		System.out.println(findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
		String s = "Hello";
		String st = "";
		 for(char c : s.toCharArray()){
			 int t = c;
	            if((65 <= c) && (c <= 90)){
	                t = c+32;
	            }
	                st+= Character.toString ((char) t);	           
	        }
		System.out.println(st);

	}
	
	static int findDuplicate(int[] nums) {
		if(nums.length > 1) {
			int fast = nums[nums[0]] ;
			int slow = nums[0] ;
			
			while(fast != slow) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}
			
		    fast = 0;
			while (fast != slow)
			{
				fast = nums[fast];
				slow = nums[slow];
			}
			
			return slow;
		}
		return -1;
	}

	static int findDuplicate1(int[] nums) {
		Arrays.sort(nums);
		Integer c = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (c == nums[i])
				return nums[i];
			c = nums[i];
		}
		return 0;
	}

}
