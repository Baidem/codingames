// ******************** Reverse FizzBuzz *****************
// https://www.codingame.com/ide/puzzle/reverse-fizzbuzz


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