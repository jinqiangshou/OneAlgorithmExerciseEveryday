/**************************************Question*******************************************
 * Given an array of numbers nums, in which exactly two elements appear only once 
 * and all the other elements appear exactly twice. Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *****************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-02-28
 * @param {number[]} nums
 * @return {number[]}
 **/
var singleNumber = function(nums) {
    var len = nums.length;
    var xor = 0;
    var i;
    for(i = 0; i < len; i++){
        xor = nums[i] ^ xor;
    }
    var lastdiffbit = 1;
    while((xor & 1) === 0){
        xor = (xor >> 1);
        lastdiffbit = (lastdiffbit << 1);
    }
    var a = 0, b = 0;
    for(i = 0; i < len; i++){
        if((nums[i] & lastdiffbit) > 0){
            a = a^nums[i];
        } else {
            b = b^nums[i];
        }
    }
    return [a, b];
};
