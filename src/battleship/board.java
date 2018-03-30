package battleship;

import java.util.InputMismatchException;
import java.util.Scanner;

//TARAS BOREYKO 
//ID 2017284
public class board {
	private int hight;
	private int width;
	//This array for board
	private String Board[][] = new String[21][21];
	
	public board() {
		
	}
	//method for get the size of board 
	public void Size() {
		boolean valid;
		 
		do {
			
		//Reade from user input for hight and width that we will use in future
		System.out.println("Please Enter width of board");
		Scanner in = new Scanner(System.in);
		String width = in.nextLine();
		 
		 System.out.println("Please Enter hight of board");
		String hight = in.nextLine();
		
		//check if input is numbers 
		if(width.matches("[0-9]+") && hight.matches("[0-9]+")) {
			
			this.width = Integer.valueOf(width);
			this.hight = Integer.valueOf(hight);
			
			//check if size will be from 10 to 20;
			if((this.width>=10 && this.hight>=10) && (this.width<=20 && this.hight<=20)) {
			valid = true;
			}else { 
			valid = false;
			System.out.println("The size must be from 10 to 20, Please try again");
			}
			
		}else {
			valid = false;
			System.out.println("Input must be just integer numbers, please try again");
		}
		}while(valid==false);
	   
		System.out.println(width+ " " + hight);
	}
	
	//Setting first board that will be showing on  the beginning of the game
	public void firstBoard() {
		int i,j;
		//in the coordinate 0 0 will be empty 
		Board[0][0] = " ";
		// this loop to write number coordinates on  0 row from 1 to size of width 
		for(j=1; j<11; j++) {
			Board[0][j] = "  "+String.valueOf(j);
		}
		
		//loop to write numbers in coloms after 10, that board looks nice 
		for(j=11; j<=width; j++)
			Board[0][j] = " "+String.valueOf(j); 
				
		// this loop to write numbers of coordinates on 0 column from 1 to 9
		for(i=1; i<10; i++) {
			Board[i][0] = " "+String.valueOf(i)+"|";
		}
		
		//loop to write numbers in row after 10, that board looks nice 
		for(i=10; i<=hight; i++)
		Board[i][0] = String.valueOf(i)+"|"; 
		
		//this double loop to write actual board 
		for(i=1; i<=hight; i++) {
			for(j=1; j<=width; j++) {
				Board[i][j] = "_ |";
			}
		}
	}
	//method to print board, I can call this method when I like and print new boar after chenges 
	public void printBoard() {
		int i,j;
		
		for(i=0; i<=hight; i++) {
			
			for(j=0; j<=width; j++) {
				System.out.print(Board[i][j]);
			}
			System.out.println("");//start new row
		}
	}

	public void ship() {
		
	}
}
