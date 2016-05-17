/*********************************Question*************************************
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * 
 * Formally the function should:
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * 
 * Given [5, 4, 3, 2, 1],
 * return false.
 *******************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-05-17
 **/
bool increasingTriplet(int* nums, int numsSize) {
    int a, b, a_bp;
    if(numsSize < 3) {
        return false;
    }
    
    a = nums[0];
    a_bp = nums[0];
    
    int count = 1;
    while(count < numsSize) {
        if(nums[count] > a) {
            b = nums[count];
            break;
        } else {
            a = nums[count];
        }
        count ++;
    }
    
    for(int i = count+1; i < numsSize; i++) {
        if(nums[i] > b) {
            return true;
        } else if(nums[i] <= b && nums[i] > a) {
            b = nums[i];
        } else if(nums[i] < a && nums[i] < a_bp){
            a_bp = nums[i];
        } else if(nums[i] < a && nums[i] > a_bp){
            a = a_bp;
            b = nums[i];
        }
    }
    
    return false;
}
