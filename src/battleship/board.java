package battleship;

public class board {
	//This array will be for drawing on screen board
	private String DBoard[][] = new String[11][11];
	//this is actual board where players will play and will check if hit target
	private String PBoard[][] = new String[11][11];
	
	public board() {
		
		
	}
	//Setting first board that will be showing on  the beginning of the game
	public void firstBoard() {
		int i,j;
		//in the coordinate 0 0 will be empty 
		DBoard[0][0] = " ";
		// this loop to write number coordinates on  0 row from 1 to 10 
		for(j=1; j<11; j++) {
			DBoard[0][j] = "  "+String.valueOf(j);
		}
		// this loop to write numbers of coordinates on 0 column from 1 to 10
		for(i=1; i<10; i++) {
			DBoard[i][0] = " "+String.valueOf(i)+"|";
		}
		DBoard[10][0] = "10|"; //because I use just 10 on 10 board I write number 10 in row 10 separate to look better
		//this double loop to write actual board 
		for(i=1; i<11; i++) {
			for(j=1; j<11; j++) {
				DBoard[i][j] = "_ |";
			}
		}
	}
	//method to print board, I can call this method when I like and print new boar after chenges 
	public void printBoard() {
		int i,j;
		
		for(i=0; i<11; i++) {
			
			for(j=0; j<11; j++) {
				System.out.print(DBoard[i][j]);
			}
			System.out.println("");
		}
	}

}
