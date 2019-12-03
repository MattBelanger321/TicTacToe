public class HumanPlayer extends Player{
	
	public HumanPlayer(String name,String symbol,GameBoard gameBoard){
		super.symbol = symbol;
		super.gameBoard = gameBoard;
		super.name = name;
		super.script = new TTTScript();
	}
	
	public void play(){
		int i=0,j=0;
		boolean flag = false;
		while(true){
			for(i=0;i<3;i++){
				for(j=0;j<3;j++){
					if(super.gameBoard.getButtons()[i][j].isActive()){
						super.gameBoard.getButtons()[i][j].toggle(false);
						if(!super.gameBoard.getButtons()[i][j].getState().equals("EMPTY")){
							this.script.playLine(10);
						}else{
							flag = true;
							break;
						}
					}
				}//j
				if(flag){
					break;
				}
			}//i
			if(flag){
				break;
			}
		}//while
		
		super.gameBoard.getButtons()[i][j].setState(super.symbol);
		super.gameBoard.getButtons()[i][j].setText(super.symbol);
		gameBoard.updateState(i,j);
		for(i=0;i<3;i++){
			for(j=0;j<3;j++){
				super.gameBoard.getButtons()[i][j].toggle(false);
			}
		}
	}
}