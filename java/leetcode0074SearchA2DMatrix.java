/* ****************************Question*****************************
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * *****************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-07-13
 * */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        int endRow = matrix.length-1;
        int targetRow = -1;
        int startCol = 0;
        int endCol = matrix[0].length-1;
        
        while(startRow<endRow){
            if(target>=matrix[endRow][0]){
                targetRow = endRow;
                break;
            }else if(target < matrix[startRow][0]){
                return false;
            }
            int midRow = (startRow+endRow)/2;
            if(target<matrix[midRow][0]){
                endRow = midRow-1;
            }else if(target>=matrix[midRow][0] && target<matrix[midRow+1][0]){
                targetRow = midRow;
                break;
            }else{
                startRow = midRow+1;
            }
        }
        if(startRow == endRow){
            targetRow = startRow;
        }
        while(startCol <= endCol){
            if(startCol==endCol){
                return matrix[targetRow][startCol] == target;
            }
            int midCol = (startCol + endCol)/2;
            if(target<matrix[targetRow][midCol]){
                endCol = midCol-1;
            }else if(target>matrix[targetRow][midCol]){
                startCol = midCol+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
