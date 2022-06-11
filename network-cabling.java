// ******************** Câblage réseau *****************
// https://www.codingame.com/ide/puzzle/network-cabling


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
        int N = in.nextInt();
        List<Long> xList= new LinkedList<Long>();
        List<Long> yList= new LinkedList<Long>(); 
        for (int i = 0; i < N; i++) {
            int X = in.nextInt();
            xList.add(Long.valueOf(X));
            int Y = in.nextInt();
            yList.add(Long.valueOf(Y));
        }
        Long xMax = Collections.max(xList);
        Long xMin = Collections.min(xList);
        Collections.sort(yList);

        Long median;
            if (yList.size() % 2 != 0) {
                median = yList.get(yList.size() / 2);
            } else {
                median = (yList.get(yList.size() / 2) + yList.get((yList.size() / 2) - 1)) / 2;
            }

        Long sum = 0l;
        for (Long y : yList) {
            sum = sum + Math.abs(median - y); 
        }
    
        System.out.println(xMax - xMin + sum);
    }
}
