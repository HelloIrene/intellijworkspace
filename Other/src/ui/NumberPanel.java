package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NumberPanel extends JPanel {
	private JButton[] btnNumbers = new JButton[28];

	public NumberPanel(){
		this.init();
		for(int i=0;i<this.getBtnNumbers().length;i++) {
			this.add(btnNumbers[i]);
		}
	}
	
	public void init() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dimension = kit.getScreenSize();
		int width = (int) dimension.getWidth();
		int height = (int) dimension.getHeight();
		
		//初始化28个按钮
		btnNumbers[0] = new JButton("MC");
		btnNumbers[1] = new JButton("MR");
		btnNumbers[2] = new JButton("MS");
		btnNumbers[3] = new JButton("M+");
		btnNumbers[4] = new JButton("M-");
		btnNumbers[5] = new JButton("←");
		btnNumbers[6] = new JButton("CE");
		btnNumbers[7] = new JButton("C");
		btnNumbers[8] = new JButton("±");
		btnNumbers[9] = new JButton("√");
		btnNumbers[10] = new JButton("7");
		btnNumbers[11] = new JButton("8");
		btnNumbers[12] = new JButton("9");
		btnNumbers[13] = new JButton("/");
		btnNumbers[14] = new JButton("%");
		btnNumbers[15] = new JButton("4");
		btnNumbers[16] = new JButton("5");
		btnNumbers[17] = new JButton("6");
		btnNumbers[18] = new JButton("*");
		btnNumbers[19] = new JButton("1/x");
		btnNumbers[20] = new JButton("1");
		btnNumbers[21] = new JButton("2");
		btnNumbers[22] = new JButton("3");
		btnNumbers[23] = new JButton("-");
		btnNumbers[24] = new JButton("=");
		btnNumbers[25] = new JButton("0");
		btnNumbers[26] = new JButton(".");
		btnNumbers[27] = new JButton("+");
		
		this.setLayout(new GridLayout(6,5));
		
		
		
//		//给按钮设置大小
//		for(int i = 0;i<btnNumbers.length;i++) {
//			btnNumbers[i].setSize(width/6, height*3/25);
//		}
//		btnNumbers[24].setSize(width/6, height*6/25);
//		btnNumbers[25].setSize(width/3, height*3/25);
//		
//		
		
		//初始化按钮位置
//		int index = 0;
//		for(int i=0;i<6;i++) {
//			for(int j=0;j<5;j++) {
//				btnNumbers[index].setLocation(j*width/36+(j-1)*width/6,(3/10+1/80)*height+i*(3/25+1/80));
//				index++;
//				if(index == 27) {
//					break;
//				}
//			}
//			
//		}
		
		
	}
	public JButton[] getBtnNumbers() {
		return btnNumbers;
	}

	public void setBtnNumbers(JButton[] btnNumbers) {
		this.btnNumbers = btnNumbers;
	}
	
	
	
}
