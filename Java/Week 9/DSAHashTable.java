import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class DSAHashTable {

    DSAHashEntry hashArray[];
    int count;

    /* Constructor */
    public DSAHashTable(int tableSize)
    {
        int actualSize = nextPrime(tableSize);
        hashArray = new DSAHashEntry[actualSize];
        for (int ii = 0; ii < actualSize; ii++)
        {
            hashArray[ii] = new DSAHashEntry();
        }
    }

    /* Accessors */
    public Object get(String inKey)
    {
        int hashIdx = hash(inKey);
        int origIdx = hashIdx;
        boolean found = false;
        boolean giveUp = false;

        while (!found && !giveUp)
        {
            if (hashArray[hashIdx].getState() == 0)
            {
                giveUp = true;
            } else if (hashArray[hashIdx].getKey().equals(inKey))
            {
                found = true;
            } else
            {
                hashIdx = (hashIdx + 1) % hashArray.length;
                if (hashIdx == origIdx)
                {
                    giveUp = true;
                }
            }
        }

        if (!found)
        {
            throw new NoSuchElementException("Key " + inKey + " not found.");
        }

        return hashArray[hashIdx].value;
    }

    public boolean hasKey(String inKey)
    {
        int hashIdx = hash(inKey);
        int origIdx = hashIdx;
        boolean found = false;
        boolean giveUp = false;

        while (!found && !giveUp)
        {
            if (hashArray[hashIdx].getState() == 0)
            {
                giveUp = true;
            } else if (hashArray[hashIdx].getKey().equals(inKey))
            {
                found = true;
            } else
            {
                hashIdx = (hashIdx + 1) % hashArray.length;
                if (hashIdx == origIdx)
                {
                    giveUp = true;
                }
            }
        }

        return found;
    }

    public double getLoadFactor()
    {
        return ((double) count / (double) hashArray.length);
    }


    /* Mutators */
    public void put(String inKey, Object inValue)
    {
        int hashIdx = hash(inKey);
        int origIdx = hashIdx;
        boolean placed = false;
        boolean giveUp = false;

        if(hashIdx >= hashArray.length){
            resize(hashIdx*2);
        }

        if (getLoadFactor() > 0.5)
        {
            resize(count * 2);
        }

        do
        {
            if ((hashArray[hashIdx].getState() != 1))
            {
                hashArray[hashIdx] = new DSAHashEntry(inKey, inValue);
                placed = true;
                count++;
            } else
            {
                if (hashArray[hashIdx].getKey().equals(inKey))
                {
                    hashArray[hashIdx].setValue(inValue);
                    placed = true;
                } else
                {
                    hashIdx = (hashIdx + stepHash(inKey)) % hashArray.length;

                    if (hashIdx == origIdx)
                    {
                        giveUp = true;
                    }
                }
            }
        } while (!placed && !giveUp);

        if (!placed)
        {
            throw new IllegalStateException("Unable to place new value, hash table full.");
        }
    }

    public void remove(String inKey)
    {
        int hashIdx = hash(inKey);

        if (count == 0)
        {
            throw new NoSuchElementException("Hash table is empty.");
        } else if (!hasKey(inKey))
        {
            throw new NoSuchElementException(inKey + " not found in hash table.");
        } else
        {
            hashArray[hashIdx].setValue(null);
            hashArray[hashIdx].setState(-1);
            count--;
        }

    }

    private void resize(int size)
    {
        DSAHashTable newTable = new DSAHashTable(size);

        for (int ii = 0; ii < (hashArray.length - 1); ii++)
        {
            newTable.put((hashArray[ii].getKey()), (hashArray[ii].getValue()));
        }

        this.hashArray = newTable.hashArray;


    }

    /* Helper Functions */
    public int getSize(){
        return hashArray.length;
    }

    private int nextPrime(int inValue)
    {
        int prime;
        boolean isPrime;

        if (inValue % 2 == 0)
        {
            prime = inValue - 1;
        } else
        {
            prime = inValue;
        }

        isPrime = false;
        do
        {
            prime += 2;
            int ii = 3;
            isPrime = true;
            double root = Math.sqrt(prime);
            do
            {
                if (prime % ii == 0)
                {
                    isPrime = false;
                } else
                {
                    ii += 2;
                }
            } while (ii <= root && isPrime);
        } while (!isPrime);

        return prime;
    }

    private int hash(String inKey)
    {
        int hashIdx = 0;

        for (int ii = 0; ii < inKey.length(); ii++)
        {
            hashIdx = (33 * hashIdx) + inKey.charAt(ii);
        }

        return (hashIdx % hashArray.length);
    }

    private int stepHash(String inKey)
    {
        int modulus = hashArray.length / 2;
        int step = modulus - (hash(inKey) % modulus);

        return step;
    }

    public void importTable(String filepath){
        
        try (Scanner reader = new Scanner(new File(filepath))){
            int count = 0;          
            while(reader.hasNextLine()){
                reader.nextLine();
                count++;
            }

            resize(count);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error, files not found.");
        }
        try (Scanner reader = new Scanner(new File(filepath))){
            
            String buffer[] = new String[2];
            
            String information;
            
            while(reader.hasNextLine()){
                information = reader.nextLine();
                buffer = information.split(",");
                put(buffer[0], buffer[1]);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error, files not found.");
        }
    }

    public void export(String filepath)
    {
        try (FileWriter writer = new FileWriter(filepath)){
            for(DSAHashEntry entry : hashArray){
                if(entry.getValue() != null){
                    writer.append(entry.getKey() + "," + entry.getValue().toString()+"\n");
                }                
            }
        } catch (IOException e){
            System.out.println("Error, unable to write to file.");
        }

    }

    private class DSAHashEntry {

        private String key;
        private Object value;
        private int state;

        /* Constructor */
        public DSAHashEntry()
        {
            key = "";
            value = null;
            state = 0;
        }

        /* Alternate Constructor */
        public DSAHashEntry(String inKey, Object inValue)
        {
            key = inKey;
            value = inValue;
            state = 1;
        }

        /* Accessors */
        public String getKey()
        {
            return key;
        }

        public Object getValue()
        {
            return value;
        }

        public int getState()
        {
            return state;
        }

        /* Mutators */
        public void setKey(String inKey)
        {
            key = inKey;
        }

        public void setValue(Object inValue)
        {
            value = inValue;
        }

        public void setState(int inState)
        {
            if (inState < -1 || inState > 1)
            {
                throw new IllegalStateException(inState + " is an invalid state: Accept values -1, 0 , 1");
            } else
            {
                state = inState;
            }
        }
    }
}
