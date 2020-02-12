/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijsktra;

/**
 *
 * @author ginaj
 */
public class Dijkstra {
    
    private int[] distance;
    private int[] previous;
    private boolean[] visited;
    private int size;
    
    public void dijkstra(int[][] matrix, int start) {
        this.size = matrix.length;
        this.distance = new int[this.size];
        this.previous = new int[this.size];
        this.visited = new boolean[this.size];
        for (int i = 0; i < this.size; i++) {
            this.distance[i] = Integer.MAX_VALUE;
            this.previous[i] = -1;
        }
        
        this.distance[start] = 0;
        
        for (int i = 0; i < this.size - 1; i++) {
            int next = minDistance();
            this.visited[next] = true;
            for (int j = 0; j < this.size; j++) {
                int calcDistance = this.distance[next] + matrix[next][j];
                if (!this.visited[j] && (matrix[next][j] != 0) && (calcDistance < this.distance[j])) {
                    this.distance[j] = calcDistance;
                    this.previous[j] = next;
                }
            }
        }
        printPath();
    }
    
    public int minDistance() {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.distance[i] < min && !this.visited[i]) {
                min = this.distance[i];
                index = i;
            }
        }
        return index;
    }
    
    public void printPath() {
        System.out.println("Vertex \t Distance from start \t Previous vertex");
        for (int i = 0; i < this.size; i++) {
            System.out.println(i + " \t\t " + this.distance[i] + " \t\t\t " + this.previous[i]);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int matrix[][] = new int[][] {  { 0, 8, 0, 0, 7 }, 
                                      { 8, 0, 2, 16, 12 }, 
                                      { 0, 2, 0, 6, 0 }, 
                                      { 0, 16, 6, 0, 14 }, 
                                      { 7, 12, 0, 14, 0 } }; 
        Dijkstra d = new Dijkstra();
        d.dijkstra(matrix, 0);
    }
}
