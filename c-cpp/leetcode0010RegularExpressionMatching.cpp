/*******************************Question***********************************
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 **************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-08
 **/
class Solution {
public:
    bool isMatch(const char *s, const char *p) {
      int plen = strlen(p);
    	int slen = strlen(s);
    	if(plen == 0){
    	  return (slen == 0);
    	}
    	if(plen == 1){
    		return (slen == 1 && (s[0] == p[0] || p[0]=='.'));
    	}
    
    	bool **dp = new bool*[slen+1];
    	for(int i=0;i<slen+1; i++){
    		dp[i] = new bool[plen+1];
    	}
    
    	for(int i=0;i<slen+1;i++){
    		for(int j=0;j<plen+1; j++){
    			dp[i][j] = false;
    		}
    	}
    	dp[0][0] = true;
    
    	//initialize the base case slen=0
    	for(int j=0;j<plen-1; j+=2){
    		if(dp[0][j] && p[j+1] == '*'){
    			dp[0][j+2] = true;
    		}
    	}
    
    	//complete dp matrix by looping
    	for(int i=1; i<slen+1;i++){
    		for(int j=1; j<plen+1;j++){
    			if(s[i-1]==p[j-1] || p[j-1]=='.'){
    				dp[i][j]=dp[i-1][j-1];
    				continue;
    			}
    			if(p[j-1]=='*'){
    				if(j>1 && dp[i][j-2]){
    					dp[i][j] = true;
    				}else if(j>1 && dp[i-1][j] && (s[i-1]==p[j-2] || p[j-2]=='.')){
    					dp[i][j] = true;
    				}else if(j==1){
    					dp[slen][plen] = (s[0]=='*' && slen==1);
    					i = slen+1; //set i to be a large value so that we jump out of two loops with a single break
    					break;
    				}
    			}
    		}
    	}
    
    	bool result = dp[slen][plen];
    	
    	//free memory
    	for(int i=0;i<slen+1; i++){
    		delete [](dp[i]);
    	}
    	delete []dp;
    
    	return result;
    }
};
