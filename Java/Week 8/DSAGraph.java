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
        if (vertices.isEmpty())
        {
            DSAGraphVertex newVertex = new DSAGraphVertex(label, value);
            vertices.insertLast(newVertex);
        } else if (hasVertex(label))
        {
            throw new IllegalStateException("Vertex with the label " + label + " already exists.");
        } else
        {
            DSAGraphVertex newVertex = new DSAGraphVertex(label, value);
            vertices.insertLast(newVertex);
        }

    }

    public void deleteVertex(String label)
    {
        if (vertices.isEmpty())
        {
            throw new NoSuchElementException("Graph contains no vertices.");
        } else if (!hasVertex(label))
        {
            throw new NoSuchElementException("The vertex " + label + " is not in graph.");
        } else
        {
            DSAGraphVertex temp = getVertex(label);
            DSALinkedList tempAdjacent = temp.getAdjacent();
            DSAQueue tempQueue = new DSAQueue();
            if (!tempAdjacent.isEmpty())
            {
                tempQueue = tempAdjacent.display();
            }

            while (!tempQueue.isEmpty())
            {
                temp = (DSAGraphVertex) tempQueue.dequeue();
                deleteEdge(label, temp.getLabel());
            }

            vertices.removeNode(getVertex(label));
        }
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
        } else if (isAdjacent(label1, label2))
        {
            throw new IllegalArgumentException("Edge already exists.");
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

    public void deleteEdge(String label1, String label2)
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
        } else if (!isAdjacent(label1, label2))
        {
            throw new IllegalArgumentException("Edge does not exist.");
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
            fromVertex.removeEdge(toVertex);
            toVertex.removeEdge(fromVertex);
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
        return foundVertex;
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
        DSAQueue tempQueue = new DSAQueue();
        DSAGraphVertex tempVertex;

        if (!tempList.isEmpty())
        {
            tempQueue = tempList.display();
        }
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
        if (vertices.isEmpty())
        {
            throw new NoSuchElementException("Graph has no vertices.");
        } else
        {
            tempQueue = vertices.display();

            while (!tempQueue.isEmpty())
            {
                tempVertex = (DSAGraphVertex) tempQueue.dequeue();
                buffer.append(tempVertex.getLabel());
                buffer.append(" | ");
                tempAdjacent = tempVertex.getAdjacent();
                if (!tempAdjacent.isEmpty())
                {
                    tempSubQueue = tempAdjacent.display();
                    while (!tempSubQueue.isEmpty())
                    {
                        tempVertex = (DSAGraphVertex) tempSubQueue.dequeue();
                        buffer.append(tempVertex.getLabel());
                        if (!tempSubQueue.isEmpty())
                        {
                            buffer.append(" ");
                        } else
                        {
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
        DSAQueue verticesQueue, tempQueue1, actualConnections;
        StringBuilder buffer = new StringBuilder();
        DSAGraphVertex tempVertex;
        DSALinkedList tempAdjacent;
        int numVertices = 0;
        int list[][];
        if (vertices.isEmpty())
        {
            throw new NoSuchElementException("Graph has no vertices.");
        } else
        {
            verticesQueue = vertices.display();

            System.out.println("Lookup Table");
            while (!verticesQueue.isEmpty())
            {
                tempVertex = (DSAGraphVertex) verticesQueue.dequeue();
                System.out.println("| " + numVertices + " | " + tempVertex.getLabel() + " |");
                numVertices++;
            }

            String posConnections[] = new String[numVertices];

            verticesQueue = vertices.display();

            for (int ii = 0; ii < numVertices; ii++)
            {
                tempVertex = (DSAGraphVertex) verticesQueue.dequeue();
                posConnections[ii] = tempVertex.getLabel();
            }

            list = new int[numVertices][numVertices];

            verticesQueue = vertices.display();
            for (int ii = 0; ii < numVertices; ii++)
            {
                tempVertex = (DSAGraphVertex) verticesQueue.dequeue();
                tempAdjacent = tempVertex.getAdjacent();
                if (!tempAdjacent.isEmpty())
                {
                    actualConnections = tempAdjacent.display();
                    while (!actualConnections.isEmpty())
                    {
                        tempVertex = (DSAGraphVertex) actualConnections.dequeue();
                        for (int jj = 0; jj < numVertices; jj++)
                        {
                            if (posConnections[jj].equals(tempVertex.getLabel()))
                            {
                                list[ii][jj] = 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Matrix");
        for (int ii = 0; ii < numVertices; ii++)
        {
            buffer.append("| ");
            for (int jj = 0; jj < numVertices; jj++)
            {
                buffer.append(list[ii][jj]);
                buffer.append(" | ");
            }
            buffer.append("\n");
        }
        System.out.printf(buffer.toString());
    }

    public boolean unvistedExists(DSAGraphVertex vertex)
    {
        boolean exists = false;

        DSALinkedList adjacent = vertex.getAdjacent();
        DSAQueue adjacentQueue = adjacent.display();
        DSAGraphVertex adjacentVertex;

        while (!adjacentQueue.isEmpty())
        {
            adjacentVertex = (DSAGraphVertex) adjacentQueue.dequeue();
            if (!adjacentVertex.getVisited())
            {
                exists = true;
            }
        }
        return exists;
    }

    public DSAGraphVertex nextUnvisited(DSAGraphVertex vertex)
    {
        boolean found = false;
        DSAGraphVertex adjacentVertex = new DSAGraphVertex(null, null);

        DSALinkedList adjacent = vertex.getAdjacent();
        DSAQueue adjacentQueue = adjacent.display();

        if (!unvistedExists(vertex))
        {
            throw new NoSuchElementException("No unvisted vertices.");
        } else
        {
            while (!adjacentQueue.isEmpty() && !found)
            {
                adjacentVertex = (DSAGraphVertex) adjacentQueue.dequeue();
                if (!adjacentVertex.getVisited())
                {
                    found = true;
                }
            }
        }

        return adjacentVertex;
    }

    public void breadthFirstSeatch()
    {
        DSAQueue tempQueue = new DSAQueue();
        DSAQueue tempVertices;
        DSAQueue tree = new DSAQueue();
        DSAGraphVertex tempVertex, tempVertex2;

        if (vertices.isEmpty())
        {
            throw new NoSuchElementException("The graph has no vertices.");
        } else
        {
            tempVertices = vertices.display();
            
            while (!tempVertices.isEmpty())
            {
                tempVertex = (DSAGraphVertex) tempVertices.dequeue();
                tempVertex.clearVisited();
            }

            tempVertices = vertices.display();
            tempVertex = (DSAGraphVertex) tempVertices.dequeue();
            tempVertex.setVisited();
            tempQueue.enqueue(tempVertex);
            while(!tempQueue.isEmpty()){
                tempVertex = (DSAGraphVertex) tempQueue.dequeue();
                while(unvistedExists(tempVertex)){
                    tempVertex2 = nextUnvisited(tempVertex);
                    tree.enqueue("(" + tempVertex.getLabel() + "," + tempVertex2.getLabel() + ")");
                    tempVertex2.setVisited();
                    tempQueue.enqueue(tempVertex2);
                }
            }

            while (!tree.isEmpty())
            {
                String output = (String) tree.dequeue();
                if (!tree.isEmpty())
                {
                    System.out.print(output + ",");
                } else
                {
                    System.out.println(output);
                }
            }

        }
    }

    public void depthFirstSearch()
    {
        DSAQueue tempQueue;
        DSAQueue tree = new DSAQueue();
        DSAGraphVertex tempVertex, tempVertex2;
        DSAStack tempStack = new DSAStack();

        if (vertices.isEmpty())
        {
            throw new NoSuchElementException("The graph has no vertices.");
        } else
        {
            tempQueue = vertices.display();

            while (!tempQueue.isEmpty())
            {
                tempVertex = (DSAGraphVertex) tempQueue.dequeue();
                tempVertex.clearVisited();
            }

            tempQueue = vertices.display();
            tempVertex = (DSAGraphVertex) tempQueue.dequeue();
            tempVertex.setVisited();
            tempStack.push(tempVertex);
            while (!tempStack.isEmpty())
            {
                while (unvistedExists(tempVertex))
                {
                    tempVertex2 = nextUnvisited(tempVertex);
                    tree.enqueue("(" + tempVertex.getLabel() + "," + tempVertex2.getLabel() + ")");
                    tempVertex2.setVisited();
                    tempStack.push(tempVertex2);
                    tempVertex = tempVertex2;
                }
                if (!unvistedExists((DSAGraphVertex) tempStack.top()))
                {
                    tempVertex = (DSAGraphVertex) tempStack.pop();
                } else
                {
                    tempVertex = (DSAGraphVertex) tempStack.top();
                }

            }

            while (!tree.isEmpty())
            {
                String output = (String) tree.dequeue();
                if (!tree.isEmpty())
                {
                    System.out.print(output + ",");
                } else
                {
                    System.out.println(output);
                }
            }

        }
    }
}
