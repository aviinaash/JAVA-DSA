package practice;

import java.util.Scanner;

public class Manually {
	static class Node
	{
		int data;
		Node next;
	}
	
	static Node  createNode(int n)
	{
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter the First Node");
		int value = ob.nextInt();
		Node head = new Node();
		Node temp =head;
		temp.data=value;
		temp.next=null;
		
		while(n>1)
		{
			System.out.println("Ente the Second Node");
			value = ob.nextInt();
			Node second = new Node();
			Node temp1 = new Node();
			temp1.data=value;
			temp.next=temp1;
			temp=temp.next;
			n--;
		}
		return head;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obb= new Scanner(System.in);
		int oo=obb.nextInt();
		Node print = createNode(oo);
		Node temp = print;
		while(temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
		
		
	}
}
