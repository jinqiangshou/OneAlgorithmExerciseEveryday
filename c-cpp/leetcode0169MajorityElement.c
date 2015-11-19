/****************************************Question*****************************************
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *****************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-11-19
 **/
int majorityElement(int num[], int n) {
    int half = n / 2;
    int count = 1;
    int number = num[0];
    for(int i=1; i<n; i++){
        if(count <= 0){
            count = 1;
            number = num[i];
            continue;
        }
        if(num[i] == number){
            count++;
            if(count > half){
                return number;
            }
        }else{
            count--;
        }
    }
    return number;
}
