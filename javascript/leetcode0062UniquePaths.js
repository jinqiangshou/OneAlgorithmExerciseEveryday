/******************************Question********************************
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * -------------------------------------------
 * |start|     |     |     |     |     |     |
 * -------------------------------------------
 * |     |     |     |     |     |     |     |
 * -------------------------------------------
 * |     |     |     |     |     |     | end |
 * -------------------------------------------
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * Note: m and n will be at most 100.
 ***********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-06-23
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    if(m===1 || n ===1){
        return 1;
    }
    var i, j;
    var mat=[];
    var matrow=[1];
    for(j=1;j<n;j++){
        matrow.push(0);
    }
    for(i=0;i<m;i++){
        mat.push(matrow);
    }
    for(j=0;j<n;j++){
        mat[0][j] = 1;
    }
    for(i=1;i<m;i++){
        for(j=1;j<n;j++){
            mat[i][j] = mat[i-1][j]+mat[i][j-1];
        }
    }
    return mat[m-1][n-1];
};
