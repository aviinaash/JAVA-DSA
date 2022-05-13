package Linkedlist;
import java.util.*;

import Linkedlist.createnode.Node;
public class SLLinsertion{
	static Scanner x;
	static Node head;
	private int size;
	SLLinsertion(){
		this.size=0;
	}
	public class Node
	{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
			size++;
		}
	}
	
	public void addFirst(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
		return;
	}
	
	public void addLast(int data)
	{
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		Node temp= head;
		while(temp.next!=null)
		{
			temp = temp.next;
		}
		temp.next = head;
		return;
	}
	
	public void deleteFirst() {
		if(head==null) {
			System.out.println("list is empty!");
		}
		head=head.next;
		size--;
	}
	
	public void deleteLast() {
		if(head==null) {
			System.out.println("list is empty!");
			return;
		}
		size--;
		if(head.next==null) {     //if list has only one node
            head=null;
            return;
		}
		Node secondLast= head;
		Node lastNode=head.next;
		while(lastNode.next!=null)
		{
			lastNode = lastNode.next;
			secondLast=secondLast.next;
		}
		secondLast.next=null;
	}
	
	public int getSize() {
		return size;
	}
	
      
	public static void Display()
	{
	   if(head==null) {
		   System.out.println("list is Empty");
	   }
	   Node curr  = head;
	   while(curr!=null)
	   {
		   System.out.print(curr.data+"->");
		   curr=curr.next;
	   }
	   System.out.println("null");
	}
	
	
	public void insertMid(int val) {
		if(head==null) {
			head = new Node(val);
		}
		else {
			Node newNode=new Node(val);
			Node slow=head;
			Node fast=head.next;
			while(fast!=null && fast.next!=null) {
				slow=slow.next;
				fast=fast.next.next;
			}
			newNode.next = slow.next;
            slow.next = newNode;
		}
	}
	
	public void reverseLLiterative() {
		if(head==null || head.next==null) {
			return;
		}
		
		Node prev=head;
		Node curr=head.next;
		while(curr!=null) {
			Node Next=curr.next;
			curr.next=prev;
			
			//update position of all three pointer
			prev=curr;
			curr=Next;
		}
		head.next=null;
		head=prev;
	}
	
	public Node reverseLLrecursive(Node head) {
		if(head==null || head.next==null) {
			return head;
		}
		
		Node newHead=reverseLLrecursive(head.next);
		head.next.next=head;
		head.next=null;
		return newHead;
	}
	
	public int FindkthNode(int k) {
		Node curr=head;
		int count=0;
		while(curr!=null) {
			if(count==k) {
				return curr.data;
			}
			count++;
			curr=curr.next;
		}
		return 0;
	}
	
	public void FindKthNodeFromLast(int k) {
		int size=0;
		Node curr = head;
		while(curr.next!=null) {
			curr=curr.next;
			size++;
		}
		if(size<k) {
			return;
		}
		curr=head;
		for (int i=1;i<size-k+1;i++) {
			curr=curr.next;
		}
		System.out.println(curr.data);
	}

	public static void main(String[] args) {
		
		SLLinsertion list=new SLLinsertion();
		list.addLast(7);
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(3);
		list.addFirst(2);
		list.addFirst(1);     //  1->2->3->4->5->null
		list.deleteFirst();   //  2->3->4->5->7->null
        list.deleteLast();    //  2->3->4->5->null
        list.insertMid(0);
        
	    Display();

        System.out.println(list.getSize());    // 4
        
//        list.reverseLLiterative();  //5->4->3->2->null
//        Display();  
//        
//        list.head=list.reverseLLrecursive(list.head);
//        Display();
        
        System.out.println("Element at index 2 is:"+list.FindkthNode(2));
        
        list.FindKthNodeFromLast(0);  //5
        
	}

}
