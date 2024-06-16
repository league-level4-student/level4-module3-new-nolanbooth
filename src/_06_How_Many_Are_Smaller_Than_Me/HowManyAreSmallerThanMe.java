package _06_How_Many_Are_Smaller_Than_Me;

import java.util.HashMap;

import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

	/*
	 * Given an AVLTree filled with the random numbers from 1 to 20, and a single
	 * number within the AVL Tree, figure out how many numbers in the AVLTree are
	 * smaller than the provided number and return the result.
	 * 
	 * You may want to create a helper method to search through the AVLTree and
	 * count iteratively or recursively.
	 */
	int count = 0;
	HashMap<Integer, Boolean> h = new HashMap<>();

	// true means visited.
	public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {
		//System.out.println(avlTree.getRoot().getValue());
		System.out.println("We want numbers smaller than: " + me);

		// make a thing that goes forward, searches right and left, and if they don't
		// have any more branches, then go backwards.
		// when going backwards, always go the opposite direction from where you came
		// if number is smaller, add to count, and return count.
		AVLNode<Integer> node = avlTree.getRoot();

		thing(node, me, avlTree);

//    	if(node.getValue() == me) { 
//    		if(node.getLeft() != null) {
//    			count++;
//    		}else {
//    			if(node.getHeight() != 0) {
//    				node.setHeight(node.getHeight()-1);
//    			}
//    		}
//    		
//    	}
		System.out.println("smaller than me: " + count);
		return count;

	}

	public void thing(AVLNode<Integer> node, int me, AVLTree<Integer> avlTree) {

		h.put(node.getValue(), true);
		// setting current node to visited.

		if (node.equals(avlTree.getRoot()) || node.getHeight() == 0) {// node is root
			if (node.getValue() >= me) { // root's value is greater (or equal), thus set right root to visited, will not
											// travel down there
				h.put(node.getRight().getValue(), true);

			}
			if (node.getLeft() != null && !h.containsKey(node.getLeft().getValue())) { // get left exists and is not on
																						// the hashmap
				
				//h.put(node.getLeft().getValue(), true); // setting left node to visited. (shouldn't be necessary)
				thing(node.getLeft(), me, avlTree); // recursive.

			}if(node.getRight() != null && !h.containsKey(node.getRight().getValue())) {
				thing(node.getRight(), me, avlTree);
				
			}
			if (node.getValue() < me) { // gotta count the root if it is smaller than me.
				count++;
			}
			if (node.getLeft() == null) {
				// terminate this "thing" method or something, maybe do nothing.

			}

		} else { // node not root, meaning height is not 0
			if(node.getValue() < me) {
				count++;
			}
			
			if (node.getLeft() != null && !h.containsKey(node.getLeft().getValue())) { // we know left unexplored
				
				thing(node.getLeft(), me, avlTree); // recursive
				
			}if(node.getRight() != null && !h.containsKey(node.getRight().getValue())) { // right unexplored. 
				thing(node.getRight(), me, avlTree);
			}else {
				node.setHeight(node.getHeight()-1); // kicks back
			}
		}
	}

}
