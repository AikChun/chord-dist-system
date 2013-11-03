import java.util.*;
import java.io.*;

/**
 * CHORD class
 */
public class CHORD {
	private final static student_name = "Sim Aik Chun";
	private final static student_number = "4234716";
	private static CHORD instance = null;
	private LinkedHashMap <Integer, NODE> map;
	private int n = 0; // size of chord (number of nodes)
	private int k = 0; // size of finger table
	
	/**
	 * Constructor 
	 * @param m  -  The M value of chord system
	 */
	public CHORD (int n) {
		this.map = new LinkedHashMap <Integer, NODE> ();
		this.n = n;
		this.k =  (int) (Math.log(n)/ Math.log(2));
	} 
	
	/**
	 * To create a CHORD or, if there's already a CHORD created before, create a brand new CHORD
	 */
	public void init(int n) {
		if(instance == null) {
			System.out.println("==================================================");
			System.out.println("CSCI319 Assignment 2 CHORD system");
			System.out.println("Done by: " + student_name);
			System.out.println("Student Number: " + student_number);
			System.out.println("==================================================");
			// instaniation new CHORD instance.
			instance = new CHORD(n);

		} else {
			System.out.println("Creating new CHORD...");
			instance = new CHORD(n);
		}
	}
	/**
	 * function to insert a node into the system.
	 * @param node_position - integer value of the node's position
	 */
	public void addPeer(int node_position) {
		this.map.put(node_position , new NODE(node_position, this.m));
	}

	/**
	 * prints out all the Nodes in the system
	 */
	public void printNodes() {
		// cycle through nodes
		for(Map.Entry <Integer, NODE> i: map.entrySet()) {
			int node_key = i.getKey();
			NODE node_value = i.getValue();
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

