package Jun20;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void sortColors(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if(nums[i] > nums[j])swap(nums, i , j);
			}
		}
	}

	static void swap(int[] nums, int src, int target) {
		int temp = nums[target];
		nums[target] = nums[src];
		nums[src] = temp;
	}
}
