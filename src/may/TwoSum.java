package may;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * @author dbuch
 *
 *         Given an array of integers, return indices of the two numbers such
 *         that they add up to a specific target.
 * 
 *         You may assume that each input would have exactly one solution, and
 *         you may not use the same element twice.
 * 
 *         Example:
 * 
 *         Given nums = [2, 7, 11, 15], target = 9,
 * 
 *         Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 9;
		int[] result = twoSum(nums, target);
		System.out.println(Arrays.toString(result));
		nums = new int[] { 3, 2, 4 };
		target = 6;
		result = twoSum(nums, target);
		System.out.println(Arrays.toString(result));
		nums = new int[] { 3, 3 };
		target = 6;
		result = twoSum(nums, target);
		System.out.println(Arrays.toString(result));
	}

	// o(n)
	public int[] twoSum2(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int result[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];

			if (map.get(diff) != null && map.get(diff) != i) {
				result[0] = map.get(diff);
				result[1] = i;
				break;
			} else {
				map.put(nums[i], i);
			}

		}
		return result;
	}

	// o(n2)
	static int[] twoSum1(int[] nums, int target) {
		int[] result = new int[2];
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

	// Destroys the array. Index are not same. Works with no duplicate
	static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int[] result = new int[2];

		Arrays.sort(nums);

		int high = nums.length - 1;
		int low = 0;
		while (low < high) {
			if (nums[high] > target)
				high--;
			else {
				if (nums[high] + nums[low] == target) {
					result[0] = map.get(nums[low]);
					result[1] = map.get(nums[high]);
					break;
				} else if (nums[high] + nums[low] > target)
					high--;
				else {
					low++;
				}
			}
		}

		return result;
	}
}
