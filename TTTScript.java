class TTTScript{
	private String[] lines;
	
	public TTTScript(){
		int NUMLINES = 18;
		this.lines = new String[NUMLINES];
		populateLines();
	}
	
	public void populateLines(){
		this.lines[0] = "WELCOME TO TIC-TAC-TOE\n";
		this.lines[1] = "A COIN FLIP WILL DECIDE WHO GOES FIRST\n";
		this.lines[2] = "PLEASE CALL HEADS OR TAILS\n";
		this.lines[3] = "YOU CALLED HEADS\n";
		this.lines[4] = "YOU CALLED TAILS\n";
		this.lines[5] = "AND YOU WON THE COIN TOSS\n";
		this.lines[6] = "AND YOU LOST THE COIN TOSS\n";
		this.lines[7] = "YOU ARE PLAYER X\n";
		this.lines[8] = "YOU ARE PLAYER O\n";
		this.lines[9] = "IT IS YOUR TURN\n";
		this.lines[10] = "PLEASE CHOSE AN EMPTY BLOCK\n";
		this.lines[11] = "THE GAME ENDED IN A DRAW\n";
		this.lines[12] = "X'S GET 3 IN A ROW\n";
		this.lines[13] = "O'S GET 3 IN A ROW\n";
		this.lines[14] = "YOU WIN!\n";
		this.lines[15] = "YOU LOSE!\n";
		this.lines[16] = "THANK YOU FOR PLAYING TIC-TAC-TOE!\n";
		this.lines[17] = "HIT OK TO CONTINUE\n";
	}
	
	public String playLine(int index){
		return this.lines[index];
	}
}