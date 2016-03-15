/*************************************Question****************************************
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * 
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *************************************************************************************/
 

/**
 * @author Horst Xu
 * @date 2016-03-15
 **/
void moveZeroes(int* nums, int numsSize) {
    int i = 0;
    int j = 0;
    while(i < numsSize){
        if(nums[i] != 0){
            nums[j] = nums[i];
            i++; j++;
        } else {
            i++;
        }
    }
    while(j < numsSize){
        nums[j] = 0;
        j++;
    }
}
