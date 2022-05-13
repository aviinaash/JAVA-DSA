package Stack;

public class StUsingLL {
	class Node
	{
		int data; Node next;
	}
	Node top;
    StUsingLL()   //constructor
    {
    	this.top=null;
    }
    public void push(int value)
    {
    	Node temp =new Node();
    	temp.data=value;
    	if (temp==null) {
    		System.out.println("heap overflow");
    		return;
    	}
    	else {
    	temp.data=value;
		temp.next=top;
		top=temp;
    	}
    }
    public boolean isEmpty() {
    	if (top==null)
    		return true;
    	return false;
    }
    public void pop() {
    	if(top==null) {
    		System.out.println("underflow error");
    		return;
    	}
    	else {
    		top=top.next;
    	}
    }
    public int peek() {
    	if (top==null){
    		System.out.println("empty! !");
    		return 0;
    	}
    	return top.data;
    }
    public void display()
    {
    	Node temp=top;
    	while(temp!=null) {
    		System.out.println(temp.data+" ");
    		temp=temp.next;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
