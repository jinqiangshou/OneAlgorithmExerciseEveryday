/* ******************************Question***********************************
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing all ones and return its area.
 * *************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-07-24
 * */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int h = matrix.length;
        int w = matrix[0].length;

        int[][] x = getX(matrix, h, w);
        int[][] y = getY(matrix, h, w);

        int maxArea = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int xIdx = x[i][j];
                int yIdx = y[i][j];
                int k = 0;
                while (k <= Math.min((xIdx - j), (yIdx - i)) && matrix[i + k][j + k] == '1') {
                    xIdx = Math.min(xIdx, x[i+k][j+k]);
                    yIdx = Math.min(yIdx, y[i+k][j+k]);
                    if ((xIdx - j + 1) * (yIdx - i + 1) <= maxArea) {
                        break;
                    }
                    int wArea = (k + 1) * (xIdx - j + 1);
                    int hArea = (k + 1) * (yIdx - i + 1);
                    if (wArea > maxArea) {
                        maxArea = wArea;
                    }
                    if (hArea > maxArea) {
                        maxArea = hArea;
                    }
                    k++;
                }
            }
        }
        return maxArea;
    }

    private int[][] getX(char[][] matrix, int h, int w) {
        int[][] res = new int[h][w];
        for (int i = h - 1; i >= 0; i--) {
            int curr = -1;
            for (int j = w - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    if (curr == -1) {
                        curr = j;
                    }
                } else {
                    curr = -1;
                }
                res[i][j] = curr;
            }
        }
        return res;
    }

    private int[][] getY(char[][] matrix, int h, int w) {
        int[][] res = new int[h][w];
        for (int j = w - 1; j >= 0; j--) {
            int curr = -1;
            for (int i = h - 1; i >= 0; i--) {
                if (matrix[i][j] == '1') {
                    if (curr == -1) {
                        curr = i;
                    }
                } else {
                    curr = -1;
                }
                res[i][j] = curr;
            }
        }
        return res;
    }
}
