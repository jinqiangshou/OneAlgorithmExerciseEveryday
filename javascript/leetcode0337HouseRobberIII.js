/**********************************Question*************************************
 * The thief has found himself a new place for his thievery again. 
 * There is only one entrance to this area, called the "root." 
 * Besides the root, each house has one and only one parent house. 
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * 
 * Example 1:
 *      3
 *     / \
 *    2   3
 *     \   \ 
 *      3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *      3
 *     / \
 *    4   5
 *   / \   \ 
 *  1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 ******************************************************************************/


/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @author Horst Xu
 * @date 2016-05-23
 * @return {array} Array of length 2. 
 *                 First element is maximum when current node is chosen.
 *                 Second element is maximum when current node is not chosen.
 **/
var helper = function(root) {
    if(!root) {
        return [0, 0];
    }
    var left = [0, 0];
    if(root.left) {
        left = helper(root.left);
    }
    var right = [0, 0];
    if(root.right) {
        right = helper(root.right);
    }
    var result1 = root.val + left[1] + right[1];
    var result2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    return [result1, result2];
};

/**
 * @param {TreeNode} root
 * @return {number}
 */
var rob = function(root) {
    var result = helper(root);
    return Math.max(result[0], result[1]);
};
