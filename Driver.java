import java.util.LinkedList;
import java.util.Queue;

public class Driver<T> {
    public static void main(String[] args) {

        // -------------- Create the sample graph using adjacency matrix representation -----------------
        Graph_Matrix<Character> g1 = new Graph_Matrix<Character>(9);
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

        // -------------- Create the sample graph using adjacency List representation ---------------
        Graph_LinkedList<Character> g2 = new Graph_LinkedList<Character>(9);
        g2.setLabel(0, 'A');
        g2.setLabel(1, 'B');
        g2.setLabel(2, 'C');
        g2.setLabel(3, 'D');
        g2.setLabel(4, 'E');
        g2.setLabel(5, 'F');
        g2.setLabel(6, 'G');
        g2.setLabel(7, 'H');
        g2.setLabel(8, 'I');

        g2.addEdge(0, 1);
        g2.addEdge(0, 3);
        g2.addEdge(0, 4);
        g2.addEdge(1, 4);
        g2.addEdge(2, 1);
        g2.addEdge(3, 6);
        g2.addEdge(4, 5);
        g2.addEdge(4, 7);
        g2.addEdge(5, 2);
        g2.addEdge(5, 7);
        g2.addEdge(6, 7);
        g2.addEdge(7, 8);
        g2.addEdge(8, 5);

        System.out.println("");
        System.out.println("The graph: {V, E} \nwhere V={ A, B, C, D, E, F, G, H, I }, \nE = { (A,B), (A, D), (A, E), (B, E), (D, G), (E, F), (E, H), (G, H), (F, C), (F, H), (H, I), (C, B), (I, F) }");
        System.out.println("");
        System.out.println("--- Adjacency Matrix Representation ---");
        System.out.println("< Breadth-First Traversal >");
        
        Queue<Character> BFT = getBreadthFirstTraversal(g1, 0);
        while (!BFT.isEmpty()){

            System.out.print(BFT.poll() + " ");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("--- Adjacency List Representation ---");
        System.out.println("< Breadth-First Traversal >");

        Queue<Character> BFT2 = getBreadthFirstTraversal(g2, 0);
        while (!BFT2.isEmpty()){

            System.out.print(BFT2.poll() + " ");
        }
    } // end Main

    public static Queue<Character> getBreadthFirstTraversal(Graph_Matrix<Character> g, int origin){

        // mark all vertices as not visited
        // i match vertex, start at 1
        boolean[] visited = new boolean[g.size()];
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
            int[] neighborVertexSet = g.neighbors(frontVertex);
            for (int i=0; i<neighborVertexSet.length; i++){
                // load neighbor to vertexQueue
                if(!visited[neighborVertexSet[i]]){
                    vertexQ.add(neighborVertexSet[i]);
                    visited[neighborVertexSet[i]] = true;
                    bfOrder.add(g.getLabel(neighborVertexSet[i]));
                }
            }
        }
        return bfOrder;
    } // end getBreadthFirstTraversal

    public static Queue<Character> getBreadthFirstTraversal(Graph_LinkedList<Character> g, int origin){

        // mark all vertices as not visited
        // i match vertex, start at 1
        boolean[] visited = new boolean[g.size()];
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
            int[] neighborVertexSet = g.neighbors(frontVertex);
            for (int i=0; i<neighborVertexSet.length; i++){
                // load neighbor to vertexQueue
                if(!visited[neighborVertexSet[i]]){
                    vertexQ.add(neighborVertexSet[i]);
                    visited[neighborVertexSet[i]] = true;
                    bfOrder.add(g.getLabel(neighborVertexSet[i]));
                }
            }
        }
        return bfOrder;
    } // end getBreadthFirstTraversal

    //public Queue<T> getDepthFirstTraversal(int origin){
        
    //}
}
