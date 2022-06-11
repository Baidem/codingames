/**
 * Unary
 * https://www.codingame.com/ide/puzzle/unary
 **/

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
        String MESSAGE = in.nextLine();

        String messageString = MESSAGE;
        String binaryString = "";
        char[] messChar = messageString.toCharArray();

       
        String code = "";

        for (int i = 0; i < messChar.length; i++) {
            int l = Integer.toBinaryString(messChar[i]).length();
            if (l < 7 ){
                int d = 7 - l;
                for (int index = 0; index < d; index++) {
                    binaryString += '0';    
                }
            }

            binaryString += Integer.toBinaryString(messChar[i]);

        }

        messChar = binaryString.toCharArray();
        //System.out.println(messChar);

        char balance = '2';
        for (int i = 0; i < messChar.length; i++) {
            if (balance == '2') {
                if (messChar[i] == '0') {balance = '0'; code+= "00 ";}
                else if (messChar[i] == '1'){balance = '1'; code+= "0 ";}
                code+="0";
            } else if(balance != messChar[i]){
                balance = messChar[i];
                if (messChar[i] == '0') {balance = '0'; code+= " 00 ";}
                else if (messChar[i] == '1'){balance = '1'; code+= " 0 ";}
                code+="0";
              
            } else if (balance == messChar[i]){
                code+= "0";
            }
        }
    System.out.println(code);

    }
}