/* *****************************************Question**********************************************
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 * ***********************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-01-14
 * */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int [][]dp = new int[matrix.length+1][matrix[0].length+1];
        int width = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    width = Math.max(width, dp[i][j]);
                    continue;
                }
                if(matrix[i-1][j-1] == '0'){
                    dp[i][j] = 0;
                }else{
                    int value1 = (j > 0)?(dp[i][j-1]):(Integer.MAX_VALUE);
                    int value2 = (i > 0)?(dp[i-1][j]):(Integer.MAX_VALUE);
                    int value3 = (i > 0 && j > 0)?(dp[i-1][j-1]):(Integer.MAX_VALUE);
                    dp[i][j] = 1 + Math.min(value1, Math.min(value2, value3));
                    width = Math.max(width, dp[i][j]);
                }
            }
        }
        return width * width;
    }
}
