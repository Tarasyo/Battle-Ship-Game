package battleship;

import java.util.ArrayList;
import java.util.Scanner;

//TARAS BOREYKO 
//ID 2017284
public class Main {
	//array list where will be transfer all information about players
	ArrayList <Player> pList = new ArrayList<>();
	private int players;
	private boolean theEnd = false;
	
	

			
	public Main() {
		
		System.out.println("Welcome");
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
	
	int conter = 0;
	// do while loop to ask information from all players one by one and will be stored in array list
	do {
	System.out.println("Player "+(conter+1)+" please enter information");
	Player p = new Player();//creating new object from player class
	p.setInfo();
	pList.add(p);//adding new object to arrayList
	
	conter++;
	}while(conter != players); 

	Board b = new Board();
	
	b.Size();
	b.getBoard();
	b.firstBoard();
	b.setParam();
	b.setSizeOfShip();
	b.setShip();
	b.printBoard();
	int hits = 0;
	//TTTTTTTTTTTTTTTTTTTTTTTTT   This part is for playing the game TTTTTTTTTTTTTTTTTTTTTTTTTT
	//while loop for game. Its will work until theEnd will be true
	while(!theEnd){
	int row = b.getRows();
	int col = b.getColum();	//this 2 we take from boat class with getter, we will need them to operate with sizes of board and check
	boolean val = false;
	String rowX;
	String colY;
	double check;
	int sizeShip = b.getSizeShip(); //we will need size of the ship to check if game is finished so initialised variable with getter
	Scanner in = new Scanner(System.in);
	for(int i = 0; i<players; i++) {
		System.out.println("\nIt's "+pList.get(i).getName()+" turn");
	//do while loop to ask for input until its will be valid 
		
	do {
		//input for rows and columns
		System.out.println("Please Enter row");
		rowX = in.nextLine();
		System.out.println("Please Enter colum");
		colY = in.nextLine();
		
		//check if its digits
	if(rowX.matches("[0-9]+") && colY.matches("[0-9]+")) {
		
		//check if its in  the size of board
		if((Integer.valueOf(rowX)>=1 && Integer.valueOf(rowX)<=row) && 
				(Integer.valueOf(colY)<=col && Integer.valueOf(colY)>=1)) {
			
			//Check if the slot in this coordinates was hit
			if(b.checkSlot(Integer.valueOf(rowX), Integer.valueOf(colY))) {
			val = true;
				}else {
			val = false;
			System.out.println("This coordinates had been hit Please try different one");
			}
		}else {
			val = false;
			System.out.println("Please Enter row from 1 to "+row+" and columna form 1 to "+col);
		}
	}else {
		val = false;
		System.out.println("Please Enter just numbers");
	}
	}while(val == false);
	
	check = Double.valueOf(rowX+"."+colY);
	boolean checkHit = false;
	
	//loop that are called from board class to check if coordinates have the hit the ship that stored in array
	for(int j=0; j<sizeShip; j++) {
	 checkHit = b.chekHit(j, check);
	 
	 //break the loop if in check of array returns true
	 if(checkHit==true) {
		 break;
	 }
	}
		//if its hit add one more point to the player score 
		if(checkHit) {
		hits+=1; //hits count plus as well to check in the end how many times in total was hit the ship
		pList.get(i).plusHits();
		System.out.println("GOOD MAN!!! You hit the ship");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//and set for this coordinates X what will mean the ship are hit
		b.setHitBoard(Integer.valueOf(rowX), Integer.valueOf(colY));
		
		}else {
			
		pList.get(i).plusMiss();
		System.out.println("NO SORRY, ITS A MISS");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		b.setMissBoard(Integer.valueOf(rowX), Integer.valueOf(colY));
		
	}
		System.out.println("X - HIT;  O - MISS  Blank spase still free to hit");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		b.printBoard();
		//if all ship was destroyed break the loop
		if(hits==sizeShip) {
			break;
			}
	}
	//Check if the hits equals size of ship then game TheEnd initialised true and the game will finished
	if(hits==sizeShip) {
		this.theEnd = true;
		}
	}
		//TTTTTTTTTTTTTTTTTTTTTTTTT   This part is for check who is the winner TTTTTTTTTTTTTTTTTTTTTTTTTT
        String winner = "";
        int bestScore = 400;
        boolean draw = false;

       //loop check if new player have smaller score then best score and if yes, he will be initialised in winner 
        for(int i = 0; i < players; i++){
        	//Score counts All misses minus hits
           if(pList.get(i).getMiss() - pList.get(i).getPoints() < bestScore){
               winner = pList.get(i).getName();
               bestScore = pList.get(i).getMiss() - pList.get(i).getPoints();
               draw = false;

           } //if its will be same score then its will initialised for draw true and store names of ALL winners in winners 
           else if(pList.get(i).getMiss() - pList.get(i).getPoints() == bestScore){ 
                draw = true;
                winner = winner + " and " + pList.get(i).getName();
           }

        }
        	//Out print Names and scores of winners first for draw
        if(draw){ 
        	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.print("Draw!!! Good job guys "+winner+"  Score: "+bestScore);
            
            //Second for one winner
        } else { 
        	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        	System.out.print("Winner is: "+winner+" with best score: "+bestScore);
        }
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();	
	}

}
