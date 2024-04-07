package _01_Spies_On_A_Train;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    Node<TrainCar> node = train.getHead();
    String pieClue = "";
    String phoneClue = "";
    String briefcaseClue = "";
    
    String[] clue1 = clues[0].split(" ");
    for(int i = 0; i < clue1.length; i++) {
    	if(clue1[i].equalsIgnoreCase("a")) {
    		pieClue = clue1[i+1];
    		System.out.println(pieClue);
    	}
    }
    String[] clue2 = clues[1].split(" ");
    for(int i = 0; i < clue2.length; i++) {
    	if(clue2[i].equalsIgnoreCase("model")) {
    		phoneClue = clue2[i+1];
    		System.out.println(phoneClue);
    	}
    }
    String[] clue3 = clues[2].split(" ");
    
    for(int i = 0; i < clue3.length; i++) {
    	if(clue3[i].equalsIgnoreCase("a")) {
    		briefcaseClue = clue3[i+1];
    		System.out.println(briefcaseClue);
    	}
    }
    // clue1 sometimes is not a thing (pieClue) spies not always eating pie I guess
    	//a + clue
    	// model + clue
    	// a + clue
    	
    
//    	for(int i = 0; i < train.size(); i++) {
//    		String thing = node.getValue().questionPassenger();
//    		String name = "";
//    		String[] words = thing.split(" ");
//    			for(int k = 0; k < words.length; k++) {
//    			if(words[i].equalsIgnoreCase("saw")) {
//    				name = words[i+1];
//    				System.out.println(name);
//    			}
//    			}
//    			
//    	
//    		node = node.getNext();
//    		
//    	}
    	HashMap<String, Integer> votesVsPeople = new HashMap<>();
    	for(int i = 0; i < train.size(); i++) {
    		String testimony = node.getValue().questionPassenger();
    		
    		if(testimony.contains(briefcaseClue) || testimony.contains(phoneClue) || testimony.contains(pieClue)) {
    			String[] words = testimony.split(" ");
    			for(int k = 0; k < words.length; k++) {
    				if(words[k].equalsIgnoreCase("saw")) {
    					//increase score of somebody
    					String name = words[k+1];
    					System.out.println(name);
    					if(votesVsPeople.containsKey(name)) {
    						votesVsPeople.replace(name, (votesVsPeople.get(name) + 1) );
    					}else {
    						votesVsPeople.put(name, 1);
    					}
    				}
    			}
    			
    		}
    		//if the pie clue exists, not null, then we ask the passenger who he saw eating the pie. then we add one to the score - hashmap for score
    		node = node.getNext();
    	}
    	
    		String theGuy = "";
    		System.out.println("values :" + votesVsPeople.values());
    		int maxValueInMap=(Collections.max(votesVsPeople.values()));  // This will return max value in the HashMap
            for (Entry<String, Integer> entry : votesVsPeople.entrySet()) {  // Iterate through HashMap
                if (entry.getValue()==maxValueInMap) {
                    theGuy = entry.getKey();
                	System.out.println(entry.getKey());     // Print the key with max value
                }
            }
    	// if entry not allowed, then go through all the keys, keep track of the largest value (list of keys)
    	
            //use them to pull out associated value in map - > eventually get largest entry. 
        return theGuy;

    }

}
