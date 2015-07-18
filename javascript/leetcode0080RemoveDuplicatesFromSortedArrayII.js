/***********************************Question***************************************
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
 * It doesn't matter what you leave beyond the new length.
 **********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-19
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    var len = nums.length;
    if(len <= 2){ return len;}
    
    var pos = 1;
    for(var i=2;i<len;i++){
        if(nums[pos] !== nums[i] || nums[pos] !== nums[pos-1]){
            pos++;
            nums[pos] = nums[i];
        }
    }
    return pos+1;
};
