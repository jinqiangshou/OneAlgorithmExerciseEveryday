/**************************************Question*****************************************
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 ***************************************************************************************/


/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @author Horst Xu
 * @date 2016-01-15
 * @param {TreeNode} root
 * @return {number}
 */
var countNodes = function(root) {
    if(root === null){
        return 0;
    }
    var nodenumber = 0;
    while(root !== null){
        nodenumber++;
        var hl = getHeight(root.left);
        var hr = getHeight(root.right);
        if(hl === hr){
            root = root.right;
            nodenumber += Math.pow(2, hl)-1;
        }else if(hl > hr){
            root = root.left;
            nodenumber += Math.pow(2, hr)-1;
        }
    }

    return nodenumber;
};

/**
 * @author Horst Xu
 * @date 2016-01-15
 * @desc root is a complete binary tree, return its height
 * @param {TreeNode} root
 * @returns {number}
 */
var getHeight = function(root){
    var height = 0;
    while(root !== null){
        height ++;
        root = root.left;
    }
    return height;
}
