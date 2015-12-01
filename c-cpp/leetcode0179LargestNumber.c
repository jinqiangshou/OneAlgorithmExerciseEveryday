/***********************************Question***********************************
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 ******************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-12-01
 **/
int mycompare(int a, int b){ 
    char astr[40];
    char bstr[40];
    
    snprintf(astr, sizeof(astr), "%d%d", a, b); 
    snprintf(bstr, sizeof(bstr), "%d%d", b, a); 
    int i=0;
    while(astr[i] != '\0' && bstr[i] != '\0'){
        if(astr[i] - bstr[i] > 0){
            return a;
        }else if(astr[i] - bstr[i] < 0){
            return b;
        }   
        i++;
    }   
    return a;
}

/**
 * @author Horst Xu
 * @date 2015-12-01
 **/
char* largestNumber(int *nums, int numsSize){
    for(int i = 0; i < numsSize; i++){
        for(int k = numsSize - 1; k >= i; k--){
            if(mycompare(nums[k], nums[k-1]) == nums[k-1]){
                int temp = nums[k];
                nums[k] = nums[k-1];
                nums[k-1] = temp;
            }   
        }   
    }   
    char *result =(char *)malloc(sizeof(char) * 20 * numsSize);
    memset(result, 0, sizeof(result));
    
    char str[20];
    for(int i = numsSize - 1; i >= 0; i--){
        if(strlen(result) == 0 && nums[i]==0){
            continue;
        }
        snprintf(str, sizeof(str), "%d", nums[i]);
        strncat(result, str, strlen(str));
    }
    if(strlen(result) == 0){
        result[0] = '0';
    }
    return result;
}
