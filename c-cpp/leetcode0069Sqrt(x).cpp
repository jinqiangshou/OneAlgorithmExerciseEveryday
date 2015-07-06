/*************************Question*****************************
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 **************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-06
 */
class Solution {
public:
    int mySqrt(int x) {
        if(x<=0) return 0;
        if(x==1) return 1;
        int small=0;
        int large=x;
        int temp=x/2;
        while(small<large){
            int a = x/temp;
            int b = x/(temp+1);
            if (a==temp) return a;
            if (b==temp+1) return b;
            if(temp<a && temp+1>b)
                return temp;
            else if(temp<a && temp+1<b){
                small=temp+1;
                temp = (small+large)/2;
            }else {
                large = temp;
                temp = (small+large)/2;
            }
        }
        return -1;
    }
};
