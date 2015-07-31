/*********************************Question*********************************
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 **************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-31
 */
class Solution {
public:
    int numDecodings(string s) {
        int len = s.length();
        if (0==len || '0'==s.at(0)) return 0;
        if (1==len) return 1;
         
        if (2==len){
            int t1 = s.at(0)-'0';
            int t2 = s.at(1)-'0';
             
            t2 += t1*10;
             
            if(10 == t2 || 20 == t2)
                return 1;
            else if(t2<=26)
                return 2;
            else if(0==t2%10)
                return 0;
            else
                return 1;
        }
     
        int *record = new int[len];
        record[0]=numDecodings(s.substr(len-1,1));
        record[1]=numDecodings(s.substr(len-2,2));
         
        for(int k=2;k<len;k++){
            string s_string = s.substr(len-k-1,k+1);
             
            int a = s_string.at(0)-'0';
            if (0==a)
                record[k]=0;
            else if (a>2)
                record[k]= record[k-1];
            else if (1==a)
                record[k]= record[k-1]+record[k-2];
            else // (2==a)
            {
                int kk = s_string.at(1)-'0';
                if(kk>6)
                    record[k]= record[k-1];
                else
                    record[k]= record[k-1]+record[k-2];
            }
        }
        int result = record[len-1];
        delete[] record;
        return result;
    }
};
