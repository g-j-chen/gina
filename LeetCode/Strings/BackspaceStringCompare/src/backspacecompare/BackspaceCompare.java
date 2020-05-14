/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backspacecompare;

/**
 *
 * @author ginaj
 */
public class BackspaceCompare {

    /**
     * @param S
     * @param T
     * @return 
     */
    
    public static boolean backspaceCompare(String S, String T) {
        int sp = S.length() - 1;
        int tp = T.length() - 1;
        int sCounter = 0;
        int tCounter = 0;
        char sChar = '$';
        char tChar = '$';
        while(sp >= 0 || tp >= 0) {
            if(sp > -1) {
                sChar = S.charAt(sp);
            } else {
                sChar = '$';
            }
            if(tp > -1) {
                tChar = T.charAt(tp);
            } else {
                tChar = '$';
            }
            if(sChar == '#' || tChar == '#') {
                if(sChar == '#') {
                    sCounter++;
                    sp--;
                }
                if(tChar == '#') {
                    tCounter++;
                    tp--;
                }
                //System.out.println("counts after #: " + sCounter + " " + tCounter);
                //System.out.println("pointers after #: " + sp + " " + tp);
                continue;
            }
            
            if((sCounter > 0 && sp > -1) || (tCounter > 0 && tp > -1)) {
                if(sCounter > 0 && sp > -1) {
                    sp--;
                    sCounter--;
                }
                if(tCounter > 0 && tp > -1) {
                    tp--;
                    tCounter--;
                }
                //System.out.println("counts after removing: " + sCounter + " " + tCounter);
                //System.out.println("pointers after removing: " + sp + " " + tp);
                continue;
            }
            System.out.println("chars: " + sChar + " " + tChar);
            if(sChar == tChar) {
                sp--;
                tp--;
            } else {
                break;
            }
        }
        return (sp == -1 && tp == -1);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("S = 'j##yc##bs#srqpfzantto###########i#mwb', T = 'j##yc##bs#srqpf#zantto###########i#mwb' " + backspaceCompare("j##yc##bs#srqpfzantto###########i#mwb", "j##yc##bs#srqpf#zantto###########i#mwb"));
        System.out.println("S = 'ab#c', T = 'ad#c' " + backspaceCompare("ab#c", "ad#c"));
        System.out.println("S = 'ab##', T = 'c#d#' " + backspaceCompare("ab##", "c#d#"));
        System.out.println("S = 'a##c', T = '#a#c' " + backspaceCompare("a##c", "#a#c"));
        System.out.println("S = 'a#c', T = 'b' " + backspaceCompare("a#c", "b"));
    }
    
}
