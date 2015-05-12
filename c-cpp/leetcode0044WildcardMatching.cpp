/*************************************Question*************************************
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 **********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-12
 **/
class Solution {
public:
  bool isMatch(string s, string p) {
    int plen = p.length();
    int slen = s.length();
    
    int count = 0;
    for(int i=0; i<plen;i++){
      if(p[i] =='*') count++;
    }
    if(plen-count > slen){
      return false;
    }
    if(slen == 0 && plen == 0){
      return true;
    }else if(slen == 0){
      if(count != plen){
        return false;
      }
      return true;
    }else if(plen == 0){
      return false;
    }
    
    bool *dp = new bool[slen+1];
    
    dp[0] = true;
    for(int i=1; i<slen+1;i++){
      dp[i] = false;
    }
    	
    for(int i=0; i< plen; i++){
      if(p[i] == '*'){
        for(int j = 0; j < slen; j++){
          dp[j+1] = (dp[j] || dp[j+1]);
        }
      }else{
        for(int j=slen-1; j>=0; j--){
          dp[j+1] = (p[i] == '?' || p[i] == s[j]) && dp[j];
        }
        dp[0] = false;
      }
    }
  
    bool result = dp[slen];
  
    delete []dp;
  
    return result;
  }
};
