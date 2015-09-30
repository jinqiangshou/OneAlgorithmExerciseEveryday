/****************************************Question**************************************
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 **************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-09-30
 **/
int candy(int ratings[], int n) {
    if(n==0){ return 0; }
	
    int total = 1;
    int current = 1;
	
    int pos = 1;
    while(pos < n){
        if(ratings[pos] > ratings[pos-1]){
            current ++;
            total += current;
            pos ++;
        }else if(ratings[pos] == ratings[pos-1]){
            current = 1;
            total += current;
            pos ++;
        }else{ //ratings[pos] < ratings[pos-1]
            int count = 0;
            while(pos < n){
                if(ratings[pos] >= ratings[pos-1]){
                    break;
                }
                pos ++;
                count ++;
            }
            if(current > count){
                total += count*(count+1)/2;
                current = 1;
            }else{
                total -= current;
                total += (count+1)*(count+2)/2;
                current = 1;
            }
        }
    }
	
    return total;
}
