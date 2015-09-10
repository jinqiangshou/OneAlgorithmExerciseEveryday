/**********************************Question*************************************
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, 
 * where n is the total number of rows in the triangle.
 *******************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-09-10
 **/
int minimumTotal(int **triangle, int numRows) {
    if(numRows < 1){
        return 0;
    }else if(numRows < 2){
        return triangle[0][0];
    }
    
    int *mat = (int *)malloc(numRows*sizeof(int));
    mat[0] = triangle[0][0];
    
    for(int i=1;i<numRows;i++){
        for(int j=i;j>=0;j--){
            if(j==i){
                mat[j] = mat[j-1]+triangle[i][j];
                continue;
            }else if(j==0){
                mat[j] = mat[j]+triangle[i][j];
                continue;
            }
            int sum1 = mat[j] + triangle[i][j];
            int sum2 = mat[j-1] + triangle[i][j];
            if(sum2 < sum1){
                mat[j] = sum2;
            }else {
                mat[j] = sum1;
            }
        }
    }
    int result = mat[0];
    for(int i=0;i<numRows;i++){
        if(mat[i] < result){
            result = mat[i];
        }
    }
    free(mat);
    return result;
}
