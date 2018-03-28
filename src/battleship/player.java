package battleship;

import java.util.Scanner;

public class player {
	
	//Creation of global arrays where all values will be writen 
	private String[] name = new String[3];
	private int[] age = new int[3];
	private String[] email = new String[3];
	private int[] points = new int[3];
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
		Arrays();
	
	}
	
	public void Arrays() {
		//create counter variable for loop, to don't change players variable
		int counter = players;
		
		//loop for writing all players info one by one
		for(int i=0; i<=counter-1;i++) {
			boolean valid;
			
			//one more loop to check if name is right
			System.out.println("Please Enter full name of "+(i+1)+" player");
			do {
			Scanner in = new Scanner(System.in);
			String nameIn = in.nextLine();
			
			//write the name in array if check returns true
			if(checkName(nameIn)==true) {
				valid=true;
				this.name[i] = nameIn;
			}else {
				valid=false;
				System.out.println("Please enter FULL name");
			}
			}while(valid == false);
			
			//Do while loop for writing in age array and check if age is right
			System.out.println("Please Enter Age of "+(i+1)+" player");
			do {
				Scanner in = new Scanner(System.in);
				String ageIn = in.nextLine();
				
				//write the age in array if check returns true
				if(checkAge(ageIn)==true) {
					valid=true;
					this.age[i] = Integer.valueOf(ageIn);
				}else {
					valid=false;
					System.out.println("Your age or input arent corect pls try again");
				}
				}while(valid == false);
                
                System.out.println("Please Enter Email addres of "+(i+1)+" player");
    			do {
    				Scanner in = new Scanner(System.in);
    				String emailIn = in.nextLine();
    				
    				//write the age in array if check returns true
    				if(checkEmail(emailIn)==true) {
    					valid=true;
    					this.email[i] = emailIn;
    				}else {
    					valid=false;
    					System.out.println("Your email are incorect pls try again");
    				}
    				}while(valid == false);
		
		}
	}
	//boolean method to check if in name have space
	boolean checkName(String in) {
		
		if(in.contains(" ")) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//boolean method for age check if its more 12 and under 100 and if input is numbers
	boolean checkAge(String in) {
		//check if input is a number
		if(in.matches("[0-9]+") ) {
	    //if its is a number check the range of ages 
		int IntIn = Integer.valueOf(in); 
		if(IntIn>12 && IntIn<100) {
			return true;
		}else {
			return false;
		}
		//if its not a number return false
		}else {
			return false;
		}
	}
	
	//boolean method for e-mail check
	boolean checkEmail(String in) {
		//if input have . and @ return true 
		if(in.contains(".") && in.contains("@"))  {
		return true;
		}else {
		return false;
		}
	}
		
	

}
