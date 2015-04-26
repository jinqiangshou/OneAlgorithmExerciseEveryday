/****************Question******************
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words 
 * exactly once and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 ******************************************/


/**
 * @author Horst Xu
 * @date 2015-04-26
 */
class Solution {
public:
    vector<int> findSubstring(string S, vector<string>& L) {
        vector<int> result;
    	int lsize = L.size();
    	int ssize = S.size();
    	
    	if( lsize < 1 || ssize < 1 || L[0].size() > ssize ){
    		return result;
    	}
    	unordered_map<string, int> mp;
    	for(int i=0;i<lsize;i++){
    		if(mp.find(L[i]) != mp.end()){
    			mp[L[i]] ++;
    		}else{
    			mp[L[i]] = 1;
    		}
    	}
    	int wordsize = L[0].size();
    	unordered_map<string, int> mp2;
    	for(int i=0; i + wordsize * lsize -1 < ssize; i++){
    		mp2 = mp;
    		for(int j=0; j<lsize;j++){
    			string str = S.substr(i+j*wordsize, wordsize);
    			if(mp2.find(str)!=mp2.end()){
    				mp2[str]--;
    				if(mp2[str]==0){
    					mp2.erase(str);
    				}
    			}else{
    				break;
    			}
    		}
    		if(mp2.size() < 1){
    			result.push_back(i);
    		}
    		mp2.clear();
    	}
    	return result;
    }
};

