package Linkedlist;
import java.util.*;
public class createnode {
	Node head;
	static Scanner x;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	
	public static Node createNode(int n) {
		x=new Scanner(System.in);
		System.out.println("Enter the data");
		int value=x.nextInt();
		Node head=new Node(value);
		Node temp=head;
		while(n>1) {
			x=new Scanner(System.in);
			System.out.println("Enter the data");
			value=x.nextInt();
			Node secondHead=new Node(value);
			temp.next=secondHead;
			temp=temp.next;
			n--;
		}
		return head;
	}
	static void display(Node head)
	{
		Node curr = head;
		while(curr!=null)
		{
			System.out.print(curr.data+"->");
            curr=curr.next;
		}
		System.out.println("null");
	}
	
	
	public void FindKthNodeFromLast(int n) {
		Node temp=head;
		int count=0;
		while(temp.next!=null) {
			temp=temp.next;
			count++;
		}
//		return count;
		//kth node from last= length-k+1                                  .
		//length=count
		temp=head;
	    for(int i=0;i<=count-n+1;i++) {
	    	temp=temp.next;
	    }
	    System.out.println(temp.data);
		
	}
	

	public static void main(String[] args) {
		Node ans = createNode(5);
        display(ans);
	}

}
