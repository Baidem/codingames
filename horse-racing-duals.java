// ******************** Chevaux de course *****************
// https://www.codingame.com/ide/puzzle/horse-racing-duals


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
        int[] pis = new int[N];
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            pis[i] = pi;
        }
        Arrays.sort(pis);
        int gapMin = 10000000;
        int i = 0;
        do {
            int s = pis[i+1] - pis[i];
            if (s < gapMin) {
                gapMin = s;
            }
            i++;
        } while (i < N-1);
        
        System.out.println(gapMin);
    }
}