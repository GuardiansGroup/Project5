/**
   An interface of methods providing basic operations for directed
   and undirected graphs that are either weighted or unweighted.
   
   @author Huijun Hu
   @version 1.0
*/
public interface BasicGraphInterface<T>
{
   /** Adds an edge between two given vertices in this graph. 
       @param source  the origin vertex of the edge.
       @param target  the target vertex of the edge.*/
   public void addEdge(int source, int target);

   /** Sees whether an edge exists between two given vertices in this graph.
       @param source  the origin vertex of the edge.
       @param target  the target vertex of the edge.
       @return  True if an edge exists. */
   public boolean isEdge(int source, int target);

   /** Remove an edge in this graph.
       @param source  the origin vertex of the edge.
       @param target  the target vertex of the edge.*/
   public void removeEdge(int source, int target);

   /** Obtain a list of neighbors of a specfied vertex of this graph.
       @param vertex location to be accessed.
       @return an int list of neighbors.*/
    public int[] neighbors(int vertex);

   /** Gets the label of vertices in this graph.
       @param vertex location to be accessed.
       @return  The label of vertex in the graph. */
    public T getLabel(int vertex);

   /** Change the label of a vertex of this graph.
       @param vertex  the vertex of object.
       @param newLabel  the replacement label.*/
    public void setLabel(int vertex, T newLabel);

   /** Determine the number of vertices in this graph.
       @return total number of vertices.*/
    public int size();

} // end BasicGraphInterface
