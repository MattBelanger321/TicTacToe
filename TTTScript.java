class TTTScript{
	private String[] lines;
	
	public TTTScript(){
		lines = new String[19];
		populateLines();
	}
	
	public void populateLines(){
		lines[0] = "WELCOME TO TIC-TAC-TOE\n";
		lines[1] = "A COIN FLIP WILL DECIDE WHO GOES FIRST\n";
		lines[2] = "PLEASE CALL HEADS OR TAILS\n";
		lines[3] = "YOU CALLED HEADS\n";
		lines[4] = "YOU CALLED TAILS\n";
		lines[5] = "AND YOU WON THE COIN TOSS\n";
		lines[6] = "AND YOU LOST THE COIN TOSS\n";
		lines[7] = "YOU ARE PLAYER X\n";
		lines[8] = "YOU ARE PLAYER O\n";
		lines[9] = "IT IS YOUR TURN\n";
		lines[10] = "IT IS AI'S TURN\n";
		lines[11] = "PLEASE CHOSE AN EMPTY BLOCK\n";
		lines[12] = "THE GAME ENDED IN A DRAW\n";
		lines[13] = "X'S GET 3 IN A ROW\n";
		lines[14] = "O'S GET 3 IN A ROW\n";
		lines[15] = "YOU WIN!\n";
		lines[16] = "YOU LOSE!\n";
		lines[17] = "THANK YOU FOR PLAYING TIC-TAC-TOE!\n";
		lines[18] = "HIT OK TO CONTINUE\n";
	}
	
	public String playLine(int index){
		return lines[index];
	}
}