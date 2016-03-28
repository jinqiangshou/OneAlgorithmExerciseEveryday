/***************************************Quesstion****************************************
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 ****************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-28
 * @constructor
 * @param {number[]} nums
 **/
var NumArray = function(nums) {
    this.curSum = [];
    var len = nums.length;
    var curVal = 0;
    for(var i=0; i < len; i++){
        curVal += nums[i];
        this.curSum.push(curVal);
    }
};

/**
 * @author Horst Xu
 * @date 2016-03-28
 * @param {number} i
 * @param {number} j
 * @return {number}
 **/
NumArray.prototype.sumRange = function(i, j) {
    return this.curSum[j] - (i > 0 ? this.curSum[i-1] : 0);
};


/**
 * Your NumArray object will be instantiated and called as such:
 * var numArray = new NumArray(nums);
 * numArray.sumRange(0, 1);
 * numArray.sumRange(0, 2);
 */
