/**************************************Question**************************************
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *************************************************************************************/
 
 
/**
 * @author Horst Xu
 * @date 2015-07-17
 **/
var mysubsets = function(nums, k, start, count, row, result){
    
    if(count===k){
        result.push(row.slice());
        return;
    }
    
    if(start>=nums.length){
        return;
    }
    
    for(var i=start; i<nums.length; i++){
        row.push(nums[i]);
        mysubsets(nums, k, i+1, count+1, row, result);
        row.pop();
    }
};

/**
 * @author Horst Xu
 * @date 2015-07-17
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    var result = [];
    result.push([]);
    nums.sort(function(a,b){return (a-b);});
    for(var k=1; k<=nums.length;k++){
        mysubsets(nums,k,0,0,[], result);
    }
    return result;
};
