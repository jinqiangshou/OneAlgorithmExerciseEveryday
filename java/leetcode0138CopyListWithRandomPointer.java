/* *********************************Question**********************************
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * ***************************************************************************/
 

/* *
 * @author Horst Xu
 * @date 2015-10-10
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 * */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode result = new RandomListNode(head.label);
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
        hm.put(head, result);
        
        RandomListNode temp = head.next;
        while(temp != null){
            RandomListNode temp2 = new RandomListNode(temp.label);
            hm.put(temp, temp2);
            result.next = temp2;
            result = result.next;
            temp = temp.next;
        }
        temp = head;
        result = hm.get(head);
        while(temp != null && result != null){
            if(temp.random == null){
                result.random = null;
            }else{
                result.random = hm.get(temp.random);
            }
            temp = temp.next;
            result = result.next;
        }
        result = hm.get(head);
        return result;
    }
}
