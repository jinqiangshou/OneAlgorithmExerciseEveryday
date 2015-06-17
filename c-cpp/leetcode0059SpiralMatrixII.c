/*****************************Question*******************************
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 ********************************************************************/
 

/**
 * @author Horst Xu
 * @date 2015-06-17
 **/
int **generateMatrix(int n) {
    if(n==0){return NULL;}

    int **result = (int **)malloc(n*sizeof(int *));
    for(int i=0;i<n;i++){
        result[i] = (int *)malloc(n*sizeof(int));
    }

    int uB = 0; //upper bound
    int bB = n-1; //bottom bound
    int lB = 0; //left bound
    int rB = n-1; //right bound
    char direction = 'r';

    int count = 1;
    int pos=0;
    while(count<=n*n){
        switch(direction){
            case 'r': //right
                result[uB][pos]=count;
                if(pos<rB){
                    pos++;
                }else{
                    direction = 'd';
                    uB++;
                    pos=uB;
                }
                break;
            case 'd': //down
                result[pos][rB] = count;
                if(pos<bB){
                    pos++;
                }else{
                    direction = 'l';
                    rB--;
                    pos= rB;
                }
                break;
            case 'l': //left
                result[bB][pos] = count;
                if(pos>lB){
                    pos--;
                }else{
                    direction = 'u';
                    bB--;
                    pos = bB;
                }
                break;
            case 'u': //up
                result[pos][lB] = count;
                if(pos>uB){
                    pos--;
                }else{
                    direction = 'r';
                    lB++;
                    pos = lB;
                }
        }
        count++;
    }
    return result;
}
