package _04_Morse_Code;

import javax.swing.JOptionPane;

import _00_Intro_to_Linked_Lists.Node;
import _03_Intro_to_Binary_Trees.BinaryTree;

public class MorseDecoder {

    BinaryTree<MorseCode> mcTree = new BinaryTree<MorseCode>();

    public static void main(String[] args) {

        MorseDecoder md = new MorseDecoder();
        md.initialize();
        md.decode();

    }

    public void initialize() {

        mcTree.insert(new MorseCode("start", ""));
        mcTree.insert(new MorseCode("e", "."));
        mcTree.insert(new MorseCode("t", "-"));

        mcTree.insert(new MorseCode("i", ".."));
        mcTree.insert(new MorseCode("a", ".-"));
        mcTree.insert(new MorseCode("n", "-."));
        mcTree.insert(new MorseCode("m", "--"));

        mcTree.insert(new MorseCode("s", "..."));
        mcTree.insert(new MorseCode("u", "..-"));
        mcTree.insert(new MorseCode("r", ".-."));
        mcTree.insert(new MorseCode("w", ".--"));
        mcTree.insert(new MorseCode("d", "-.."));
        mcTree.insert(new MorseCode("k", "-.-"));
        mcTree.insert(new MorseCode("g", "--."));
        mcTree.insert(new MorseCode("o", "---"));

        mcTree.insert(new MorseCode("h", "...."));
        mcTree.insert(new MorseCode("v", "...-"));
        mcTree.insert(new MorseCode("f", "..-."));
        mcTree.insert(new MorseCode("l", ".-.."));
        mcTree.insert(new MorseCode("p", ".--."));
        mcTree.insert(new MorseCode("j", ".---"));
        mcTree.insert(new MorseCode("b", "-..."));
        mcTree.insert(new MorseCode("x", "-..-"));
        mcTree.insert(new MorseCode("c", "-.-."));
        mcTree.insert(new MorseCode("y", "-.--"));
        mcTree.insert(new MorseCode("z", "--.."));
        mcTree.insert(new MorseCode("q", "--.-"));

        mcTree.printVertical();

    }

    /*
     * 1.) See if you can decode the following message using the binary tree and
     * print it to the console:
     * 
     * -.-- --- ..- .- .-. . .- -- .- --.. .. -. --.
     * 
     * 2.) Then use the binary tree and the scanner class to create a morse code
     * translator. The user should be able to type multiple letters in morse
     * code on a single line and have it repeated back to them, decoded into the
     * English alphabet.
     * 
     */
    void decode() {
        String morseCode = JOptionPane.showInputDialog("Enter morse code");
        String noah = ""; 
        
        
        _03_Intro_to_Binary_Trees.Node<MorseCode> current = mcTree.getRoot();
        if(current != null) {
        	//System.out.println("Current exists");
        }
       
       
        String[] letters = morseCode.split(" ");
        for(int i = 0; i < letters.length; i++) {// runs for the amount of letters
        	
        	for(int j = 0; j < letters[i].length(); j++) { //runs for the specific amount of Morse codes there are
        		
        		if(letters[i].charAt(j) == '-' && current != null) {
        			current = current.getRight();
        			
        			
        			
            	}else if(letters[i].charAt(j) == '.' && current != null) {
            			current = current.getLeft();
            		
            		
            	}
        	}
        	System.out.print(current.getValue());
        	
        	noah = noah + current.getValue();
        	
        	current = mcTree.getRoot();
        	
        	
        	
        	
        }
        JOptionPane.showMessageDialog(null, noah);
    }

}
