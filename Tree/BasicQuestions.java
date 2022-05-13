package Tree;
public class BasicQuestions {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	static int max;
	static int maxElement(Node root) {
		if (root==null) {
			return 0;
		}
		if(root.data>max) {
			max=root.data;
		}
		maxElement(root.left);
		maxElement(root.right);
		return max;
	}
	
	static boolean searchElement(Node root,int val) {
		if(root==null) {
			return false;
		}
		if(root.data==val) {
			return true;
		}
		boolean Left=searchElement(root.left,val);
		boolean Right=searchElement(root.right,val);
		if(Left || Right) {
			return true;
		}
		return false;
	}
	
	static Node insertElementBT(Node root,int val) {
		if(root==null) {
			root= new Node(val);
			return root;
		}
		if(root.left==null) {
			root.left=new Node(val);
			return root;
		}
		if(root.right==null) {
			root.right=new Node(val);
			return root;
		}
		return root;
	}
	
	static int heightBT(Node root) {
		if(root==null) {
			return 0;
		}
		int left=heightBT(root.left);
		int right=heightBT(root.right);
		int max=Math.max(left, right);
		return max+1;
	}
	
	static int diameterBT(Node root) {
		if(root==null) {
			return 0;
		}
		int leftheight=heightBT(root.left);  //finding height of left subtree
		int rightheight=heightBT(root.right); //finding height of right sub tree
		int value1= leftheight+rightheight+1;
		int leftdia=diameterBT(root.left);
		int rightdia=diameterBT(root.right);
		int max=Math.max(Math.max(leftdia, rightdia), value1);
		return max;
	}
	
	static Node mirrorBT(Node root) {
		if(root==null) {
			return root;
		}
		Node L=mirrorBT(root.left);
		Node R=mirrorBT(root.right);
		root.left=R;
		root.right=L;
		return root;
	}
	
	
	static boolean isBST(Node root)   //fun for checking BT is BST or not
	{
	    if (root == null) {
	        return true;
	    }
	    /* False if left is > than node */
	    if (root.left != null && root.left.data > root.data) {
	        return false;
	    }
	    /* False if right is < than node */
	    if (root.right != null && root.right.data < root.data) {
	        return false;
	    }
	     //False if, recursively, the left or right is not a BST 
	    if (!isBST(root.left) || !isBST(root.right)) {
	        return false;
	    }
	    return true;
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
		
		System.out.println(maxElement(root));
		
		System.out.println(searchElement(root,4));
		
		//insertElementBT(root,25);
		System.out.println(heightBT(root));
		
		
	}

}
