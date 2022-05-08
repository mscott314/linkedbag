
public class LinkedBag<E> implements BagInterface<E>{

	private Node<E> firstNode;       // Reference to first node
	private int numberOfEntries;

	public LinkedBag(){
		firstNode = null;
        numberOfEntries = 0;
	} 

	/** Adds a new entry to beginning of chain of this bag.
    @param newEntry  	The object to be added as a new entry
    @return  True 		if the addition is successful, or false if not. 
	*/
	public boolean add(E newEntry)  {
	  	Node<E> newNode = new Node<E>(newEntry);
		newNode.next = firstNode; // new node references rest of chain                        
	  	firstNode = newNode;      // New node is at beginning of chain
		numberOfEntries++;
	  
		return true;
	}

	/** Retrieves all entries that are in this bag.
	@return  A newly allocated array of all the entries in this bag. 
*/
	public E[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		E[] result = (E[])new Object[numberOfEntries];    // Unchecked cast
		int index = 0;
		Node<E> currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		} 
		return result;
	}

	/** Counts the number of times a given entry appears in this bag.
	 @param anEntry  The entry to be counted.
	 @return  The number of times anEntry appears in this bag. 
	*/
	public int getFrequencyOf(E anEntry)  {
	     int frequency = 0;
	     int counter = 0;
	     Node<E> currentNode = firstNode;
	
	     while ((counter < numberOfEntries) && (currentNode != null)) {
	        if (anEntry.equals(currentNode.data)) {
	           frequency++;
	        } 
	        counter++;
	        currentNode = currentNode.next;
	     } 
	     return frequency;
	}

	/** Tests whether this bag contains a given entry.
	 @param anEntry  The entry to locate.
	 @return  True if the bag contains anEntry, or false otherwise. 
	*/
	public boolean contains(E anEntry){
		boolean found = false;
		Node<E> currentNode = firstNode;
		 
		while (!found && (currentNode != null)){
	        if (anEntry.equals(currentNode.data)){
	        	found = true;
	 		}
			else{
				currentNode = currentNode.next;
			}
		} 
		return found;
	}

	/** Removes one unspecified entry from this bag, if possible.
	@return  Either the removed entry, if the removal was successful, or null. 
	*/
	public E remove() {
		E result = null;
		if (firstNode != null) {
			result = firstNode.data; 
			firstNode = firstNode.next; // Remove first node from chain
			numberOfEntries--;
		} 
		return result;
	}

	/** Removes one occurrence of a given entry from this bag, if possible.
    @param anEntry  The entry to be removed.
    @return  True if the removal was successful, or false otherwise. */
	public boolean remove(E anEntry) {
		boolean result = false;
		Node<E> nodeN = getReferenceTo(anEntry);
		   
		if (nodeN != null)  {
			nodeN.data = firstNode.data; 
			firstNode = firstNode.next;  
			numberOfEntries--;
			result = true;
		}
		return result;
	}
	
    // Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node<E> getReferenceTo(E anEntry) {
		boolean found = false;
		Node<E> currentNode = firstNode;
		while (!found && (currentNode != null)){
			if (anEntry.equals(currentNode.data)){
				found = true;
			}
			else{
				currentNode = currentNode.next;
			}
		}      
		return currentNode;
	} 


	/** Removes all entries from this bag. */
	public void clear()  {
		while (!isEmpty()) {
			remove();
		}
	}

	@Override
	public int getCurrentSize() {
		int size = 0;
		Node<E> currentNode = firstNode;
		while(currentNode != null) {
			size++;
		}
		return size;
		
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null;
	} 
	
	
	
	
	

	/////////////////////////////////////// NODE CLASS ////////////////////////////////////////////////////
	@SuppressWarnings("hiding")
	public class Node<E> {
		private E	 data;  		// data portion
		private Node<E> next;  	// link to next node
		
		public Node(E dataPortion){
			this(dataPortion, null);	
		} 
		public Node(E dataPortion, Node<E> nextNode){
			data = dataPortion;
			next = nextNode;	
		} 
		public E getData(){
			return data;
		} 
		public void setData(E newData){
			data = newData;
		} 
		public Node<E> getNextNode(){
			return next;
		} 
		public void setNextNode(Node<E> nextNode){
			next = nextNode;
		} 
	} // end of Node
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
