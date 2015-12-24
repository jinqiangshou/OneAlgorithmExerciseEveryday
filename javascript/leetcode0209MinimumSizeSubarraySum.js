/****************************************Question******************************************
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 ******************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-12-24
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 **/
var minSubArrayLen = function(s, nums) {
    if(nums.length === 0){
        return 0;
    }else if(nums[0]>=s){
        return 1;
    }
    var start = -1;
    var end = -1;
    var result = nums.length+1;
    var record = 0;
    while(end<nums.length-1){
        while(record <s){
            end++;
            record += nums[end];
        }
        if(record>=s && end-start<result){
            result = end-start;
        }
        while(record >=s){
            start++;
            record -= nums[start];
        }
        if(record+nums[start]>=s && end-start+1 < result){
            result = end-start+1;
        }
    }
    return (result>nums.length ? 0 : result);
};
