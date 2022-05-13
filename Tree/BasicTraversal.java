package Tree;
import java.util.*;
public class BasicTraversal {
	static int count=0;
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	static void preorder(Node root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");     // 10 20 40 50 30
		preorder(root.left);
		preorder(root.right);
	}
	
	
//	static ArrayList<integer> itterativePreorder(Node root){
//		ArrayList<integer> res =new ArrayList<integer>();
//	}
	
	static void inorder(Node root) {
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");    //40 20 50 10 30
		inorder(root.right);
	}
   
	static void postorder(Node root) {
		if(root==null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");    //40 50 20 30 10
	}
	
	static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<Node>(); 
		
		q.offer(root);
		while(!q.isEmpty()) {
			Node temp=q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null) {
				q.offer(temp.left);
			}
			if(temp.right!=null) {
				q.offer(temp.right);
			}
		}
	}
	
	static void levelorderReverseorder(Node root) {    //70 60 50 40 30 20 10 
		Stack<Node> s = new Stack<>();
	    Queue<Node> q = new LinkedList<>();
	    Node temp;
	    q.offer(root);
	    while(!q.isEmpty()) {
			temp=q.poll();
			s.push(temp);
			//System.out.print(temp.data+" ");
			if(temp.right!=null) {
				q.offer(temp.left);
			}
			if(temp.left!=null) {
				q.offer(temp.right);
			}
		}
	    while (!s.isEmpty()) {
	        temp = s.pop();
	        System.out.print(temp.data + " ");
	    }
	}
	static void spiralOrder(Node root) {
		Queue<Node> q = new LinkedList<Node>(); 
		
		q.offer(root);
		while(!q.isEmpty()) {
			Node temp=q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null) {
				q.offer(temp.right);
			}
			if(temp.right!=null) {
				q.offer(temp.left);
			}
		}
	}
	
	static int CountNode(Node root) {
		if(root==null)
			return 0;
		count=count+1;
		CountNode(root.left);
		CountNode(root.right);
		return count;
	}
	
	static int LeafNode(Node root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null) {
			count=count+1;	
		}
		LeafNode(root.left);
		LeafNode(root.right);
		return count;
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
		
//		preorder( root);
//		System.out.println("preorder");
//		
//		inorder(root);
//		System.out.println("inorder");
//		
//        postorder(root);
//        System.out.println("postorder");
        
        //System.out.println(CountNode(root));
       // System.out.println("No of leaf node:"+LeafNode(root));
        
//        System.out.print("Level order:");
//        levelOrder(root);
//        System.out.println();
//        System.out.print("Spiral order:");
//        spiralOrder(root);
        System.out.println("levelorderReverseorder:");
        levelorderReverseorder(root);
	}

}
