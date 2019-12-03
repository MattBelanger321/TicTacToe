abstract class Player{
	protected String symbol;
	protected String name;
	protected GameBoard gameBoard;
	protected TTTScript script;
	public abstract void play();
	
	public String getName(){
		return this.name;
	}
	
	public String getSymbol(){
		return this.symbol;
	}
}