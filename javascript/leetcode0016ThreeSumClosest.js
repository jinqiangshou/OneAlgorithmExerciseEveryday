/****************************Question**********************************
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 **********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-13
 * @param {number[]} num
 * @param {number} target
 * @returns {number}
 */
var threeSumClosest = function (num, target) {
    num.sort(function(a,b){return (a-b);});
    var len = num.length;
    if(len<3){return null;}
    
    var diff = num[0]+num[1]+num[2] - target;
    
    for(var i=0; i<num.length-2; i++){
        if(i>0 && num[i]===num[i-1]){
            continue;
        }
        var p1=i+1;
        var p2=num.length-1;
        while(p1<p2){
            var temp = num[i]+num[p1]+num[p2]-target;
            if(temp === 0){return target;}
            
            if(Math.abs(temp) < Math.abs(diff)){
                diff = num[i]+num[p1]+num[p2]-target;
            }
            if(temp > 0){
                p2--;
            }else if(temp < 0){
                p1++;
            }
        }
    }
    return diff+target;
};
