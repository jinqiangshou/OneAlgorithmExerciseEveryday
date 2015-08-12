/* *******************************Question********************************
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * ***********************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-08-12
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    private TreeNode tobeswaped1 = null;
    private TreeNode tobeswaped2 = null;
    
    public void recoverTree(TreeNode root) {
        if (root==null || (root.left==null && root.right==null)){
            return;
        }
        myRecover(root,null);
        if(tobeswaped1 != null && tobeswaped2 != null){
            int temp=tobeswaped1.val;
            tobeswaped1.val=tobeswaped2.val;
            tobeswaped2.val=temp;
        }
    }

    private TreeNode myRecover(TreeNode cur, TreeNode prev) {
        if (cur.left != null) {
            prev = myRecover(cur.left, prev);
        }
        if (prev != null) {
            if (cur.val < prev.val) {
                if (tobeswaped1 == null)
                    tobeswaped1 = prev;
                tobeswaped2 = cur;
            }
        }
        if(cur.right!=null)
            return myRecover(cur.right,cur);
        else 
            return cur;
    }
}
