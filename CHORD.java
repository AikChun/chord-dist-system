import java.util.*;
import java.io.*;

/**
 * CHORD class
 */
public class CHORD {
	private LinkedHashMap <Integer, Node> map;
	private int m = 0;
	
	/**
	 * Constructor 
	 * @param m  -  The M value of chord system
	 */
	public CHORD (int m) {
		this.map = new LinkedHashMap <Integer, Node> ();
		this.m = m;
	} 

	/**
	 * function to insert a node into the system.
	 * @param node_position - integer value of the node's position
	 */
	public void addPeer(int node_position) {
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
		if(args.length < 1) {
	 		System.out.println("Please specify filename.");	
		} else if (args.length >1){
			System.out.println("too many argument. Please specify one filename.");	
		} else {
			read(args[0]);
		}
	}
	private static void read(String filename) {
		try {
			File file = new File(filename);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = br.readLine()) != null) {
				String []incoming_line = line.split("\\s+");
				//System.out.println(line);
				interpretCommand(incoming_line);
			}
		} catch (FileNotFoundException e) {
		
		} catch (IOException ioe) {
		
		}
	}
	private static void interpretCommand(String []command) {
		boolean error_in_command = false;
		int input_value = 0;

		if(command.length < 2) {
			error_in_command = true;
		}

		try {
			input_value = Integer.parseInt(command[1]);
		} catch (NumberFormatException e){
			error_in_command = true;	
		}

		if(!error_in_command) { // if there are no errors in received commands so far
			if (command[0].equalsIgnoreCase("init")) {
				if(command.length == 2) {
					System.out.println("Command: " + command[0]);
					System.out.println("value: " + input_value);
					//CHORD.init(Integer.parseInt(command[1]));
				}
			} else if (command[0].equalsIgnoreCase("addpeer")) {
				System.out.println("Command: " + command[0]);
				System.out.println("value: " + input_value);
				//addPeer(id);

			} else if(command[0].equalsIgnoreCase("insert")) {
				if(command.length > 2) {
					StringBuilder sb = new StringBuilder();
					for(int i=2;i<command.length;i++){
						sb.append(command[i]);
						if(i!=command.length-1) {
							sb.append(" ");
						}
					}
					String node_name = sb.toString();

					System.out.println("Command: " + command[0]);
					System.out.println("value :" + input_value);
					System.out.println("data key: " + node_name);
					//insert(id, node_name);
				} 
			} else if(command[0].equalsIgnoreCase("removepeer")) {
				if(command.length ==  2) {
					System.out.println("Command: " + command[0]);
					System.out.println("value: " + input_value);
					//removePeer(input_value);
				}	
			} else if(command[0].equalsIgnoreCase("print")) {
				if(command.length ==  2) {
					System.out.println("Command: " + command[0]);
					System.out.println("value: " + input_value);
					//printNode(input_value);
				}	
			
			} else if(command[0].equalsIgnoreCase("delete")) {
				if(command.length ==  2) {
					System.out.println("Command: " + command[0]);
					System.out.println("value: " + input_value);
					//deleteNode(input_value);
				}	
			
			}
		}
	} //end of interpretCommand()
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

