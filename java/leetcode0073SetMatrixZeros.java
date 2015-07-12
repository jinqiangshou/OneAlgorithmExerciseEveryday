/* ****************************Question*********************************
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * *********************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-07-12
 * */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean firstColumnZeros = false;
        boolean firstRowZeros = false;
        for(int i=0; i<row; i++){
            if(matrix[i][0] == 0){
                firstColumnZeros = true;
                break;
            }
        }
        for(int i=0; i<column;i++){
            if(matrix[0][i] == 0){
                firstRowZeros = true;
                break;
            }
        }
        for(int i=1; i<row;i++){
            for(int j=1; j<column; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1; i<row; i++){
            if(matrix[i][0] == 0){
                for(int j=0; j<column; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j=1; j<column; j++){
            if(matrix[0][j] == 0){
                for(int i=0; i<row; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstColumnZeros){
            for(int i=0;i<row; i++){
                matrix[i][0] = 0;
            }
        }
        if(firstRowZeros){
            for(int j=0; j<column; j++){
                matrix[0][j] = 0;
            }
        }
    }
}
