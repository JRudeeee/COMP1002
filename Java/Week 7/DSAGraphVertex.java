
import java.util.NoSuchElementException;

public class DSAGraphVertex {
    /* Class Fields */
    private final String label;
    private final Object value;
    private DSALinkedList links;
    private boolean visited;

    /* Constructor */
    public DSAGraphVertex(String inLabel, Object inValue)
    {
        label = inLabel;
        value = inValue;
    }

    /* Accessors */
    public String getLabel()
    {
        return label;
    }

    public Object getValue()
    {
        return value;
    }

    public DSALinkedList getAdjacent()
    {
        return links;    }

    public boolean getVisited()
    {
        return visited;
    }

    public String toString()
    {
        String output;
        if(links.isEmpty()){
            throw new NoSuchElementException("There are no edges.");
        } else {
            DSAQueue temp = links.display();
            StringBuilder buffer = new StringBuilder();
            DSAGraphVertex tempVertex;
            while (!temp.isEmpty()){
                tempVertex = (DSAGraphVertex) temp.dequeue();
                buffer.append(tempVertex.getLabel());
                buffer.append(" ");
            }
            buffer.append("\n");
            output = buffer.toString();
        }
        return output;
    }

    /* Mutators */
    public void setVisited()
    {
        visited = true;
    }

    public void clearVisited()
    {
        visited = false;
    }

    public void addEdge(Object destination){
        links.insertLast(destination);
    }
}
