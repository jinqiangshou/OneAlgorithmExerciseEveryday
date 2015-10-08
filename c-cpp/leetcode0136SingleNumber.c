/*****************************************Question******************************************
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *******************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-10-08
 **/
int singleNumber(int* nums, int numsSize) {
    int k = nums[0];
    for(int i = 1; i < numsSize; i++){
        k = k ^ nums[i];
    }
    return k;
}
