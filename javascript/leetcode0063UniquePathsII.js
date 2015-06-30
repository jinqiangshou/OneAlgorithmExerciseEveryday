/****************************Question*******************************
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 *******************************************************************/


/**
 * @author Horst Xu
 * @date 2015-06-30
 * @param {number[][]} obstacleGrid
 * @returns {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    if(obstacleGrid[0][0] === 1){
        return 0;
    }
    var m=obstacleGrid.length;
    var n=obstacleGrid[0].length;
    var mat=[];
    var matrow=[];
    var i,j;
    for(i=0;i<n;i++){
        matrow.push(0);
    }
    for(j=0;j<m;j++){
        mat.push(matrow.slice());
    }
    mat[0][0] = 1;
    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            if(obstacleGrid[i][j] === 1){
                mat[i][j] = 0;
            }else{
                if(i>0 && j>0){
                    mat[i][j] = mat[i-1][j]+mat[i][j-1];
                }else if(i>0){
                    mat[i][j] = mat[i-1][j];
                }else if(j>0){
                    mat[i][j] = mat[i][j-1];
                }
            }
        }
    }
    return mat[m-1][n-1];
};
