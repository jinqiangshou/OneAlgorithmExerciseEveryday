/*************************************Question****************************************
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 *************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-11-12
 **/
class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        bool isNegative = (numerator ^ denominator) < 0;
        unsigned long long n1 = abs((long long)numerator);
        unsigned long long n2 = abs((long long)denominator);
        queue<int> q;
        map<int, int> mp;
        
        if(n1 < n2){
            q.push(0);
        }else{
            q.push(n1 / n2);
            n1 = n1 % n2;
        }
        int k = 0;
        while(n1 != 0){
            k++;
            n1 *= 10;
            map<int, int>::iterator it = mp.find(n1);
            if(it != mp.end()){
                k = it->second;
                break;
            }else{
                mp.insert(pair<int, int>(n1, k));
            }
            q.push(n1 / n2);
            n1 = n1 % n2;
        }
        int len = q.size();
        char *temp = new char[len + 128];
        int pos = 0;
        if(isNegative){
            temp[pos] = '-';
            pos++;
        }
        pos += sprintf(temp+pos, "%u", q.front());
        q.pop();
        if(!q.empty()){
            pos += sprintf(temp+pos, "%c", '.');
        }
        if(n1 == 0){ //除尽了
            while(!q.empty()){
                pos += sprintf(temp+pos, "%d", q.front());
                q.pop();
            }
        }else{ //没除尽
            for(int j = 1; j < k; j++){
                pos += sprintf(temp+pos, "%d", q.front());
                q.pop();
            }
            pos += sprintf(temp+pos, "%c", '(');
            while (!q.empty()){
                pos += sprintf(temp+pos, "%d", q.front());
                q.pop();
            }
            pos += sprintf(temp+pos, "%c", ')');
        }
        temp[pos] = '\0';
        string result(temp);
        return result;
    }
};
