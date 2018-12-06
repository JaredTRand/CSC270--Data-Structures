/**
 * 
 */

/**
 * @author gaok
 *
 */
public final class ArrayBag<T> implements BagInterface<T>{

	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY=25;
	
	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag()
	{
		this (DEFAULT_CAPACITY);
	} // end default constructor
	
	/** Creates an empty bag having a given capacity.
    @param desiredCapacity  The integer capacity desired. */
	@SuppressWarnings("unchecked")
	public ArrayBag(int desiredCapacity)
	{
		bag=(T[]) new Object[desiredCapacity];
		numberOfEntries=0;
	} // end constructor

	
	
	@Override
	public int getCurrentSize() {
		int currentSize = numberOfEntries;
		return currentSize;
	}

	public boolean isEmpty() {
		if(numberOfEntries == 0){
			return true;
			
		}else{
			return false;
		}
		
	}

	@Override
	public boolean add(T newEntry) {
		if(numberOfEntries >= bag.length){
			return false;
		}
		
		bag[numberOfEntries] = newEntry;
		numberOfEntries++;
		return true;
			
		
	}

	@Override
	public T remove() {
		if (isEmpty()){
			return null;
		}
		T buffer = bag[numberOfEntries-1];
		bag[numberOfEntries-1] = null;
		numberOfEntries--;
		return buffer;
		
	}

	@Override
	public boolean remove(T anEntry) {
		boolean answer = false;
		for(int i=0; i<numberOfEntries; i++){
			if(anEntry==bag[i]){ 					//Found
				bag[i] = bag[numberOfEntries-1];	//Copy the last object to the target position
				bag[numberOfEntries] = null;
				numberOfEntries--;
				i--;	
				answer = true;
			}
			
		}
		return answer;
	}

	@Override
	public void clear() {
		int count = numberOfEntries;
		for(int i=0; i<numberOfEntries; i++){
			bag[count-1] = null;
			count--;
		}
		numberOfEntries = 0;		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int count = 0;
		for(int i=0; i<numberOfEntries; i++){
			if(bag[i]==anEntry){
				count++;
			}
			
		}
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		//getFrequencyOf(anEntry)>0;
		//Or copy getfrequencyof code with return true and false instead of count
		return getFrequencyOf(anEntry)>0;
	}

	@Override
	public T[] toArray() {
		
		return java.util.Arrays.copyOf(bag, numberOfEntries);
	}
	
}
