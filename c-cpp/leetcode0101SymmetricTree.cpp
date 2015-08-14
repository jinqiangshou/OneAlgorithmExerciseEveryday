/************************************Question*************************************
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *    1
 *   / \
 *  2   2
 *   \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-08-14
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
    bool isSymmetric(TreeNode *root) {
         if (!root) return true;
         
         if(!root->left && !root->right)
             return true;
             
         if(!root->left && root->right)
             return false;
         
         if(root->left && !root->right)
             return false;
             
         if(root->left->val == root->right->val)
             return symmetricTree(root->left, root->right);
         else
             return false;
     }
     
     bool symmetricTree(TreeNode *a, TreeNode *b){
         if(!a && !b)
             return true;
             
         if((!a && b) || (a && !b))
             return false;
             
         if(a->val == b->val)
             return symmetricTree(a->left, b->right) && symmetricTree(a->right, b->left);
         else
             return false;
     }
};
