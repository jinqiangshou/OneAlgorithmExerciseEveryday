/*************************************************Question***************************************************
 * Median is the middle value in an ordered integer list. If the size of the list is even, 
 * there is no middle value. So the median is the mean of the two middle value.
 * 
 * Examples: 
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:
 * 
 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3) 
 * findMedian() -> 2
 ************************************************************************************************************/
 

/**
 * @author Horst Xu
 * @date 2016-03-23
 **/
class MedianFinder {
private:
    struct cmp{
        bool operator () (int &a, int &b){
            return a > b;
        }
    };
    
    priority_queue<int,vector<int>, less<int> > less_queue;
    priority_queue<int, vector<int>, cmp > greater_queue;
    bool isOdd = false;
public:

    // Adds a number into the data structure.
    void addNum(int num) {
        if(!greater_queue.empty() && num > greater_queue.top()){
            int tmp1 = greater_queue.top();
            greater_queue.pop();
            greater_queue.push(num);
            less_queue.push(tmp1);
        } else {
            less_queue.push(num);
        }
        isOdd = (!isOdd);
        if(isOdd){
            int tmp = less_queue.top();
            less_queue.pop();
            greater_queue.push(tmp);
        }
    }
    
    // Returns the median of current data stream
    double findMedian() {
        if(isOdd){
            return (double)greater_queue.top();
        }else{
            return (less_queue.top() + greater_queue.top())/2.0;
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf;
// mf.addNum(1);
// mf.findMedian();
