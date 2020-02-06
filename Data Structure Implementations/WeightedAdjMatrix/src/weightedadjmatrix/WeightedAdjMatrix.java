/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weightedadjmatrix;

import java.util.ArrayList;

/**
 *
 * @author ginaj
 */
public class WeightedAdjMatrix {
    private ArrayList<ArrayList<Integer>> matrix;
    private boolean directed;
    private int numVertices;
    
    public WeightedAdjMatrix(int numVertices, boolean directed) {
        this.numVertices = numVertices;
        this.directed = directed;
        this.matrix = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < numVertices; j++) {
                list.add(-1);
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
    
    public void addEdge(int v1, int v2, int w) {
        if (sameVertex(v1, v2)) {
            System.out.println("Same index");
            return;
        }
        if (!validIndex(v1) || !validIndex(v2)) {
            System.out.println("Invalid index");
            return;
        }
        this.matrix.get(v1).set(v2, w);
        if (!this.directed) {
            this.matrix.get(v2).set(v1, w);
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
        this.matrix.get(v1).set(v2, -1);
        if (!this.directed) {
            this.matrix.get(v2).set(v1, -1);
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
        return !(this.matrix.get(v1).get(v2).equals(-1));
    }
    
    public void addVertex(int v1, int w) { //connection is from newly added vertex to v1 (if undirected, also adds back connection
        if (!validIndex(v1) || v1 == this.numVertices) {
            System.out.println("Invalid index");
            return;
        }
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            if (i == v1) {
                newList.add(w);
            } else {
                newList.add(-1);
            }
            ArrayList<Integer> list = this.matrix.get(i);
            if (!this.directed && i == v1) {
                list.add(w);
            } else {
                list.add(-1);
            }
        }
        newList.add(-1);
        this.matrix.add(newList);
        this.numVertices++;
    }
    
    public void insertVertex(int index, int v1, int w) { //connection is from newly added vertex to v1 (if undirected, also adds back connection
        if (index == this.numVertices) {
            addVertex(v1, w);
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
                newList.add(w);
            } else {
                newList.add(-1);
            }
            ArrayList<Integer> list = this.matrix.get(i);
            if (!this.directed && i == v1) {
                list.add(index, w);
            } else {
                list.add(index, -1);
            }
        }
        newList.add(-1);
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
        System.out.println("Weighted Adjacency matrix:");
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                System.out.print(this.matrix.get(i).get(j));
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
        System.out.println();
        
        System.out.println("Inserting vertex at index 4");
        graph.insertVertex(4, 0, 5);
        graph.printMatrix();
        System.out.println();
        
        System.out.println("Removing vertex 3");
        graph.removeVertex(3);
        graph.printMatrix();
        System.out.println();
        
        
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
        System.out.println();
        
        System.out.println("Adding vertex with connection to 0");
        directed.addVertex(0, 9);
        directed.printMatrix();
    }
    
}
