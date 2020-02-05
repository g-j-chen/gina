/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weightedadjmatrix;

import java.util.Arrays;

/**
 *
 * @author ginaj
 */
public class WeightedAdjMatrix {
    private int[][] matrix;
    private boolean directed;
    private int numVertices;
    
    public WeightedAdjMatrix(int numVertices, boolean directed) {
        this.numVertices = numVertices;
        this.directed = directed;
        this.matrix = new int[numVertices][numVertices];
        for (int[] row : this.matrix) {
            Arrays.fill(row, -1); //initialising matrix with -1 as all values;
        }
    }
    
    public void addEdge(int v1, int v2, int w) {
        this.matrix[v1][v2] = w;
        if (!this.directed) {
            this.matrix[v2][v1] = w;
        }
    }
    
    public void removeEdge(int v1, int v2) {
        this.matrix[v1][v2] = -1;
        if (!this.directed) {
            this.matrix[v2][v1] = -1;
        }
    }
    
    public boolean hasEdge(int v1, int v2) {
        return this.matrix[v1][v2] != -1;
    }
    
    public void printMatrix() {
        System.out.println("Weighted Adjacency matrix:");
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.matrix[i][j]);
                System.out.print("\t");
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
        WeightedAdjMatrix graph = new WeightedAdjMatrix(5, false);
        graph.addEdge(0, 1, 8);
        graph.addEdge(0, 4, 7);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 16);
        graph.addEdge(1, 4, 12);
        graph.addEdge(2, 3, 6);
        graph.addEdge(3, 4, 14);
        graph.printMatrix();
        System.out.println();
        
        System.out.println("Removing edge between 1 and 3");
        graph.removeEdge(1, 3);
        graph.printMatrix();
        
        
        System.out.println("Directed graph:");
        WeightedAdjMatrix directed = new WeightedAdjMatrix(5, true);
        directed.addEdge(0, 1, 8);
        directed.addEdge(0, 4, 7);
        directed.addEdge(1, 2, 2);
        directed.addEdge(1, 3, 16);
        directed.addEdge(1, 4, 12);
        directed.addEdge(2, 3, 6);
        directed.addEdge(3, 4, 14);
        directed.printMatrix();
        System.out.println();
        
        System.out.println("Removing edge from 1 to 4");
        directed.removeEdge(1, 4);
        directed.printMatrix();

    }
    
}
