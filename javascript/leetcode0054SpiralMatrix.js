/***********************Question**************************
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 *
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 *********************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-24
 * @param {number[][]} matrix
 * @return {number[]
 */
var spiralOrder = function(matrix) {
    var result = [];
    var row = matrix.length;
    if(row === 0){
        return result;
    }
    var column = matrix[0].length;
    if(column === 0){
        return result;
    }
    var rEnd = column-1;
    var dEnd = row-1;
    var lEnd = 0;
    var uEnd = 0;
    var direction = 'r';
    var i=0, j=0;
    var count = 0;
    while(count< column*row){
        switch(direction){
            case 'r':
                for(j=lEnd; j<= rEnd; j++){
                    result.push(matrix[uEnd][j]);
                    count++;
                }
                direction = 'd';
                uEnd++;
                break;
            case 'd':
                for(i=uEnd; i<=dEnd; i++){
                    result.push(matrix[i][rEnd]);
                    count++;
                }
                direction = 'l';
                rEnd --; 
                break;
            case 'l':
                for(j=rEnd; j>=lEnd; j--){
                    result.push(matrix[dEnd][j]);
                    count++;
                }
                direction = 'u';
                dEnd--;
                break;
            case 'u':
                for(i=dEnd; i>=uEnd; i--){
                    result.push(matrix[i][lEnd]);
                    count++;
                }
                direction = 'r';
                lEnd++;
                break;
        }
    }
    return result;
};
