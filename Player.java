abstract class Player{
	protected String symbol;
	protected String name;
	protected GameBoard gameBoard;
	protected TTTScript script;

	public abstract void play();//Allows player to make move
	
	public String getName(){
		return name;
	}
	
	public String getSymbol(){
		return symbol;
	}
}