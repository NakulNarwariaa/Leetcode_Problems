/*
 * 143.Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */


public class ReorderList {
	
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public void reorderList(ListNode head) {
	        
	        if(head == null || head.next==null)
	            return;
	        
	        ListNode mid = head;
	        ListNode end = head;
	        while(end !=null && end.next!=null){
	            mid = mid.next;
	            end = end.next.next;
	        }
	        ListNode l2 = mid.next;
	        ListNode l1 = head;
	        mid.next = null;
	        
	        l2 = reverse(l2);
	        
	        merge(l1,l2);
	        
	    }
	    
	    public ListNode reverse(ListNode head){
	        if(head ==null || head.next == null)
	            return head;
	        
	        ListNode curr = head;
	        ListNode prev = null;
	        ListNode out = curr;
	        while(curr != null){
	            ListNode tmp = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = tmp;
	            
	        }
	        
	        return prev;    
	    }
	    
	    public void merge(ListNode l1, ListNode l2){
	        
	        while(l1 !=null && l2!=null){
	            ListNode tmp = l1.next;
	            l1.next = l2;
	            l2 = l2.next;
	            l1.next.next = tmp;
	            l1 = tmp;
	        }
	        if(l2!=null)
	            l1.next = l2;
	        
	        
	    }
	}

}
