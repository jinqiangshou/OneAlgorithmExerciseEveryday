/**************************Question*****************************
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * 
 * Your algorithm should run in O(n^2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 ***************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-26
 **/
int lengthOfLIS(int* nums, int numsSize) {
    if(numsSize == 0){
        return 0;
    }
    int *arr = (int *)malloc(numsSize*sizeof(int));
    int pos = 0;
    for(int i = 0; i < numsSize; i++){
        int tmp = pos-1;
        while(tmp >= 0 && nums[i] <= arr[tmp]){
            tmp --;
        }
        arr[tmp+1] = nums[i];
        if(tmp == pos - 1){
            pos++;
        }
    }
    free(arr);
    return pos;
}
