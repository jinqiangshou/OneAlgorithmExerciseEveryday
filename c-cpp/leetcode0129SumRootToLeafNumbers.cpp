/*************************************Question**********************************
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 ********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-09-22
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
    int sumNumbers(TreeNode* root) {
        if (root == NULL){
            return 0;
        }
        stack<pair<struct TreeNode*, int> > mystack;
        mystack.push(pair<struct TreeNode*, int>(root, 0));
        int result = 0;
        while(!mystack.empty()){
            pair<struct TreeNode*, int> p = mystack.top();
            struct TreeNode* tn = p.first;
            int value = p.second;
            mystack.pop();
            if(tn->left == NULL && tn->right == NULL){
                result += value*10 + tn->val;
            }
            if(tn->right != NULL){
                mystack.push(pair<struct TreeNode*, int>(tn->right, value*10 + tn->val));
            }
            if(tn->left != NULL){
                mystack.push(pair<struct TreeNode*, int>(tn->left, value*10 + tn->val));
            }
        }
        return result;
    }
};
