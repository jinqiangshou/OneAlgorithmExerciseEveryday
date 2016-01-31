/* *******************************************Question*********************************************
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- 
 * which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. 
 * You may simulate a stack by using a list or deque (double-ended queue), 
 * as long as you use only standard operations of a stack.
 * You may assume that all operations are valid 
 * (for example, no pop or peek operations will be called on an empty queue).
 * ************************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-01-31
 * */
class MyQueue {
    
    private Stack<Integer> st1 = new Stack<Integer>();
    private Stack<Integer> st2 = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> currST = st1.empty()?st1:st2;
        Stack<Integer> prevST = st1.empty()?st2:st1;
        
        while(!prevST.empty()){
            currST.push(prevST.pop());
        }
        prevST.push(x);
        while(!currST.empty()){
            prevST.push(currST.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> st = st1.empty()?st2:st1;
        if(st.empty()){
            return;
        }
        st.pop();
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> st = st1.empty()?st2:st1;
        return st.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st1.empty() && st2.empty();
    }
}
