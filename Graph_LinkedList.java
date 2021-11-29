import java.util.LinkedList;
/** A directed graph with n vertices can be represented by n different linked lists. */
public class Graph_LinkedList<T> implements BasicGraphInterface<T> {
    // collection of all vertice presented as linkedList
    private LinkedList<Integer>[] vertexList;
    // collection of labels corresponding to vertice
    private T[] labels;
    // number of vertice in this Graph
    private int size;

    @SuppressWarnings("unchecked")
    public Graph_LinkedList(int n){
        size = n;
        vertexList = new LinkedList[n];
        for (int i = 0; i < size; i++){
            vertexList[i] = new LinkedList<>();
        }
        labels = (T[])new Object[n];
    } // end constructor

    public void addEdge(int source, int target){
        vertexList[source].add(target);
    } // end addEdge

    
    public boolean isEdge(int source, int target){
        return vertexList[source].contains(target);
    } // end isEdge
 

    public void removeEdge(int source, int target){
        vertexList[source].remove(target);
    } // end removeEdge
 
    public int[] neighbors(int vertex){
        LinkedList<Integer> temp = this.vertexList[vertex];
        int counter = temp.size();
        int[] answer = new int[counter];

        for (int i = 0; i< counter; i++){
            answer[i] = temp.pop();
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
        return size;
    } // end size

} // end Graph
