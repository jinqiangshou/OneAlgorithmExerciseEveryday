/******************Question*********************
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 ***********************************************/


/**
 * @author Horst Xu
 * @date 2015-04-25
 */
class Solution {
public:
    int divide(int dividend, int divisor) {
        int isDiffSign = 0;
    	int temp = (dividend ^ divisor);
    	if(temp < 0){
    		isDiffSign = 1;
    	}
    
    	if(divisor == 0){
    		return INT_MAX;
    	}else if(dividend == INT_MIN && divisor == -1){
    		return INT_MAX;
    	}
    
     	int result = 0;
        long long dnd = abs((long long)dividend);
    	long long dor = abs((long long)divisor);
        long long record = 0;
     
        while(dor <= dnd){
            int count = 1;
            record = dor;
            while( (record << 1) <= dnd ){
    			record <<= 1;
                count <<= 1;
            }
            result += count;
            dnd -= record;
        }
     
        if(isDiffSign){
    		return (0 - result);
    	}
    	return result;
    }
};

