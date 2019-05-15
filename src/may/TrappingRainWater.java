package may;

public class TrappingRainWater {

	public static void main(String[] args) {
		trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
	}
	
	static int trap(int[] height) {
        Integer left = null;
        Integer right = null;
        
        for(int i = 0 ; i < height.length ; i++ ) {
        	if(left == null || right == null) {
        		left = height[i];
        		right = left;
        	}
        	if(left < height[i]) {
        		left = height[i];
    			System.out.println("Found left : " + left);
        	}
        	else {
        		if(height[i] < right) {
        			left = height[i];
        			System.out.println("Found right : " + right);
        		}else {
        			right = height[i];
        		}
        	}

        }
        return 0 ;
    }

}
