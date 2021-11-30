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
        Graph_List<Character> g2 = new Graph_List<Character>(9);
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
        
         Graph g = new Graph(13);

        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(2, 1);
        g.addEdge(3, 6);
        g.addEdge(4, 5);
        g.addEdge(4, 7);
        g.addEdge(5, 2);
        g.addEdge(5, 7);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 5);

        
        System.out.println("Following is the Depth First Traversal");
        g.DFS(0);
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

    public static Queue<Character> getBreadthFirstTraversal(Graph_List<Character> g, int origin){

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
    
    static class Graph
    {
        int V; //Number of Vertices
         
        LinkedList<Integer>[] adj; // adjacency lists
         
        //Constructor
        Graph(int V)
        {
            this.V = V;
            adj = new LinkedList[V];
             
            for (int i = 0; i < adj.length; i++)
                adj[i] = new LinkedList<Integer>();
             
        }
         
        //To add an edge to graph
        void addEdge(int v, int w)
        {
            adj[v].add(w); // Add w to v’s list.
        }
         
        // prints all not yet visited vertices reachable from s
        void DFS(int s)
        {
            // Initially mark all vertices as not visited
            Vector<Boolean> visited = new Vector<Boolean>(V);
            for (int i = 0; i < V; i++)
                visited.add(false);
     
            // Create a stack for DFS
            Stack<Integer> stack = new Stack<>();
             
            // Push the current source node
            stack.push(s);
             
            while(stack.empty() == false)
            {
                // Pop a vertex from stack and print it
                s = stack.peek();
                stack.pop();
                 
                // Stack may contain same vertex twice. So
                // we need to print the popped item only
                // if it is not visited.
                if(visited.get(s) == false)
                {
                    System.out.print(s + " ");
                    visited.set(s, true);
                }
                 
                // Get all adjacent vertices of the popped vertex s
                // If a adjacent has not been visited, then push it
                // to the stack.
                Iterator<Integer> itr = adj[s].iterator();
                 
                while (itr.hasNext())
                {
                    int v = itr.next();
                    if(!visited.get(v))
                        stack.push(v);
                }
                 
            }

        }

    }

    //public Queue<T> getDepthFirstTraversal(int origin){
        
    //}
}
