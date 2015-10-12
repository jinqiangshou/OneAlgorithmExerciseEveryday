/* **************************************Question*****************************************
 * Given a string s and a dictionary of words dict, determine if s can be segmented into 
 * a space-separated sequence of one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * ***************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-10-12
 * */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean dp[] = new boolean[len];
        for(int i = 0; i < len; i++){
            dp[i] = false;
        }
        
        for(int i = 0; i < len; i++){
            for(int j = i; j >= 0; j--){
                if(i - j - 1 >= 0 && !dp[i-j-1]){
                    continue;
                }
                String t2 = s.substring(i-j, i+1);
                if(wordDict.contains(t2)){
                    dp[i] = true;
                }
            }
        }
        return dp[len-1];
    }
}
