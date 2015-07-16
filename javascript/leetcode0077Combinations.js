/**********************************Question************************************
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 ******************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-16
 */
var mycombine = function(n, k, start, count, row, result){
    if(count===k){
        result.push(row.slice());
        return;
    }
    if(start>n){
        return;
    }
    for(var i=start; i<=n; i++){
        row.push(i);
        mycombine(n, k, i+1, count+1, row, result);
        row.pop();
    }
};
    
/**
 * @author Horst Xu
 * @date 2015-07-16
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    var result = [];
    mycombine(n,k,1,0,[], result);
    return result;
};
