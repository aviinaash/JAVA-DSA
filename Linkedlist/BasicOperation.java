package Linkedlist;
import java.util.*;
public class BasicOperation {
	static class Node
	{
		int data;
		Node next;
		Node prev;
	}
	static int traverse(Node head)
	{
		int count = 0;
		Node temp = head;
		
		while(temp != null)
		{
			count++;
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println("Length of the linked list is: "+count);
		return count;
		
	}
	//function to insert a node in first position.
		static Node insertAtBegin(Node head, int value)
		{
			if(head == null)
			{
				Node temp = new Node();
				temp.data = value;
				head = temp;
				return head;
			}
			
			Node temp = new Node();
			temp.data = value;
			
			temp.next = head;
			
			head = temp;
			return head;
		}
		static void insertAtLast(Node head, int value)
		{
			Node temp = new Node();
			temp.data = value;
			temp.next = null;
			
			Node temp2 = head;
			
			while(temp2.next != null)
			{
				temp2 = temp2.next;
				
			}
			
			//temp2 is pointing to last node.
			temp2.next = temp;
			
			//return head;
		 }
		//function to find the middle node of the linked list.
		static void middle(Node head)
		{
			Node slow,fast,prev;
			slow =head; fast = head;
			prev = head;
			
			while(fast != null && fast.next != null )
			{
				prev = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			if(fast == null)
			{
				System.out.println("length is even. two middle nodes. "+prev.data+" "+slow.data);
			}
			else
			{
				System.out.println("length is odd.: "+slow.data);
				
			}
			
		}
		//create function to create linked list of size n.
		static Node create(int n)
		{
			Node head = new Node();
			Scanner x = new Scanner(System.in);
			int value = x.nextInt();
			head.data = value;
			
			Node temp = head;
			
			//n-1 nodes 
			int count = n-1;
			while(count > 0)
			{
				Node temp2 = new Node();
				value = x.nextInt();
				temp2.data = value;
				
				temp.next = temp2;
				
				temp = temp2;
				count--;
				
			}
			return head;
			
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node first = new Node();
		first.data = 10;
		first.next = null;
		
		Node second = new Node();
		second.data = 20;
		second.next = null;
		
		first.next = second;
		
		Node third = new Node();
		third.data = 30;
		third.next = null;
		
		second.next = third;
		
		Node fourth = new Node();
		fourth.data = 40;
		fourth.next = null;
		
		third.next = fourth;
		
		Node fifth = new Node();
		fifth.data= 50;
		fifth.next = null;
		
		Node sixth = new Node();
		sixth.data = 60;
		
		fifth.next = sixth;
		fourth.next =  fifth;
		
		traverse(first);
		insertAtBegin(first,500);
		//Reverse(first);
	}

}
