/************************************Question*************************************
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 *********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-10-19
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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<pair<struct TreeNode*, bool> > mystack;
        if(root == NULL){
            return result;
        }
        mystack.push(pair<struct TreeNode*, bool>(root->right, false));
        mystack.push(pair<struct TreeNode*, bool>(root->left, false));
        mystack.push(pair<struct TreeNode*, bool>(root, true));
        while(!mystack.empty()){
            pair<struct TreeNode*, bool> p = mystack.top();
            mystack.pop();
            if(p.first != NULL){
                struct TreeNode* tn = p.first;
                if(p.second){
                    result.push_back(tn->val);
                }else{
                    mystack.push(pair<struct TreeNode*, bool>(tn->right, false));
                    mystack.push(pair<struct TreeNode*, bool>(tn->left, false));
                    mystack.push(pair<struct TreeNode*, bool>(tn, true));
                }
            }
        }
        return result;
    }
};
