/***************************Question***************************
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 ***************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-08
 */
class Solution {
public:
    int isValid(vector<int> &list, int target){
    	int len = list.size();
    	int sum = 0;
    	for(int i=0;i<len;i++){
    		sum += list[i];
    	}
    	if(sum == target){
    		return 1; //exactly equal to target
    	}else if(sum > target){
    		return 0; // larger than target
    	}
    	return -1; //less than target
    }

    void solve(vector<vector<int> > &result, vector<int> &candidates, vector<int> list, int index, const int target){
    	int csize = candidates.size();
    	if(index >= csize){
    		return;
    	}
    	for(int i = index; i < csize; i++){
    		list.push_back(candidates[i]);
    		int iv = isValid(list, target);
    		if(iv == 1){
    			result.push_back(list);
    		}else if(iv == -1){
    			solve(result, candidates, list, i+1, target);
    		}
    
    		list.pop_back();
    		while(i+1<csize && candidates[i] == candidates[i+1]){
    			i++;
    		}
    	}
    }

    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
    	sort(num.begin(), num.end());
    	vector<vector<int> > result;
    	vector<int> list;
    	int sum = 0;
    	solve(result, num, list, 0, target);
    	return result;
    }

};
