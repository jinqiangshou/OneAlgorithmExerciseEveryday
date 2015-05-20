/*************************Question****************************
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 **************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-20
 **/
var isValid = function(arr, i, j){
    var len = arr.length;
    for(var t=0; t<len; t++){
        if(arr[t] !== -1 && Math.abs(arr[t]-j) === Math.abs(t-i))
            return false;
        if(arr[t] !== -1 && arr[t] === j)
            return false;
    }
    return true;
};

/**
 * @author Horst Xu
 * @date 2015-05-20
 **/
var mysolution = function(n, start, arr, result){
    if(start >= n){
        var myarr = arr.slice();
        result.push(myarr);
        return;
    }
    for(var j=0; j<n; j++){   
        if(isValid(arr,start,j)){
            arr[start]= j;
            mysolution(n, start+1, arr, result);
            arr[start] = -1;
        } 
    }
};

/**
 * @author Horst Xu
 * @date 2015-05-20
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    var result = [];
    var retValue = new Array(result.length);
    if(n === 1){
        var retstr = "Q";
        var row1 = [];
        row1.push(retstr);
        retValue.push(row1);
        return retValue;
    }
    
    var arr = new Array(n);
    var i;
    for(i=0;i<n;i++){
        arr[i] = -1;
    }
   
    mysolution(n, 0, arr, result);
    
    for(i=0; i<result.length;i++){
        var row = [];
        for(var j=0; j<n; j++){
            var str = "";
            for(var k=0; k<n; k++){
                if(k === result[i][j]){
                    str += "Q";
                }else{
                    str += ".";
                }
            }
            row.push(str);
        }
        retValue.push(row);
    }
    return retValue;
};
