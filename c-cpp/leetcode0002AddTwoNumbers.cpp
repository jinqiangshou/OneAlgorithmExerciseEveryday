/*********************Question*************************
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
*******************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-01
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        ListNode *head=NULL;
        ListNode *pNext=NULL;
        ListNode *first = NULL;
        while(l1 && l2){
            if(!head){
                head = new ListNode(0);
                first = head;
            }else{
                pNext = new ListNode(0);
                head ->next = pNext;
                head = head->next;
            }
            head->val = l1->val + l2->val;
            l1 = l1->next;
            l2 = l2->next;
        }
        while(l1){
            if(!head){
                head = new ListNode(0);
                first = head;
            }else{
                pNext = new ListNode(0);
                head ->next = pNext;
                head = head->next;
            }
            head->val = l1->val;
            l1 = l1->next;
        }
        while(l2){
            if(!head){
                head = new ListNode(0);
                first = head;
            }else{
                pNext = new ListNode(0);
                head ->next = pNext;
                head = head->next;
            }
            head->val = l2->val;
            l2 = l2->next;    
        }
        ListNode *firstCopy = first;
        int jinwei = 0;
        while(firstCopy){
            firstCopy ->val += jinwei;
            jinwei = 0;
            if(firstCopy->val>9){
                firstCopy->val %= 10;
                jinwei = 1;
            }
            if(!firstCopy->next) break;
            firstCopy = firstCopy->next;
        }
        if(jinwei==1){
            firstCopy->next = new ListNode(1);
        }
        
        return first;
    }
};
