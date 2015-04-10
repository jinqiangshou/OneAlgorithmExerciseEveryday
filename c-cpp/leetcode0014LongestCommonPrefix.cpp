/***********************Question************************
 * Write a function to find the longest common prefix string amongst an array of strings.
 *******************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-11
 **/
class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        int len = strs.size();
    	string result = "";
    	if(len == 0){
    		return result;
    	}
    	if(len == 1){
    		result = strs[0];
    		return result;
    	}
    
    	result = strs[0];
    	int templen;
    	vector<string>::iterator it;
    	for(it=strs.begin()+1; it!= strs.end();it++)
    	{
    		templen =  ((*it).size()<result.size())?((*it).size()):(result.size());
    		int i=0;
    		for(; i<templen;i++){
    			if(result.at(i) != (*it).at(i)){
    				break;
    			}
    		}
    		result = result.substr(0, i);
    	}
    	return result;
    }
};
