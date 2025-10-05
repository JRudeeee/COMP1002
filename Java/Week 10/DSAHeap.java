
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class DSAHeap {

    /* Global Variables */
    private DSAHeapEntry heap[];
    private int count;

    /* Constructor */

    public DSAHeap(int heapSize)
    {
        heap = new DSAHeapEntry[heapSize];
        count = 0;
    }

    /* Accessors */
    public void display()
    {
        
        for (int ii = 0; ii < heap.length; ii++)
        {
            if (heap[ii] != null)
            {
                System.out.printf("""
                        Index    : %d
                        Priority : %d
                        Value    : %s\n
                            """, ii, heap[ii].getPriority(), heap[ii].getValue().toString());
            }
            
        }
    }

    public int getCount()
    {
        return count;
    }

    /* Mutators */
    public void add(int inPriority, Object inValue)
    {
        heap[count] = new DSAHeapEntry(inPriority, inValue); // insert new entry at end of array
        heap = trickleUp(heap, count); // sort array based on priority
        count++; // increase count of items in array
    }

    public DSAHeapEntry remove()
    {
        DSAHeapEntry removed;

        if (count == 0)
        {
            throw new NoSuchElementException("Heap is empty");
        } else
        {
            removed = heap[0];
            heap[0] = heap[count - 1];
            heap[count - 1] = null;
            count--;
            heap = trickleDown(heap, 0, count);
        }

        return removed;
    }

    /* Helpers */
    private DSAHeapEntry[] trickleUp(DSAHeapEntry[] heapArray, int currIdx)
    {
        int parentIdx = parentIdx(currIdx);

        if (currIdx > 0)
        {
            if (heapArray[currIdx].getPriority() > heapArray[parentIdx].getPriority())
            {
                DSAHeapEntry temp = heapArray[parentIdx];
                heapArray[parentIdx] = heapArray[currIdx];
                heapArray[currIdx] = temp;
                trickleUp(heapArray, parentIdx);
            }
        }
        return heapArray;
    }

    private DSAHeapEntry[] trickleDown(DSAHeapEntry[] heapArray,int currIdx, int numItems)
    {
        int leftChildIdx = leftChildIdx(currIdx);
        int rightChildIdx = rightChildIdx(currIdx);

        if (leftChildIdx < numItems)
        {
            int largeIdx = leftChildIdx;
            if (rightChildIdx < numItems)
            {
                if (heapArray[leftChildIdx].getPriority() < heapArray[rightChildIdx].getPriority())
                {
                    largeIdx = rightChildIdx;
                }
            }
            if (heapArray[largeIdx].getPriority() > heapArray[currIdx].getPriority())
            {
                DSAHeapEntry temp = heapArray[currIdx];
                heapArray[currIdx] = heapArray[largeIdx];
                heapArray[largeIdx] = temp;
                trickleDown(heapArray, largeIdx, numItems);
            }
        }
        return heapArray;
    }

    private DSAHeapEntry[] heapify(DSAHeapEntry[] heapArray, int numItems)
    {
        for (int ii = (numItems / 2) - 1; ii >= 0; ii--)
        {
            heapArray = trickleDown(heapArray, ii, numItems);
        }

        return heapArray;
    }

    private DSAHeapEntry[] heapSort (DSAHeapEntry[] heapArray, int numItems)
    {
        heapArray = heapify(heapArray, numItems);
        for (int ii = numItems - 1; ii > 0; ii--)
        {
            DSAHeapEntry temp = heapArray[ii];
            heapArray[ii] = heapArray[0];
            heapArray[0] = temp;
            trickleDown(heapArray, 0, ii);
        }

        return heapArray;
    }

    public void importTable(String filepath)
    {
        DSAHeapEntry importedHeap[];
        int lines = 0;

        try (Scanner reader = new Scanner(new File(filepath)))
        {

            while (reader.hasNextLine())
            {
                reader.nextLine();
                lines++;
            }

            reader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("Error, files not found.");
        }

        importedHeap = new DSAHeapEntry[lines];
        try (Scanner reader = new Scanner(new File(filepath)))
        {

            String buffer[] = new String[2];
            int inPriority;

            String information;
            int ii = 0;
            while (reader.hasNextLine())
            {
                information = reader.nextLine();
                buffer = information.split(",");
                inPriority = Integer.parseInt(buffer[0]);
                DSAHeapEntry temp = new DSAHeapEntry(inPriority,buffer[1]);        
                importedHeap[ii] = temp;
                ii++;
            }

            reader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("Error, files not found.");
        }
        importedHeap = heapSort(importedHeap, lines);
        count = lines;
        heap = importedHeap;
    }

    public void export(String filepath)
    {
        try (FileWriter writer = new FileWriter(filepath))
        {
            for (DSAHeapEntry entry : heap)
            {
                if (entry.getValue() != null)
                {
                    writer.append(entry.getPriority() + "," + entry.getValue().toString() + "\n");
                }
            }
        } catch (IOException e)
        {
            System.out.println("Error, unable to write to file.");
        }

    }

    private int leftChildIdx(int currIdx)
    {
        int leftChildIdx = (currIdx * 2) + 1;
        return leftChildIdx;
    }

    private int rightChildIdx(int currIdx)
    {
        int rightChildIdx = (currIdx * 2) + 2;
        return rightChildIdx;
    }

    private int parentIdx(int currIdx)
    {
        int parentIdx = (currIdx - 1) / 2;
        return parentIdx;
    }

}
