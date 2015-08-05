/*********************************Question********************************
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 **************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-08-05
 **/
class Solution {
public:
    int numTrees(int n) {
        if(n<=1)
            return 1;
        int *rec = new int[n+1];
        for(int k = 0; k < n+1; k++){
            rec[k] = 0;
        }
        rec[0] = 1;
        rec[1] = 1;
        
        for(int i=2;i<=n;i++){
            for(int j=0; j<i; j++){
                rec[i] += rec[i-1-j] * rec[j];
            }
        }
        int result = rec[n];
        delete[] rec;
        return result;
    }
};
