/*************************Question***************************
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 ************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-30
 */
class Solution {
public:
    vector<int> searchRange(int A[], int n, int target) {
        vector<int> result;
    	int maxpos = -1, minpos = -1;
    	int start = 0;
    	int end = n-1;
    
    	while(start <= end){
    		int mid = ( start + end ) / 2;
    		if(A[mid]>target){
    			end = mid-1;
    		}else if(A[mid]<target){
    			start = mid+1;
    		}else{
    			if(maxpos == -1 || mid > maxpos){
    				maxpos = mid;
    			}
    			start = mid+1;
    		}
    	}
    
    	start = 0;
    	end = n-1;
    	while(start <= end){
    		int mid = ( start + end ) / 2;
    		if(A[mid]>target){
    			end = mid-1;
    		}else if(A[mid]<target){
    			start = mid+1;
    		}else{
    			if(minpos == -1 || mid < minpos){
    				minpos = mid;
    			}
    			end = mid-1;
    		}
    	}
    
    	result.push_back(minpos);
    	result.push_back(maxpos);
    	return result;
    }
};
