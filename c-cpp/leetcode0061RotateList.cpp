/********************************Question*********************************
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-06-19
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (!head || !head->next || 0==k)
            return head;
          
        ListNode *ret = head;  
        int len = 1;  
        while(ret->next != NULL){  
            len++;  
            ret = ret->next;  
        }  
          
        ret->next = head;  
          
        k = k % len;  
        int step = len - k; 
        while(step > 0){  
            ret = ret->next;  
            step--;  
        }  
          
        head = ret->next;  
        ret->next = NULL;  
          
        return head; 
    }
};
