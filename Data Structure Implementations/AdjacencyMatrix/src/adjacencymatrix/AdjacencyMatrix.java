/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjacencymatrix;
import java.util.ArrayList;


/**
 *
 * @author ginaj
 */
public class AdjacencyMatrix {
    private ArrayList<ArrayList<Integer>> matrix;
    private int numVertices;
    private boolean directed;
    
    public AdjacencyMatrix(int numVertices, boolean directed) {
        this.numVertices = numVertices;
        this.directed = directed;
        this.matrix = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < numVertices; j++) {
                list.add(0);
            }
            this.matrix.add(list);
        }
    }
    
    private boolean validIndex(int index) {
        return index >= 0 && index < this.numVertices;
    }
    
    private boolean sameVertex(int v1, int v2) {
        return v1 == v2;
    }
    
    public void addEdge(int v1, int v2) {
        if (sameVertex(v1, v2)) {
            System.out.println("Same index");
            return;
        }
        if (!validIndex(v1) || !validIndex(v2)) {
            System.out.println("Invalid index");
            return;
        }
        this.matrix.get(v1).set(v2, 1);
        if (!this.directed) {
            this.matrix.get(v2).set(v1, 1);
        }
    }
    
    public void removeEdge(int v1, int v2) {
        if (sameVertex(v1, v2)) {
            System.out.println("Same index");
            return;
        }
        if (!validIndex(v1) || !validIndex(v2)) {
            System.out.println("Invalid index");
            return;
        }
        this.matrix.get(v1).set(v2, 0);
        if (!this.directed) {
            this.matrix.get(v2).set(v1, 0);
        }
    }
    
    public boolean hasEdge(int v1, int v2) {
        if (sameVertex(v1, v2)) {
            System.out.println("Same index");
            return false;
        }
        if (!validIndex(v1) || !validIndex(v2)) {
            System.out.println("Invalid index");
            return false;
        }
        return this.matrix.get(v1).get(v2).equals(1);
    }
    
    public void addVertex(int v1) { //connection is from newly added vertex to v1 (if directed)
        if (!validIndex(v1) || v1 == this.numVertices) {
            System.out.println("Invalid index");
            return;
        }
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            if (i == v1) {
                newList.add(1);
            } else {
                newList.add(0);
            }
            ArrayList<Integer> list = this.matrix.get(i);
            if (!this.directed && i == v1) {
                list.add(1);
            } else {
                list.add(0);
            }
        }
        newList.add(0);
        this.matrix.add(newList);
        this.numVertices++;
    }
 
    public void insertVertex(int index, int v1) { //connection is from newly added vertex to v1 (if undirected, also adds back connection
        if (index == this.numVertices) {
            addVertex(v1);
            return;
        }
        if (!validIndex(index)) {
            System.out.println("Invalid index");
            return;
        }
        if (sameVertex(v1, index)) {
            System.out.println("Same index");
            return;
        }
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            if (i == v1) {
                newList.add(1);
            } else {
                newList.add(0);
            }
            ArrayList<Integer> list = this.matrix.get(i);
            if (!this.directed && i == v1) {
                list.add(index, 1);
            } else {
                list.add(index, 0);
            }
        }
        newList.add(0);
        this.matrix.add(index, newList);
        this.numVertices++;
    }
    
    public void removeVertex(int v) {
        if (!validIndex(v)) {
            System.out.println("Invalid index");
            return;
        }
        for (int i = 0; i < this.numVertices; i++) {
            this.matrix.get(i).remove(v);
        }
        this.matrix.remove(v);
        this.numVertices--;
    }
    
    public void printMatrix() {
        System.out.println("Adjacency matrix:");
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.matrix.get(i).get(j) + " ");
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
        
        graph.addVertex(5);
        graph.printMatrix();

        /*
        System.out.println("Testing if it breaks when checking an edge between vertex 1 and 5 (5 is out of bounds)");
        graph.hasEdge(1, 5);
        System.out.println();
        
        System.out.println("Inserting new vertex at index 2");
        graph.insertVertex(2, 0);
        graph.printMatrix();
        System.out.println();
        
        graph.removeEdge(0, 1);
        System.out.println("Removing edge between 0 and 1");
        graph.printMatrix();
        System.out.println();
        
        System.out.println("Removing vertex 1");
        graph.removeVertex(1);
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
        
        directedGraph.addVertex(0);
        directedGraph.printMatrix();
        System.out.println();
        
        directedGraph.removeEdge(4, 1);
        System.out.println("Removing edge from 4 to 1");
        directedGraph.printMatrix();
        */
    }
}
