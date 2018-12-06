/**
   A class of bags whose entries are stored in a chain of linked nodes.
	The bag is never full.
*/

public class LinkedBag<T> implements BagInterface<T>{



	private class Node 
	{
		private T    data; // Entry in bag
		private Node next; // Link to next node
	
		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
	} // end Node

	
	private Node firstNode;       // Reference to first node
	private int numberOfEntries;

	// Default constructor
	public LinkedBag() 
	{
		firstNode = null;
		numberOfEntries = 0;
		
		
	} // end default constructor
	
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		//return (numberOfEntries<=0);	//Method 1
		return firstNode == null;		//Method 2
	}

	@Override
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry, firstNode);
		firstNode = newNode;
		numberOfEntries++;
		return true;
		
	}

	@Override
	public T remove() {
		if(isEmpty()) return null;
		T buffer = firstNode.data;
		firstNode = firstNode.next;
		numberOfEntries--;
		return buffer;
	}

 	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry)
	{
		Node currentNode; 
		
		for (currentNode = firstNode;currentNode != null; currentNode = currentNode.next)
		{
			if (anEntry==currentNode.data)
				return currentNode;
		} // end while
		return currentNode;
	} // end getReferenceTo

	@Override
	public boolean remove(T anEntry) {
		//getReferenceTo(anEntry);
		//copy the first node data to the node being deleted
		//deete the first node
		Node temp = getReferenceTo(anEntry); //step 1 if it is null
		Node currentNode = firstNode;
		boolean answer = false;
		if(temp==null) return answer;
		
		while(temp != null){				//Keeps looking for anEntry in bag until no more are left
			temp = getReferenceTo(anEntry);
			
			if(currentNode.data == anEntry){
				temp.data = firstNode.data; //step 2
				firstNode = firstNode.next;
				currentNode.data = temp.data;
				numberOfEntries--;
				answer = true;
			}
			currentNode = currentNode.next;
			temp = getReferenceTo(anEntry);
				
		}
		return answer;
	}

	@Override
	public void clear() {						//dothis
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int count = 0;
		Node currentNode = firstNode;
		for(int i=0; i<numberOfEntries; i++){
			if(currentNode.data == anEntry){
				count++;
			}
			currentNode = currentNode.next;
		}
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		Node currentNode = firstNode;
		for(int i=0; i<numberOfEntries; i++){
			if(currentNode.data == anEntry){
				return true;
			}
			currentNode = currentNode.next;
		}
		
		return false;
	}

	@Override
	public T[] toArray() {		
		Node curr = firstNode;
		
		T[] temp = (T[]) new Object[numberOfEntries];
		for(int i=0; i<temp.length; i++){
			temp[i] = curr.data;
			curr = curr.next;
		} 
		return temp;   
	}
	
}
