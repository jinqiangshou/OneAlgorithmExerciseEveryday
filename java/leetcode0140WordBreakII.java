/* *******************************Question**********************************
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * *************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-10-13
 * */
public class Solution {
    public void myWordBreak(String s, Set<String> wordDict, List<String> result, StringBuilder sb, int pos){
        int slen = s.length();
        if(pos >= slen){
            result.add(sb.toString().trim());
            return;
        }
        
        for(int i = pos; i < slen; i++){
            String str = s.substring(pos, i + 1);
            if(wordDict.contains(str)){
                sb.append(" ");
                sb.append(str);
                myWordBreak(s, wordDict, result, sb, i + 1);
                int len = sb.length();
                sb.delete(len-(i + 1 - pos)-1, len);
            }
        }
        
    }
    
    public boolean isBreakable(String s, Set<String> wordDict) {
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
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new LinkedList<String>();
        
        if(isBreakable(s, wordDict)){
            StringBuilder sb = new StringBuilder();
            myWordBreak(s, wordDict, result, sb, 0);
        }
        return result;
    }
}
