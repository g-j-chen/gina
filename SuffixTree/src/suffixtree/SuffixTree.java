/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suffixtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author ginaj
 */
public class SuffixTree {

    /**
     * @param args the command line arguments
     */
    public class Node {
        private int firstCharIndex;
        private int lastCharIndex;
        private List<Node> children;

        public Node(int start, int end) {
            this.firstCharIndex = start;
            this.lastCharIndex = end;
            this.children = new ArrayList<>();
        }
        
        public int getStartIndex() {
            return firstCharIndex;
        }
        
        public int getlastIndex() {
            return lastCharIndex;
        }
        
        public void setlastCharIndex(int n) {
            lastCharIndex = n;
        }
        
        @Override
        public String toString() {
            return string.substring(firstCharIndex, lastCharIndex);
        }
    }
    
    
    private String string;
    private static Node root;
    private Node activeNode;
    private char activeEdge;
    private int activeLength;
    private int remainder;
    private int position;
    
    public SuffixTree(String s) {
        this.string = s + "$";
        this.root = new Node(0, 0);
        this.activeNode = root;
        this.position = -1;
        this.activeEdge = 0;
        this.activeLength = 0;
        this.remainder = 1;
    }
    
    public void buildTree() {
        for(int i = 0; i < string.length(); i++) {
            position++;

            for(Node n : activeNode.children) {
                n.setlastCharIndex(i);
            }
            Node current = null;
            for(Node n : activeNode.children) {
                String nodeString = n.toString();
                if(string.charAt(i) == nodeString.charAt(position)) {
                    activeEdge = string.charAt(i);
                    activeLength++;
                    remainder++;
                    current = n;
                    break;
                } else {
                    activeNode.children.add(new Node(i, i + 1));

                    while(remainder > 0) {
                        current.setlastCharIndex(position - 1);
                        current.children.add(new Node(position, i + 1));
                        current.children.add(new Node(i, i + 1));
                        remainder--;
                    }
                }
            }

        }
    }
    
    public boolean findSubstring(String substring) {
        Node currentNode = root;

        for(Node n : currentNode.children) {
            int i = 0;
            int nodeIndex = n.firstCharIndex;
            
            while(string.charAt(nodeIndex) == substring.charAt(i)) {
                nodeIndex++;
                i++;

                if(i == substring.length()) {
                    return true;
                }
                if(nodeIndex == string.length() && i < substring.length()) {
                    return false;
                }
            }
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        SuffixTree st = new SuffixTree("abcd");
        st.buildTree();
        //System.out.println(st.findSubstring("abcd"));
        root.children.forEach((n) -> {
            System.out.println(n);
        });
    }
    
}
