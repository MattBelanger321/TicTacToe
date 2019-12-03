import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

class BlockButton extends JButton implements ActionListener{
	private boolean isActivated;
	private String state;
	public BlockButton(){
		this.isActivated = false;
		this.addActionListener(this);
		this.state = "EMPTY";
	}
	public String getState(){
		return this.state;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	public void actionPerformed(ActionEvent e){
		this.isActivated = true;
	}
	
	public boolean isActive(){
		return this.isActivated;
	}
	
	public void toggle(boolean newState){
		this.isActivated = newState;
	}
	
}