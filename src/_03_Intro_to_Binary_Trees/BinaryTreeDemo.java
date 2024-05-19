package _03_Intro_to_Binary_Trees;

public class BinaryTreeDemo {

    /*
     * A Binary Tree is a data structure that makes use of nodes and references
     * like a LinkedList, but instead of the nodes pointing to a previous node
     * or next node in an unorderd list they each points to two child nodes that
     * are below them in the hierarchy.
     * 
     * Some important properties of BinaryTree are:
     * 
     * -The left node is always a smaller value than its parent and the right
     * node is always a larger value. This is a property you have seen in some
     * form already via Binary Search.
     * 
     * -Empty nodes are null references.
     * 
     * -The parent node at the very top of the tree is called the root.
     * 
     * 1. Read through the BinaryTree and Node classes.
     * 
     * 2. Create a BinaryTree of any type you like.
     * 
     * 3. Try using some BinaryTree methods to insert, search for, delete and
     * print elements.
     * 
     * 4. Save the root into a Node Object and use references to traverse
     * through the BinaryTree and perform an operation on every element(You may
     * choose to do this recursively or iteratively). Then print it out to see
     * if it worked.
     * 
     */

    public static void main(String[] args) {

    	BinaryTree<Integer> noah = new BinaryTree<>();
    	
    	for(int i = 5; i < 10; i++) {
    		noah.insert(i);
    	}
    	noah.insert(-4);
    	noah.insert(-3);
    	Node<Integer> root = noah.getRoot();
    	noah.insert(-1);
    	System.out.println(root.getRight());
    	//noah.insert(6);
//    	noah.search(5); //returns the node i believe
//    	noah.delete(5);
//    	noah.search(5);
    	noah.printVertical();
    	for(int i = 0; i < 3; i++) {
    		root.setValue(root.getValue() + 1);
    		if(root.getRight() == null && root.getLeft().equals(null)) {
    			root = noah.getRoot();
    			
    		}
    		//basically go to the right, and if the right doesn't exist, go to the left, and if that doesn't exist, go back one.
    		//After this you basically just check if the thing has already been visited, and then yeah, keep going back and forwards
    		//until you are finished. 
    	}
    	noah.printVertical();
    	//noah.notifyAll();// I wonder what this does
    }

}
