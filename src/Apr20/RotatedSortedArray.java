package Apr20;

public class RotatedSortedArray {

	public static void main(String[] args) {
		ListNode node = new ListNode(4);
		node.next = new ListNode(5);
		node.next.next = new ListNode(6);
		node.next.next.next = new ListNode(7);
		node.next.next.next.next = new ListNode(0);
		node.next.next.next.next.next = new ListNode(1);
		node.next.next.next.next.next.next = new ListNode(2);
		node.next.next.next.next.next.next .next = node;
		//traverse(node);
		int[] nums = new int[]{4,5,6,7,0,1,2};
		System.out.println(binarySearch(nums, 0, 0, nums.length-1));
		System.out.println(binarySearch(nums, 3, 0, nums.length-1));
		nums = new int[]{1,3};
		System.out.println(binarySearch(nums, 0, 0, nums.length-1));
		System.out.println(binarySearch(nums, 2, 0, nums.length-1));
		System.out.println(binarySearch(nums, 3, 0, nums.length-1));
		nums = new int[]{3,1};
		System.out.println(binarySearch(nums, 1, 0, nums.length-1));


	}

	//[4,5,6,7,0,1,2]
	private static int binarySearch(int[] nums, int target, int x , int y) {
		int mid = x + (y - x)/2 ;
		
		if(nums[mid]==target)return mid;
		if(mid<=x && mid>=y)return nums[mid]==target ? mid : -1;
        		
		if(mid != 0 && mid < nums.length && nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]) {
            			if(nums[mid]> target && nums[mid+1] < target)return -1;
			if(target <= nums[mid-1] && target >= nums[x]) {
				return binarySearch(nums, target, x, mid-1);
			}else if(target <= nums[mid+1] && target <= nums[y]) {
				return binarySearch(nums, target, mid+1, y);
			}
		}
		
		if(target < nums[mid]) {
			return binarySearch(nums, target, x, mid-1);
		}
		
		else if(nums[mid] < target ) {
			return binarySearch(nums, target, mid+1, y);
		}
        
		return -1;

	}
	private static void traverse(ListNode node) {
		ListNode temp1 = node;
		ListNode temp2 = node.next;
		
		while(temp1.val < temp2.val) {
			System.out.println("pt 1 : " + temp1.val + " pt 2 : " + temp2.val);
			temp1 = temp1.next;
			temp2 = temp2.next.next;
		}
		
		System.out.println("center : " + temp2.val);

	}

}

class ListNode{
	int val;
	ListNode next;
	
	public ListNode(int val) {
		this.val = val;
	}
}
