package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	private JTextField text;//文本框
	private NumberPanel panel;//下方数字按钮组成的panel
	private JMenuBar menuBar;//菜单栏
	private JMenu menu1;//菜单
	private JMenu menu2;//菜单
	private JMenuItem menuItem1;//菜单项
	private JMenuItem menuItem2;//菜单项
	private JMenuItem menuItem3;//菜单项
	private JMenuItem menuItem4;//菜单项
	
	
	public MyFrame(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = (int) dimension.getWidth();
		int height = (int) dimension.getHeight();
		menuBar = new JMenuBar();
		menu1 = new JMenu("编辑");
		menu2 = new JMenu("关于");
		menuItem1 = new JMenuItem("复制");
		menuItem2 = new JMenuItem("粘贴");
		menuItem3 = new JMenuItem("帮助");
		menuItem4 = new JMenuItem("查看");
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu2.add(menuItem3);
		menu2.add(menuItem4);
		menuBar.add(menu1);
		menuBar.add(menu2);
		this.setJMenuBar(menuBar);
		
		
		
		
		text = new JTextField();
		text.setHorizontalAlignment(JTextField.RIGHT);
		panel = new NumberPanel();
		this.init();
		
		this.setLayout(new GridLayout(2,1));
		//this.setLayout(null);
		
//		this.getText().setLocation(0,0);
//		this.getText().setSize(width,height/10);
//		
//		this.getPanel().setLocation(width,height/2);
//		this.getPanel().setSize(10,height/10);
		
		
		this.add(this.getText());
		this.add(this.getPanel());

	}
	
	public void init() {
		this.setResizable(false);//设置不可改变的大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = (int) dimension.getWidth();
		int height = (int) dimension.getHeight();
		this.setTitle("计算器");
		this.setSize(width/5,height/2);
		Image image = toolkit.getImage("compute.png");
		this.setIconImage(image);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setVisible(true);
	}
	
	

	public JTextField getText() {
		return text;
	}
	public void setText(JTextField text) {
		this.text = text;
	}
	public NumberPanel getPanel() {
		return panel;
	}
	public void setPanel(NumberPanel panel) {
		this.panel = panel;
	}
	
	
}
