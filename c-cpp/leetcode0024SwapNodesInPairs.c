/*********************************Question*******************************
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 ************************************************************************/
 

/**
 * @author Horst Xu
 * @date 2015-04-20
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *swapPairs(struct ListNode *head) {
    if(!head || !head->next){
        return head;
    }   
    struct ListNode *current = head;
    struct ListNode *result = head->next;
    struct ListNode *next2node;
    struct ListNode *previous = NULL;
    while(current){
        if(!current->next){
            break;
        }   
        next2node = current->next->next;
        if(previous){
            previous->next = current->next;
        }   
        previous = current;
        current->next->next = current;
        current->next = next2node;
        current = next2node;
    }   
    return result;
}
