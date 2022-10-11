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
    public void reorderList(ListNode head) {
        int size=0;
        Stack<ListNode> invertedOrder = new Stack<>();
        ListNode curr = head;
        
        while(curr!=null){
            size++;
            invertedOrder.push(curr);
            curr=curr.next;
        }
        
        curr=head;
        
        for(int i=0; i<size/2; i++){
            ListNode temp = invertedOrder.pop();
            temp.next = curr.next;
            curr.next = temp;
            curr=temp.next;
        }
        
        curr.next=null;        
    }
}