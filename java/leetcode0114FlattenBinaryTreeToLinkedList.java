/* ************************************Question***************************************
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * ************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-09-01
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode record = root;
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        if(root.right != null){
            st.push(root.right);
        }
        if(root.left != null){
            st.push(root.left);
            root.left = null;
        }
        while(!st.empty()){
            record.right = st.pop();
            record = record.right;
            
            if(record.right != null){
                st.push(record.right);
            }
            if(record.left != null){
                st.push(record.left);
                record.left = null;
            }
        }
    }
}
