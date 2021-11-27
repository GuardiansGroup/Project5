import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Driver<T> {
    public static void main(String[] args) {

        // Create the sample graph using adjacency matrix representation
        Graph<Character> g1 = new Graph<Character>(9);
        g1.setLabel(0, 'A');
        g1.setLabel(1, 'B');
        g1.setLabel(2, 'C');
        g1.setLabel(3, 'D');
        g1.setLabel(4, 'E');
        g1.setLabel(5, 'F');
        g1.setLabel(6, 'G');
        g1.setLabel(7, 'H');
        g1.setLabel(8, 'I');

        g1.addEdge(0, 1);
        g1.addEdge(0, 3);
        g1.addEdge(0, 4);
        g1.addEdge(1, 4);
        g1.addEdge(2, 1);
        g1.addEdge(3, 6);
        g1.addEdge(4, 5);
        g1.addEdge(4, 7);
        g1.addEdge(5, 2);
        g1.addEdge(5, 7);
        g1.addEdge(6, 7);
        g1.addEdge(7, 8);
        g1.addEdge(8, 5);

        // mark all vertices as not visited
        // i match vertex, start at 1
        boolean[] visited = new boolean[g1.size()];
        for(int i=0; i <visited.length; i++)
            visited[i] = false;

        Queue<Character> bfOrder = new LinkedList<Character>();
        Queue<Integer> vertexQ = new LinkedList<Integer>();

        // origin of the traversal
        vertexQ.add(0);
        bfOrder.add('A');
        visited[0] = true; // mark vertex as visited
        
        while(!vertexQ.isEmpty()){
            // take front
            int frontVertex = vertexQ.poll();
            // load its neighbor into a set
            int[] neighborVertexSet = g1.neighbors(frontVertex);
            for (int i=0; i<neighborVertexSet.length; i++){
                // load neighbor to vertexQueue
                if(!visited[neighborVertexSet[i]]){
                    vertexQ.add(neighborVertexSet[i]);
                    visited[neighborVertexSet[i]] = true;
                    bfOrder.add(g1.getLabel(neighborVertexSet[i]));
                }
            }
        }

        while (!bfOrder.isEmpty()){
            System.out.print(bfOrder.poll() + " ");
        }
    }

    //public Queue<T> getBreadthFirstTraversal(int origin){

    //}

    //public Queue<T> getDepthFirstTraversal(int origin){
        
    //}
}
