/****************************Question*****************************
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *****************************************************************/
 

/**
 * @author Horst Xu
 * @date 2015-05-14
 */
int jump(int* nums, int numsSize) {
    if(numsSize == 0 || numsSize == 1){
		return 0;
	}
	int result = 0;
    int longest = 0;
    int maxPos = 0;
    for(int i=0; i<numsSize-1; i++) {
        maxPos = (maxPos>i+nums[i])?maxPos:(i+nums[i]);
        if( i == longest ) {
            result++;
            longest = maxPos;
        } 
    }
    return result;
}
