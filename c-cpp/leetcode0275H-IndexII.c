/*************************************Question******************************************
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 * 
 * Hint:
 * Expected runtime complexity is in O(log n) and the input is sorted.
 ***************************************************************************************/

/**
 * @author Horst Xu
 * @date 2016-03-08
 **/
int hIndex(int* citations, int citationsSize) {
    if (citationsSize == 0){
        return 0;
    }
    int start = 0;
    int end = 1 + ((citationsSize < citations[citationsSize-1])?citationsSize: citations[citationsSize-1]);
    while (start < end) {
        int mid = start + (end - start) / 2;
        if (citations[citationsSize - mid] == mid || start == mid){
            return mid;
        }else if (citations[citationsSize - mid] > mid){
            start = mid; 
        }else{ 
            end = mid;                             
        }
    }
    return start;
}
