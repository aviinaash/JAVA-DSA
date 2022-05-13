package Linkedlist;

public class DoublyLL {
	static class Node
	{
		int data;
		Node next;
		Node prev;
	}
//	static Node deleteAtBegin (Node head, int value)
//	{
//		if(head == null) {  
//             return head;
//        } 
//		else {
//			 Node temp=head;
//			 head=head.next;
//			 head.prev=null;
//			 
//			 
//			 
//		}
//	}
	static Node Reverse(Node head) 
    {
    Node temp = head;
    Node ans = head;
    while (temp != null) 
    {
        Node prev = temp.prev;
        temp.prev = temp.next;
        temp.next = prev;
        ans = temp;
        temp = temp.prev;
    }
    return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
