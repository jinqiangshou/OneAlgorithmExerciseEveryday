/*********************************Question*********************************
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 **************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-10-09
 **/
int singleNumber(int* nums, int numsSize) {
    int one=0;
    int two=0;
    int three=0;
    for(int i=0;i<numsSize;i++)
    {
        three =  two & nums[i];
        two = two | one & nums[i];
        one = one | nums[i];
        one = one & ~three;
        two = two & ~three;
    }
     return one;
}
