import java.lang.Math;

public class Game{
	private GameBoard gameBoard;
	private TTTScript script;
	private Player X;
	private Player O;
	private boolean isX;
	public Game(){
		this.gameBoard = new GameBoard();
		this.script = new TTTScript();
		
		if(coinToss()){
			this.X = new HumanPlayer("YOU","X",this.gameBoard);
			this.O = new AIPlayer("O",this.gameBoard);
			this.isX = true;
			rollScript(7);
		}else{
			this.X = new AIPlayer("X",this.gameBoard);
			this.O = new HumanPlayer("YOU","O",this.gameBoard);
			this.isX = false;
			rollScript(8);
		}
	}
	
	public void rollScript(int index) {
		this.gameBoard.setMessage(this.script.playLine(index)+this.script.playLine(17));
		//HOLDS PROGRAM UNTIL OK IS HIT
		while(true) {
			if (this.gameBoard.getMenu().getText().equals("")) {
				return;
			}
		}
	}
	
	public void start(){
		for(int i = 0;i<9;i++){
			if(i%2==0){
				this.script.playLine(9);
				this.X.play();
			}else{
				this.script.playLine(17);
				this.O.play();
			}
			if(!this.gameBoard.getState().equals("EMPTY")){
				break;
			}
		}
		if(this.gameBoard.getState().equals("EMPTY")){
			rollScript(11);
		}else if(this.gameBoard.getState().equals("X")){
			rollScript(12);
			rollScript(this.isX?14:15);
		}else{
			rollScript(13);
			rollScript(this.isX?15:14);
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
		this.gameBoard.getButtons()[0][0].setText("HEADS");
		this.gameBoard.getButtons()[0][1].setText("TAILS");
		while(true){
			if(this.gameBoard.getButtons()[0][0].isActive()){
				heads = true;
				this.gameBoard.getButtons()[0][0].toggle(false);
				rollScript(3);
				break;
			}else if(this.gameBoard.getButtons()[0][1].isActive()){
				heads = false;
				this.gameBoard.getButtons()[0][1].toggle(false);
				rollScript(4);
				break;
			}else{
				System.out.println();
			}
		}
		this.gameBoard.getButtons()[0][0].setText("");
		this.gameBoard.getButtons()[0][1].setText("");
		
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