/*************************************Question*****************************************
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 **************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-08-03
 **/
class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        int i = 0, j, k;
        int len = s.size();
        vector<string> result;
        if (len > 12 || len < 4)
            return result;
        for(i; i < len - 3; i++){
            for(j = i + 1; j < len - 2; j++){
                for(k = j + 1; k < len - 1; k++){
                    string s1 = s.substr(0, i + 1);
                    string s2 = s.substr(i + 1, j - i);
                    string s3 = s.substr(j + 1, k - j);
                    string s4 = s.substr(k + 1);
                    if(isOK(s1) && isOK(s2) && isOK(s3) && isOK(s4)){
                        string s5 = s1 + "." + s2 + "." + s3 + "." + s4;
                        result.push_back(s5);
                    }
                }
            }
        }
        return result;
    }
    
    bool isOK(string s){
        int len = s.size();
        if (len > 3 || len < 1)
            return false;
        else if (1 == len)
            return true;
        else if (2 == len){
            return ('0' != s.at(0));
        }else{ //3==len
            int a = (s.at(0) - '0') * 100 + (s.at(1) - '0') * 10 + (s.at(2) - '0');
            return (a >= 100 && a <= 255);
        }
    }
};
