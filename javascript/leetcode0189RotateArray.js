/************************************Question*******************************************
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 
 * Hint:
 * Could you do it in-place with O(1) extra space?
 ***************************************************************************************/
 

/**
 * @author Horst Xu
 * @date 2015-12-06
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    var len = nums.length;
    k = k % len;
    var i;
    var temp;
    for(i=0; i<Math.floor((len-k)/2);i++){
        temp = nums[i];
        nums[i] = nums[len-k-1-i];
        nums[len-k-1-i] = temp;
    }
    
    for(i=0; i< Math.floor(k/2); i++){
        temp = nums[len-k+i];
        nums[len-k+i] = nums[len-1-i];
        nums[len-1-i] = temp;
    }
    
    for(i=0; i<Math.floor(len/2); i++){
        temp = nums[i];
        nums[i] = nums[len-1-i];
        nums[len-1-i] = temp;
    }
    return;
};
