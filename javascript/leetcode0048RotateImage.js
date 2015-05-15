/*************************Question***************************
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 ************************************************************/
 
 
 /**
  * @author Horst Xu
  * @date 2015-05-16
  * @param {number[][]} matrix
  * @return {void} Do not return anything, modify matrix in-place instead.
  */
var rotate = function(matrix) {
    if(matrix.length < 2){
        return;
    }
    var len = matrix.length;
    var temp;
    for(var i=0; i < len; i++){
        for(var j=i; j < len-1-i; j++){
            temp = matrix[i][j];
            matrix[i][j] = matrix[len-1-j][i];
            matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
            matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
            matrix[j][len-1-i] = temp;
        }
    }
    return;
};
