package battleship;

import java.util.ArrayList;
import java.util.Scanner;

//TARAS BOREYKO 
//ID 2017284
public class Main {
	//array list where will be transfer all information about players
	ArrayList <Player> p_list = new ArrayList<>();
	private int players;
	
	//Method for asking the numbers of players

			
	public Main() {
		
	/*	System.out.println("Welcome");
		System.out.println("How many players will play?");
		System.out.println("MIN=1; MAX=4;");
		System.out.println("Enter please number");
		
		boolean valid = true;
		//Loop for asking input until user entered number from 1 to 4
		
		do {
		// Reading input
		Scanner in = new Scanner(System.in);
		String nPlayers = in.nextLine();
		
		//if number in nPlayers matches from 1 to 4 everything is good
		if(nPlayers.matches("[1-4]")) {
			valid=true;
			players = Integer.valueOf(nPlayers);
		}else {
			valid=false;
			System.out.println("*****ERROR*****");
			System.out.println("Please Enter number from 1 to 4");
		}
		
		}while(valid==false);	
		
	//create object from class player 
	Player p = new Player();
	int conter = 0;
	// do while loop to ask information from all players one by one and will be stored in array list
	do {
	System.out.println("Player "+(conter+1)+" please enter information");
	p.setInfo();
	p_list.add(p);
	
	conter++;
	}while(conter != players); */
	Board b = new Board();
	
	b.Size();
	b.getBoard();
	b.firstBoard();
	b.printBoard();
	b.setParam();
	b.setSizeOfShip();
	b.setShip();
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();	
	}

}
