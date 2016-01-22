/******************************************Question***************************************
 * Invert a binary tree.
 * 
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * Google: 90% of our engineers use the software you wrote (Homebrew), 
 * but you can’t invert a binary tree on a whiteboard so fuck off.
 *****************************************************************************************/


/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 **/
/**
 * @author Horst Xu
 * @date 2016-01-22
 * @param {TreeNode} root
 * @return {TreeNode}
 **/
var invertTree = function(root) {
    if(root === null){
        return root;
    }
    if(root !== null){
        var tn = root.left;
        root.left = root.right;
        root.right = tn;
    }
    
    invertTree(root.left);
    invertTree(root.right);
    return root;
};
