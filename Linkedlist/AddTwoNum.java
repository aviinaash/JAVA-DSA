package Linkedlist;

import java.util.Stack;

public class AddTwoNum {
	static class Node
	{
		int data;
		Node next;
	}
	static int cf;
	static Node pointer = null;
	
	//Addition of two numbers represented by two linked list.
	static Node add(Node head1, Node head2)
	{
		//inserting these linked list into 2 separate stack.
		Stack st1 = new Stack();
		Stack st2 = new Stack();
		
		Node temp1 = head1;
		while(temp1 != null)
		{
			st1.push(temp1);
			temp1 = temp1.next;
		
		}
		
		Node temp2 = head2;
		while(temp2 != null)
		{
			st2.push(temp2);
			temp2 = temp2.next;
		
		}
		
		while( !st1.isEmpty() && !st2.isEmpty())
		{
			Node temp3 = (Node)st1.pop();
			Node temp4 = (Node)st2.pop();
			
			int a = temp3.data; int b = temp4.data;
			int sum = a+b+cf;
			if(sum <10)
			{
				Node temp5 = new Node();
				temp5.data = sum;
				
				temp5.next = pointer;
				pointer = temp5;
				cf = 0;
			}
			else
			{
				int rem = sum%10;
				Node temp5 = new Node();
				temp5.data = rem;
				temp5.next = pointer;
				pointer = temp5;
				cf= 1;
				
			
			}
		}
		
		//check whether st1 is empty or not.
		while(!st1.isEmpty())
		{
			
			Node temp5 = new Node();
			int sum = temp5.data + cf;
			
			if(sum <10)
			{
				temp5 = new Node();
				temp5.data = sum;
				
				temp5.next = pointer;
				pointer = temp5;
				cf = 0;
			}
			else
			{
				int rem = sum%10;
				temp5 = new Node();
				temp5.data = rem;
				temp5.next = pointer;
				pointer = temp5;
				cf= 1;
			}
			
		}
		//check whether st2 is empty or not. 
		while(!st2.isEmpty())
		{
			
			Node temp5 = new Node();
			int sum = temp5.data + cf;
			
			if(sum <10)
			{
				temp5 = new Node();
				temp5.data = sum;
				
				temp5.next = pointer;
				pointer = temp5;
				cf = 0;
			}
			else
			{
				int rem = sum%10;
				temp5 = new Node();
				temp5.data = rem;
				temp5.next = pointer;
				pointer = temp5;
				cf= 1;
			}
			
		}
		
		//if both the stacks are empty. 
		if(cf == 1)
		{
			Node temp5 = new Node();
			temp5.data = 1;
			
			temp5.next = pointer;
			pointer = temp5;
			return pointer;
			
		}
		else
		{
			return pointer;
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1 = new Node();
		head1.data = 2;
		
		head1.next = new Node();
		head1.next.data = 4;
		
		head1.next.next = new Node();
		head1.next.next.data = 3;
		
		
		Node head2 = new Node();
		head2.data = 5;
		
		head2.next = new Node();
		head2.next.data = 6;
		
		head2.next.next = new Node();
		head2.next.next.data = 4;
		
		Node ans = add(head1,head2);
		
		while(ans != null)
		{
			System.out.println(ans.data);
			ans = ans.next;
		}
		

	}

}

//class Solution {
//    
//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null)
//        {
//            return head;
//        }
//        if (head.val != val)
//        {
//            head.next = removeElements (head.next, val);
//        }
//        else
//        {            
//            head = removeElements(head.next, val);
//        }
//        return head;            
//    }
//}
