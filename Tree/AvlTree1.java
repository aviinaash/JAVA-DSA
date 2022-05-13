package Tree;
import java.util.*;
public class AvlTree1 {
	public static class Node{
		int data,height;
		Node left;
		Node right;
		public int val;
		public Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	
	Node root;
    static Node insertElement(Node root,int val) { //normal BST  insertion
    	if(root==null) {
    		Node temp = new Node(val);
    		root = temp;
    		return root;
    	}
    	else {
    		if(root.data>val) {
    			root.left = insertElement(root.left,val);
    		}
    		else if(root.data<val){
    			root.right  = insertElement(root.right,val);
    		}
 
    	}
    	root.height = 1 + Math.max(Height(root.left),
        Height(root.right));
        int balance = BalanceFactor(root);
        if (balance > 1 && val < root.left.val) {
        return rightRotate(root);
        }
        if (balance < -1 && val > root.right.val) {
         return leftRotate(root);
        }
        if (balance > 1 && val > root.left.val) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
      }
     if (balance < -1 && val < root.right.val) {
     root.right = rightRotate(root.right);
     return leftRotate(root);
     }

    return root;
    }
   
	//Finding balance factor of node
	static int BalanceFactor(Node root) {
		if(root==null) {
			return 0;
		}
		return Height(root.left) - Height(root.right);
	}
	
	
  //Fun for checking node is balance or not   
  public static void balance(Node root) {
  	if(root == null) {
  		return;
  	}
  	else {
  		int l = BalanceFactor(root.left);
  		int r = BalanceFactor(root.right);
  		System.out.println(l+" "+r);
  		if(l>1 && l<-1) {
  			System.out.println(root.data);
  		}
  		if(r>1 && r<-1) {
  			System.out.println(root.data);
  		}
  	}
  }
  
	
	static int Height(Node root) {
		if(root==null) {
			return 0;
		}
		else {
			int LD=Height(root.left);
			int RD=Height(root.right);
			if(LD>RD) {
				return (LD+1);
			}
			else {
				return (RD+1);
			}
		}
	}
	
	
	//Fuction for left left rotate
	static Node LLrotate(Node root) {    //right rotation
		if(root==null) {
			return root;
		}
		else {
			Node temp = root;
    		root = root.left;
    		temp.left = root.right;
    		root.right = temp;
    		return root;
		}
	}
	
	
	//Fuction for right right rotate
		static Node RRrotate(Node root) {   //left rotation
		  	if(root==null) {
		  		return root;
		  	}
		  	else {
		  		Node temp = root;
		  		root = root.right;
		  		temp.right = root.left;
		  		root.left = temp;
		  		return root;
		  	}
		  	
		  }
	
	//Fuction for left right rotate
	static Node LRrotate(Node root) {
		root.left = LLrotate(root.left);     //first right then left rotation 
    	return RRrotate(root);
	}
	
	//Fuction for right left rotate
	static Node RLrotate(Node root) {
		root.right = RRrotate(root.right);   //first left then right rotation 
		return LLrotate(root);
	  }

	
	//2nd md for left rotate
	static Node leftRotate(Node root) {
        Node temp = root.right;
        Node temp2 = temp.left;
 
        temp.left = root;
        root.right = temp2;
 
        root.height = Math.max(Height(root.left), Height(root.right)) + 1;
        temp.height = Math.max(Height(temp.left), Height(temp.right)) + 1;
 
        return temp;
    }
	
	//2nd md for right rotate
		static Node rightRotate(Node root) {
	        Node temp = root.right;
	        Node temp2 = temp.left;
	 
	        temp.right = root;
	        root.left = temp2;
	 
	        root.height = Math.max(Height(root.left), Height(root.right)) + 1;
	        temp.height = Math.max(Height(temp.left), Height(temp.right)) + 1;
	 
	        return temp;
	    }
	
		//level order traversal
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
		
		
		static Node minValueNode(Node root)      /* loop down to find the leftmost leaf */
	    {
	        Node temp = root;
	        while (temp.left != null)
	        temp = temp.left;
	 
	        return temp;
	    }
		
		static Node deleteNode(Node root, int val)
	    {
			if (root == null)
	            return root;
	        if (val < root.val)
	            root.left = deleteNode(root.left, val);
	        else if (val > root.val)
	            root.right = deleteNode(root.right, val);
	        else
	        {
	 	         if ((root.left == null) || (root.right == null))
	            {
	                Node temp = null;
	                if (temp == root.left) {
	                    temp = root.right;
	                }
	                else {
	                    temp = root.left;
	                }
	 
	                if (temp == null)
	                {
	                    temp = root;
	                    root = null;
	                }
	                else 
	                    root = temp;
	            }
	            else
	            {
	                Node temp = minValueNode(root.right);
	 	            root.val = temp.val;
	 	            root.right = deleteNode(root.right, temp.val);
	            }
	        }
	 	        if (root == null) {
	            return root;
	 	        }
	 
	        root.height = Math.max(Height(root.left), Height(root.right)) + 1;
	        int balance = BalanceFactor(root);
	        if (balance > 1 && BalanceFactor(root.left) >= 0) {
	            return rightRotate(root);
	        }
	 	    if (balance > 1 && BalanceFactor(root.left) < 0)
	        {
	            root.left = leftRotate(root.left);
	            return rightRotate(root);
	        }
	        if (balance < -1 && BalanceFactor(root.right) <= 0) {
	            return leftRotate(root);
	        }
	 
	        if (balance < -1 && BalanceFactor(root.right) > 0)
	        {
	            root.right = rightRotate(root.right);
	            return leftRotate(root);
	        }
	 
	        return root;
	    }
	
	public static void main(String[] args) {
        AvlTree1 tree = new AvlTree1();
        tree.root = AvlTree1.insertElement(tree.root, 10);
        tree.root = AvlTree1.insertElement(tree.root, 20);
        tree.root = AvlTree1.insertElement(tree.root, 30);
        tree.root = AvlTree1.insertElement(tree.root, 40);
        tree.root = AvlTree1.insertElement(tree.root, 50);
        tree.root = AvlTree1.insertElement(tree.root, 60);
        tree.root = AvlTree1.insertElement(tree.root, 15);
        tree.root = AvlTree1.insertElement(tree.root, 70);
        tree.root = AvlTree1.insertElement(tree.root, 5);
        AvlTree1.levelOrder(tree.root);
        
	}

}
