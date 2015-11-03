/*************************************Question**************************************
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 ***********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-11-03
 **/
int findMin(int* nums, int numsSize) {
    int start = 0;
    int end = numsSize - 1;
    while(start < end){
        while(start<end && nums[start] == nums[end]){
            start++;
        }
        if(start == end || nums[start] < nums[end]){
            return nums[start];
        }
        if(end - start == 1){
            return (nums[start]<nums[end]?nums[start]:nums[end]);
        }
        int mid = (start+end)/2;
        if(nums[mid] <= nums[end]){
            end = mid;
        }
        if(nums[mid] >= nums[start]){
            start = mid;
        }
    }
    return nums[start];
}
