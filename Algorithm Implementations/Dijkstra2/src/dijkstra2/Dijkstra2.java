/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;


/**
 *
 * @author ginaj
 */
public class Dijkstra2 {
    
    public static class Node implements Comparable<Node> {
        private final int value;
        private final int nodeNo;
        
        public Node(int nodeNo, int value) {
            this.value = value;
            this.nodeNo = nodeNo;
        }

        @Override
        public int compareTo(Node n) {
            if (this.value < n.value) {
                return -1;
            }
            if (n.value < this.value) {
                return 1;
            }
            return 0;
        }
        
        @Override
        public String toString() {
            return this.nodeNo + " " + this.value;
        }
    }
    
    private int distance[];
    private int previous[];
    private HashSet<Integer> visited;
    private PriorityQueue<Node> queue;
    private int size;
    private ArrayList<ArrayList<Node>> matrix;
    
    public void dijkstra2(ArrayList<ArrayList<Node>> matrix, int start) {
        this.size = matrix.size();
        this.matrix = matrix;
        this.distance = new int[size];
        this.previous = new int[size];
        this.visited = new HashSet<>();
        this.queue = new PriorityQueue<>();
        
        for (int i = 0; i < size; i++) {
            this.distance[i] = Integer.MAX_VALUE;
        }
        
        this.distance[start] = 0;
        this.previous[start] = -1;
        
        this.queue.add(new Node(start, 0));
        
        while (visited.size() != size) {
            int n = queue.remove().nodeNo;
            visited.add(n);
            for (Node a : this.matrix.get(n)) {
                if (!visited.contains(a.nodeNo)) {
                    int calcDistance = this.distance[n] + a.value;
                    if (calcDistance < this.distance[a.nodeNo]) {
                        this.distance[a.nodeNo] = calcDistance;
                        this.previous[a.nodeNo] = n;
                    }
                    this.queue.add(new Node(a.nodeNo, this.distance[a.nodeNo]));
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int size = 5;
        int start = 0;
        
        ArrayList<ArrayList<Node> > matrix = new ArrayList<>(); 
  
        for (int i = 0; i < size; i++) { 
            ArrayList<Node> item = new ArrayList<>(); 
            matrix.add(item); 
        } 
  
        matrix.get(0).add(new Node(1, 8)); 
        matrix.get(0).add(new Node(4, 7)); 
        matrix.get(1).add(new Node(2, 2)); 
        matrix.get(1).add(new Node(3, 16));
        matrix.get(1).add(new Node(4, 12)); 
        matrix.get(2).add(new Node(3, 6)); 
        matrix.get(3).add(new Node(4, 14)); 
  
        Dijkstra2 d = new Dijkstra2(); 
        d.dijkstra2(matrix, start); 
  

        System.out.println("The shorted path from node :"); 
        for (int i = 0; i < d.distance.length; i++) {
            System.out.println(start + " to " + i + " is " + d.distance[i] + " via node " + d.previous[i]); 
        } 
    }
    
}
