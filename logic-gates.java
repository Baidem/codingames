// httpswww.codingame.comidepuzzlelogic-gates

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
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<String, String> inputs = new HashMap<String, String>();
        for (int i = 0; i < n; i++) {
            String inputName = in.next();
            String inputSignal = in.next();
            inputs.put(inputName, inputSignal);
        }
        String[][] outputs = new String[m][4];
        for (int i = 0; i < m; i++) {
            String outputName = in.next();
            String type = in.next();
            String inputName1 = in.next();
            String inputName2 = in.next();
            outputs[i][0] = outputName;
            outputs[i][1] = type;
            outputs[i][2] = inputName1;
            outputs[i][3] = inputName2;
        }
        for (int i = 0; i < m; i++) {
            System.out.println(outputs[i][0] + " " + funLogic(outputs[i][1], inputs.get(outputs[i][2]), inputs.get(outputs[i][3])));
        }
    }
    public static String funLogic(String type, String enter1, String enter2) {
        String result = "";
        switch (type) {
            case "AND":
                result = funAnd(enter1, enter2);
                break;
            case "OR":
                result = funOr(enter1, enter2);
                break;
            case "XOR":
                result = funXor(enter1, enter2);
                break;
            case "NAND":
                result = funNand(enter1, enter2);
                break;
            case "NOR":
                result = funNor(enter1, enter2);
                break;
            case "NXOR":
                result = funNxor(enter1, enter2);
                break;
        
            default:
                break;
        }
        return result;
    }

    public static String funAnd(String enter1, String enter2) {
        String result = "";
        for (int index = 0; index < enter1.length(); index++) {
            if ((enter1.charAt(index) == '-') && (enter2.charAt(index) == '-')) {
                result = result + '-';
            } else {
                result = result + '_';
            }
        }
        return result;
    }
    public static String funOr(String enter1, String enter2) {
        String result = "";
        for (int index = 0; index < enter1.length(); index++) {
            if ((enter1.charAt(index) == '_') && (enter2.charAt(index) == '_')) {
                result = result + '_';
            } else {
                result = result + '-';
            }
        }
        return result;
    }
    public static String funXor(String enter1, String enter2) {
        String result = "";
        for (int index = 0; index < enter1.length(); index++) {
            if ((enter1.charAt(index) == '-') && (enter2.charAt(index) == '-')
                ||
                (enter1.charAt(index) == '_') && (enter2.charAt(index) == '_')) {
                result = result + '_';
            } else {
                result = result + '-';
            }
        }
        return result;
    }
    public static String funNand(String enter1, String enter2) {
        String result = "";
        for (int index = 0; index < enter1.length(); index++) {
            if ((enter1.charAt(index) == '-') && (enter2.charAt(index) == '-')) {
                result = result + '_';
            } else {
                result = result + '-';
            }
        }
        return result;
    }
    public static String funNor(String enter1, String enter2) {
        String result = "";
        for (int index = 0; index < enter1.length(); index++) {
            if ((enter1.charAt(index) == '_') && (enter2.charAt(index) == '_')) {
                result = result + '-';
            } else {
                result = result + '_';
            }
        }
        return result;
    }

    public static String funNxor(String enter1, String enter2) {
        String result = "";
        for (int index = 0; index < enter1.length(); index++) {
            if ((enter1.charAt(index) == '-') && (enter2.charAt(index) == '-')
                ||
                (enter1.charAt(index) == '_') && (enter2.charAt(index) == '_')) {
                result = result + '-';
            } else {
                result = result + '_';
            }
        }
        return result;
    }
}