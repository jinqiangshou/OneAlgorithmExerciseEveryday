/******************************************Question**********************************************
 * Given n balloons, indexed from 0 to n-1. 
 * Each balloon is painted with a number on it represented by array nums. 
 * You are asked to burst all the balloons. If the you burst balloon i 
 * you will get nums[left] * nums[i] * nums[right] coins. 
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note: 
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * Example:
 * 
 * Given [3, 1, 5, 8]
 * 
 * Return 167
 * 
 *    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 ************************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-04-07
 * @param {number[]} nums
 * @return {number}
 **/
var maxCoins = function(nums) {
    var newNums = [1];
    for(var i = 0; i < nums.length; i++) {
        newNums.push(nums[i]);
    }
    newNums.push(1);
    
    var mat = [];
    var emptyArr = [];
    for(var j = 0; j < newNums.length; j++) {
        emptyArr.push(0);
    }
    for(var k = 0; k < newNums.length; k++) {
        mat.push(emptyArr.slice());
    }
    
    return DP(mat, newNums, 0, newNums.length-1);
};

var DP = function(mat, nums, left, right) {
    if(left + 1 === right){
        return 0;
    }
    if(mat[left][right] > 0){
        return mat[left][right];
    }
    var result = 0;
    for(var i = left + 1; i < right; i++) {
        result = Math.max(result, nums[left]*nums[i]*nums[right]+DP(mat,nums,left,i)+DP(mat, nums, i, right));
    }
    mat[left][right] = result;
    return result;
};
