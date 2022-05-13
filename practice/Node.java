package practice;

import java.util.Scanner;

public class Node {
  static	Scanner x;
       static class SingleLinked
       {
    	   int data;
    	   SingleLinked next;
       }
    	static SingleLinked userDefine(int n)
       
    	{
    		x = new Scanner(System.in);
    		System.out.println("Enter the part of Node");
    		int value =x.nextInt();
    		SingleLinked head = new SingleLinked();
    		SingleLinked temp = head;
    		temp.data=value;
    		temp.next=null;
    		
    		while(n > 1)
    		{
    			 System.out.println("Enter the Node parts of ");
    			 value= x.nextInt();
    			 SingleLinked second = new SingleLinked();
    			 SingleLinked temp1= second;
    			 temp1.data=value;
    			 temp.next=temp1;
    			 temp=temp.next;
    			 n--;
    			
    		}
    		return head;
    	}
       
	public static void main(String[] args) {
		 
		  int a=7;
	SingleLinked head =	userDefine(a);
	SingleLinked temp1 = head;
	int count = 0;
	while(temp1!=null)
	{
		count++;
		System.out.println(temp1.data);
		temp1=temp1.next;
	}
	System.out.println("Length of LinkedList"+count);
        
	}

}
