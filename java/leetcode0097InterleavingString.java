/* *********************************Question**********************************
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * ***************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-08-07
 * */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len3 != len1+len2){
            return false;
        }
        boolean[][] mat = new boolean[len1+1][];
        for(int i=0; i<len1+1;i++){
            mat[i] = new boolean[len2+1];
        }
        
        mat[0][0] = true;
        for(int i=0; i<=len1; i++){
            for(int j=0;j<=len2;j++){
                if(j==0 && i==0){
                    continue;
                }
                mat[i][j] = false;
                if(j != 0){ //不是第一列
                    if(mat[i][j-1] == false){
                        mat[i][j] = false;
                    }else{
                        mat[i][j] = (s2.charAt(j-1)==s3.charAt(i+j-1));
                    }
                }
                if(i != 0 && mat[i][j] == false){ //不是第一行
                    if(mat[i-1][j] == false){
                        mat[i][j]= false;
                    }else{
                        mat[i][j] = (s1.charAt(i-1)==s3.charAt(i+j-1));
                    }
                }
            }
        }
        return mat[len1][len2];
    }
}
