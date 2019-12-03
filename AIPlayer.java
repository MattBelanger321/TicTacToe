public class AIPlayer extends Player{
	
	public AIPlayer(String symbol,GameBoard gameBoard){
		super.symbol = symbol;
		super.gameBoard = gameBoard;
		name = "AI";
		script = new TTTScript();
	}
	
	public void play(){
		if(gameBoard.getButtons()[1][1].getState().equals("EMPTY")){//checks middle if its empty
			gameBoard.getButtons()[1][1].setState(symbol);
			gameBoard.updateState(1,1);
			return;
		}else if(gameBoard.getButtons()[0][0].getState().equals(gameBoard.getButtons()[2][0].getState())&&!gameBoard.getButtons()[0][0].getState().equals("EMPTY")&&gameBoard.getButtons()[1][0].getState().equals("EMPTY")){//either stops a win or gets a win
			gameBoard.getButtons()[1][0].setState(symbol);
			gameBoard.updateState(1,0);
			return;
		}else if(gameBoard.getButtons()[0][0].getState().equals(gameBoard.getButtons()[0][2].getState())&&!gameBoard.getButtons()[0][0].getState().equals("EMPTY")&&gameBoard.getButtons()[0][1].getState().equals("EMPTY")){//either stops a win or gets a win
			gameBoard.getButtons()[0][1].setState(symbol);
			gameBoard.updateState(0,1);
			return;
		}else if(gameBoard.getButtons()[0][2].getState().equals(gameBoard.getButtons()[2][2].getState())&&!gameBoard.getButtons()[2][2].getState().equals("EMPTY")&&gameBoard.getButtons()[1][2].getState().equals("EMPTY")){//either stops a win or gets a win
			gameBoard.getButtons()[1][2].setState(symbol);
			gameBoard.updateState(1,2);
			return;
		}else if(gameBoard.getButtons()[2][0].getState().equals(gameBoard.getButtons()[2][2].getState())&&!gameBoard.getButtons()[2][2].getState().equals("EMPTY")&&gameBoard.getButtons()[2][1].getState().equals("EMPTY")){//either stops a win or gets a win
			gameBoard.getButtons()[2][1].setState(symbol);
			gameBoard.updateState(2,1);
			return;
		}else if(gameBoard.getButtons()[1][1].getState().equals(gameBoard.getButtons()[1][0].getState())&&!gameBoard.getButtons()[1][1].getState().equals("EMPTY")&&gameBoard.getButtons()[1][2].getState().equals("EMPTY")){
			gameBoard.getButtons()[1][2].setState(symbol);
			gameBoard.updateState(1,2);
			return;
		}else if(gameBoard.getButtons()[1][1].getState().equals(gameBoard.getButtons()[0][1].getState())&&!gameBoard.getButtons()[1][1].getState().equals("EMPTY")&&gameBoard.getButtons()[2][1].getState().equals("EMPTY")){
			gameBoard.getButtons()[2][1].setState(symbol);
			gameBoard.updateState(2,1);
			return;
		}else if(gameBoard.getButtons()[1][1].getState().equals(gameBoard.getButtons()[2][1].getState())&&!gameBoard.getButtons()[1][1].getState().equals("EMPTY")&&gameBoard.getButtons()[0][1].getState().equals("EMPTY")){
			gameBoard.getButtons()[0][1].setState(symbol);
			gameBoard.updateState(0,1);
			return;
		}else if(gameBoard.getButtons()[1][1].getState().equals(gameBoard.getButtons()[1][2].getState())&&!gameBoard.getButtons()[1][1].getState().equals("EMPTY")&&gameBoard.getButtons()[1][0].getState().equals("EMPTY")){
			gameBoard.getButtons()[1][0].setState(symbol);
			gameBoard.updateState(1,0);
			return;
		}else if(gameBoard.getButtons()[0][0].getState().equals("EMPTY")){//checks corner if its empty
			gameBoard.getButtons()[0][0].setState(symbol);
			gameBoard.updateState(0,0);
			return;
		}else if(gameBoard.getButtons()[0][2].getState().equals("EMPTY")){//checks corner if its empty
			gameBoard.getButtons()[0][2].setState(symbol);
			gameBoard.updateState(0,2);
			return;
		}else if(gameBoard.getButtons()[2][0].getState().equals("EMPTY")){//checks corner if its empty
			gameBoard.getButtons()[2][0].setState(symbol);
			gameBoard.updateState(2,0);
			return;
		}else if(gameBoard.getButtons()[2][2].getState().equals("EMPTY")){//checks corner if its empty
			gameBoard.getButtons()[2][2].setState(symbol);
			gameBoard.updateState(2,2);
			return;
		}else {
			for (int i = 2; i >= 0; i--) {
				for (int j = 0; j < 3; j++) {
					if (gameBoard.getButtons()[i][j].getState().equals("EMPTY")) {
						gameBoard.getButtons()[i][j].setState(symbol);
						gameBoard.updateState(i, j);
						return;
					}
				}
			}
		}
	}
}