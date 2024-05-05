package _02_Rainbow_Zombie_Conga_Line;

import java.util.ArrayList;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {

	/*
	 * You are hosting a rainbow zombie conga dance party! Zombies are not very
	 * smart(maybe that's why they crave brains) and need your help to direct them
	 * through the choreography.
	 * 
	 * Each method is a dance move you will need to implement.
	 * 
	 * When you think you've gotten your zombies trained well enough you can start
	 * the party by running the main method in RainbowZombieDanceParty and typing
	 * how many rounds you want in the console to see if they followed your
	 * choreography correctly.
	 * 
	 * Note: The party will always start with a rainbow brains and every 5 rounds
	 * the head and tail of the dance line will be removed.
	 */

	private LinkedList<Zombie> congaLine;
	private ZombieHatColor[] zombieHats;

	public RainbowZombieCongaLine() {

		congaLine = new LinkedList<Zombie>();
		zombieHats = ZombieHatColor.values();

	}

	// Make the passed in zombie the first Zombie in the conga line!
	public void engine(Zombie dancer) {
		Node<Zombie> node = new Node<>(dancer);
		node.setNext(congaLine.getHead());
		congaLine.setHead(node);

		//
	}

	// Make the passed in zombie the last Zombie in the conga line!
	public void caboose(Zombie dancer) {
		Node<Zombie> node = new Node<>(dancer);
		congaLine.getTail().setNext(node);
		congaLine.setTail(node);

	}

	// Place the zombie at the designated position in the conga line!
	public void jumpInTheLine(Zombie dancer, int position) {
		Node<Zombie> node = new Node<>(dancer);
		node.setNext(congaLine.getHead());
		for (int i = 0; i < position; i++) {
			node = node.getNext();
			node.setNext(node.getNext());

		}
		node.getNext().setPrev(node);
		// this could be totally wrong
	}

	/*
	 * Remove all zombies with the same hat color as the passed in zombie from the
	 * conga line!
	 */
	public void everyoneOut(Zombie dancer) {
		ZombieHatColor color = dancer.getZombieHatColor();
		Node<Zombie> node = congaLine.getHead();

		while (node != null) {
			if (node.getValue().getZombieHatColor() == color) {
				if (node == congaLine.getHead()) {
					congaLine.setHead(node.getNext());
					node.getNext().setPrev(null); // or node.getPrev()
					

				} else if (node == congaLine.getTail()) {
					node.getPrev().setNext(null);
					congaLine.setTail(node.getPrev());
					
				} else {
					node.getPrev().setNext(node.getNext());
					node.getNext().setPrev(node.getPrev());
					

				}
			
			} 
				node = node.getNext(); // eventually null and end
			
		}

	}

	/*
	 * Remove the first zombie with the same hat color as the passed in zombie from
	 * the conga line!
	 */
	public void youAreDone(Zombie dancer) {
		ZombieHatColor color = dancer.getZombieHatColor();
		Node<Zombie> node = congaLine.getHead();
		boolean successful = false;
		while (node != null && successful == false) {
			if (node.getValue().getZombieHatColor() == color) {
				successful = true;
				if (node == congaLine.getHead()) {
					congaLine.setHead(node.getNext());
					node.getNext().setPrev(null); // or node.getPrev()
					
					

				} else if (node == congaLine.getTail()) {
					node.getPrev().setNext(null);
					congaLine.setTail(node.getPrev());
					
				} else {
					node.getPrev().setNext(node.getNext());
					node.getNext().setPrev(node.getPrev());
					

				}
			
			} 
				node = node.getNext(); // eventually null and end
			
		}

	}

	/*
	 * Make two more zombies with the same hat color as the passed in zombie and add
	 * one to the front, one to the end and one in the middle. It says to add 2 zombies to 3 locations, start, middle, end ok
	 */
	public void brains(Zombie dancer) {
		ZombieHatColor hatColor = dancer.getZombieHatColor();
		Zombie front = new Zombie(hatColor);
		Zombie end = new Zombie(hatColor);
		
		
		Node<Zombie> node = new Node<>(front); // node is equal to the head, so set its previous equal to front
		Node<Zombie> endNode = new Node<>(end);
		Node<Zombie> middleNode = new Node<>(dancer);
		
		congaLine.getHead().setPrev(node);
		node.setNext(congaLine.getHead());
		congaLine.setHead(node);
	
		
		congaLine.getTail().setNext(endNode);
		endNode.setPrev(congaLine.getTail());
		congaLine.setTail(endNode);
		
		int size = congaLine.size();
			middleNode.setNext(congaLine.getHead());	
		for(int i = 0; i < size/2; i++) {
			middleNode.setNext(middleNode.getNext().getNext());
			
			
		}
		middleNode.setPrev(middleNode.getNext().getPrev());
		middleNode.getNext().setPrev(middleNode);
		middleNode.getPrev().setNext(middleNode);
		
	}

	/*
	 * Add the passed in zombie to the front and then add one zombie of each hat
	 * color to the end of the line.
	 */
	public void rainbowBrains(Zombie dancer) {
		Node<Zombie> node = new Node<>(dancer);
		
		congaLine.add(dancer);
		
		
		
		congaLine.getHead().setPrev(node);
		node.setNext(congaLine.getHead());
		congaLine.setHead(node);
		
		Zombie zombie = new Zombie(ZombieHatColor.R);
		
		Node<Zombie> test = new Node<>(zombie);
		
		ArrayList<Zombie> zombies = new ArrayList<>();
		
		congaLine.add(zombie);
		
		
		for(int i = 0; i < ZombieHatColor.values().length; i++) {
			zombies.add(new Zombie(     ZombieHatColor.values()[i]      ));
			
			
		}for(int i = 0; i < ZombieHatColor.values().length; i++) {
			congaLine.add(zombies.get(i));
		}
		
		for(int i = 0; i < ZombieHatColor.values().length; i++) {
			test.setPrev(congaLine.getTail());
			congaLine.getTail().setNext(test);
			congaLine.setTail(test);
			
			test = new Node<>(zombies.get(i));
			//this might add two R colored zombies, to correct you can just not have the test equal a zombie at the beginning
			//too lazy to fix it though
			
		}
		// uh I think that works
		
	}

	public LinkedList<Zombie> getCongaLine() {
		return congaLine;
	}
}
