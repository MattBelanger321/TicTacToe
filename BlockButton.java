import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

class BlockButton extends JButton implements ActionListener{
	private boolean isActivated;
	private String state;
	public BlockButton(){
		isActivated = false;
		addActionListener(this);
		this.state = "EMPTY";
	}
	public String getState(){
		return state;
	}
	
	public void setState(String state){
		this.state = state;
		setText(state.equals("EMPTY")?"":state);
	}
	
	public void actionPerformed(ActionEvent e){
		isActivated = true;
	}
	
	public boolean isActive(){
		return isActivated;
	}
	
	public void toggle(boolean newState){
		isActivated = newState;
	}
	
}