/********************************Question********************************
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 *************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-08-03
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<pair<struct TreeNode*, bool> > mystack;
        if(root == NULL){
            return result;
        }
        mystack.push(pair<struct TreeNode*, bool>(root->right, false));
        mystack.push(pair<struct TreeNode*, bool>(root, true));
        mystack.push(pair<struct TreeNode*, bool>(root->left, false));
        while(!mystack.empty()){
            pair<struct TreeNode*, bool> p = mystack.top();
            mystack.pop();
            if(p.first != NULL){
                struct TreeNode* tn = p.first;
                if(p.second){
                    result.push_back(tn->val);
                }else{
                    mystack.push(pair<struct TreeNode*, bool>(tn->right, false));
                    mystack.push(pair<struct TreeNode*, bool>(tn, true));
                    mystack.push(pair<struct TreeNode*, bool>(tn->left, false));
                }
            }
        }
        return result;
    }
};
