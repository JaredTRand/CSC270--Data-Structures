package sorting;

/**
 * This class implements six different comparison sorts (and an optional
 * heap sort for extra credit):
 * 
 * insertion sort
 * selection sort
 * shell sort
 * quick sort
 * bubble sort
 * merge sort
 * (extra credit) heap sort
 * 
 * It also has a method that runs all the sorts on the same input array and
 * prints out statistics.
 */

public class SortingComparisons{

    /**
     * Sorts the given array using the insertion sort algorithm. Note: after
     * this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void insertionSort(T[] A) {		//DONE
    	//SortObject key = new SortObject();
    	//key.assignTo(A[0]);
    	
    	int i = 0 , j = 0;
    	SortObject key = new SortObject();
    	
    	for(i=1; i<A.length; i++){			
			key.assignTo(A[i]);				//take number next to key
			j = i-1;
			
			while(j >= 0 && A[j].compareTo(key) > 0){
				A[j+1] = A[j];
				j = j-1;
			}
			A[j+1].assignTo(key);
    	}    	    
    }


    /**
     * Sorts the given array using the selection sort algorithm. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void selectionSort(T[] A) {	//DONE
		int minimumPos = 0;		
		
		for (int i=0; i<A.length;i++){
			for(int k=i; k<A.length; k++){
				minimumPos = i;
				
				if(A[k].compareTo(A[minimumPos]) < 0){		//Find the new minimum
					minimumPos = k;
				}				
				SortObject temp = new SortObject();				
				
				temp.assignTo(A[i]);
				A[i].assignTo(A[minimumPos]);			//Swap new minimum with number at i
				A[minimumPos].assignTo(temp);									
			}	
		}
    }
    /**
     * Sorts the given array using the bubble sort algorithm.
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void bubbleSort(T[] A) {			//DONE
    	int arrSize = A.length;
    	for(int i = 0; i < arrSize - 1; i++){
    		for(int j = 0; j < arrSize - 1; j++){
    			if(A[j].compareTo(A[j+1]) > 0){
    				SortObject temp = new SortObject();
    				temp.assignTo(A[j+1]);
    				A[j+1].assignTo(A[j]);	//A[j+1] = A[j]			
    				A[j].assignTo(temp);    //A[j]   = A[j+1]
    			}
    		}
    	}
        
    }
    
    
    /**
     * Sorts the given array using the shell sort algorithm.
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
 	public static <T extends SortObject> void shellSort(T[] A)		//DONE
 	{
 		for(int gap = A.length/2; gap>0; gap /= 2){
 			for(int i = gap; i < A.length; i += 1){
 				SortObject temp = new SortObject();
 				temp.assignTo(A[i]);
 				
 				int j; 				
 				for(j = i; j >= gap && A[j-gap].compareTo(temp) > 0; j -= gap){
 					A[j].assignTo(A[j-gap]);
 				}
 				
 				A[j].assignTo(temp);
 			}
 		}

 	 	
 	} // end shellSort

 
    /**
     * Sorts the given array using the merge sort algorithm. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
   
 	public static <T extends SortObject> void mergeSort(T[] A) {		//DONE
 		bigSort(A, 0, A.length-1);
 	}
 	
 	private static <T extends SortObject> void merge(T[] A, int l, int m, int r){
 		int n1 = (m - l) + 1;
 		int n2 = r - m;
 		
 		SortObject Left[] = new SortObject[n1];
 		SortObject Right[] = new SortObject[n2];
 		
 		for(int i=0; i<n1; i++){
 			Left[i] = new SortObject();
 			Left[i].assignTo(A[l+i]);
 		}
 		for(int j=0; j<n2; j++){
 			Right[j] = new  SortObject();
 			Right[j].assignTo(A[m+1+j]);
 		}
 		int i = 0;
 		int j = 0;
 		int k = l;
 		
 		while(i<n1 && j<n2){
 			if(Left[i].compareTo(Right[j]) <= 0){
 				A[k].assignTo(Left[i]);
 				i++;
 			}else{
 				A[k].assignTo(Right[j]);
 				j++;
 			}
 			k++;
 		}
 		
 		while(i<n1){
 			A[k].assignTo(Left[i]);
 			i++;
 			k++;
 		}
 		while(j<n2){
 			A[k].assignTo(Right[j]);
 			j++;
 			k++;
 		}
 		
 	}
 	
	private static <T extends SortObject> void bigSort (T[] A, int l, int r){
 		if(l<r){
 			int m = (l+r)/2;
 			
 			bigSort(A, l, m);
 			bigSort(A, m+1, r);
 			merge(A, l, m, r);
 		}
 	}

   
        
    /**
     * Sorts the given array using the quick sort algorithm, using the median of
     * the first, last, and middle values in each segment of the array as the
     * pivot value. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * @param <T>  the type of values to be sorted
     * @param A   the array to sort
     */
    public static <T extends SortObject> void quickSort(T[] A) {		//DONE
    	sort(A, 0, A.length-1);
    }
    private static <T extends SortObject> int partition(T[] A, int low, int high){    
    	SortObject pivot = new SortObject();
    	pivot.assignTo(A[high]);
    	int i = (low - 1);
    	for(int j=low; j<high; j++){
    		if(A[j].compareTo(pivot)<=0){
    			i++;
    			
    			SortObject temp = new SortObject();
    			temp.assignTo(A[i]);
    			A[i].assignTo(A[j]);
    			A[j].assignTo(temp);
    			
    		}    		
    	}
    	SortObject temp = new SortObject();
    	temp.assignTo(A[i+1]);
    	A[i+1].assignTo(A[high]);
    	A[high].assignTo(temp);
		return i + 1;
    }
    
    private static <T extends SortObject> void sort(T[] A, int low, int high){
    	if(low < high){
    		int pi = partition(A, low, high);
    		
    		sort(A, low, pi-1);
    		sort(A, pi+1, high);
    	}
    }
    


        
    /**
     * Sorts the given array using the heap sort algorithm outlined below. 
     * Note: after this method finishes the array is in sorted order.
     * 
     * The heap sort algorithm is:
     * 
     * for each i from 1 to the end of the array
     *     insert A[i] into the heap (contained in A[0]...A[i-1])
     *     
     * for each i from the end of the array up to 1
     *     remove the max element from the heap and put it in A[i]
     * 
     * 
     * @param <T>  the type of values to be sorted
     * @param A    the array to sort
     */
    public static <T extends SortObject> void heapSort(T[]  A)		//DONE
    {
    	int n = A.length;
    	
    	for(int i = n/2-1; i >= 0; i--){
    		heapOfFaith(A, n, i);
    	}
    	
    	for(int i = n-1; i >= 0; i--){
    		SortObject temp = new SortObject();
    		temp.assignTo(A[0]);;
    		A[0].assignTo(A[i]);
    		A[i].assignTo(temp);
    		
    		heapOfFaith(A, i, 0);
    	}
       	
    }    
    
    public static <T extends SortObject> void heapOfFaith(T[] A, int n, int i){
    	int largest = i;
    	int l = (i*2) + 1;
    	int r = (i*2) + 2;
    	
    	if(l < n && A[l].compareTo(A[largest]) > 0){
    		largest = l;
    	}
    	
    	if(r < n && A[r].compareTo(A[largest]) > 0){
    		largest = r;
    	}
    	
    	if(largest != i){
    		SortObject swap = new SortObject();
    		swap.assignTo(A[i]);
    		A[i].assignTo(A[largest]);
    		A[largest].assignTo(swap);
    		
    		heapOfFaith(A, n, largest);
    	}
    }
    
       
    
 
    /**
     * Internal helper for printing rows of the output table.
     * 
     * @param sort          name of the sorting algorithm
     * @param compares      number of comparisons performed during sort
     * @param moves         number of data moves performed during sort
     * @param milliseconds  time taken to sort, in milliseconds
     */
    @SuppressWarnings("unused")
	private static void printStatistics(final String sort, final int compares, final int moves,
                                        final long milliseconds) {
        System.out.format("%-23s%,15d%,15d%,15d\n", sort, compares, moves, 
                          milliseconds);
    }

    /**
     * Sorts the given array using the six (heap sort with the extra credit)
     * different sorting algorithms and prints out statistics. The sorts 
     * performed are:
     * 
     * insertion sort
     * selection sort
     * shell sort
     * quick sort
     * bubble sort
     * merge sort
     * (extra credit) heap sort
     * 
     * The statistics displayed for each sort are: number of comparisons, 
     * number of data moves, and time (in milliseconds).
     * 
     * Note: each sort is given the same array (i.e., in the original order). 
     * 
     * @param A  the array to sort
     */
    public static <T extends SortObject>void runAllSorts(T[] A) {
        System.out.format("%-23s%15s%15s%15s\n", "algorithm", "data compares", 
                          "data moves", "milliseconds");
        System.out.format("%-23s%15s%15s%15s\n", "---------", "-------------", 
                          "----------", "------------");
        // TODO: run each sort and print statistics about what it did
        
        long startTime, endTime;
        T[] arr=reset(A);
        startTime = System.nanoTime();
        insertionSort(arr);
        endTime = System.nanoTime();

        System.out.format("%-23s%15s%15s%15s\n", "insertion sort", SortObject.getCompares(), 
                SortObject.getAssignments(),(endTime-startTime)/1000000);
        
        arr=reset(A);
        startTime = System.nanoTime();
        selectionSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "selection sort", SortObject.getCompares(), 
                 SortObject.getAssignments(),(endTime-startTime)/1000000);
  
        
        arr=reset(A);
        startTime = System.nanoTime();
        shellSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "shell sort", SortObject.getCompares(), 
                   SortObject.getAssignments(),(endTime-startTime)/1000000 );
          

        arr=reset(A);
        startTime = System.nanoTime();
        quickSort(arr);
        endTime = System.nanoTime();
          System.out.format("%-23s%15s%15s%15s\n", "quick sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);
    

        arr=reset(A);
        startTime = System.nanoTime();
        heapSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "heap sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);

          
        arr=reset(A);
        startTime = System.nanoTime();
        bubbleSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "bubble sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);

           
        arr=reset(A);
        startTime = System.nanoTime();
        mergeSort(arr);
        endTime = System.nanoTime();
        System.out.format("%-23s%15s%15s%15s\n", "merge sort", SortObject.getCompares(), 
                    SortObject.getAssignments(),(endTime-startTime)/1000000);
    }
    
    @SuppressWarnings("unchecked")
	private static <T extends SortObject> T[] reset(T[] A){

    	SortObject[] arr = TestSort.makeCopy(A, A.length); 
        SortObject.resetCompares();
    	SortObject.resetAssignments();
    	return (T[])arr;
        
    }
}
