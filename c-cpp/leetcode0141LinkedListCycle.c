/*************************************Question****************************************
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 *************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-10-14
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 **/
bool hasCycle(struct ListNode *head) {
    if(head == NULL || head->next == NULL){
        return false;
    }
    struct ListNode *fastPt = head, *slowPt = head;
    while(1){
        fastPt = fastPt->next;
        slowPt = slowPt->next;
        if(slowPt == NULL || fastPt == NULL){
            return false;
        }
        fastPt = fastPt->next;
        if(fastPt == NULL){
            return false;
        }
        if(fastPt == slowPt){
            return true;
        }
    }
}
