/************************************Question**************************************
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 **********************************************************************************

/**
 * @author Horst Xu
 * @date 2015-11-25
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 **/
class BSTIterator {
private:
    stack<TreeNode *> st;
public:
    BSTIterator(TreeNode *root) {
        TreeNode *temp = root;
        while(temp != NULL){
            st.push(temp);
            temp = temp->left;
        }
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !st.empty();
    }

    /** @return the next smallest number */
    int next() {
        TreeNode *result = st.top();
        st.pop();
        if(result->right != NULL){
            TreeNode *temp = result->right;
            while(temp != NULL){
                st.push(temp);
                temp = temp->left;
            }
        }
        return result->val;
    }
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */
