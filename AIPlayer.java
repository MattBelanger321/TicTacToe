public class AIPlayer extends Player{
	
	public AIPlayer(String symbol,GameBoard gameBoard){
		super.symbol = symbol;
		super.gameBoard = gameBoard;
		super.name = "AI";
		super.script = new TTTScript();
	}
	
	public void play(){
		this.script.playLine(17);
		if(gameBoard.buttons[1][1].getState().equals("EMPTY")){//checks middle if its empty
			gameBoard.buttons[1][1].setState(super.symbol);
			gameBoard.buttons[1][1].setText(super.symbol);
			gameBoard.updateState(1,1);
			return;
		}else if(gameBoard.buttons[0][0].getState().equals(gameBoard.buttons[2][0].getState())&&!gameBoard.buttons[0][0].getState().equals("EMPTY")&&gameBoard.buttons[1][0].getState().equals("EMPTY")){//either stops a win or gets a win
			gameBoard.buttons[1][0].setState(super.symbol);
			gameBoard.buttons[1][0].setText(super.symbol);
			gameBoard.updateState(1,0);
			return;
		}else if(gameBoard.buttons[0][0].getState().equals(gameBoard.buttons[0][2].getState())&&!gameBoard.buttons[0][0].getState().equals("EMPTY")&&gameBoard.buttons[0][1].getState().equals("EMPTY")){//either stops a win or gets a win
			gameBoard.buttons[0][1].setState(super.symbol);
			gameBoard.buttons[0][1].setText(super.symbol);
			gameBoard.updateState(0,1);
			return;
		}else if(gameBoard.buttons[0][2].getState().equals(gameBoard.buttons[2][2].getState())&&!gameBoard.buttons[2][2].getState().equals("EMPTY")&&gameBoard.buttons[1][2].getState().equals("EMPTY")){//either stops a win or gets a win
			gameBoard.buttons[1][2].setState(super.symbol); 
			gameBoard.buttons[1][2].setText(super.symbol);
			gameBoard.updateState(1,2);
			return;
		}else if(gameBoard.buttons[2][0].getState().equals(gameBoard.buttons[2][2].getState())&&!gameBoard.buttons[2][2].getState().equals("EMPTY")&&gameBoard.buttons[2][1].getState().equals("EMPTY")){//either stops a win or gets a win
			gameBoard.buttons[2][1].setState(super.symbol);
			gameBoard.buttons[2][1].setText(super.symbol);
			gameBoard.updateState(2,1);
			return;
		}else if(gameBoard.buttons[1][1].getState().equals(gameBoard.buttons[1][0].getState())&&!gameBoard.buttons[1][1].getState().equals("EMPTY")&&gameBoard.buttons[1][2].getState().equals("EMPTY")){
			gameBoard.buttons[1][2].setState(super.symbol); 
			gameBoard.buttons[1][2].setText(super.symbol);
			gameBoard.updateState(1,2);
			return;
		}else if(gameBoard.buttons[1][1].getState().equals(gameBoard.buttons[0][1].getState())&&!gameBoard.buttons[1][1].getState().equals("EMPTY")&&gameBoard.buttons[2][1].getState().equals("EMPTY")){
			gameBoard.buttons[2][1].setState(super.symbol); 
			gameBoard.buttons[2][1].setText(super.symbol);
			gameBoard.updateState(2,1);
			return;
		}else if(gameBoard.buttons[1][1].getState().equals(gameBoard.buttons[2][1].getState())&&!gameBoard.buttons[1][1].getState().equals("EMPTY")&&gameBoard.buttons[0][1].getState().equals("EMPTY")){
			gameBoard.buttons[0][1].setState(super.symbol); 
			gameBoard.buttons[0][1].setText(super.symbol);
			gameBoard.updateState(0,1);
			return;
		}else if(gameBoard.buttons[1][1].getState().equals(gameBoard.buttons[1][2].getState())&&!gameBoard.buttons[1][1].getState().equals("EMPTY")&&gameBoard.buttons[1][0].getState().equals("EMPTY")){
			gameBoard.buttons[1][0].setState(super.symbol); 
			gameBoard.buttons[1][0].setText(super.symbol);
			gameBoard.updateState(1,0);
			return;
		}else if(gameBoard.buttons[0][0].getState().equals("EMPTY")){//checks corner if its empty
			gameBoard.buttons[0][0].setState(super.symbol); 
			gameBoard.buttons[0][0].setText(super.symbol);
			gameBoard.updateState(0,0);
			return;
		}else if(gameBoard.buttons[0][2].getState().equals("EMPTY")){//checks corner if its empty
			gameBoard.buttons[0][2].setState(super.symbol);
			gameBoard.buttons[0][2].setText(super.symbol);
			gameBoard.updateState(0,2);
			return;
		}else if(gameBoard.buttons[2][0].getState().equals("EMPTY")){//checks corner if its empty
			gameBoard.buttons[2][0].setState(super.symbol); 
			gameBoard.buttons[2][0].setText(super.symbol);
			gameBoard.updateState(2,0);
			return;
		}else if(gameBoard.buttons[2][2].getState().equals("EMPTY")){//checks corner if its empty
			gameBoard.buttons[2][2].setState(super.symbol);
			gameBoard.buttons[2][2].setText(super.symbol);
			gameBoard.updateState(2,2);
			return;
		}else{
			for(int i = 2;i>=0;i--){
				for(int j = 0;j<3;j++){
					if(gameBoard.buttons[i][j].getState().equals("EMPTY")){
						gameBoard.buttons[i][j].setState(super.symbol); 
						gameBoard.buttons[i][j].setText(super.symbol);
						gameBoard.updateState(i,j);
						return;
					}
				}
			}
		}
	}
}