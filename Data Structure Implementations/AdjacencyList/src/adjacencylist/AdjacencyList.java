/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjacencylist;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author ginaj
 */
public class AdjacencyList {
    private int numVertices;
    private boolean directed;
    private ArrayList<LinkedList> adjList;
    
    public AdjacencyList(int numVertices, boolean directed) {
        this.numVertices = numVertices;
        this.directed = directed;
        this.adjList = new ArrayList<>();
        
        for (int i = 0; i < this.numVertices; i++) {
            this.adjList.add(new LinkedList<>());
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
        this.adjList.get(v1).add(v2);
        if (!this.directed) {
            this.adjList.get(v2).add(v1);
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
        for (Object l : this.adjList.get(v1)) {
            if (l.equals(v2)) {
                this.adjList.get(v1).remove(l);
                break;
            }
        }
        if (!this.directed) {
            for (Object l : this.adjList.get(v2)) {
                if (l.equals(v1)) {
                    this.adjList.get(v2).remove(l);
                    break;
                }
            }
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
        return this.adjList.get(v1).contains(v2);
    }
    
    public void printList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print("Vertex " + i + " connects to: ");
            for (int j = 0; j < this.adjList.get(i).size(); j++) {
                System.out.print(this.adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    
    public void addVertex(int v1) { //connection is from newly added vertex to v1 (if directed)
        if (!validIndex(v1) || v1 == this.numVertices) {
            System.out.println("Invalid index");
            return;
        }
        this.adjList.add(new LinkedList<>());
        this.adjList.get(this.numVertices).add(v1);
        if (!this.directed) {
            this.adjList.get(v1).add(this.numVertices);
        }
        this.numVertices++;
    }
    
    public void removeVertex(int v) {
        if (!validIndex(v)) {
            System.out.println("Invalid index");
            return;
        }
        this.adjList.remove(v);
        this.numVertices--;
        for (int i = 0; i < this.numVertices; i++) {
            int index = this.adjList.get(i).indexOf(v);
            if (index != -1) {
                this.adjList.get(i).remove(index);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AdjacencyList list = new AdjacencyList(5, false);
        list.addEdge(0, 1);
        list.addEdge(0, 4);
        list.addEdge(1, 2);
        list.addEdge(1, 3);
        list.addEdge(1, 4);
        list.addEdge(2, 3);
        list.addEdge(3, 4);
        list.printList();
        System.out.println("This list has edge between 1 and 3: " + list.hasEdge(1, 3));
        System.out.println();
        
        System.out.println("Adding vertex");
        list.addVertex(2);
        list.printList();
        System.out.println();
        
        System.out.println("Removing last vertex (index 5)");
        list.removeVertex(5);
        list.printList();
        System.out.println();
        
        System.out.println("Removing edge between 1 and 3");
        list.removeEdge(1, 3);
        list.printList();
        System.out.println("This list has edge between 1 and 3: " + list.hasEdge(1, 3));
        System.out.println();
        
        System.out.println("Directed adjacency list");
        AdjacencyList directed = new AdjacencyList(5, true);
        directed.addEdge(0, 1);
        directed.addEdge(0, 4);
        directed.addEdge(1, 2);
        directed.addEdge(1, 3);
        directed.addEdge(1, 4);
        directed.addEdge(2, 3);
        directed.addEdge(3, 4);
        directed.printList();
        System.out.println("This list has edge between 1 and 4: " + directed.hasEdge(1, 4));
        System.out.println();
        
        System.out.println("Removing edge from 1 to 4");
        directed.removeEdge(1, 4);
        directed.printList();
        System.out.println("This list has edge between 1 and 4: " + directed.hasEdge(1, 4));
    }
    
}
