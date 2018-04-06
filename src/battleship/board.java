package battleship;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//TARAS BOREYKO 
//ID 2017284
public class Board {
	//I decide to write columns and rows not width and height
	private int row;
	private int col;
	//This array for board
	private String Board[][];
	//some variables that we will use in future 
	private boolean isVertical;
	//for store the size of ship
	private int sizeShip;
	//array where the ship will be stored
	private double[] ship;
	//coordinates for first part of ship with which will work
	private int x;
	private int y;
	
	public Board() {
		
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
		// Initialising rows and colum after check if input is numbers 
			this.col = Integer.valueOf(width);
			this.row = Integer.valueOf(hight);
			
			//check if size will be from 10 to 20;
			if((this.col>=10 && this.row>=10) && (this.col<=20 && this.row<=20)) {
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
	   
	}
	//Initialisation for size of Array and bring it to main
	public String[][] getBoard() {
			return Board = new String[row+1][col+1];
	}
	
	//Setting first board that will be showing on  the beginning of the game
	public void firstBoard() {
		int i,j;
		//in the coordinate 0 0 will be empty 
		Board[0][0] = "  ";
		// this loop to write number coordinates on  0 row from 1 to 9 
		for(j=1; j<10; j++) {
			Board[0][j] = "  "+String.valueOf(j);
		}
		
		//loop to write numbers in coloms after 10, that board looks nice 
		for(j=10; j<=col; j++)
			Board[0][j] = " "+String.valueOf(j); 
				
		// this loop to write numbers of coordinates on 0 column from 1 to 9
		for(i=1; i<10; i++) {
			Board[i][0] = " "+String.valueOf(i)+"|";
		}
		
		//loop to write numbers in row after 10, that board looks nice 
		for(i=10; i<=row; i++)
		Board[i][0] = String.valueOf(i)+"|"; 
		
		//this double loop to write actual board 
		for(i=1; i<=row; i++) {
			for(j=1; j<=col; j++) {
				Board[i][j] = "_ |";
			}
		}
	}
	//method to print board, I can call this method when I need to print new boar after chenges 
	public void printBoard() {
		int i,j;
		
		for(i=0; i<=row; i++) {
			
			for(j=0; j<=col; j++) {
				System.out.print(Board[i][j]);
			}
			System.out.println("");//start new row
		}
	}
	//In this method will be set parameters for ship
	public void setParam() {
		//this is size that divide width of board on 3 and round 
		this.sizeShip = Math.round(col/3);
		
		//boolean for vertical if its true or false
		this.isVertical = new Random().nextBoolean();
		
		//random generator for my coordinates 
		Random rand = new Random();
		
		//first random coordinates 
		this.x = rand.nextInt(this.row) + 1;
		this.y = rand.nextInt(this.col) + 1;
		
		System.out.println(x+" "+y+isVertical+sizeShip);
	}
	//Setting size of array that we need for ship
	public double[] setSizeOfShip() {
		return ship = new double[sizeShip];
	}
	//method to set the random place for ship
	public void setShip() {
		//if its vertical do this
		if(isVertical) {
			//if its enough space to + the size of the ship do +
			if((x+sizeShip)<=row) {
				for(int i=0; i<sizeShip; i++) {
					this.ship[i] = Double.valueOf((x+i)+"."+y);
				}
			//if not, minus the size 
			}else {
				for(int i=0; i>((-1)*sizeShip); i--) {
					this.ship[i] = Double.valueOf((x+i)+"."+y);
				}
			}
			//If its not Vertical do horizontal
		}else {
			//if enough space for + do this
			if((x+sizeShip)<=row) {
				for(int i=0; i<sizeShip; i++) {
					this.ship[i] = Double.valueOf(x+"."+(y+i));
				}
			//if not, minus the size 
			}else {
				for(int i=0; i>((-1)*sizeShip); i--) {
					this.ship[i] = Double.valueOf(x+"."+(y+i));
				}
		}
	}
					for(int i=0; i<(sizeShip);i++){
						System.out.println(ship[i]);
					}
	}
}
