/*
    Sort a linked list using insertion sort.
	
	Algorithm of Insertion Sort:
	Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
	At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
	It repeats until no input elements remain.
 */
public class InsertionSortLinkedList {

	public ListNode insertionSortList(ListNode head) {
        
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode currentNode = head;
        ListNode prev = newHead;
        
        while(currentNode!=null){
            
            if(prev.val > currentNode.val)
                prev = newHead;
            
            
            while(prev.next!=null && prev.next.val < currentNode.val)
                prev = prev.next;
            
            ListNode next = currentNode.next;
            currentNode.next = prev.next;
            prev.next = currentNode;
            currentNode = next;
        }
        
        
        return newHead.next;
        
        
        
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
