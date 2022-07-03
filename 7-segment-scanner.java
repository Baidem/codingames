//https://www.codingame.com/ide/puzzle/7-segment-scanner

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String line3 = in.nextLine();
        System.out.println(result(line1, line2, line3));
    }

    public static String result(String line1, String line2, String line3) {
        String result = "";
        for (int i = 0; i < line1.length()/3; i++) {
            result = result + convertCode(line1.charAt((i*3)+1) + line2.substring(0+(i*3), 3+(i*3)) + line3.substring(0+(i*3), 3+(i*3)));
        }   
        return result;
    } 

    public static String convertCode(String code) {
        if (code.equals("_| ||_|")) {return "0";}
        if (code.equals("   |  |")) {return "1";}
        if (code.equals("_ _||_ ")) {return "2";}
        if (code.equals("_ _| _|")) {return "3";}
        if (code.equals(" |_|  |")) {return "4";}
        if (code.equals("_|_  _|")) {return "5";}
        if (code.equals("_|_ |_|")) {return "6";}
        if (code.equals("_  |  |")) {return "7";}
        if (code.equals("_|_||_|")) {return "8";}
        if (code.equals("_|_| _|")) {return "9";}
        return "ERROR";
    }
}