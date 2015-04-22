/* *****************************Question********************************
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * *********************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-04-22
 * */
public class Solution {
    public int removeDuplicates(int[] A) {
        int pos = 0;
        int len = A.length;
        if(len < 2){return len;}
        for(int i=1;i<len;i++){
            if(A[pos] != A[i]){
                pos++;
                A[pos] = A[i];
            }
        }
        return pos+1;
    }
}
