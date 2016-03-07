/********************************Question************************************
 * Given an array of citations (each citation is a non-negative integer) of a researcher, 
 * write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: 
 * "A scientist has index h if h of his/her N papers have at least h citations each, 
 * and the other N − h papers have no more than h citations each."
 * 
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total 
 * and each of them had received 3, 0, 6, 1, 5 citations respectively. 
 * Since the researcher has 3 papers with at least 3 citations each 
 * and the remaining two with no more than 3 citations each, his h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 * Hint:
 * 
 * An easy approach is to sort the array first.
 * What are the possible values of h-index?
 * A faster approach is to use extra space.
 *****************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-07
 **/
int hIndex(int* citations, int citationsSize) {
    int *arr = (int *)calloc(citationsSize+1, sizeof(int));
    for(int i = 0; i < citationsSize; i++){
        if(citations[i] > citationsSize){
            arr[citationsSize] ++; 
        }else if(citations[i] >= 0){ 
            arr[citations[i]] ++; 
        }else{
            arr[0] ++; 
        }   
    }   
    int rec = 0;
    for(int j = citationsSize; j >=0; j--){
        rec += arr[j];
        if(rec >= j){ 
            free(arr);
            return j;
        }   
    }   
    free(arr);
    return 0;
}
