/****************************************Question*********************************************
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *********************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-01-28
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 **/
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        stack<TreeNode *> st;
        TreeNode * tn = root;
        while(true){
            while(tn != NULL){
                st.push(tn);
                tn = tn->left;
            }
            tn = st.top();
            st.pop();
            k--;
            if(k == 0){
                return tn->val;
            }
            tn = tn->right;
        }
    }
};
