/* *******************************************Question*********************************************
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * ************************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-01-05
 * */
public class Solution {
    public int helper(int[] nums, int k, int start, int end){
        if(start >= end){
            return nums[end];
        }
        int pivot = nums[start];
        int low = start;
        int high = end;
        while(low < high){
            while(low < high && nums[high] >= pivot){
                high--;
            }
            nums[low] = nums[high];
            while(low < high && nums[low] <= pivot){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        if(end-low+1 == k){
            return pivot;
        }else if(end-low+1 < k){
            return helper(nums, k - end + low - 1, start, low-1);
        }else{
            return helper(nums, k, low + 1, end);
        }     
    }
    
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, k, 0, nums.length -1);
    }
}
