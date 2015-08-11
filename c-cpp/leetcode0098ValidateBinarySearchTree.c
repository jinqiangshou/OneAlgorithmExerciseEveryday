/**************************************Question************************************
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 **********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-08-11
 **/
bool myIsValidBST(struct TreeNode* root, int max, int min, bool flagmax, bool flagmin){
    if(root == NULL) return true;
    
    if((!flagmax && root->val >= max) || (!flagmin && root->val <= min)){
        return false;
    }
    if(root->left != NULL){
        if(root->left->val >= root->val){
            return false;
        }
    }
    if(root->right != NULL){
        if(root->right->val <= root->val){
            return false;
        }
    }
    
    bool result =  myIsValidBST(root->left, root->val, min, false, flagmin);
    if(result == false){return false;}
    result =  myIsValidBST(root->right, max, root->val, flagmax, false);
    return result;
}

/**
 * @author Horst Xu
 * @date 2015-08-11
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool isValidBST(struct TreeNode* root) {
    return myIsValidBST(root, INT_MAX, INT_MIN, true, true);
}
