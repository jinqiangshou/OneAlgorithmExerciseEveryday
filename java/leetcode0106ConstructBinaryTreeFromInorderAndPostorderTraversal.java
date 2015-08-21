/* ******************************Question********************************
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * **********************************************************************/

/* *
 * @author Horst Xu
 * @date 2015-08-21
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0){
            return null;
        }
        return myBuildTree(postorder, inorder, 0, postorder.length-1, 0, inorder.length-1);
    }
    public TreeNode myBuildTree(int[] postorder, int[] inorder, int pstart, int pend, int istart, int iend) {
        if(pstart>pend || istart>iend){
            return null;
        }
        TreeNode result = new TreeNode(-1);
        if(pstart == pend){
            result.val = postorder[pstart];
            result.left = null;
            result.right = null;
            return result;
        }
        int root = postorder[pend];
        int ipos = 0;
        for(;ipos+istart<=iend;ipos++){
            if(root == inorder[istart+ipos]){
                break;
            }
        }

        result.val = root;
        result.left = myBuildTree(postorder, inorder, pstart, pstart+ipos-1, istart, istart+ipos-1);
        result.right = myBuildTree(postorder, inorder, pstart+ipos, pend-1, istart+ipos+1, iend);
        return result;
    }
}
