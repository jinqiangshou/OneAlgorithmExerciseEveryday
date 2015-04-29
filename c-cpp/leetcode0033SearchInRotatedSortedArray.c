/********************************Question********************************
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. 
 * If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 ************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-29
 */
int mysearch(int A[], int start, int end, int target){
    if(start == end){
        return (A[start]==target)?start:-1;
    }else if(start > end){
        return -1;
    }else if(end-start == 1){
        if(A[start]==target) return start;
        if(A[end] == target) return end;
        return -1;
    }

    int middle = (start+end)/2;

    if(target == A[middle]) return middle;

    if(A[middle] >= A[start] && A[middle] < A[end]){
        if(target > A[middle]){
            return mysearch(A, middle, end, target);
        }else{ 
            return mysearch(A, start, middle, target);
        }
    }else if(A[middle] >= A[start] && A[middle]>=A[end]){
        if(target>A[middle] || (target<A[middle] && target<A[start])){
            return mysearch(A, middle, end, target);
        }else{ 
            return mysearch(A, start, middle, target);
        }
    }else if(A[middle] < A[start] && A[middle]>=A[end]){ // this is impossible so the program never executes this branch
        return -1; 
    }else{ // A[middle]<A[start] && A[middle] < A[end]
        if(target>A[middle] && target < A[start]){
            return mysearch(A, middle, end, target);
        }else{ 
            return mysearch(A, start, middle, target);
        }
    }
}

/**
 * @author Horst Xu
 * @date 2015-04-29
 */
int search(int A[], int n, int target) {
    if(n==0) return -1;

    if(n==1) return (A[0]==target)?0:-1;

    return mysearch(A, 0, n-1, target);

}
