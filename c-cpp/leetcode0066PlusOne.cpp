/**********************************Question**************************************
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 ********************************************************************************/
 
/**
 * @author Horst Xu
 * @date 2015-07-02
 */
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        bool allNine = true;    
        int size = digits.size();
         
        for(int i = 0; i< size; i++){
            if(digits[i] != 9){
                allNine = false;
                break;
            }
        }
         
        if(allNine){
            vector<int> result(1+size, 0);
            result[0] = 1;
            return result;
        }
         
        vector<int> result(size);
         
        for(int i=0;i<size;i++){
            result[i]=digits[i];
        }
         
        result[size-1] += 1;
        int k = size-1;
         
        while(10==result[k]){
            result[k] = 0;
            k--;
            result[k]++;
        }
         
        return result;
    }
};
