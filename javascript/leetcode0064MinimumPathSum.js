/******************************Question********************************
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 **********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-06-30
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    var m=grid.length;
    var n=grid[0].length;
    var mat=[];
    var matrow=[];
    var i,j;
    for(i=0;i<n;i++){
        matrow.push(0);
    }
    for(j=0;j<m;j++){
        mat.push(matrow.slice());
    }
    var result = grid[0][0];
    mat[0][0]=grid[0][0];
    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            if(i>0 && j>0){
                mat[i][j] = grid[i][j]+((mat[i][j-1]<mat[i-1][j])?(mat[i][j-1]):(mat[i-1][j]));
            }else if(i>0){
                mat[i][j] = grid[i][j]+mat[i-1][j];
            }else if(j>0){
                mat[i][j] = grid[i][j]+mat[i][j-1];
            }
        }
    }
    return mat[m-1][n-1];
};
