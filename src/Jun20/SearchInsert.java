package Jun20;

public class SearchInsert {

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 3 }, 2));
		System.out.println(searchInsert(new int[] { 1 }, 2));

		System.out.println(searchInsert(new int[] { 1,3,5,6 }, 5));
		System.out.println(searchInsert(new int[] { 1,3,5,6 }, 2));
		System.out.println(searchInsert(new int[] { 1,3,5,6 }, 7));
		System.out.println(searchInsert(new int[] { 1,3,5,6 }, 0));

	}

	static int searchInsert(int[] nums, int target) {
		for(int i = 0 ; i < nums.length ; i++) {
			if(nums[i] < target)continue;
			else if(nums[i] == target) return i;
			else {
				return i;
			}
		}
		return nums.length;
	}
}
