/**************************************Question******************************************
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 ****************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-11-02
 **/
int findMin(int* nums, int numsSize) {
    int start = 0;
    int end = numsSize-1;
    while(start<end){
        if(nums[start]<nums[end]){
            return nums[start];
        }
        if(end-start == 1){
            return nums[start]<nums[end]?nums[start]:nums[end];
        }
        int mid = (start+end)/2;
        if(nums[mid]<nums[end]){
            end = mid;
        }
        if(nums[mid]>nums[start]){
            start = mid+1;
        }
    }
    return nums[start];
}
