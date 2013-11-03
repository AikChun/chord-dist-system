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

