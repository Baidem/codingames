// ******************** Sudoku Solver *****************
// https://www.codingame.com/ide/puzzle/sudoku-solver


import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.


 Adapted from Coding with John 
 https://www.youtube.com/watch?v=mcXc8Mva2bA
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        String [] sudoku = new String[9];
        for (int i = 0; i < 9; i++) {
            String line = in.nextLine();
            sudoku[i] = line;
        }

        if (solveBoard(sudoku)) {
            for (String string : sudoku) {
            System.out.println(string);
        }
        } else {
            System.out.println("sudoku unsolvable");
        }
    }

    private static boolean isNumberInRow(String[] sudoku, String number, int row) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row].charAt(i) == number.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(String[] sudoku, String number, int column) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i].charAt(column) == number.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(String[] sudoku, String number, int row, int column) {
        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;
        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn; j < localBoxColumn +3; j++) {
                if (sudoku[i].charAt(j) == number.charAt(0)) {
                return true;    
                }
            }
        }
        return false;
    }

    private  static boolean isValidPlacement(String[] sudoku, String number, int row, int column) {
        return  !isNumberInRow(sudoku, number, row) &&
                !isNumberInColumn(sudoku, number, column) &&
                !isNumberInBox(sudoku, number, row, column);
    }
    private static boolean solveBoard(String[] sudoku) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (Character.compare(sudoku[row].charAt(column), '0') == 0) {
                    for (Integer numberToTry = 1; numberToTry <= 9; numberToTry++) {
                        if (isValidPlacement(sudoku, String.valueOf(numberToTry), row, column)) {
                            StringBuffer string = new StringBuffer(sudoku[row]);
                            string.setCharAt(column, numberToTry.toString().charAt(0));
                            sudoku[row] = string.toString();

                            if (solveBoard(sudoku)) {
                                return true;
                            }
                            else {
                                StringBuffer string0 = new StringBuffer(sudoku[row]);
                                string0.setCharAt(column, '0');
                                sudoku[row] = string0.toString();
                            }
                        }
                    }
                    return false;         
                }
            }            
        }
        return true;
    }
}