/*****************************Question*****************************
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * 1. All numbers (including target) will be positive integers.
 * 2. Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * 3. The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 ******************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-07
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

    void solve(vector<vector<int> > &result, vector<int> &candidates, vector<int> &list, int index, const int target){
    	int csize = candidates.size();
    	if(index >= csize){
    		return;
    	}
    	for(int i=index; i<csize; i++){
    		list.push_back(candidates[i]);
    		int iv = isValid(list, target);
    		if(iv == 1){
    			result.push_back(list);
    		}else if(iv == -1){
    			solve(result, candidates, list, i, target);
    		}
    
    		list.pop_back();
    	}
    }

    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
    	sort(candidates.begin(), candidates.end());
    	vector<vector<int> > result;
    	vector<int> list;
    	int sum=0;
    	solve(result, candidates, list, 0, target);
    	return result;
    }

};
