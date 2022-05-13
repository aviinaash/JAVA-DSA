package Tree;
import java.util.*;

class Node{
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data =data;
		left = right = null;
		
	}
}
public class Avltree2 {
	
	
//	for inserting in the binary search tree;
	
    public static Node insert(Node root,int data) {
    	Stack<Node> s = new Stack<Node>();
    	Node n = new Node(data);
    	if(root==null) {
    		root = n;
    		return root;
    	}
    	
    	Node ptr = root;
    	Node pre = ptr;
    	while(ptr!=null) {
    		
    		pre =ptr;
    		s.add(pre);
    		if(ptr.data<data) {
    			ptr=ptr.right;
    		}
    		else {
    			ptr = ptr.left;
    		}
    	}
    	if(pre.data<data) {
    		pre.right = n;
    	}
    	else {
    		pre.left = n;
    		
    	}
    
    	System.out.println("data entered "+n.data);
    	while(!s.isEmpty()) {
    		
    		Node st = s.pop();
    		if(balanceBinaryTree(st)) {
    			System.out.println("Node is "+st.data);
    			if(data<st.data && st.left!=null) {
    				if(data<st.left.data) {
    					System.out.println("Leftleft");
    				   root =leftleft(s.peek());
    				}
    				else if(st.right!=null){
    					System.out.println("LeftRight");
    					root = leftright(s.peek());
    				}
    			}
    			else if(st.right!=null  && data>st.data) {
    				if(data<st.right.data  ) {
    					System.out.println("Rightright");
    					root=rightright(s.peek());
    				}
    				else {
    					System.out.println("RightLeft");
    					root=rightleft(s.peek());
    				}
    			}
    			System.out.println(st.data);
    			break;
    		}
    	};
    	System.out.println();
    	
    	return root;
    }
    
    
    
    
//    for leftleft we do right rotation
    static Node leftleft(Node st) {
    	if(st==null) {
    		return st;
    	}
    	else {
    		Node temp = st;
    		st = st.left;
    		temp.left = st.right;
    		st.right = temp;
    		return st;
    	}
    	
    }
//   for leftright we do 
    static Node leftright(Node st) {
    	st.left = leftleft(st.left);
    	return rightright(st);
    }
    
//  for rightright we do left rotation
  static Node rightright(Node st) {
  	if(st==null) {
  		return st ;
  	}
  	else {
  		Node temp = st;
  		st = st.right;
  		temp.right = st.left;
  		st.left = temp;
  		return st;
  	}
  	
  }
//    if we do rightleft 
   static Node rightleft(Node st) {
	   st.right = leftleft(st.right);
	   return leftleft(st);
   }
    
//    insertion method 2 using recursion
    public static Node insertion(Node root,int data) {
    	
    	if(root==null) {
    		Node n = new Node(data);
    		root = n;
    		return root;
    	}
    	else {
    		if(root.data>data) {
    			root.left = insertion(root.left,data);
    		}
    		else if(root.data<data){
    			root.right  = insertion(root.right,data);
    		}
    		return root;
    	}
    }
    
//   for printing binary search tree - inorder
    public static void inorder(Node root) {
    	if(root==null) {
    		return;
    	}
    	else {
    		inorder(root.left);
    		System.out.print(root.data+" ");
    		inorder(root.right);
    	}
    }
    
    
//  for calculating height of the tree
    public static int height(Node root) {
    	
    	if(root == null) {
    		return -1;
    	}
    	else {
    		int lh = height(root.left);
    		int rh = height(root.right);
    		if(lh>rh) {
    			return lh+1;
    		}
    		else {
    			return rh+1;
    		}
    	}
    }
    
    
//    printlevel order 
    public static void printLevelOrder(Node root)
    {
    	int h = height(root);
    	for (int i = 1; i <= h+1; i++) {
    		levelorder(root, i);
    		System.out.println();
    	}
    }
    public static void levelorder(Node root, int level)
    {
    	if (root == null) {
    		return;
    	}
    	if (level == 1) {
    		System.out.print(root.data + " ");
    	}
    	else if (level > 1) {
    		levelorder(root.left, level - 1);
    		levelorder(root.right, level - 1);
    	}
    }
    
    
    
    
//    for calculating balancing factor of the tree
    public static int balancingFactor(Node root) {
    	if(root == null) {
    		return 0;
    	}
    	else {
    		int lh = height(root.left);
    		int rh  = height(root.right);
    		return lh-rh;
    	}
    }
    
    
//    for checking which node is inbalance
    public static void balance(Node root) {
    	if(root == null) {
    		return;
    	}
    	else {
    		int l=0,r=0;
    		l = balancingFactor(root.left);
    		r = balancingFactor(root.right);
    		System.out.println(l+" "+r);
    		if(l>1 && l<-1) {
    			System.out.println(root.data);
    		}
    		if(r>1 && r<-1) {
    			System.out.println(root.data);
    		}
    	}
    }
    
    public static  boolean balanceBinaryTree(Node n) {
		   if(n==null) {
			   return false;   //tree is balanced
		   }
		   else {
			   int lh = height(n.left);
			   int rh = height(n.right);
			   int balfac=lh-rh;
		   if(balfac>=-1 && balfac<=1 && balanceBinaryTree(n.left)==false && balanceBinaryTree(n.right)==false )
			   return false;
		   else
			   if(balfac<-1 || balfac>1) {
			   System.out.println("Unbalanced Node : "+n.data);
			   
			   
			   }
		   return true;
		   }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int size = input.nextInt();
		Node root = null;
		for(int i = 0; i<size;i++) {
			int data = input.nextInt();
			root = insert(root,data);
//			printLevelOrder(root);
		}
		
//		5 3 4 8 7 6 2 9                                      12 8 16 4 10 14 2 6 1
//		         5                                                    12
//		        /  \                                                 /  \
//		       3   8                                                8    16
//		      /\   /\                                              / \   /
//		     2  4 7  9                                            4  10 14
//		         /                                               / \ 
//		         6                                              2   6
//		                                                       /
//		                                                      1
		input.close();                           
//		root = new Node(10);
//		root.left = new Node(8);
//		root.right = new Node(12);
//		root.left.left = new Node(7);
//		root.left.left = new Node(5);
//		root.right.left = new Node(11);
//		root.right.right = new Node(13);
		printLevelOrder(root);
//		balance(root);
//		balanceBinaryTree(root);
	}

}
