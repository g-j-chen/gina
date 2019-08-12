/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytostring;

/**
 *
 * @author ginaj
 */
public class BinaryToString {


    public static String binaryToString(double d) {
        if(d == 1) {
            return "1";
        }
        if(d == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        int limit = 30;
        while(limit > 0) {
            d *= 2;
            int fractionalBit = (int) d;
            if(fractionalBit == 1) {
                d -= fractionalBit;
                sb.append("1");
            } else {
                sb.append("0");
            }
            limit--;
            if(d == 0) {
                break;
            }
        }
        if(d != 0) {
            System.out.println(sb.toString());
            throw new NumberFormatException("ERROR");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(binaryToString(0.9999999981373549));
    }
    
}
