/*********************************Question*********************************
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 **************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-15
 **/
class Solution {
public:
    void mypermuteUnique(vector<vector<int> > &result, vector<int> &num, vector<int> &element){
        if(num.size() == 0 && element.size() != 0){
            result.push_back(element);
            return;
        }

        set<int> used;
        int len = num.size();
        for(int i=0; i<len;i++){
            int k = num[i];
            if(used.find(k) != used.end()){
                continue;
            }else{
                used.insert(k);
            }
            element.push_back(k);
            num.erase(num.begin()+i);
            mypermuteUnique(result, num, element);
            element.pop_back();
            num.insert(num.begin()+i, k);
        }
        return;
    }
    
    vector<vector<int> > permuteUnique(vector<int> &num){
        vector< vector<int> > result;
        vector<int> element;
        if(num.size() < 1){
    		    return result;
        }
        mypermuteUnique(result, num, element);
        return result;
    }

};
