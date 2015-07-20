/***************************Question****************************
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 ***************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-20
 **/
var mySearch = function(nums, start, end, target) {
    while(nums[start] === nums[end] && start < end){
        start++;
    }
    if(start>end){
        return false;
    }else if(start === end){
        return (nums[start] === target);
    }else if(start+1 === end){
        return (nums[start] === target) || (nums[end] === target);
    }
    
    var mid = Math.floor((start+end)/2);
    if(nums[mid] === target || nums[start] === target || nums[end] === target){
        return true;
    }
    if(nums[mid] > target && target > nums[start]){
        return mySearch(nums, start+1, mid-1,target);
    }else if(nums[mid] > target && target < nums[end]){
        if(nums[mid]<=nums[end]){
            return mySearch(nums, start+1, mid-1, target);
        }else if(nums[mid] >= nums[start]){
            return mySearch(nums, mid+1, end-1, target);
        }
    }else if(nums[mid] < target && target > nums[start]){
        if(nums[mid] >= nums[start]){
            return mySearch(nums, mid+1, end-1, target);
        }else if(nums[mid] <= nums[end]){
            return mySearch(nums, start+1, end-1, target);
        }
    }else if(nums[mid] < target && target < nums[end]) {
        return mySearch(nums, mid+1, end-1, target);
    }
    return false;
};

/**
 * @author Horst Xu
 * @date 2015-07-20
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 **/
var search = function(nums, target) {
    if(nums.length ===1){
        return nums[0] === target;
    }
    return mySearch(nums, 0, nums.length-1, target);
};
