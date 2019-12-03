import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

class GameBoard implements ActionListener{
	protected BlockButton buttons[][];
	protected JButton ok;
	protected JFrame frame;
	protected JTextArea menu;
	private String state;
	
	public GameBoard(){
		this.state = "EMPTY";
		this.frame = new JFrame();
		this.buttons = new BlockButton[3][3];
		
		for(int i = 0;i<3;i++){//holds row index
			for(int j = 0;j<3;j++){//holds col index
				this.buttons[i][j] = new BlockButton();
				this.buttons[i][j].setBounds(200*j,200*i,200, 200);//x axis, y axis, width, height  
				this.frame.add(buttons[i][j]);//adds button to frame
			}
		}
		
		//Text box and OK Button
		this.ok = new JButton("OK");
		this.ok.setBounds(750,50,100,100);
		this.ok.addActionListener(this);
		frame.add(this.ok);
		this.menu = new JTextArea(400,300);
		this.menu.setEditable(false);
		this.menu.setText("WELCOME TO TIC TAC TOE");
		this.menu.setBounds(635,300,300,200);
		frame.add(this.menu);
		
		
		frame.setSize(1000,630);//width height 
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible  
	}
	
	public void updateState(int r, int c){
		for(int i = 0;i<3;i++){//check row for a win
			if(this.buttons[r][c].getState()!=this.buttons[r][i].getState()){
				break;
			}
			if(i==2){
				this.state = this.buttons[r][c].getState();
				return;
			}
		}
		
		for(int i = 0;i<3;i++){//check col for a win
			if(this.buttons[r][c].getState() != this.buttons[i][c].getState()){
				break;
			}
			if(i==2){
				this.state = this.buttons[r][c].getState();
				return;
			}
		}
		
		for(int i = 0;i<3;i++){//check diagonal for a win
			if(r==c){
				if(this.buttons[r][c].getState() != this.buttons[i][i].getState()){
					break;
				}
			}else if(r+c == 2){
				if(this.buttons[r][c].getState() != this.buttons[i][2-i].getState()){
					break;
				}
			}else{
				break;
			}
			if(i==2){
				this.state = this.buttons[r][c].getState();
				return;
			}
			
		}
	}
	
	public String getState(){
		return this.state;
	}
	
	public void actionPerformed(ActionEvent e){  
		menu.setText("");
	}	 
	
	public void setMessage(String message){
		menu.setText(message);
	}
	
	public void setButtonTitle(String Title,int r,int c){
		buttons[r][c].setText(Title);
	}
	
	public BlockButton[][] getButtons() {
		return this.buttons;
	}
	
	public JButton getOK() {
		return this.ok;
	}
	
	public JTextArea getMenu() {
		return this.menu;
	}
	
	
	/*this.buttons[3*i+j].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						JButton button = (JButton)e.getSource();
						button.setText(this.human.getSymbol());
						sendIndex(3*r+c);
						
					}
				});//component button will be added to the components that are being tracked for action event. 
	
	*/
}