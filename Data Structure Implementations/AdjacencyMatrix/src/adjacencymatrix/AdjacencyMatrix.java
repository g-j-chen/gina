/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjacencymatrix;

/**
 *
 * @author ginaj
 */
public class AdjacencyMatrix {
    private int[][] matrix;
    private int numVertices;
    private boolean directed;
    
    public AdjacencyMatrix(int numVertices, boolean directed) {
        this.numVertices = numVertices;
        this.directed = directed;
        this.matrix = new int[numVertices][numVertices];
    }
    
    public void addEdge(int v1, int v2) {
        this.matrix[v1][v2] = 1;
        if (!this.directed) {
            this.matrix[v2][v1] = 1;
        }
    }
    
    public void removeEdge(int v1, int v2) {
        this.matrix[v1][v2] = 0;
        if (!this.directed) {
            this.matrix[v2][v1] = 0;
        }
    }
    
    public boolean hasEdge(int v1, int v2) {
        return this.matrix[v1][v2] == 1;
    }
    
    public void printMatrix() {
        System.out.println("Adjacency matrix:");
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Undirected graph:");
        AdjacencyMatrix graph = new AdjacencyMatrix(5, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printMatrix();
        System.out.println();
        
        graph.removeEdge(0, 1);
        System.out.println("Removing edge between 0 and 1");
        graph.printMatrix();
        System.out.println();
        
        System.out.println("Directed graph:");
        AdjacencyMatrix directedGraph = new AdjacencyMatrix(5, true);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(0, 4);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(1, 3);
        directedGraph.addEdge(1, 4);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 4);
        directedGraph.addEdge(4, 1);
        directedGraph.printMatrix();
        System.out.println();
        
        directedGraph.removeEdge(4, 1);
        System.out.println("Removing edge from 4 to 1");
        directedGraph.printMatrix();
    }
    
}
