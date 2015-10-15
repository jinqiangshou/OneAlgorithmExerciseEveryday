/************************************Question**************************************
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 **********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-10-15
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 **/
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if(head == NULL || head->next == NULL){
        return false;
        }
        struct ListNode *fastPt = head, *slowPt = head;
        while(1){
            fastPt = fastPt->next;
            slowPt = slowPt->next;
            if(slowPt == NULL || fastPt == NULL){
                return NULL;
            }
            fastPt = fastPt->next;
            if(fastPt == NULL){
                return NULL;
            }
            if(fastPt == slowPt){
                break;
            }
        }
        slowPt = head;
        while(1){
            if(slowPt == fastPt){
                return slowPt;
            }
            fastPt = fastPt->next;
            slowPt = slowPt->next;
        }
        return NULL;
    }
};
