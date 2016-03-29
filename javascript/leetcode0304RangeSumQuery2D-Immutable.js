/*****************************************Question********************************************
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined 
 * by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 **********************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-29
 * @constructor
 * @param {number[][]} matrix
 **/
var NumMatrix = function(matrix) {
    this.sumMat = [];
    var row = matrix.length;
    if(row === 0){
        return;
    }
    var col = matrix[0].length;

    var tempSum = [];
    var sum = 0;
    var i;
    for(i = 0; i < col; i++){
        sum += matrix[0][i];
        tempSum.push(sum);
    }

    this.sumMat.push(tempSum);
    for(i = 1; i < row; i++){
        tempSum = [];
        sum = 0;
        for(var j = 0; j < col; j++){
            sum += matrix[i][j];
            tempSum.push(sum + this.sumMat[i-1][j]);
        }
        this.sumMat.push(tempSum);
    }
};

/**
 * @param {number} row1
 * @param {number} col1
 * @param {number} row2
 * @param {number} col2
 * @return {number}
 */
NumMatrix.prototype.sumRegion = function(row1, col1, row2, col2) {
    var result = this.sumMat[row2][col2];
    result -= ((row1 > 0)?(this.sumMat[row1-1][col2]):0);
    result += ((row1 > 0 && col1 > 0)?(this.sumMat[row1-1][col1-1]):0);
    result -= ((col1 > 0)?(this.sumMat[row2][col1-1]):0);
    return result;  
};


/**
 * Your NumMatrix object will be instantiated and called as such:
 * var numMatrix = new NumMatrix(matrix);
 * numMatrix.sumRegion(0, 1, 2, 3);
 * numMatrix.sumRegion(1, 2, 3, 4);
 */
