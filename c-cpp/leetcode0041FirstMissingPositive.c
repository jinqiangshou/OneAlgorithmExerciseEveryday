/****************************Question****************************
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 ****************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-09
 */
int firstMissingPositive(int* nums, int numsSize) {
    int i=0;
	while(i<numsSize){
		if(nums[i] == i+1){
			i++;
		}else if(nums[i] <= 0 || nums[i] >= numsSize){
			i++;
		}else{
			if(nums[i] != nums[nums[i]-1]){
				int temp = nums[i];
				nums[i] = nums[nums[i]-1];
				nums[temp-1] = temp;
				continue;
			}
			i++;
		}
	}
	for(i=0; i<numsSize; i++){
		if(nums[i] != i+1){
			return i+1;
		}
	}
	return numsSize+1;
}
