/******************************Question************************************
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
**************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-13
 * @param {number[]} num
 * @returns {number[][]} an array of number arrays with length = 3
 */
var threeSum = function (num) {
    num.sort(function(a,b){return (a-b);});
    var result = [];
    
    for(var i=0; i<num.length-2; i++){
        if(i>0 && num[i]===num[i-1]){
            continue;
        }
        var target = 0 - (num[i]);
        var p1 = i+1;
        var p2 = num.length-1;
        while(p1<p2){
            if(num[p1]+num[p2] > target){
                p2--;
            }else if (num[p1]+num[p2] < target){
                p1++;
            }else{ //(num[p1]+num[p2] === target)
                if(result.length === 0 || result[result.length-1][0] !== num[i] || result[result.length-1][1] !== num[p1]){
                    result.push([num[i], num[p1], num[p2]]);
                }
                p1++;
                p2--;
            }
        }
    }
    return result;
};
