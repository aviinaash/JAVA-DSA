package Stack;


public class StUsingArr {
int top; int arr[] = new int[5];
	
	StUsingArr()
	{
		top = -1;
	}
	
	//IsEmpty function.
	boolean isEmpty()
	{
		if(top == -1)
			return true;
		return false;
	}
	
	//push.
	boolean push(int value)
	{
		if(top + 1 < 5)
		{
			top++;
			arr[top] = value;
			return true;
		}
		else
		{
			System.out.println("stack overflow.!!");
			return false;
		}
	}
	
	//pop.
	int pop()
	{
		if(top == -1)
		{
			System.out.println("underflow.!!");
			return -1;
		}
		else
		{
			int a = arr[top];
			top--;
			return a;
		}
	}
	
	//display
	void display()
	{
		for(int i = top; i>=0; i--)
		{
			System.out.println(arr[i]);
		}
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		

	}

}
