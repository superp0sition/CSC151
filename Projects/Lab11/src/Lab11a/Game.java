package Lab11a;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static Scanner s = new Scanner(System.in);

    private static Team fillRoster(){
        Team theTeam = new Team(); // initialize temp team to add players to
        int height = 0;
        String name = "";
        for (int i = 0; i < 3; i++) { // set to 2 to test getCurrentTeamMembers
            System.out.printf("Enter team member %d:\nName: ", i + 1);
            name = s.next();

            System.out.print("Height: ");
            height = s.nextInt(); // probably should check for errors here but I'm rushed

            theTeam.add(new Player(height, name));
        }
        return theTeam;
    }

    public static void main(String[] args) {
	    Team home;
	    Team visitor;

	    System.out.println("Enter the home team"); // generate teams
	    home = fillRoster();

        System.out.println("Enter the visiting team");
        visitor = fillRoster();

        boolean homeTaller = home.averageHeight() > visitor.averageHeight(); // only have to call once

        System.out.printf("The %s team is taller\n", homeTaller ? "home" : "visitor"); // definitely inefficient to have a repeated conditional, but I still like it better than big if blocks
        System.out.printf("Taller team roster: %s\n", homeTaller ? home : visitor);
        System.out.printf("Shorter team roster: %s\n", homeTaller ? visitor : home); // almost had this condition backwards

        // getCurrentTeamMembers tester
        //System.out.println(Arrays.toString(home.getCurrentTeamMembers()));
        //System.out.println(Arrays.toString(visitor.getCurrentTeamMembers()));

        // Note: getCurrentTeamMembers cannot be tested with the method used to get input as next() forces some string to be entered
    }
}

class Player{
    private int height = 0;
    private String name = "";

    public Player() {
    }

    public Player(int height, String name){
        this.height = height;
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        // Lab11a.Team{numPlayers=3, members=[Lab11a.Player{name='Aaron', height=73}, Lab11a.Player{name='Abe', height=78}, Lab11a.Player{name='Andrew', height=80}]}
        return "Lab11a.Player{name='%s', height=%d}".formatted(name, height); // I think there's another way to do this, but I might be thinking of C#
    }
}

class Team{
    private Player[] myTeam = new Player[0]; // length = 0 since there are now players at initialization
    private int nextOpen = 0;

    public Team(){}

    public void add(Player player){
        if(nextOpen >= 3)
            return;
        myTeam = Arrays.copyOf(myTeam, myTeam.length+1); // Add a new element only when needed
        myTeam[nextOpen++] = player; // iterate the next open index
    }

    public Player[] getCurrentTeamMembers(){
        return Arrays.copyOf(myTeam, myTeam.length);
    }

    public int averageHeight() {
        int sum = 0;
        for (int i = 0; i < nextOpen; i++) {
            sum += myTeam[i].getHeight() / (nextOpen + 1);
        }
        return sum;
    }

    public String toString(){
        // Lab11a.Team{numPlayers=3, members=[Lab11a.Player{name='Aaron', height=73}, Lab11a.Player{name='Abe', height=78}, Lab11a.Player{name='Andrew', height=80}]}
        return "Lab11a.Team{numPlayers=%d, members=%s}".formatted(nextOpen + 1, Arrays.toString(this.getCurrentTeamMembers()));
    }
}
