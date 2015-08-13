/****************************Question******************************
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 ******************************************************************/


/**
 * @author Horst Xu
 * @date 2015-08-13
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
 public:
     bool isSameTree(TreeNode *p, TreeNode *q) {
         if (NULL == p && NULL == q) return true;
         
         if (NULL != p && NULL == q) return false;
         
         if (NULL != q && NULL == p) return false;
         
         if (p->val == q-> val)
             return (isSameTree(p->left, q->left) && isSameTree(p->right, q->right));
         else
             return false;
     }
 };
