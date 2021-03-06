import java.util.*;

public class Driver<T> {
    public static void main(String[] args) {

        // -------------- Create the sample graph using adjacency matrix representation -----------------
        Graph_Matrix<Character> gm1 = createMatrixGraph();
        Graph_List<Character> gl1 = createListGraph();
        Graph_Matrix<Character> gm2 = createMatrixGraph();
        Graph_List<Character> gl2 = createListGraph();

        System.out.println("");
        System.out.println("The graph: {V, E} \nwhere V={ A, B, C, D, E, F, G, H, I }, \nE = { (A,B), (A, D), (A, E), (B, E), (D, G), (E, F), (E, H), (G, H), (F, C), (F, H), (H, I), (C, B), (I, F) }");
        System.out.println("");
        System.out.println("--- Adjacency Matrix Representation ---");
        System.out.println("< Breadth-First Traversal >");

        Queue<Character> BFT = getBreadthFirstTraversal(gm1, 0);
        while (!BFT.isEmpty()){

            System.out.print(BFT.poll() + " ");
        }
    
        System.out.println("\n< Depth-First Traversal >");
        Queue<Character> DFT = getDepthFirstTraversal(gm2, 0);
        while (!DFT.isEmpty()){

            System.out.print(DFT.poll() + " ");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("--- Adjacency List Representation ---");
        System.out.println("< Breadth-First Traversal >");

        Queue<Character> BFT2 = getBreadthFirstTraversal(gm2, 0);
        while (!BFT2.isEmpty()){

            System.out.print(BFT2.poll() + " ");
        }
                
        System.out.println("\n< Depth-First Traversal >");
        //g3.DFS(0);
        Queue<Character> DFT2 = getDepthFirstTraversal(gl2, 0);
        while (!DFT2.isEmpty()){

            System.out.print(DFT2.poll() + " ");
        }
    } // end Main

    public static Graph_Matrix<Character> createMatrixGraph(){
        Graph_Matrix<Character> g = new Graph_Matrix<Character>(9);
        g.setLabel(0, 'A');
        g.setLabel(1, 'B');
        g.setLabel(2, 'C');
        g.setLabel(3, 'D');
        g.setLabel(4, 'E');
        g.setLabel(5, 'F');
        g.setLabel(6, 'G');
        g.setLabel(7, 'H');
        g.setLabel(8, 'I');

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

        return g;
    }
    public static Graph_List<Character> createListGraph(){
        Graph_List<Character> g = new Graph_List<Character>(9);
        g.setLabel(0, 'A');
        g.setLabel(1, 'B');
        g.setLabel(2, 'C');
        g.setLabel(3, 'D');
        g.setLabel(4, 'E');
        g.setLabel(5, 'F');
        g.setLabel(6, 'G');
        g.setLabel(7, 'H');
        g.setLabel(8, 'I');

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

        return g;
    }
    public static Queue<Character> getBreadthFirstTraversal(Graph_Matrix<Character> g, int origin){

        // mark all vertices as not visited
        // i match vertex, start at 1
        boolean[] visited = new boolean[g.size()];
        for(int i=0; i <visited.length; i++)
            visited[i] = false;

        Queue<Character> bfOrder = new LinkedList<Character>();
        Queue<Integer> vertexQ = new LinkedList<Integer>();

        // origin of the traversal
        vertexQ.add(origin);
        bfOrder.add(g.getLabel(origin));
        visited[origin] = true; // mark vertex as visited
        
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
        vertexQ.add(origin);
        bfOrder.add(g.getLabel(origin));
        visited[origin] = true; // mark vertex as visited
        
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
    public static Queue<Character> getDepthFirstTraversal(Graph_Matrix<Character> g, int origin){
        // mark all vertices as not visited
        // i match vertex, start at 1
        boolean[] visited = new boolean[g.size()];
        for(int i=0; i <visited.length; i++)
            visited[i] = false;

        Queue<Character> orderQ = new LinkedList<Character>();
        Stack<Integer> stack = new Stack<Integer>();

        // origin of the traversal
        stack.push(origin);
        orderQ.add(g.getLabel(origin));
        visited[origin] = true; // mark vertex as visited

        while (!stack.isEmpty()){
            int current = stack.peek();
            boolean hasUnvisited = false;
            int nextNeighbor = -1;

            for (int i = 0; i < g.neighbors(current).length; i++){

                if (!visited[g.neighbors(current)[i]]){
                    hasUnvisited = true;
                    nextNeighbor = g.neighbors(current)[i];
                    break;
                }
            }
            if (hasUnvisited){
                current = nextNeighbor;
                visited[current] = true;
                stack.push(current);
                orderQ.add(g.getLabel(current));
            }
            else{
                stack.pop();
            }
        }

        return orderQ;
    }
    public static Queue<Character> getDepthFirstTraversal(Graph_List<Character> g, int origin){
        // mark all vertices as not visited
        // i match vertex, start at 1
        boolean[] visited = new boolean[g.size()];
        for(int i=0; i <visited.length; i++)
            visited[i] = false;

        Queue<Character> orderQ = new LinkedList<Character>();
        Stack<Integer> stack = new Stack<Integer>();

        // origin of the traversal
        stack.push(origin);
        orderQ.add(g.getLabel(origin));
        visited[origin] = true; // mark vertex as visited

        while (!stack.isEmpty()){
            int current = stack.peek();
            boolean hasUnvisited = false;
            int nextNeighbor = -1;

            for (int i = 0; i < g.neighbors(current).length; i++){

                if (!visited[g.neighbors(current)[i]]){
                    hasUnvisited = true;
                    nextNeighbor = g.neighbors(current)[i];
                    break;
                }
            }
            if (hasUnvisited){
                current = nextNeighbor;
                visited[current] = true;
                stack.push(current);
                orderQ.add(g.getLabel(current));
            }
            else{
                stack.pop();
            }
        }

        return orderQ;
    }

}
