/**********************Question***************************
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where 
 * index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.

 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
*********************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-01
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]} two integers in an array, ie: [index1, index2]
 */
var twoSum = function(numbers, target) {
    var rec=[];
    var diff; 
    var result=[];
    for(var i=0;i<numbers.length;i++){
        diff = target - numbers[i];
        if(typeof(rec[diff])==='undefined'){
            rec[numbers[i]] = i;
        }else{
            result = (rec[diff]>i)?([i+1, rec[diff]+1]):([rec[diff]+1,i+1]);
            break;
        }
    }
    return result;
};
