/** An Graph application can examine locations of the matrix to determine which edges are present and which are missing */
public class Graph_Matrix<T> implements BasicGraphInterface<T> {
    //edges[i][j] is true if there is a vertex from i to j
    private boolean[][] edges;
    // labels[i] contains the label for vertex i
    private T[] labels;

    @SuppressWarnings("unchecked")
    public Graph_Matrix(int n){
        // All values initially false
        edges = new boolean [n][n];
        // All values initially null
        labels = (T[]) new Object[n];
    } // end constructor

    public void addEdge(int source, int target){
        edges[source][target] = true;
    } // end addEdge

    
    public boolean isEdge(int source, int target){
        return edges[source][target];
    } // end isEdge
 

    public void removeEdge(int source, int target){
        edges[source][target] = false;
    } // end removeEdge
 
    public int[] neighbors(int vertex){
        int i;
        int count = 0;
        int[] answer;

        for (i = 0; i< labels.length; i++){
            if (edges[vertex][i])
                count++;
        }

        answer = new int[count];
        count = 0;
        for (i = 0; i< labels.length; i++){
            if (edges[vertex][i])
                answer[count++] = i;
        }
        return answer;
        
    } // end neighbors
 
    public T getLabel(int vertex){
        return labels[vertex];
    } // end getLabel
 
    public void setLabel(int vertex, T newLabel){
        labels[vertex] = newLabel;
    } // end setLabel
 
    public int size(){
        return labels.length;
    } // end size

} // end Graph
