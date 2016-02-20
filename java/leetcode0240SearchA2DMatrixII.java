/* **********************************Question**************************************
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * 
 * Given target = 20, return false.
 * ********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-02-20
 * */
public class Solution {
    
    private boolean mysearch(int [][]matrix, int target, int start_row, int end_row, int start_col, int end_col){
        if(start_row > end_row || start_col > end_col){
            return false;
        }
        if(target < matrix[start_row][start_col] || target > matrix[end_row][end_col]){
            return false;
        }
        int mid_row = (start_row + end_row)/2;
        int mid_col = (start_col + end_col)/2;
        boolean result = false;
        if(matrix[mid_row][mid_col] == target){
            return true;
        }else if(matrix[mid_row][mid_col] < target){
            result = result || mysearch(matrix, target, start_row, end_row, mid_col + 1, end_col);
            result = result || mysearch(matrix, target, mid_row + 1, end_row, start_col, mid_col);
            return result;
        }else{    
            result = result || mysearch(matrix, target, start_row, end_row,start_col, mid_col-1);
            result = result || mysearch(matrix, target, start_row, mid_row-1, mid_col, end_col);
            return result;
        }
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        return mysearch(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
    }
}
