/***************************Question*******************************
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 ******************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-18
 **/
class Solution {
public:
    bool isValid(string str){
    	int len = str.length();
    	int i=0;
    	int count = 0;
    	while(i<len){
    		if(str.at(i) == ')'){
    			count--;
    		}else if(str.at(i) == '('){
    			count++;
    		}else {
    			return false;
    		}
    		if(count<0){
    			return false;
    		}
    		i++;
    	}
    	return (count>=0);
    }
    
    void backtracking(int i, int n, vector<string> &result, string str, int pos){
    	if(i>n){
    		string *s = new string(str.c_str());
    		result.push_back(*s);
    	}else{
    		for(int k=pos+1;k<str.length();k++){
    			str[k]=')';
    			if(isValid(str)){
    				backtracking(i+1, n, result, str, k);
    			}	
    			str[k]='(';
    		}
    	}
    }

    vector<string> generateParenthesis(int n) {
        vector<string> result;
	    string *str = new string(2*n, '(');
	    backtracking(1, n, result, *str, -1);
	    return result;
    }
};

