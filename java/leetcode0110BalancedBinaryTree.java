/* ************************************Question****************************************
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * ************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-08-27
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public boolean isBalanced(TreeNode root){
        return height(root) >= 0;
    }
    
    public int height(TreeNode root)
    {
        if(root == null) {
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        if (leftheight == -1 || rightheight == -1 || Math.abs(leftheight - rightheight) > 1) {
            return -1;
        }
        return Math.max(leftheight, rightheight) + 1;
    }
}
