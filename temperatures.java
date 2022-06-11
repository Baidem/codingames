//****************** Températures *********************
//https://www.codingame.com/ide/puzzle/temperatures

import java.util.*;
import java.io.*;
import java.math.*;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int result = 0;
        List<Integer> temperatures=new ArrayList<Integer>();
        List<Integer> tempAbss=new ArrayList<Integer>();
 
   
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            temperatures.add(t);
        }
        if (temperatures.size() < 1) {
            result = 0; 
        } else {
            for (Integer t : temperatures) {
                tempAbss.add(Math.abs(t));
            }
            int minAbs = Collections.min(tempAbss);
            result = -273;
            for (int i = 0; i < tempAbss.size(); i++) {
                if (tempAbss.get(i) == minAbs) {
                    if (result <= temperatures.get(i)) {
                        result = temperatures.get(i) ;
                    }    
                }
            }
        }
        System.out.println(result);
    }
}