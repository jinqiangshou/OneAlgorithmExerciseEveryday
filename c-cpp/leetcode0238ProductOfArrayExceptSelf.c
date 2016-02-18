/*****************************************Question*******************************************
 * Given an array of n integers where n > 1, nums, 
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? 
 * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 ********************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-02-18
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 **/
int* productExceptSelf(int* nums, int numsSize, int* returnSize) {
    
    *returnSize = numsSize;
    
    int *result = (int *)malloc(sizeof(int)*numsSize);
    for(int i = 0; i < numsSize; i++){
        result[i] = 1;
    }
    
    int left = 1;
    for(int i=0; i<numsSize; i++){
        result[i] *= left;
        left *= nums[i];
    }
    int right = 1;
    for(int i=numsSize-1; i >= 0; i--){
        result[i] *= right;
        right *= nums[i];
    }
    return result;
}
