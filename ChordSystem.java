import java.util.*;
import java.io.*;

public class ChordSystem {
	public static void main(String []args){
		System.out.println("Starting Chord System...");
	}
}

class Node {
	private ArrayList <Finger> finger_table;

/*
 * Constructor
 *
 */	
	public Node(){
		this.finger_table = new ArrayList <Finger> ();	
	}

/*
 * Function to call updateSuccessor() in all the Fingers`
 *
 *
 */	
	public void updateFingerTable(){
		
	}

}

class Finger {

	private int m = 0;
	private int successor = 0;
	private String data_key = "";

	public Finger (int m){
		this.m = m;
	}

/*
 * This function update the successor of the finger
 * 
 *
 */
	public void updateFinger(){
		
	}
}
