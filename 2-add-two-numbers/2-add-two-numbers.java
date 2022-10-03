/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                
        ListNode head = new ListNode(); 
        head.val=l1.val+l2.val;
        
        int carry=head.val/10;
        head.val=head.val%10;
        
        ListNode curr = head; 
        
        while(l1.next!=null && l2.next!=null){
            l1=l1.next;
            l2=l2.next;
            curr.next=new ListNode();
            curr=curr.next;
            
            curr.val=l1.val+l2.val+carry;
            carry=curr.val/10;
            curr.val=curr.val%10;
        }
        
        while(l1.next!=null){
            l1=l1.next;
            curr.next=new ListNode();
            curr=curr.next;
            
            curr.val=l1.val+carry;
            carry=curr.val/10;
            curr.val=curr.val%10;
        }
        
        while(l2.next!=null){
            l2=l2.next;
            curr.next=new ListNode();
            curr=curr.next;
            
            curr.val=l2.val+carry;
            carry=curr.val/10;
            curr.val=curr.val%10;
        }
        
        if(carry!=0){
            curr.next=new ListNode();
            curr=curr.next;
            curr.val=carry;
        }

        return head;   
        
    }
}