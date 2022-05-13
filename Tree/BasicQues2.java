package Tree;
import java.util.*;

import Tree.BasicQuestions.Node;
public class BasicQues2 {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	
	static boolean abssumchild(Node root) 
	{ //absolute sum child property in BT
		int l=0,r=0;
		if(root==null) {
			return true;
		}
		if(root.left==null && root.right==null) {
			return true;
		}
		if(root.left!=null) {
			l=root.left.data;
		}
		if(root.right!=null) {
			r=root.right.data;
		}
		if((root.data==l+r)&&(abssumchild(root.left)==true)&& (abssumchild(root.right)==true)){
			return true;
		}
		else {
			return false;
		}
	}
	
	static void printExteriorNode(Node root) {
		int l=0,r=0;
		if(root==null) {
			return;
		}
		if(root!=null) 
		{
			if(r==0) {
				System.out.println(root.data);
			}
			printExteriorNode(root.left);
			l=l+1;
			if(root.left==null && root.right==null && r>0) {
				System.out.println(root.data);
			}
			printExteriorNode(root.right);
			r=r+1;
			if(l==0) {
				if(r!=0) {
					System.out.println(root.data);
				}
			}
		}
	}
	
	static void InternalNodesOfBT(Node root)
	{
	    Queue<Node> q = new LinkedList<Node>();
	    q.offer(root);
	    while (!q.isEmpty())
	    {
	        Node temp = q.peek();
	        q.poll();
	        boolean InternalNodes = false;
	        if (temp.left != null)
	        {
	            InternalNodes = true;
	            q.offer(temp.left);
	        }
	        if (temp.right != null)
	        {
	            InternalNodes = true;
	            q.offer(temp.right);
	        }
	        if (InternalNodes == true)
	            System.out.print(temp.data + " ");
	    }
	}
	
	static void rightRotOfBT(Node root) {
		if(root==null) {
			return;
		}
		if(root.left!=null) {
			Node temp=root;
			root=root.left;
			temp.left=root.right;
			root.right=temp;
		}
		return;
	}
	
	static Node rightRotOfBTUntilRightSkewBT(Node root) {
		
		return root;
	}
	
	static Node LeftRotOfBST(Node root) {
		if(root==null) {
			return root;
		}
		if(root.right!=null) {
			Node temp=root;
			root=root.right;
			temp.right=root.left;
			root.left=temp;
		}
		return root;
	}
	
	
	Node root;
    static Node insertElementBST(Node root,int val) {
    	if(root==null) {
    		Node temp = new Node(val);
    		root = temp;
    		return root;
    	}
    	else {
    		if(root.data>val) {
    			root.left = insertElementBST(root.left,val);
    		}
    		else if(root.data<val){
    			root.right  = insertElementBST(root.right,val);
    		}
    		return root;
    	}
    }
	
	static Node deleteBST(Node root,int val) {
		if(root==null) {
			return root;
		}
		if(root.data>val) {
			root.left = deleteBST(root.left, val);
	        return root;
		}
		else if(root.data<val) {
			root.right = deleteBST(root.right, val);
	        return root;
		}
		
		// if only one child is empty
		Node temp=null;
		 if (root.left== null && root.right == null)
		    {
		      return null;
		    }
		if (root.left == null)
	    {
	        temp = root.right;
	        return temp;
	    }
	    else if (root.right == null)
	    {
	        temp = root.left;
	        return temp;
	    }
		
		//if both child exists
	    else {
	    	Node succParent = root;
	        Node succ = root.right; 
	        while (succ.left != null)
	        {
	            succParent = succ;
	            succ = succ.left;
	        }
	        if (succParent != root)
	            succParent.left = succ.right;
	        else {
	            succParent.right = succ.right;
	        }
	        root.data = succ.data;
	        return root;
	    }
	}
	
	static void largestBST(Node root) {
		
	}
	
    static void smallestBST(Node root) {
		
	}
    
    static void OuterTopNodes(Node root) {
    	
    }


	public static void main(String[] args) {
		Node root = new Node(10);
		Node rootLeft = new Node(20);
		Node rootRight = new Node(30);
		Node rootLeftLeft = new Node(40);
		Node rootLeftRight = new Node(50);
		Node rootRightLeft = new Node(60);
		Node rootRightRight = new Node(70);
		
		root.left=rootLeft;
		root.right=rootRight;
		
		rootLeft.left=rootLeftLeft;
		rootLeft.right=rootLeftRight;
		
		rootRight.left=rootRightLeft;
		rootRight.right=rootRightRight;
		
//		InternalNodesOfBT(root);
//		System.out.println();
//		
//		 rightRotOfBT(root);
		 
		 System.out.println(deleteBST(root,40));

	}

}
