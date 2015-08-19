/*************************************Question**************************************
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 ***********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-08-19
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int maxDepth(struct TreeNode* root) {
    if(!root) return 0;
        
    return 1+max(maxDepth(root->left), maxDepth(root->right));
}

int max(int a, int b){
    return a>b?a:b;
}
