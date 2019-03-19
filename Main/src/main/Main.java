/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

/**
 *
 * @author ginaj
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv";
        String t = "bsdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv";
        System.out.println(appendAndDelete(s, t, 100));
 
    }
    
    public static String appendAndDelete(String s, String t, int k) {
        String answer = "";
        int pos = 0;
        for(int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if(s.charAt(i) == t.charAt(i)) {
                pos++;
            } else {
                break;
            }
        }
        
        if((s.length() + t.length() - 2 * pos) > k) {
            answer = "No";
        } else if((s.length() + t.length() - 2 * pos) % 2 == k % 2) {
            answer = "Yes";
        } else if(s.length() + t.length() - k < 0) {
            answer = "Yes";
        } else {
            answer = "No";
        }
        
        return answer;
    }
    
    
}
