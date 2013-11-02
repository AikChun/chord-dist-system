import java.util.*;
import java.io.*;

/**
 * ChordSystem class
 */
public class ChordSystem {
	private LinkedHashMap <Integer, Node> map;
	private int m = 0;
	
	/**
	 * Constructor 
	 * @param m  -  The M value of chord system
	 */
	public ChordSystem (int m) {
		this.map = new LinkedHashMap <Integer, Node> ();
		this.m = m;
	} 

	/**
	 * function to insert a node into the system.
	 * @param node_position - integer value of the node's position
	 */
	public void insertNode(int node_position) {
		this.map.put(node_position , new Node(node_position, this.m));
	}

	/**
	 * prints out all the Nodes in the system
	 */
	public void printNodes() {
		// cycle through nodes
		for(Map.Entry <Integer, Node> i: map.entrySet()) {
			int node_key = i.getKey();
			Node node_value = i.getValue();
			// print out next_node
			System.out.println("================================================================================");
			System.out.println("Node index: " + node_key);
			System.out.println("*****");
			node_value.printNextNodes();
			System.out.println("================================================================================");
		}
	}

	/**
	 * main function
	 */
	public static void main(String []args){
		System.out.println("Starting Chord System...");
		System.out.print("Enter the value for m: ");
		Scanner input = new Scanner (System.in);
		int m = input.nextInt();
		ChordSystem system = new ChordSystem(m);
		// Now you can insert nodes using system.insertNode()
		// print attributes of all nodes using system.printNodes()
	}
}

/**
 * Node Class
 */
class Node {
	private int node_position = 0;
	private ArrayList <Finger> finger_table;

	/**
	 * Constructor specifying node position
	 * @param node_position - integer value of the node's position.
	 * @param m - integer value of the 'm' value of the system
	 */	
	public Node(int node_position, int m){
		this.finger_table = new ArrayList <Finger> ();	
		// populate finger_table once the node is created.
		this.populateFingerTable(m);
	}

	/**
	 * populate the finger table.
	 * @param m - Integer value of 'm' of the system.
	 */
	public void populateFingerTable(int m) {
		for(int i=1;i<=m;i++) {
			this.finger_table.add(new Finger(i));
		}
	}

	/**
	 * Prints out all Fingers "next_node" column.
	 */
	public void printNextNodes() {
		for(int i=0;i<this.finger_table.size(); i++) {
			Finger temp = this.finger_table.get(i);
			System.out.println("Node :" + temp.getIndex() + "\n" + "next_node: " + temp.getNextNode());
		}
	}

	/**
	 * Function to call updateSuccessor() in all the Fingers`
	 */	
	public void updateFingerTable(){
		
	}

	/**
	 * sub-class Finger
	 */
	class Finger {
		private int index = 0;
		private int next_node = 0; // the supposed next node to go to.
		private int successor = 0;
		private String data_key = "";

		/**
		 * Constructor specifying index position
		 * @param i - Integer value of the finger's index.
		 */
		public Finger (int i){
			this.index = i;
			this.generateNextNodes();
		}

		/**
		 * Function to calculate the supposed next node to go.
		 */
		private void generateNextNodes(){
			this.next_node = index + ((int) Math.pow(2, index-1));
		}

		/**
		 * This function update the successor of the finger
		 */
		public void updateSuccessor(){
			
		}

		public int getIndex() {
			return this.index;
		}

		public int getNextNode() {
			return this.next_node;
		}

		public String getDatakey() {
			return this.data_key;
		}
	}
}

