package Tree;

import java.util.*;

public class AVltree {
	
	public static class Node{
		int data=0;
		Node left=null;
		Node right=null;
		
		int height=0;
		int bf=0;
		
		public Node(int data) {
			this.data=data;
		}
		
	}
	
	public static void updateHeightAndBalance(Node root) {    //O(1)
		int leftheight=-1;
		int rightheight=-1;
		
		if(root.left!=null) {
			leftheight=root.left.height;
		}
		if(root.right!=null) {
			rightheight=root.right.height;
		}
		int bf=leftheight-rightheight;
		int height=Math.max(leftheight,rightheight)+1;
		
		root.height=height;     //updating height
		root.bf=bf;
	}
	
	public static Node LLstr_rightrotation(Node A) {        //        A          
		Node B=A.left;                                      //       / \            B
		Node B_right=B.right;                               //      B   1          / \
		                                                    //     / \    =>      C   A
		B.right=A;                                          //    C   2          / \ / \
		A.left=B_right;                                     //   / \            3  4 2   1
	                                                        //  3   4
		updateHeightAndBalance(A);
		updateHeightAndBalance(B);
		
		return B;
	}                                                       
	
	
	
	public static Node RRstr_leftrotation(Node A) {         //  A                
		Node B=A.right;                                     //   \              B
		Node B_left=B.left;                                //     B    =>      / \
		                                                    //     \          A   C
		B.left=A;                                          //       C
		A.left=B_left;
		
		updateHeightAndBalance(A);
		updateHeightAndBalance(B);
		
		return B;
	}
	
	public static Node rotateNode(Node root) {
		updateHeightAndBalance(root);
		if(root.bf==2) {                   //LL,LR
			if(root.left.bf==1) {          //LL
				LLstr_rightrotation(root);
			}
			else {                         //LR
				root.left=RRstr_leftrotation(root.left);
				return LLstr_rightrotation(root);
			}
		}
		else if(root.bf==-2) {            //RR,RL
			if(root.right.bf==-1) {       //RR
				RRstr_leftrotation(root);
			}
			else {                         //RL
				root.right=LLstr_rightrotation(root.right);
				return RRstr_leftrotation(root);
			}
		}
		return root;
	}
	
	public static Node insertData(Node root,int data) {
		if(root==null) {
			return new Node(data);
		}
		if(data<root.data) {
			root.left=insertData(root.left,data);
		}
		else if(data>root.data) {
			root.right=insertData(root.right,data);
		}
		
		root=rotateNode(root);
		return root;
	}
	
	public static Node getMaximumNode(Node root) {
		Node temp=root;
		while(temp.right!=null) {
			temp=temp.right;
		}
		return temp;
	}
	
	public static Node DeleteData(Node root,int data) {
		if(root==null) {
			return root;
		}
		if(data<root.data) {
			root.left=DeleteData(root.left,data);
		}
		else if(data>root.data) {
			root.right=DeleteData(root.right,data);
		}
		else if(data==root.data){
			if(root.left==null || root.right==null) {
				if(root.left!=null) {
					return root.left;
				}
				else {
					return root.right;
				}
			}
			Node maxNode=getMaximumNode(root.left);
			root.data=maxNode.data;
			root.left=DeleteData(root.left,maxNode.data);
		}
		
		root=rotateNode(root);
		return root;
	}
	
	
	public static void preorder(Node root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");     
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void display(Node root) {
		if(root==null) {
			return;
		}
		String str=" ";
		str += root.left!=null? root.left.data + " " : ".";
		str += " <- " + root.data + " -> ";
		str += root.right!=null? root.right.data + " " : ".";
		System.out.println(str);
		
		display(root.left);
		display(root.right);
	}
	
//	public static void solve() {
//		int[] arr= {10,20,30,40,50,60,70,80,90,100};
//		Node root=null;
//		for(int i:arr) {
//			root=insertData(root,i);
//		}
//		display(root);
//		System.out.println("-------------------------------------------");
//		System.out.println();
//		
//		for(int j=arr.length-1;j>=0;j--) {
//			root=DeleteData(root,arr[j]);
//			display(root);
//			
//			System.out.println("=======================================");
//		}
//	}

	public static void main(String[] args) {
		int[] arr= {10,20,30,40,50,60,70,80,90,100};
		Node root=null;
		for(int i:arr) {
			root=insertData(root,i);
		}
		display(root);
		System.out.println("-------------------------------------------");
		System.out.println();
		
		for(int j=arr.length-1;j>=0;j--) {
			root=DeleteData(root,arr[j]);
			display(root);
			
			System.out.println("=======================================");
		}
	}
}
