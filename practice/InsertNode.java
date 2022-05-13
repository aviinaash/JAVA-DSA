package practice;

import java.util.Scanner;

public class InsertNode {
	   static class Node
	   {
		   int data;
		   Node next;
	   }
	   
	   static Node insertBegin(Node head,int value)
	   {
		   Node beg = new Node();
		   Node temp= beg;
		   temp.data=value;
		   temp.next=null;
		   
		   temp.next=head;
		   head = temp;
		   return beg;
	   }
	   
      static Node createUserNode(int n)
      {
    	 Scanner x = new Scanner(System.in);
    	 System.out.println("Enter the Data in linked List");
    	 int value=x.nextInt();
    	 Node head = new Node();
    	 Node temp = head;
    	 temp.data=value;
    	 temp.next=null;
    	 
    	 while(n > 1)
    	 {
    		 System.out.println("Enter the Data in Linked List");
    		 value=x.nextInt();
    		 Node temp2 = new Node();
    		 Node temp3= temp2;
    		 temp3.data=value;
    		 temp.next=temp3;
    		 temp=temp.next;
    		 n--;
    	 }
    	 
    	 return head;
    	  
    	  
    	  
      }
	public static void main(String[] args) {
		 
			// TODO Auto-generated method stub
	Node uday =	createUserNode(5);
	Node insert = insertBegin(uday, 102);
    while(insert!=null)
    {
    	System.out.println(insert.data);
    	insert=insert.next;
    }
	}

}
