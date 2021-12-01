import java.util.*;
/** A directed graph with n vertices can be represented by n different linked lists. */
public class Graph_List<T> implements BasicGraphInterface<T> {
    // collection of all vertice presented as linkedList
    private LinkedList<Integer>[] vertexList;
    // collection of labels corresponding to vertice
    private T[] labels;
    // number of vertice in this Graph
    private int size;

    @SuppressWarnings("unchecked")
    public Graph_List(int n){
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
        int length = this.vertexList[vertex].size();
        int[] answer = new int[length];

        for (int i = 0; i< length; i++){
            answer[i] = this.vertexList[vertex].get(i);
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

    void DFS(int s)
    {
        // Initially mark all vertices as not visited
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++)
            visited[i] = false;
 
        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();
                 
        int current = s;
        stack.push(s);
        while(!stack.isEmpty())
        {
            if (!visited[current]){
                System.out.print(this.getLabel(current)+ " ");
                visited[current] = true;
                current = vertexList[current].poll();
                while (visited[current]){
                    if(!(vertexList[current].isEmpty()))
                    {
                        current = vertexList[current].poll();
                    }else if(!stack.empty()){
                        current = stack.pop();
                        if (!stack.empty())
                            current = stack.peek();
                    }
                }
                stack.push(current);  
            }
        }

    }

} // end Graph
