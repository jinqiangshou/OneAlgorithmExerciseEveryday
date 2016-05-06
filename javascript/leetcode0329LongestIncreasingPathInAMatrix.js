/*******************************************Question********************************************
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. 
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * 
 * Example 1:
 * nums = [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * Example 2:
 * nums = [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 ************************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-05-06
 * @param {number[][]} matrix
 * @return {number}
 **/
var longestIncreasingPath = function(matrix) {
    if(matrix.length < 1 || matrix[0].length < 1) {
        return 0;
    }

    var process = function(matrix, i, j, record, prev){
        if(i < 0 || i > matrix.length-1 || j < 0 || j > matrix[0].length-1){
            return 0;
        }
        var curr = matrix[i][j];
        if(curr < prev){
            if(record[i][j] > 0) {
                return record[i][j];
            }
            var result = arguments.callee(matrix, i, j+1, record, curr) + 1;
            result = Math.max(result, arguments.callee(matrix, i, j-1, record, curr) + 1);
            result = Math.max(result, arguments.callee(matrix, i+1, j, record, curr) + 1);
            result = Math.max(result, arguments.callee(matrix, i-1, j, record, curr) + 1);
            record[i][j] = result;
            return result;
        }
        return 0;
    };
    
    var record = [];
    var rowCount = matrix.length;
    var columnCount = matrix[0].length;
    var row = [];
    for (var i = 0; i < columnCount; i++) {
        row.push(0);
    }
    for (var j = 0; j < rowCount; j++) {
        record.push(row.slice());
    }
    var result = 1;
    for (var i = 0; i < rowCount; i++) {
        for (var j = 0; j < columnCount; j++) {
            result = Math.max(result, process(matrix, i, j, record, matrix[i][j]+1));
        }
    }
    
    return result;
};
