/************************************Question************************************
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 ********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-27
 */
void mysort(int num[], int start, int end){
	for(int i=end; i>=start; i--){
		for(int j=start; j<i; j++){
			if(num[j]>num[j+1]){
				int temp = num[j];
				num[j] = num[j+1];
				num[j+1] = temp;
			}
		}
	}
}

/**
 * @author Horst Xu
 * @date 2015-04-27
 */
void nextPermutation(int num[], int n) {
	if( n < 2 ){ return; }

	int pos = -1;
	for(int i=n-2; i>=0;i--){
		if(num[i]<num[i+1]){
			pos = i;
			break;
		}
	}
	if(pos == -1){
		for(int i=0; i< (n/2); i++){
			int temp = num[i];
			num[i] = num[n-1-i];
			num[n-1-i] = temp;
		}
		return;
	}

	int pos2 = 0;
	for(int i=n-1;i>pos;i--){
		if(num[i]>num[pos]){
			pos2 = i;
			break;
		}
	}

	int temp2 = num[pos];
	num[pos] = num[pos2];
	num[pos2] = temp2;

	mysort(num, pos+1, n-1);
	return;
}
