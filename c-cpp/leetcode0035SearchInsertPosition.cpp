/******************************Question*******************************
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-04
 */
class Solution {
public:
    int searchInsert(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(0==n) return 0;
        if(1==n){
            if(A[0]==target) return 0;
            return A[0]>target?0:1;
        }
        
        int mid = n/2;
        if(A[mid]==target) 
            return mid;
        else if(A[mid]>target) 
            return searchInsert(A,mid,target);
        else
            return mid+searchInsert(A+mid,n-mid,target);
    }
};
