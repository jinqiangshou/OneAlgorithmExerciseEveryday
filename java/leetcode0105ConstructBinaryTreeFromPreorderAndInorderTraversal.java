/* **********************************Question*************************************
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * *******************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-08-20
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        return myBuildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend) {
        if(pstart>pend || istart>iend){
            return null;
        }
        TreeNode result = new TreeNode(-1);
        if(pstart == pend){
            result.val = preorder[pstart];
            result.left = null;
            result.right = null;
            return result;
        }
        int root = preorder[pstart];
        int ipos = 0;
        for(;ipos+istart<=iend;ipos++){
            if(root == inorder[istart+ipos]){
                break;
            }
        }
        
        result.val = root;
        result.left = myBuildTree(preorder, inorder, pstart+1, pstart+ipos, istart, istart+ipos-1);
        result.right = myBuildTree(preorder, inorder, pstart+ipos+1, pend, istart+ipos+1, iend);
        return result;
    }
}
