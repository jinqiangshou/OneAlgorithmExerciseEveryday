/* ****************************************Question******************************************
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * ******************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-09-25
 * */
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length(); 
        boolean [][]mp = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || mp[i + 1][j - 1])) {
                    mp[i][j] = true;
                }else{
                    mp[i][j] = false;
                }
            }
        }
        
        int[] res = new int[len];
        
        for (int j = 0; j < len; j++) {
            int value = j;
            for (int i = 0; i <= j; i++) {
                if(mp[i][j]){
                    value = Math.min(value, (i > 0)?(res[i - 1] + 1) : 0);
                }
            }
            res[j] = value;
        }
        return res[len - 1];
    }
}
