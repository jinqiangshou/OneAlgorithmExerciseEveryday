/********************************Question***********************************
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 ***************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-16
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        struct ListNode *p1 = head;
        struct ListNode *p2 = head;
        struct ListNode *temp;
        for(int i=0;i<n;i++){
            p2 = p2->next;
        }
        if(!p2){
            temp = head;
            head = head->next;
            delete temp;
            return head;
        }
        while(p2){
            p2 = p2->next;
            if(!p2){
                temp = p1->next;
                p1->next = p1->next->next;
                delete temp;
                break;
            }   
            p1 = p1->next;
        }   
        return head;
    }
};
