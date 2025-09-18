import java.util.NoSuchElementException;

public class DSAGraph {

    /* Class Fields */
    DSALinkedList vertices;

    /* Constructor */
    public DSAGraph()
    {
        vertices = new DSALinkedList();
    }

    /* Mutators */
    public void addVertex(String label, Object value)
    {
        DSAGraphVertex newVertex = new DSAGraphVertex(label, value);
        vertices.insertLast(newVertex);
    }

    public void addEdge(String label1, String label2)
    {
        DSAQueue temp;
        DSAGraphVertex tempVertex;
        DSAGraphVertex fromVertex = new DSAGraphVertex(label1, null);
        DSAGraphVertex toVertex = new DSAGraphVertex(label2, null);
        if (vertices.isEmpty())
        {
            throw new NoSuchElementException("The graph has no vertices.");
        } else if (!hasVertex(label1))
        {
            throw new NoSuchElementException("Vertex " + label1 + " is not in graph.");
        } else if (!hasVertex(label2))
        {
            throw new NoSuchElementException("Vertex " + label2 + " is not in graph.");
        } else
        {
            temp = vertices.display();
            while (!temp.isEmpty())
            {
                tempVertex = (DSAGraphVertex) temp.dequeue();
                if (label1.equals(tempVertex.getLabel()))
                {
                    fromVertex = tempVertex;
                } else if (label2.equals(tempVertex.getLabel()))
                {
                    toVertex = tempVertex;
                }
            }
            fromVertex.addEdge(toVertex);
            toVertex.addEdge(fromVertex);
        }
    }

    /* Accessors */

    public boolean hasVertex(String label)
    {
        boolean found = false;
        DSAQueue temp;
        DSAGraphVertex tempVertex;
        if (vertices.isEmpty())
        {
            throw new NoSuchElementException("The graph has no vertices.");
        } else
        {
            temp = vertices.display();
            while (!temp.isEmpty())
            {
                tempVertex = (DSAGraphVertex) temp.dequeue();
                if (label.equals(tempVertex.getLabel()))
                {
                    found = true;
                }
            }
        }
        return found;
    }

    public int getVertexCount()
    {
        int count = 0;
        DSAQueue temp;
        if (vertices.isEmpty())
        {
            throw new NoSuchElementException("The graph has no vertices.");
        } else
        {
            temp = vertices.display();
            while (!temp.isEmpty())
            {
                temp.dequeue();
                count++;
            }
        }
        return count; // temp
    }

    public int getEdgeCount()
    {
        int count = 0;
        DSAQueue tempVertices, tempEdgeQueue;
        DSALinkedList tempEdgeList;
        DSAGraphVertex tempVertex;
        if (vertices.isEmpty())
        {
            throw new NoSuchElementException("The graph has no vertices.");
        } else
        {
            tempVertices = vertices.display();
            while (!tempVertices.isEmpty())
            {
                tempVertex = (DSAGraphVertex) tempVertices.dequeue();
                tempEdgeList = tempVertex.getAdjacent();
                if (!tempEdgeList.isEmpty())
                {
                    tempEdgeQueue = tempEdgeList.display();
                    while (!tempEdgeQueue.isEmpty())
                    {
                        tempEdgeQueue.dequeue();
                        count++;
                    }
                }
            }
        }
        count = count / 2;
        return count;
    }

    public DSAGraphVertex getVertex(String label)
    {
        DSAQueue temp;
        DSAGraphVertex tempVertex;
        DSAGraphVertex foundVertex = null;

        if (vertices.isEmpty())
        {
            throw new NoSuchElementException("The graph has no vertices.");
        } else
        {
            temp = vertices.display();
            while (!temp.isEmpty())
            {
                tempVertex = (DSAGraphVertex) temp.dequeue();
                if (label.equals(tempVertex.getLabel()))
                {
                    foundVertex = tempVertex;
                }
            }
        }
        if (foundVertex == null)
        {
            throw new NoSuchElementException("The Vertex " + label + " is not within graph.");
        }
        return foundVertex; // temp
    }

    public DSALinkedList getAdjacent(String label)
    {
        DSAGraphVertex temp = getVertex(label);
        return temp.getAdjacent();
    }

    public boolean isAdjacent(String label1, String label2)
    {
        boolean adjacent = false;
        DSALinkedList tempList = getAdjacent(label1);
        DSAQueue tempQueue = tempList.display();
        DSAGraphVertex tempVertex;

        while (!tempQueue.isEmpty())
        {
            tempVertex = (DSAGraphVertex) tempQueue.dequeue();
            if (label2.equals(tempVertex.getLabel()))
            {
                adjacent = true;
            }
        }

        return adjacent;
    }

    public void displayAsList()
    {
        DSAQueue tempQueue, tempSubQueue;
        DSALinkedList tempAdjacent;
        DSAGraphVertex tempVertex;
        StringBuilder buffer = new StringBuilder();
        if (vertices.isEmpty()){
            throw new NoSuchElementException("Graph has no vertices.");
        } else {
            tempQueue = vertices.display();
            
            while(!tempQueue.isEmpty()){
                tempVertex = (DSAGraphVertex) tempQueue.dequeue();
                buffer.append(tempVertex.getLabel());
                buffer.append(" | ");
                tempAdjacent =  tempVertex.getAdjacent();
                if(!tempAdjacent.isEmpty()){
                    tempSubQueue = tempAdjacent.display();
                    while(!tempSubQueue.isEmpty()){
                        tempVertex = (DSAGraphVertex) tempSubQueue.dequeue();
                        buffer.append(tempVertex.getLabel());
                        if (!tempSubQueue.isEmpty()){
                            buffer.append(" ");
                        } else {
                            buffer.append("\n");
                        }
                    }
                }
            }
            System.out.print(buffer.toString());
        }
    }

    public void displayAsMatrix()
    {
        if (vertices.isEmpty()){
            throw new NoSuchElementException("Graph has no vertices.");
        } else {
            
        }
    }
}
