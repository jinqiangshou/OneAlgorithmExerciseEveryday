/**************************************Question*******************************************
 * Count the number of prime numbers less than a non-negative number, n.
 *****************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-12-16
 **/
int countPrimes(int n) {
    if(n<=2){
        return 0;
    }
    
    bool *arr = (bool *)malloc(sizeof(bool)*(n+1));
    for(int i=0; i<n+1;i++){
        arr[i] = true;
    }
    int count = 0;
    int start = 2;
    while(start < n){
        if(arr[start]){
            count++;
            for(int k=1; k*start < n; k++){
                arr[k*start] = false;
            }
        }
        start++;
    }
    free(arr);
    return count;
}
