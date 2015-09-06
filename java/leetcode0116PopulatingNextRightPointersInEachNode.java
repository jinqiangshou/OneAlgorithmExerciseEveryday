/* ************************************Question**************************************
 * Given a binary tree
 * 
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree 
 * (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 * *********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-09-06
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if(root == null){
            return;
        }
        q.offer(root);
        int count = 0;
        int total = 1;
        TreeLinkNode curr = null;
        while(!q.isEmpty()){
            curr = q.poll();
            if(curr.left != null){ q.offer(curr.left); count++;}
            if(curr.right != null){ q.offer(curr.right); count++;}
            for(int i=1;i<total;i++){
                TreeLinkNode temp = q.poll();
                curr.next = temp;
                curr = temp;
                if(curr.left != null){ q.offer(curr.left); count++;}
                if(curr.right != null){ q.offer(curr.right); count++;}
            }
            total = count;
            count = 0;
            curr.next = null;
        }
    }
}
