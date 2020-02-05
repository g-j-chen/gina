/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjacencylist;

import java.util.LinkedList;

/**
 *
 * @author ginaj
 */
public class AdjacencyList {
    private int numVertices;
    private boolean directed;
    private LinkedList<Integer> adjList[];
    
    public AdjacencyList(int numVertices, boolean directed) {
        this.numVertices = numVertices;
        this.directed = directed;
        this.adjList = new LinkedList[numVertices];
        
        for (int i = 0; i < this.numVertices; i++) {
            this.adjList[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int v1, int v2) {
        this.adjList[v1].add(v2);
        if (!this.directed) {
            adjList[v2].add(v1);
        }
    }
    
    public void removeEdge(int v1, int v2) {
        LinkedList listOne = this.adjList[v1];
        for (Object l : listOne) {
            if (l.equals(v2)) {
                listOne.remove(l);
                break;
            }
        }
        this.adjList[v1] = listOne;

        if (!this.directed) {
            LinkedList listTwo = this.adjList[v2];
            for (Object l : listTwo) {
                if (l.equals(v1)) {
                    listTwo.remove(l);
                    break;
                }
            }
            this.adjList[v2] = listTwo;
        }
    }
    
    public boolean hasEdge(int v1, int v2) {
        return this.adjList[v1].contains(v2);
    }
    
    public void printList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < this.numVertices; i++) {
            System.out.print("Vertex " + i + " connects to: ");
            for (int j = 0; j < this.adjList[i].size(); j++) {
                System.out.print(this.adjList[i].get(j) + " ");
            }
            System.out.println();
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
