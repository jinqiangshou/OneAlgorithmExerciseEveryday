/********************************Question********************************
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. 
 * It doesn't matter what you leave beyond the new length.
 ************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-23
 **/
class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        int len=n-1;
        int i=0;
        while(i<=len){
            if(A[i]==elem){
                A[i]=A[len];
                len--;
            }else{
                i++;
            }
        }
        return len+1;
    }
};
