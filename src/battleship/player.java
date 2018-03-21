package battleship;

import java.util.Scanner;

public class player {
	
	//Creation of global arrays where all values will be writen 
	private String[] name;
	private int[] age;
	private String[] email;
	private int[] points;
	private int players;
	
	public player() {
		
		System.out.println("Welcome");
		System.out.println("Chuse hove many players will play");
		System.out.println("MIN=1; MAX=4;");
		System.out.println("Write plese number");
		
		boolean valid = true;
		//Loop for asking input until user entered number from 1 to 4
		
		do {
		// Reading input
		Scanner in = new Scanner(System.in);
		String nPlayers = in.nextLine();
		
		//if number in nPlayers mathces from 1 to 4 everithing is goood
		if(nPlayers.matches("[1-4]")) {
			valid=true;
			players = Integer.valueOf(nPlayers);
		}else {
			valid=false;
			System.out.println("*****ERROR*****");
			System.out.println("Please Enter number from 1 to 4");
		}
		
		}while(valid==false);
		setArrays();
	
	}
	
	public void setArrays() {
		
		for(int i=0; i<=players-1;i++) {
			
			System.out.println("Please Enter full name of "+players+" player");
			Scanner in = new Scanner(System.in);
			String name = in.nextLine();
			checkName(name);
			
		}
	}
	boolean checkName(String in) {
		
		if(in.contains(" ")) {
			return true;
		}else {
			return false;
		}
		
	}
		
	

}
