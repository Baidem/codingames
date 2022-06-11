---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
************************ Unary *******************


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

---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
****************** Températures *********************

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

---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
******************** La descente *****************

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * The while loop represents the game.
 * Each iteration represents a turn of the game
 * where you are given inputs (the heights of the mountains)
 * and where you have to print an output (the index of the mountain to fire on)
 * The inputs you are given are automatically updated according to your last actions.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            List<Integer> mounts = new ArrayList<Integer>();
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.
                mounts.add(mountainH);
            }
            int hmax = Collections.max(mounts);
            Integer index = mounts.lastIndexOf(hmax);
            String result = index.toString();
            System.out.println(result); // The index of the mountain to fire on.
        }
    }
}

---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
******************** Rock Paper Scissors Lizard Spock *****************

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String winnerName = "";
        String defeatedList = "";
        List<Player> players = new ArrayList<Player>();
        List<Player> winningPlayers = new ArrayList<Player>();

        // Init players list 
        for (int i = 0; i < N; i++) {
            Integer NUMPLAYER = in.nextInt(); // Integer ==> Integer.parseInt(playerBlue.name)
            String SIGNPLAYER = in.next();
            String numPlayer = NUMPLAYER.toString();
            Player player = new Player(numPlayer, SIGNPLAYER);
            players.add(player);
        }

        // matchs play
        int condition = players.size();
        while (condition > 1) {
            for (int i = 0; i < players.size(); i += 2) {
                Match match = new Match(players.get(i), players.get(i+1));
                winningPlayers.add(match.fight()); 
            }
            players = winningPlayers;
            winningPlayers = new ArrayList<Player>();
            condition = players.size();
        }
        
        //Result display
        winnerName = players.get(0).getName();
        defeatedList = players.get(0).getLosersString();
        defeatedList = defeatedList.substring(0, defeatedList.length()-1);//delete last space
        System.out.println(winnerName);
        System.out.println(defeatedList);
    }
}

class Player {

    public String name;
    public String weapon;
    public String losersString;

    public Player() {
    this.losersString = ""; 
    }
    public Player(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
        this.losersString = ""; 
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWeapon() {
        return weapon;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    public String getLosersString() {
        return losersString;
    }
    public void setLosersString(String losersString) {
        this.losersString = losersString;
    }
}

class Match {

    private Player playerBlue;
    private Player playerRed;

    public Match(Player playerBlue, Player playerRed) {
        this.playerBlue = playerBlue;
        this.playerRed = playerRed;
    }
    public Player winnerIs(Player winner, Player loser) {
        Player playerWinned = new Player();
        String losersList = winner.getLosersString();
        losersList += loser.getName() + " ";
        playerWinned.setName(winner.getName());
        playerWinned.setWeapon(winner.getWeapon());
        playerWinned.setLosersString(losersList);
        return playerWinned;
    }
    public Player fight() {
        Player winnerFight = new Player();
        if (playerBlue.weapon.equals(playerRed.weapon)) {// if DRAW
            if (Integer.parseInt(playerBlue.name) < Integer.parseInt(playerRed.name)) {
                winnerFight = winnerIs(playerBlue, playerRed);
            } else {
                winnerFight = winnerIs(playerRed, playerBlue);
            }
        } else {// DUALS
            if (playerBlue.weapon.equals("C")) {//sCissors duals
                if (playerRed.weapon.equals("P") || playerRed.weapon.equals("L")) {//Paper or Lizard
                    winnerFight = winnerIs(playerBlue, playerRed);
                } else {// Spock or Rock
                    winnerFight = winnerIs(playerRed, playerBlue);
                }
            } else if (playerBlue.weapon.equals("P")) {//Paper duals
                if (playerRed.weapon.equals("R") || playerRed.weapon.equals("S")) {//Rock or Spock
                    winnerFight = winnerIs(playerBlue, playerRed);
                } else {//sCissors or Lizard
                    winnerFight = winnerIs(playerRed, playerBlue);
                }
            } else if (playerBlue.weapon.equals("R")) {//Rock duals
                if (playerRed.weapon.equals("L") || playerRed.weapon.equals("C")) {//Lizard or sCissors
                    winnerFight = winnerIs(playerBlue, playerRed);
                } else {//Paper or Rock
                    winnerFight = winnerIs(playerRed, playerBlue);
                }
            } else if (playerBlue.weapon.equals("L")) {//Lizard duals
                if (playerRed.weapon.equals("S") || playerRed.weapon.equals("P")) {//Spock or Paper
                    winnerFight = winnerIs(playerBlue, playerRed);
                } else {//Rock or Spock
                    winnerFight = winnerIs(playerRed, playerBlue);
                }
            } else if (playerBlue.weapon.equals("S")) {//Spock duals
                if (playerRed.weapon.equals("C") || playerRed.weapon.equals("R")) {//sCissors
                    winnerFight = winnerIs(playerBlue, playerRed);
                } else {//Lizard or Paper
                    winnerFight = winnerIs(playerRed, playerBlue);
                }
            }        
        }
    return winnerFight;
    }
}


---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
******************** Sudoku Solver *****************

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

---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
******************** Reverse FizzBuzz *****************

import java.util.*;
//import java.io.*;
//import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    public static void main(String args[]) {
        Tables tables = new Tables();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (Integer i = 0; i < n; i++) {
            String line = in.nextLine();
            tables.setStringList(line);
        }
        tables.buildIntegerList();
        System.out.println(tables.result());
    }
}

class Tables {

    private List<String> stringList;
    private Integer[] integerList;

    public Tables() {
        this.stringList = new ArrayList<String>();
    }

    public void setStringList(String line) {
        this.stringList.add(line);
    }

    public void buildIntegerList() {
        this.integerList = new Integer[this.stringList.size()];
        Integer start = 1;
        if (haveNumber()) {
            String string = "0";
            int i=0;    
            do{ 
                string = stringList.get(i);
                if (isNumber(string)) {
                    start = Integer.parseInt(stringList.get(i))-i;
                    i = stringList.size();
                }
            i++;    
            } while (i <= stringList.size());
        }
        for (int i = 0; i < stringList.size(); i++) {
            integerList[i] = start+i;
        }
    }

    private boolean haveNumber() {
        for (String string : stringList) {
            if (!(string.contains("zz"))) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isNumber(String string) {
        if (!(string.contains("zz"))) {
            return true;
        }
        return false;
    }

    public String result() {
        String fizz="";
        String buzz="";
        List<Integer> fizzIndexs = new ArrayList<Integer>();
        List<Integer> buzzIndexs = new ArrayList<Integer>();
        Integer i=0;
        do {// make lists fizzIndexs and buzzIndexs
            if (!isNumber(stringList.get(i))) {
                if (stringList.get(i).contains("Fizz")) {
                    fizzIndexs.add(i);
                }
                if (stringList.get(i).contains("Buzz")){
                    buzzIndexs.add(i);
                }
            }
            i++;
        } while (i < stringList.size());
        if (fizzIndexs.size() > 1) {// tests for fizz
            Integer x = (integerList[fizzIndexs.get(1)]-integerList[fizzIndexs.get(0)]);
            fizz = x.toString();
        } else if (fizzIndexs.size() == 1) {
            Integer x = integerList[fizzIndexs.get(0)];
            fizz = x.toString();
        } else {
            fizz = "Fizz not found";
        }
        if (buzzIndexs.size() > 1) {// tests for buzz
            Integer x = integerList[buzzIndexs.get(1)]-integerList[buzzIndexs.get(0)];
            buzz = x.toString();
        } else if (buzzIndexs.size() == 1) {
            Integer x = integerList[buzzIndexs.get(0)];
            buzz = x.toString();
        } else {
            buzz = "Buzz not found";
        }
        return fizz + " " + buzz;
    }
}

---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
******************** Câblage réseau *****************

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

---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------
******************** Chevaux de course *****************

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