/*************************************Question****************************************
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-11-04
 **/
class MinStack {
public:
    stack<int> data;
    stack<int> minData;
    
    void push(int x) {
        data.push(x);
        if(minData.empty() || x <= minData.top()){
            minData.push(x);
        }
    }

    void pop() {
        if(data.top() == minData.top()){
            minData.pop();
        }
        data.pop();
    }

    int top() {
        return data.top();
    }

    int getMin() {
        return minData.top();
    }
};
