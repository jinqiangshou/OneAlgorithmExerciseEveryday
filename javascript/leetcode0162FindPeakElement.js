/**************************************Question***************************************
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * 
 * Note:
 * Your solution should be in logarithmic complexity.
 *************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-11-06
 **/
var isValid = function(nums, pos){
    if(pos === 0){
        return (nums[pos] > nums[pos+1])?0:1;
    }else if(pos === nums.length-1){
        return (nums[pos] > nums[pos-1])?0:(-1);
    }
    if(nums[pos] > nums[pos-1] && nums[pos] > nums[pos+1]){
        return 0;
    }else if(nums[pos] > nums[pos-1] && nums[pos] < nums[pos+1]){
        return 1;
    }else if(nums[pos] < nums[pos-1] && nums[pos] > nums[pos+1]){
        return -1;
    }else{
        return 1;
    }
};
  
/**
 * @author Horst Xu
 * @date 2015-11-06
 **/  
var check = function(nums, start, end){
    if(start === end){
        return start;
    }
    if(isValid(nums, start) === 0){
        return start;
    }else if(isValid(nums, end) === 0){
        return end;
    }
    var mid = Math.floor((start+end)/2);
    var temp = isValid(nums, mid);
    if(temp === 0){
        return mid;
    }else if(temp === 1){
        return check(nums, mid, end);
    }else{ // temp === -1
        return check(nums, start, mid);
    }
};


/**
 * @author Horst Xu
 * @date 2015-11-06
 * @param {number[]} nums
 * @return {number}
 **/
var findPeakElement = function(nums) {
    return check(nums, 0, nums.length-1);
};
