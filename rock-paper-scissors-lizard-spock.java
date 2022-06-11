// ******************** Rock Paper Scissors Lizard Spock *****************
// https://www.codingame.com/ide/puzzle/rock-paper-scissors-lizard-spock


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