/* ***********************************Question************************************
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * *******************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-08-25
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return null;
        }
        return mySortedArrayToBST(nums, 0, len-1);
    }
    
    public TreeNode mySortedArrayToBST(int[] nums, int start, int end){
        if(start>end){
            return null;
        }
        
        int rootvalue = nums[(end+start)/2];
        TreeNode tn = new TreeNode(rootvalue);
        tn.left = mySortedArrayToBST(nums, start, (end+start)/2 -1);
        tn.right = mySortedArrayToBST(nums, (end+start)/2 + 1, end);
        return tn;
    }
}
