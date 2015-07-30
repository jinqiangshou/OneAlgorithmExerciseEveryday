/**************************************Question**************************************
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-30
 **/
var mysubsetsWithDup = function(nums, k, start, count, row, result){
    
    if(count===k){
        result.push(row.slice());
        return;
    }
    
    if(start>=nums.length){
        return;
    }
    
    for(var i=start; i<nums.length; i++){
        if(i>start && nums[i] === nums[i-1]){
            continue;
        }
        row.push(nums[i]);
        mysubsetsWithDup(nums, k, i+1, count+1, row, result);
        row.pop();
    }
};

/**
 * @author Horst Xu
 * @date 2015-07-30
 * @param {number[]} nums
 * @return {number[][]}
 **/
var subsetsWithDup = function(nums) {
    var result = [];
    result.push([]);
    nums.sort(function(a,b){return (a-b);});
    for(var k=1; k<=nums.length;k++){
        mysubsetsWithDup(nums,k,0,0,[], result);
    }
    return result;
};
