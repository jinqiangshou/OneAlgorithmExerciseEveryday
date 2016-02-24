/* **********************************Question***************************************
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 * *********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-02-24
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    private void helper(TreeNode root, List<String> result, StringBuilder sb){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            StringBuilder tmpsb = new StringBuilder(sb);
            if(tmpsb.length() == 0){
                tmpsb.append(root.val);
            }else{
                tmpsb.append("->");
                tmpsb.append(root.val);
            }
            result.add(tmpsb.toString());
            return;
        }
        if(root.left != null){
            StringBuilder tmpsb2 = new StringBuilder(sb);
            if(tmpsb2.length() == 0){
                tmpsb2.append(root.val);
            }else{
                tmpsb2.append("->");
                tmpsb2.append(root.val);
            }
            helper(root.left, result, tmpsb2);
        }
        if(root.right != null){
            StringBuilder tmpsb3 = new StringBuilder(sb);
            if(tmpsb3.length() == 0){
                tmpsb3.append(root.val);
            }else{
                tmpsb3.append("->");
                tmpsb3.append(root.val);
            }
            helper(root.right, result, tmpsb3);
        }
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new LinkedList<>();
        helper(root, result, sb);
        return result;
    }
}
