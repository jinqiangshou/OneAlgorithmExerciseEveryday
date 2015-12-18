/*******************************************Question*********************************************
 * Reverse a singly linked list.
 ************************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-12-18
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 **/
struct ListNode* reverseList(struct ListNode* head) {
    if(head == NULL){
        return head;
    }
    struct ListNode* prev = NULL;
    struct ListNode* curr = head;
    struct ListNode* next = head->next;
    while(curr != NULL){
        curr->next = prev;
        prev = curr;
        curr = next;
        if(curr != NULL){
            next = next->next;
        }
    }
    return prev;
}
