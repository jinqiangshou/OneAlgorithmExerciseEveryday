/********************************************Question**********************************************
 * Given two arrays of length m and n with digits 0-9 representing two numbers. 
 * Create the maximum number of length k <= m + n from digits of the two. 
 * The relative order of the digits from the same array must be preserved. 
 * Return an array of the k digits. You should try to optimize your time and space complexity.
 * 
 * Example 1:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * return [9, 8, 6, 5, 3]
 * 
 * Example 2:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * return [6, 7, 6, 0, 4]
 * 
 * Example 3:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * return [9, 8, 9]
 ****************************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-04-15
 **/
var getMaxSubArray = function(arr, k){
    if(k === 0 || k > arr.length){
        return [];
    }
    var ptr = arr.length - k;
    var res = [];
    while(ptr < arr.length) {
        res.push( arr[ptr] );
        ptr ++ ;
    }
    
    ptr = arr.length - k - 1;
    
    while(ptr >= 0) {
        var tmp = arr[ptr];
        for(var i =0; i < res.length && res[i] <= tmp; i++){
            var tmp2 = tmp;
            tmp = res[i];
            res[i] = tmp2;
        }
        ptr--;
    }
    return res;
};

var mergeArray = function(arr1, arr2) {
    var result = [];
    var i=0;
    var j=0;
    while(i < arr1.length && j < arr2.length){
        if(arr1[i] > arr2[j]){
            result.push(arr1[i]);
            i++;
        } else if(arr1[i] < arr2[j]) {
            result.push(arr2[j]);
            j++;
        } else {
            var i2 = i;
            var j2 = j;
            while(i2 < arr1.length && j2 < arr2.length && arr1[i2] === arr2[j2]){
                i2++;
                j2++;
            }
            if(i2 === arr1.length) {
                result.push(arr2[j]);
                j++;
            } else if(j2 === arr2.length) {
                result.push(arr1[i]);
                i++;
            } else if(arr1[i2] > arr2[j2]){
                result.push(arr1[i]);
                i++;
            } else {
                result.push(arr2[j]);
                j++;
            }
        }
    }
    while(i < arr1.length) {
        result.push(arr1[i]);
        i++;
    }
    while(j < arr2.length) {
        result.push(arr2[j]);
        j++;
    }
    return result;
};
var compareArray = function(arr1, arr2) {
    var len1 = arr1.length;
    var len2 = arr2.length;
    if(len1 > len2) { return 1; }
    if(len1 < len2) { return -1; }
    
    for(var i = 0; i < len1; i++){
        if(arr1[i] > arr2[i]){
            return 1;
        } else if (arr1[i] < arr2[i]) {
            return -1;
        }
    }
    return 0;
};

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number} k
 * @return {number[]}
 */
var maxNumber = function(nums1, nums2, k) {
    var result = [];
    for(var i = 0; i <= nums1.length && i <= k; i++){
        var num1 = getMaxSubArray(nums1, i);
        var num2 = getMaxSubArray(nums2, k-i);
        var arr = mergeArray(num1, num2);
        if(num1.length + num2.length === k && compareArray(result, arr) < 1) {
            result = arr;
        }
    }
    return result;  
};
