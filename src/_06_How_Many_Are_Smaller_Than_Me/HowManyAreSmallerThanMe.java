package _06_How_Many_Are_Smaller_Than_Me;

import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

    /*
     * Given an AVLTree filled with the random numbers from 1 to 20, and a
     * single number within the AVL Tree, figure out how many numbers in the
     * AVLTree are smaller than the provided number and return the result.
     * 
     * You may want to create a helper method to search through the AVLTree and
     * count iteratively or recursively.
     */
	int count = 0;
    public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {
    	System.out.println(avlTree.getRoot().getValue());
    	System.out.println(me);
    	
    	//make a thing that goes forward, searches right and left, and if they don't have any more branches, then go backwards. 
    	//when going backwards, always go the opposite direction from where you came
    	//if number is smaller, add to count, and return count. 
    	AVLNode<Integer> node = avlTree.getRoot();
    	
    	
    	
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
    	
        return count;

    }
    public void thing(AVLNode<Integer> node, int me){
    	
    		if(node.getValue() == me) { // node is equal to the value we want
    			if(node.getLeft() == null) {// get left is null, so we gotta go backwards
    				if(node.getHeight() !=0) {
    					node.setHeight(node.getHeight()-1);
        				thing(node, me);
    				}else {
    					//do nothing, we know we have reached the end. 
    				}
    				
    				
    			}else {
    				count++;
    				thing(node.getLeft(), me);
    			}
    		}else { // node value not equivalent to what we want
    			if(node.getValue() > me){// node is greater than the value we want, go left until you can't no more
    				if(node.getLeft() == null) {
    					//no damn idea what I'm doing but I think it's right. 
    				}
    			}else{
    				
    			}
    			 {
    				
    			}
    		
    			
    	}
    	
    }

}
