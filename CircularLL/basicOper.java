package CircularLL;


public class basicOper {
	static class Node
	{
		int data;
		Node next;
	}
	static Node insertBeg(Node head, int data) {
        Node newNode=new Node ();
        if(head==null){
          newNode.next=newNode;
          head=newNode;
          return head;
        }
        Node temp=head;
        while(temp.next!=head){
          temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=head;
        return head;
    }
    static Node insertEnd(Node head, int data) {
      Node newNode=new Node();
        if(head==null){
          newNode.next=newNode;
          head=newNode;
          return head;
        }
        Node temp=head;
        while(temp.next!=head){
          temp=temp.next;
        }
        temp.next=newNode;
        newNode.next=head;
        head=newNode;
        return head;
    }

	public static void main(String[] args) {
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
		
		//insertBeg(first, 1000);
		insertEnd(first,100);

	}

}
