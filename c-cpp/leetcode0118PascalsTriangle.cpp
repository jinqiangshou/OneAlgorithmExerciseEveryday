/***********************************Question*************************************
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 ********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-09-08
 **/
class Solution {
public:
    vector<vector<int> > generate(int numRows) {
        if(0 == numRows){
            vector<vector<int> > result;
            return result;
        }
        vector<vector<int> > result(numRows);
        vector<int> first(1,1);
        result[0] = first;
        for(int i=1;i<numRows;i++){
            result[i] = nextTriangle(result[i-1]);
        }
        return result;
    }
    
    vector<int> nextTriangle(vector<int> a){
        int k = a.size();
        vector<int> next(k+1);
        for(int i=0;i<k+1;i++){
            if(0==i){
                next[i] = a[i];
                continue;
            }
            if(k==i){
                next[i] = a[k-1];
                continue;
            }
            next[i] = a[i-1]+a[i];
        }
        return next;
    }
};
