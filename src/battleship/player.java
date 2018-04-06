package battleship;
//TARAS BOREYKO 
//ID 2017284
import java.util.Scanner;

public class Player {
	
	//Creation of globals where all values will be writen 
	private String name;
	private int age;
	private String email;
	private int points;

	
	public Player() {
		
	
	}
	
	
	public void setInfo() {
		
		//loop for writing all players info one by one
			boolean valid;
			
			//one more loop to check if name is right
			System.out.println("Please Enter full name");
			do {
			Scanner in = new Scanner(System.in);
			String nameIn = in.nextLine();
			
			//write the name in array if check returns true
			if(checkName(nameIn)) {
				valid=true;
				this.name = nameIn;
			}else {
				valid=false;
				System.out.println("Please enter just letters and use full name");
			}
			}while(valid == false);
			
			//Do while loop for writing in age array and check if age is right
			System.out.println("Please Enter Age");
			do {
				Scanner in = new Scanner(System.in);
				String ageIn = in.nextLine();
				
				//write the age in array if check returns true
				if(checkAge(ageIn)) {
					valid=true;
					this.age = Integer.valueOf(ageIn);
				}else {
					valid=false;
					System.out.println("Your age or input arent corect pls try again");
				}
				}while(valid == false);
                
                System.out.println("Please Enter Email addres");
    			do {
    				Scanner in = new Scanner(System.in);
    				String emailIn = in.nextLine();
    				
    				//write the age in array if check returns true
    				if(checkEmail(emailIn)==true) {
    					valid=true;
    					this.email = emailIn;
    				}else {
    					valid=false;
    					System.out.println("Your email are incorect pls try again");
    				}
    				}while(valid == false);
		
		}
	
	//boolean method to check if in name have space and just letter's 
	boolean checkName(String in) {
		
		if(in.contains(" ")) {
		 if(in.matches("^[ A-Za-z]+$")) {
			return true;
		}else {
			return false;
		}}else {
			return false;}
		
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
	//Getters for variables 	
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public String gerEmail() {
		return this.email;
	}
	public int getPoints() {
		return this.points;
	}

	

}
