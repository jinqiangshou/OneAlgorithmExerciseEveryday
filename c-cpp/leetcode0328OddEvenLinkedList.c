/**********************************Question***************************************
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * 
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * 
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input. 
 * The first node is considered odd, the second node even and so on ...
 *********************************************************************************/


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* oddEvenList(struct ListNode* head) {
    if(head == NULL || head->next == NULL) {
        return head;
    }
    struct ListNode* odd = head;
    struct ListNode* even = head->next;
    
    struct ListNode* odd_t = head;
    struct ListNode* even_t = head->next;
    struct ListNode* last_odd = NULL;
    
    while( odd_t != NULL && even_t != NULL ){
        odd_t->next = even_t->next;
        if(odd_t->next == NULL){
            last_odd = odd_t;
        }
        odd_t = odd_t->next;
        if(odd_t != NULL){
            even_t->next = odd_t->next;
            even_t = even_t->next;
        }
    }
    
    if(last_odd == NULL){
        odd_t->next = even;
    } else {
        last_odd->next = even;
    }
    
    return odd;
}
