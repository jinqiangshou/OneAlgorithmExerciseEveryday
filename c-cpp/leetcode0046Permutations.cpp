/*********************************Question*********************************
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 **************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-14
 */
class Solution {
public:
    void mypermute(vector<vector<int> > &result, vector<int> &num, vector<int> &element){
        if(num.size() == 0 && element.size() != 0){
            result.push_back(element);
            return;
        }
    
        int len = num.size();
        for(int i=0; i<len;i++){
            int k = num[i];
            element.push_back(k);
            num.erase(num.begin()+i);
            mypermute(result, num, element);
            element.pop_back();
            num.insert(num.begin()+i, k);
        }
        return;
    }

    vector<vector<int> > permute(vector<int> &num){
        vector< vector<int> > result;
        vector<int> element;
        if(num.size() < 1){
            return result;
        }
        mypermute(result, num, element);
        return result;
    }

};
