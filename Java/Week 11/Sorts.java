
import java.util.Random;

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

        for (int i = 1; i < A.length; i++)
        {
            int j = i;
            while ((j > 0) && (A[j - 1] > A[j]))
            {
                temp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = temp;

                j--;
            }
        }
    }// insertionSort()

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
        int leftIdx, rightIdx, midIdx = 0;

        leftIdx = 0;
        rightIdx = A.length - 1;

        if (leftIdx < rightIdx)
        {
            midIdx = (leftIdx + rightIdx) / 2;
            mergeSortRecurse(A, leftIdx, midIdx);
            mergeSortRecurse(A, midIdx + 1, rightIdx);
            merge(A, leftIdx, midIdx, rightIdx);
        }

    }// mergeSort()

    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int midIdx = 0;
        if (leftIdx < rightIdx)
        {
            midIdx = (leftIdx + rightIdx) / 2;
            mergeSortRecurse(A, leftIdx, midIdx);
            mergeSortRecurse(A, midIdx + 1, rightIdx);
            merge(A, leftIdx, midIdx, rightIdx);
        }
    }// mergeSortRecurse()

    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
        int tempArr[] = new int[rightIdx - leftIdx + 1];
        int ii = leftIdx;
        int jj = midIdx + 1;
        int kk = 0;

        while ((ii <= midIdx) && (jj <= rightIdx))
        {
            if (A[ii] < A[jj])
            {
                tempArr[kk] = A[ii];
                ii++;
            } else
            {
                tempArr[kk] = A[jj];
                jj++;
            }
            kk++;
        }

        while (ii <= midIdx)
        {
            tempArr[kk] = A[ii];
            kk++;
            ii++;
        }

        while (jj <= rightIdx)
        {
            tempArr[kk] = A[jj];
            kk++;
            jj++;
        }

        for (kk = leftIdx; kk <= rightIdx; kk++)
        {
            A[kk] = tempArr[kk - leftIdx];
        }

    }// merge()

    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
        int leftIdx, rightIdx, pivotIdx, newPivotIdx;

        leftIdx = 0;
        rightIdx = A.length - 1;

        if (rightIdx > leftIdx)
        {
            pivotIdx = (leftIdx + rightIdx) / 2;
            newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

            quickSortRecurse(A, leftIdx, newPivotIdx - 1);
            quickSortRecurse(A, newPivotIdx + 1, rightIdx);
        }

    }// quickSort()

    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int pivotIdx, newPivotIdx;

        if (rightIdx > leftIdx)
        {
            pivotIdx = (leftIdx + rightIdx) / 2;
            newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

            quickSortRecurse(A, leftIdx, newPivotIdx - 1);
            quickSortRecurse(A, newPivotIdx + 1, rightIdx);
        }

    }// quickSortRecurse()

        public static void quickSortMedian3(int[] A)
    {
        int leftIdx, rightIdx, midIdx;

        leftIdx = 0;
        rightIdx = A.length - 1;
        midIdx = (leftIdx + rightIdx) / 2;
        if(rightIdx > leftIdx){
            medianOfThree(A, leftIdx, rightIdx);
            int pivotIdx = doPartitioning(A, leftIdx, rightIdx, midIdx);
            quickSortMedian3Recurse(A, leftIdx, pivotIdx - 1);
            quickSortMedian3Recurse(A, pivotIdx + 1, rightIdx);
        }

    }// quickSortMedian3()

    private static void quickSortMedian3Recurse(int[] A, int leftIdx, int rightIdx)
    {
        int midIdx, pivotIdx;
        midIdx = (leftIdx + rightIdx) / 2;

        if (rightIdx > leftIdx)
        {
            medianOfThree(A, leftIdx, rightIdx);
            
            pivotIdx = doPartitioning(A, leftIdx, rightIdx, midIdx);

            quickSortMedian3Recurse(A, leftIdx, pivotIdx - 1);
            quickSortMedian3Recurse(A, pivotIdx + 1, rightIdx);
        }

    }// quickSortMedian3Recurse()

        // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSortRandom(int[] A)
    {
        int leftIdx, rightIdx, pivotIdx, newPivotIdx;
        Random random = new Random();

        leftIdx = 0;
        rightIdx = A.length - 1;

        if (rightIdx > leftIdx)
        {
            pivotIdx = leftIdx + random.nextInt(rightIdx-leftIdx);
            newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

            quickSortRandomRecurse(A, leftIdx, newPivotIdx - 1);
            quickSortRandomRecurse(A, newPivotIdx + 1, rightIdx);
        }

    }// quickSortRandom()

    private static void quickSortRandomRecurse(int[] A, int leftIdx, int rightIdx)
    {
        int pivotIdx, newPivotIdx;
        Random random = new Random();

        if (rightIdx > leftIdx)
        {
            pivotIdx = leftIdx + random.nextInt(rightIdx-leftIdx);
            newPivotIdx = doPartitioning(A, leftIdx, rightIdx, pivotIdx);

            quickSortRandomRecurse(A, leftIdx, newPivotIdx - 1);
            quickSortRandomRecurse(A, newPivotIdx + 1, rightIdx);
        }

    }// quickSortRandomRecurse()

    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
        int newPivotIdx;
        int pivotVal = A[pivotIdx];
        A[pivotIdx] = A[rightIdx];
        A[rightIdx] = pivotVal;

        int currIdx = leftIdx;

        for (int ii = leftIdx; ii < rightIdx; ii++){
            if (A[ii] < pivotVal){
                int temp = A[ii];
                A[ii] = A[currIdx];
                A[currIdx] = temp;
                currIdx++;
            }
        }

        newPivotIdx = currIdx;
        A[rightIdx] = A[newPivotIdx];
        A[newPivotIdx] = pivotVal;
        
        return newPivotIdx; 
    }// doPartitioning

    private static void medianOfThree (int A[], int leftIdx, int rightIdx){
        int midIdx = (leftIdx + rightIdx) / 2;

        if(A[leftIdx] > A[midIdx]){
            swap(A, leftIdx, midIdx);
        }
        if(A[midIdx] > A[rightIdx]){
            swap(A, midIdx, rightIdx);
        }
        if(A[leftIdx] > A[midIdx]){
            swap(A, leftIdx, midIdx);
        }
        swap(A, leftIdx, midIdx);
    }
    private static void swap(int A[], int idx1, int idx2) {
        int temp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = temp;
    }
    
}// end Sorts calss
