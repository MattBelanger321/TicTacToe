import java.lang.Math;

public class Game{
	private GameBoard gameBoard;
	private TTTScript script;
	private Player X;
	private Player O;
	private boolean isX;

	public Game(){
		gameBoard = new GameBoard();
		script = new TTTScript();
		
		if(coinToss()){
			X = new HumanPlayer("YOU","X",gameBoard);
			O = new AIPlayer("O",gameBoard);
			isX = true;
			rollScript(7);
		}else{
			X = new AIPlayer("X",gameBoard);
			O = new HumanPlayer("YOU","O",this.gameBoard);
			isX = false;
			rollScript(8);
		}
	}
	
	public void rollScript(int index) {
		gameBoard.setMessage(script.playLine(index)+script.playLine(18));
		//HOLDS PROGRAM UNTIL OK IS HIT
		while(true) {
			if (gameBoard.getMessage().equals("")) {
				return;
			}
		}
	}
	
	public void start(){
		for(int i = 0;i<9;i++){
			if(i%2==0){
				//gameBoard.setMessage(isX?script.playLine(9):script.playLine(10));//"YOUR TURN" IF HUMAN IS X "AI'S TURN" OTHERWISE
				rollScript(!isX?10:9);
				X.play();
			}else{
				//gameBoard.setMessage(isX?script.playLine(10):script.playLine(9));//"YOUR TURN" IF HUMAN IS O "AI'S TURN" OTHERWISE
				rollScript(isX?10:9);
				O.play();
			}
			if(!this.gameBoard.getState().equals("EMPTY")){
				break;
			}
		}
		if(gameBoard.getState().equals("EMPTY")){
			rollScript(12);
		}else if(gameBoard.getState().equals("X")){
			rollScript(13);
			rollScript(isX?15:16);
		}else{
			rollScript(13);
			rollScript(isX?15:14);
		}
	}
	
  /*This method will simulate a coin toss and determine the player order
	No INPUT
	returns true if human won toss*/
	private boolean coinToss(){
		boolean heads;
		for(int i = 0;i<=2;i++) {
			rollScript(i);
		}
		gameBoard.getButtons()[0][0].setText("HEADS");
		gameBoard.getButtons()[0][1].setText("TAILS");
		while(true){
			if(this.gameBoard.getButtons()[0][0].isActive()){
				heads = true;
				gameBoard.getButtons()[0][0].toggle(false);
				rollScript(3);
				break;
			}else if(this.gameBoard.getButtons()[0][1].isActive()){
				heads = false;
				gameBoard.getButtons()[0][1].toggle(false);
				rollScript(4);
				break;
			}else{
				System.out.println();
			}
		}
		gameBoard.getButtons()[0][0].setText("");
		gameBoard.getButtons()[0][1].setText("");
		
		if(Math.floor(Math.random()*10)%2 == 0){
			if(heads){
				rollScript(5);
				return true;
			}else{
				rollScript(6);
				return false;
			}
		}else{
			if(heads){
				rollScript(6);
				return false;
			}else{
				rollScript(5);
				return true;
			}
		}
	}
}