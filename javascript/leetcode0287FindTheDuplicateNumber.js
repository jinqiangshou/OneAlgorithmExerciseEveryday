/***********************************Question*************************************
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. 
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n^2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 ********************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-17
 * @param {number[]} nums
 * @return {number}
 **/
var findDuplicate = function(nums) {
    var len = nums.length;
    var p1 = len - 1;
    var p2 = len - 1;
    while(true){
        p1 = nums[p1] - 1;
        p2 = nums[p2] - 1;
        p2 = nums[p2] - 1;
        if( p1 == p2 ){
            break;
        }
    }
    p2 = len - 1;
    while(true){
        p1 = nums[p1] - 1;
        p2 = nums[p2] - 1;
        if( p1 == p2 ){
            return p1 + 1;
        }
    }
};
