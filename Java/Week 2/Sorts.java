/**
 ** Software Technology 152 Class to hold various static sort methods.
 */
class Sorts {
    // bubble sort
    public static void bubbleSort(int[] A)
    {
        int temp; // temp holding variable for swaps
        int lowestSortedIndex = A.length; // position of lowest sorted number
        int newLowestSorted = 0; // to avoid checking higher

        while (lowestSortedIndex != 0) // while there are numbers to sort
        {
            newLowestSorted = 0; // set lowest to zero in case array already
                                 // sorted

            // loop from index 0 to lowest sorted index
            for (int i = 0; i < lowestSortedIndex - 1; i++)
            {
                // Check which number is larger and swap if needed
                if (A[i] > A[i + 1])
                {
                    temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;

                    // if swapped, update new lowest sorted number
                    newLowestSorted = i + 1;
                }
            }
            // update lowest sorted for next loop
            lowestSortedIndex = newLowestSorted;
        }
    }// bubbleSort()

    // selection sort
    public static void selectionSort(int[] A)
    {
        int temp; // temp holding varibale for swaps
        int lowestNumIndex; // position of lowest number in index

        // loop through array
        for (int i = 0; i < A.length; i++)
        {
            lowestNumIndex = i; // set first check postition to lowest

            // loop through remaining array to compare
            for (int j = i + 1; j < A.length; j++)
            {
                // compare next number to lowest number
                if (A[j] < A[lowestNumIndex])
                {
                    // set new lowest index to compared value position
                    lowestNumIndex = j;
                }
            }

            // swap lowest number found into position
            temp = A[lowestNumIndex];
            A[lowestNumIndex] = A[i];
            A[i] = temp;
        }
    }// selectionSort()

    // insertion sort
    public static void insertionSort(int[] A)
    {
        int temp; // temp holding variable for swaps

        for(int i = 1; i < A.length; i++)
        {
            int j = i;
            while((j > 0) && (A[j-1] > A[j]))
            {
                temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;

                j--;
            }
        }
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
    }// mergeSort()

    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }// mergeSortRecurse()

    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
    }// merge()

    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
    }// quickSort()

    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
    }// quickSortRecurse()

    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
        return 0; // TEMP - Replace this when you implement QuickSort
    }// doPartitioning

}// end Sorts calss
