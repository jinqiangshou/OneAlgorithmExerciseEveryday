/*********************************Question*************************************
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant extra space complexity?
 ******************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-03
 **/
int missingNumber(int* nums, int numsSize) {
    int max = INT_MIN;
    unsigned int sum = 0;
    for(int i = 0; i < numsSize; i++){
        sum += nums[i];
        if(nums[i] > max){
            max = nums[i];
        }
    }
    if(max < numsSize){
        return numsSize;
    }
    unsigned int total = max * (numsSize + 1) / 2;
    return (int)(total - sum);
}
