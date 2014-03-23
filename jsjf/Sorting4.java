package jsjf;
/**
 * Solution to Programming Project 9.3.
 *
 * @author Lewis and Chase
 */
public class Sorting4
{
    /**
     * Sorts the specified array of integers using the selection
     * sort algorithm. Prints number of comparisons and run time.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> 
		void selectionSort(T[] data)
    {
        int min, comparisons = 0;
        long startTime, stopTime;

        startTime = System.currentTimeMillis();
        
        for (int index = 0; index < data.length-1; index++)
        {
            min = index;
            for (int scan = index+1; scan < data.length; scan++)
                if (data[scan].compareTo(data[min]) < 0)
                {
                    min = scan;
                    comparisons++;
                }
			
            swap(data, min, index);
        }

//        stopTime = System.currentTimeMillis();
//        System.out.println("Selection Sort====================================");
//        System.out.println("Running time (ms): " + (stopTime-startTime));
//        System.out.println("Comparisons: " + comparisons);
//        System.out.println("==================================================");
    }

	/**
	 * Swaps to elements in an array. Used by various sorting algorithms.
	 * 
	 * @param data   the array in which the elements are swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 */
	private static <T extends Comparable<T>> 
		void swap(T[] data, int index1, int index2)
	{
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

    /**
     * Sorts the specified array of objects using an insertion
     * sort algorithm. Prints number of comparisons and run time.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> 
		void insertionSort(T[] data)
    {
	    int comparisons = 0;
	    long startTime, stopTime;
	
	    startTime = System.currentTimeMillis();
	
        for (int index = 1; index < data.length; index++)
        {
            T key = data[index];
            int position = index;
			
            // shift larger values to the right 
            while (position > 0 && data[position-1].compareTo(key) > 0)
            {
	            comparisons++;
                data[position] = data[position-1];
                position--;
            }
			
            data[position] = key;
        }

      
    }

    /**
     * Sorts the specified array of objects using a bubble sort
     * algorithm. Prints number of comparisons and run time.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<T>> 
		void bubbleSort(T[] data)
    {
        int position, scan, comparisons = 0;
        long startTime, stopTime;

        startTime = System.currentTimeMillis();
		
        for (position =  data.length - 1; position >= 0; position--)
        {
            for (scan = 0; scan <= position - 1; scan++)
            {
                if (data[scan].compareTo(data[scan+1]) > 0)
                    swap(data, scan, scan + 1);
                comparisons++;
            }
        }

       
    }

    /**
     * Sorts the specified array of objects using the merge sort
     * algorithm. Prints number of comparisons and run time.
     *
     * @param data the array to be sorted
     */
	public static <T extends Comparable<T>>
		void mergeSort(T[] data)
	{
        long startTime, stopTime;
        int[] comparisons = new int[1];  // array is used to preserve count
        comparisons[0] = 0;
        startTime = System.currentTimeMillis();

		mergeSort(data, 0, data.length - 1, comparisons);

       
	}

    /**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
     *
     * @param data the array to be sorted
     * @param min  the index of the first element 
     * @param max  the index of the last element
     */
	private static <T extends Comparable<T>>
		void mergeSort(T[] data, int min, int max, int[] sortCounter)
	{
		if (min < max)
		{
			int mid = (min + max) / 2;
			mergeSort(data, min, mid, sortCounter);
			mergeSort(data, mid+1, max, sortCounter);
			merge(data, min, mid, max, sortCounter);
		}
	}

	/**
     * Merges two sorted subarrays of the specified array.
     *
     * @param data the array to be sorted
     * @param first the beginning index of the first subarray 
     * @param mid the ending index fo the first subarray
     * @param last the ending index of the second subarray
     */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>>
		void merge(T[] data, int first, int mid, int last, int[] sortCounter)
	{
		T[] temp = (T[])(new Comparable[data.length]);
		
		int first1 = first, last1 = mid;  // endpoints of first subarray
		int first2 = mid+1, last2 = last;  // endpoints of second subarray
		int index = first1;  // next index open in temp array
		
		//  Copy smaller item from each subarray into temp until one
		//  of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2)
		{
            // there are 2 comparisons in the while statement and one in the if statement
            sortCounter[0] += 3;
			if (data[first1].compareTo(data[first2]) < 0)
			{
				temp[index] = data[first1];
				first1++;
			}
			else
			{
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}
		
		//  Copy remaining elements from first subarray, if any
		while (first1 <= last1)
		{
            sortCounter[0]++;
			temp[index] = data[first1];
			first1++;
			index++;
		}
		
		//  Copy remaining elements from second subarray, if any
		while (first2 <= last2)
		{
            sortCounter[0]++;
			temp[index] = data[first2];
			first2++;
			index++;
		}
		
		//  Copy merged data into original array
		for (index = first; index <= last; index++)
		{
            sortCounter[0]++;
			data[index] = temp[index];
		}
    }

	/**
	 * Sorts the specified array of objects using the quick sort algorithm.
     * Prints number of comparisons and run time.
	 * 
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> 
		int quickSort(T[] data)
	{
		
        long startTime, stopTime;
        int[] comparisons = new int[1]; // array is used to preserve count
        comparisons[0] = 0;
        startTime = System.currentTimeMillis();

		quickSort(data, 0, data.length - 1, comparisons);
		
      
        return comparisons[0];
	}

	/**
	 * Recursively sorts a range of objects in the specified array using the
	 * quick sort algorithm. 
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max, int[] sortCounter)
	{
		
		if (min < max)
		{
			// create partitions
			int indexofpartition = partition(data, min, max, sortCounter);
			
			// sort the left partition (lower values)
			quickSort(data, min, indexofpartition - 1, sortCounter);
			
			// sort the right partition (higher values)
			quickSort(data, indexofpartition + 1, max, sortCounter);
		}
		
	}

	/**
	 * Used by the quick sort algorithm to find the partition.
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> int partition(T[] data, int min, int max, int[] sortCounter)
	{
		T partitionelement;
		int left, right;
		int middle = (min + max) / 2;
		
		// use the middle data value as the partition element
		partitionelement = data[middle];
		// move it out of the way for now
		swap(data, middle, min);
		
		left = min;
		right = max;
		
		while (left < right)
		{
			sortCounter[0]++;
			// search for an element that is > the partition element
			while (left < right && data[left].compareTo(partitionelement) <= 0)
			{
				left++;
				sortCounter[0]++;
				
			}
			
			// search for an element that is < the partition element
			while (data[right].compareTo(partitionelement) > 0)
			{
				right--;
				sortCounter[0]++;
				
			}
			
			// swap the elements
			if (left < right)
			{
				swap(data, left, right);
				
			}
			
		}
		
		// move the partition element into place
		swap(data, min, right);
		
		return right;
	}
}
