package practice;

import java.util.Scanner;

public class insertLast {
	static Scanner x;
          static class Node
          {
        	  int data;
        	  Node next;
          }
           
           static Node createNode(int n)
           {
        	  x  = new Scanner(System.in);
        	   System.out.println("Enter the Data In Linked List");
        	   Node head =  new Node();
        	   int value = x.nextInt();
        	   Node temp = head;
        	   temp.data=value;
        	   temp.next=null;
        	   
        	   while(n > 1)
        	   {
        		   System.out.println("Enter the Data in linked list");
        		   value=x.nextInt();
        		   Node temp1= new Node();
        		   temp1.data=value;
        		   temp1.next=null;
        		   temp.next=temp1;
        		   temp=temp.next;
        		   n--;
        		   
        		   
        	   }
        	   return head;
        	   
           }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = createNode(5);
		Node temp = head;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
           
	}

}
