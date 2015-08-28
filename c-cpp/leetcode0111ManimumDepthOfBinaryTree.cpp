/***************************************Question*****************************************
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 ****************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-08-28
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 **/
class Solution {
public:
    int minDepth(TreeNode *root) {
        if(!root){
            return 0;
        }
        if(root->left && root->right){
            return 1+min(minDepth(root->left), minDepth(root->right));
        }
        if(root->left){
            return 1+ minDepth(root->left);
        }
        if(root->right){
            return 1+ minDepth(root->right);
        }
        return 1;
    }
    int min(int a, int b){
        return a<b?a:b;
    }
};
