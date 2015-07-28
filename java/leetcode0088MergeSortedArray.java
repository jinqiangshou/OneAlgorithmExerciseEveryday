/****************************Question*****************************
 * Given two sorted integer arrays nums1 and nums2, merge nums2 
 * into nums1 as one sorted array.
 *
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 *****************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-28
 **/
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int pB = n - 1;
        int pA = m - 1;
        for(int i = m + n - 1; i >= 0; i--){
            if( pA < 0 ){
                A[i] = B[pB];
                pB --;
                continue;
            }
            if( pB < 0 ){
                A[i] = A[pA];
                pA --;
                continue;
            }
            if(A[pA] > B[pB]){
                A[i] = A[pA];
                pA --;
            }else{
                A[i] = B[pB];
                pB --;
            }
        }
    }
}
