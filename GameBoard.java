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
		state = "EMPTY";
		frame = new JFrame();
		buttons = new BlockButton[3][3];
		
		for(int i = 0;i<3;i++){//holds row index
			for(int j = 0;j<3;j++){//holds col index
				buttons[i][j] = new BlockButton();
				buttons[i][j].setBounds(200*j,200*i,200, 200);//x axis, y axis, width, height
				frame.add(buttons[i][j]);//adds button to frame
			}
		}
		
		//Text box and OK Button
		ok = new JButton("OK");
		ok.setBounds(750,50,100,100);
		ok.addActionListener(this);
		frame.add(ok);
		menu = new JTextArea(400,300);
		menu.setEditable(false);
		menu.setText("WELCOME TO TIC TAC TOE");
		menu.setBounds(635,300,300,200);
		frame.add(menu);
		
		
		frame.setSize(1000,630);//width height 
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible  
	}
	
	public void updateState(int r, int c){
		for(int i = 0;i<3;i++){//check row for a win
			if(buttons[r][c].getState()!=buttons[r][i].getState()){
				break;
			}
			if(i==2){
				state = buttons[r][c].getState();
				return;
			}
		}
		
		for(int i = 0;i<3;i++){//check col for a win
			if(buttons[r][c].getState() != buttons[i][c].getState()){
				break;
			}
			if(i==2){
				state = buttons[r][c].getState();
				return;
			}
		}
		
		for(int i = 0;i<3;i++){//check diagonal for a win
			if(r==c){
				if(buttons[r][c].getState() != buttons[i][i].getState()){
					break;
				}
			}else if(r+c == 2){
				if(buttons[r][c].getState() != buttons[i][2-i].getState()){
					break;
				}
			}else{
				break;
			}
			if(i==2){
				state = buttons[r][c].getState();
				return;
			}
			
		}
	}
	
	public String getState(){
		return state;
	}
	
	public void actionPerformed(ActionEvent e){
		menu.setText("");
	}	 
	
	public void setMessage(String message){
		menu.setText(message);
	}
	public String getMessage() {
		return menu.getText();
	}
	
	public void setButtonTitle(String Title,int r,int c){
		buttons[r][c].setText(Title);
	}
	
	public BlockButton[][] getButtons() {
		return buttons;
	}
}