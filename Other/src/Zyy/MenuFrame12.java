package Zyy;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

public class MenuFrame12 extends JFrame{
	
	private static final long serialVersionUID = 9122648360487983376L;
	// 菜单条
	private JMenuBar bar;
	// 菜单
	private JMenu check;
	private JMenu compile;
	private JMenu help;
	private JMenu historyRecord;//拥有子菜单
	// 菜单项
	private JMenuItem standard;
	private JMenuItem basic;
	private JMenuItem copy;
	private JMenuItem paste;
	
	private JMenuItem lookHelp;
	private JMenuItem about;
	
	//也是菜单项，不过是historyRecord下拥有的四个子菜单
	private JMenuItem one;
	private JMenuItem two;
	private JMenuItem three;
	private JMenuItem four;
	
	private JPanel pnl;
	private JTextField ta;

	private String name[]={"MC","MR","MS","M+","M-","←","CE","C","±","√","7","8","9"
			,"/","%","4","5","6","*","1/x","1","2","3","-","=","0",".","+"};
	
	public  MenuFrame12(){
		
		check = new JMenu("查看(V)");
		check.setMnemonic('V');// 添加快捷键
		compile = new JMenu("编辑(E)");
		compile.setMnemonic('E');
		help = new JMenu("帮助(H)");
		help.setMnemonic('H');
		
		//查看下拉具体设置
		standard =new JMenuItem("标准型(T)");
		standard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));
		basic =new JMenuItem("基本(B)");
		basic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
		//编辑下拉具体设置
		copy =new JMenuItem("复制(C)");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		paste =new JMenuItem("粘贴(P)");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
				
		check.add(standard);
		check.add(basic);
		compile.addSeparator();
		compile.add(copy);
		compile.add(paste);
		
		//历史记录拥有子菜单
		historyRecord = new JMenu("历史记录(H)");
		compile.addSeparator();
		compile.add(historyRecord);
		one =new JMenuItem("复制历史记录(I)");				
		two = new JMenuItem("编辑(E)");
		two.setAccelerator(KeyStroke.getKeyStroke("F2"));
		three = new JMenuItem("取消编辑(N)");
		three.setAccelerator(KeyStroke.getKeyStroke("ESCAPE"));
		four = new JMenuItem("清除(L)");
		four.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK+ InputEvent.SHIFT_MASK));
		historyRecord.add(one);
		historyRecord.add(two);
		historyRecord.add(three);
		historyRecord.add(four);
		
		lookHelp = new JMenuItem("查看帮助(V)");
		lookHelp.setAccelerator(KeyStroke.getKeyStroke("F1"));
		about = new JMenuItem("关于计算器(A)");
				
		help.add(lookHelp);
		help.addSeparator();
		help.add(about);
		//改变字体大小
		Font f = new Font("隶书",Font.PLAIN,16);
		UIManager.put("Button.font",f);
		
		//文本框
		ta=new JTextField("0");
		ta.setHorizontalAlignment(JTextField.RIGHT);
		ta.setSize(270,50);
		ta.setLocation(10, 10);                                          
		//28个按钮

		pnl = new JPanel();
		pnl.setLayout(null);

		for (int i = 0; i < 24; i++) {
			setButton(name[i],i);
		}

		setSingleButton(name[24],230, 210, 50, 65);
		setSingleButton(name[25],10, 245, 105, 30);
		setSingleButton(name[26],120, 245, 50, 30);
		setSingleButton(name[27],175, 245, 50, 30);

		bar = new JMenuBar();
		bar.add(check);
		bar.add(compile);
		bar.add(help);
		pnl.add(ta);		
		this.add(bar, BorderLayout.NORTH);		
		this.add(pnl);
				
		MyFrame();
	}

	public void setButton(String name,int i){
		JButton button = new JButton(name);
		button.setMargin(new java.awt.Insets(0,0,0,0));
		button.setBounds(10+(i%5)*55,70+(i/5)*35,50, 30);
		pnl.add(button);
	}

	public void setSingleButton(String content,int x,int y,int width,int height){
		JButton singleButton =new JButton(content);
		singleButton.setMargin(new java.awt.Insets(0,0,0,0));
		singleButton.setBounds(x,y,width,height);
		pnl.add(singleButton);
	}

	public void MyFrame(){
		//this.setLayout(null);//此句必须删除！
		//this.add(btnName);//一定是容器去add控件
		this.setSize(295,340);
		this.setLocationRelativeTo(null);
		this.setTitle("计算器");
		//设置图标
		Toolkit kit=Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/com/zyy/day811/test2/calculator.png");
		this.setIconImage(img);
		this.setResizable(false);//设置窗体不能最大化
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MenuFrame12 menuFrame12 = new MenuFrame12();
		menuFrame12.setVisible(true);
	}
}
