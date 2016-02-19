/* **************************************Question****************************************
 * Given an array nums, there is a sliding window of size k which is moving 
 * from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note: 
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 * **************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-02-19
 * */
public class Solution {
    private class Pair {
        int x;
        int y;
        Pair(int a, int b){x=a; y=b;}
    }
    public void pushDeque(ArrayDeque<Pair> ad, int value){
        Pair p = new Pair(value, 0);
        while(!ad.isEmpty()){
            Pair last = ad.peekLast();
            if(last.x < p.x){
                p.y += (last.y + 1);
                ad.pollLast();
            }else{
                break;
            }
        }
        ad.addLast(p);
    }
    
    public int maxDeque(ArrayDeque<Pair> ad){
        return ad.peekFirst().x;
    }
    
    public void popDeque(ArrayDeque<Pair> ad){
        Pair p = ad.peekFirst();
        if(p.y > 0){
            p.y = p.y - 1;
            return;
        }
        ad.pollFirst();
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            int []arr = {};
            return arr;
        }
        ArrayDeque<Pair> ad = new ArrayDeque<>();
        
        int []result = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++){
            pushDeque(ad, nums[i]);
        }
        int pos = k - 1;
        while(pos < nums.length){
            result[pos - k + 1] = maxDeque(ad);
            pos ++;
            popDeque(ad);
            if(pos < nums.length){
                pushDeque(ad, nums[pos]);
            }
        }
        return result;
    }
}
