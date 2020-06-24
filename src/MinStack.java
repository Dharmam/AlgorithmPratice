import java.util.Stack;

class MinStack {
    
        public Stack<Integer> stack = null;
        public Integer top = null;
        public Integer min = null;
        
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        top = -1;
        min = -1;
    }
    
    public void push(int x) {
       if(x < min || min == null) min = x; 
       this.top = x;
       this.stack.push(x);
    }
    
    public void pop() {
    	this.top = stack.pop();
    }
    
    public int top() {
        return this.top ;
    }
    
    public int getMin() {
        return this.min ;
    }


public static void main(String args[]) {
	MinStack obj = new MinStack();
	  obj.push(2);
	  obj.pop();
	  int param_3 = obj.top();
	  int param_4 = obj.getMin(); 
}
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */