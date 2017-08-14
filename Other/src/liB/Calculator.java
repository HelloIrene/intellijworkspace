package liB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Calculator extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7289102176753970759L;
	private JMenuBar menuBar;//菜单条
	private JMenu menuView;
	private JMenu menuEdit;
	private JMenu menuHelp;
	private JMenuItem menuCopy;
	private JMenuItem menuPaste;
	private JPanel panelMain;
	private JRadioButtonMenuItem menuTouchstone;
	private JRadioButtonMenuItem menuScience;
	private JRadioButtonMenuItem menuProgrammer;
	private JRadioButtonMenuItem menuStatistics;
	private JRadioButtonMenuItem menuHistory1;
	private JRadioButtonMenuItem menuDigitGrouping;
	private JRadioButtonMenuItem menuBase;
	private JRadioButtonMenuItem menuUnitConversion;
	private JRadioButtonMenuItem menuDateCalculation;
	private JMenu menuWorkSheet;
	private JRadioButtonMenuItem menuMortgage;
	private JRadioButtonMenuItem menuCarRental;
	private JRadioButtonMenuItem menuFuelConsumption1;
	private JRadioButtonMenuItem menuFuelConsumption2;
	private JMenu menuHistory2;
	private JMenuItem menuCopyHistory;
	private JMenuItem menuEdit2;
	private JMenuItem menuNoEdit;
	private JMenuItem menuEliminate;
	private JMenuItem menuViewHelp;
	private JMenuItem menuAboutCalculator;
	private JTextField text;  
    private JButton num[];  
    private String name[]={"MC","MR","MS","M+","M-","←","CE","C","±","√","7","8","9","/","%","4","5","6","*","1/x","1","2","3","-","=","0",".","+"};  
    public  Calculator() {
		CalMenu();
	}
	private void CalMenu(){
		menuBar = new JMenuBar();
		menuView = new JMenu("查看(V)");
		menuView.setMnemonic('V');//设置快捷键
		menuEdit = new JMenu("编辑(E)");
		menuEdit.setMnemonic('E');
		menuHelp = new JMenu("帮助(H)");
		menuHelp.setMnemonic('H');
		menuTouchstone = new JRadioButtonMenuItem("标准型(T)");
		menuTouchstone.setMnemonic('T');
		menuTouchstone.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));
		menuScience = new JRadioButtonMenuItem("科学型(S)");
		menuScience.setMnemonic('S');
		menuScience.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.ALT_MASK));
		menuProgrammer = new JRadioButtonMenuItem("程序员(P)");
		menuProgrammer.setMnemonic('P');
		menuProgrammer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.ALT_MASK));
		menuStatistics = new JRadioButtonMenuItem("统计信息(A)");
		menuStatistics.setMnemonic('A');
		menuStatistics.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_MASK));
		//这四个按钮放入ButtonGroup1，只能单选
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(menuTouchstone);
		bg1.add(menuScience);
		bg1.add(menuProgrammer);
		bg1.add(menuStatistics);
		menuHistory1 = new JRadioButtonMenuItem("历史记录(Y)");
		menuHistory1.setMnemonic('Y');
		menuHistory1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		menuDigitGrouping = new JRadioButtonMenuItem("数字分组(I)");
		menuDigitGrouping.setMnemonic('I');
		menuBase = new JRadioButtonMenuItem("基本(B)");
		menuBase.setMnemonic('B');
		menuBase.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
		menuUnitConversion = new JRadioButtonMenuItem("单位转换(U)");
		menuUnitConversion.setMnemonic('U');
		menuUnitConversion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
		menuDateCalculation = new JRadioButtonMenuItem("日期计算(D)");
		menuDateCalculation.setMnemonic('D');
		menuDateCalculation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		//这七个按钮放入ButtonGroup2，只能单选

		
		menuWorkSheet = new JMenu("工作表(W)");
		menuWorkSheet.setMnemonic('W');
		menuMortgage = new JRadioButtonMenuItem("抵押(M)");
		menuMortgage.setMnemonic('M');
		menuCarRental = new JRadioButtonMenuItem("汽车租赁(V)");
		menuCarRental.setMnemonic('V');
		menuFuelConsumption1 = new JRadioButtonMenuItem("油耗(mpg)(F)");
		menuFuelConsumption1.setMnemonic('F');
		menuFuelConsumption2 = new JRadioButtonMenuItem("油耗(l/100 km)(U)");
		menuFuelConsumption2.setMnemonic('U');
		menuWorkSheet.add(menuMortgage);
		menuWorkSheet.add(menuCarRental );
		menuWorkSheet.add(menuFuelConsumption1);
		menuWorkSheet.add(menuFuelConsumption2);

		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(menuBase);
		bg2.add(menuUnitConversion);
		bg2.add(menuDateCalculation);
		ButtonGroup bg3 = new ButtonGroup();
		bg3.add(menuMortgage);
		bg3.add(menuCarRental );
		bg3.add(menuFuelConsumption1);
		bg3.add(menuFuelConsumption2);
		//增加"查看"菜单
		menuView.add(menuTouchstone);
		menuView.add(menuScience);
		menuView.add(menuProgrammer);
		menuView.add(menuStatistics);
		menuView.addSeparator();
		menuView.add(menuHistory1);
		menuView.add(menuDigitGrouping);
		menuView.addSeparator();
		menuView.add(menuBase);
		menuView.add(menuUnitConversion);
		menuView.add(menuDateCalculation);
		menuView.add(menuWorkSheet);
		menuCopy = new JMenuItem("复制(C)");
		menuCopy.setMnemonic('C');
		menuCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		menuPaste = new JMenuItem("粘贴(V)");
		menuPaste.setMnemonic('V');
		menuPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		menuHistory2 = new JMenu("历史记录(H)"); 
		menuHistory2.setMnemonic('H');
		menuCopyHistory = new JMenuItem("复制历史记录(I)");
		menuCopyHistory.setMnemonic('I');
		menuEdit2 = new JMenuItem("编辑(E)");
		menuEdit2.setMnemonic('E');
		menuEdit2.setAccelerator(KeyStroke.getKeyStroke("F2"));
		menuNoEdit = new JMenuItem("取消编辑(N)");
		menuNoEdit.setMnemonic('N');
		menuNoEdit.setAccelerator(KeyStroke.getKeyStroke("ESCAPE"));
		menuEliminate = new JMenuItem("清除(L)");
		menuEliminate.setMnemonic('L');
		menuEliminate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK + InputEvent.SHIFT_MASK));
		menuHistory2.add(menuCopyHistory);
		menuHistory2.add(menuEdit2);
		menuHistory2.add(menuNoEdit);
		menuHistory2.add(menuEliminate);
		//增加"编辑"菜单
		menuEdit.add(menuCopy);
		menuEdit.add(menuPaste);
		menuEdit.addSeparator();
		menuEdit.add(menuHistory2);
		menuViewHelp = new JMenuItem("查看帮助(V)");
		menuViewHelp.setMnemonic('V');
		menuViewHelp.setAccelerator(KeyStroke.getKeyStroke("F1"));
		menuAboutCalculator = new JMenuItem("关于计算器(A)");
		menuAboutCalculator.setMnemonic('A');
		menuHelp.add(menuViewHelp);
		menuHelp.add(menuAboutCalculator);
		//在主菜单中增加
		menuBar.add(menuView);
		menuBar.add(menuEdit);
		menuBar.add(menuHelp);
		this.add(menuBar, BorderLayout.NORTH);
		panelMain = new JPanel();
		this.add(panelMain);
		CalFrame();
	}
	private void CalFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("E:/timg.jpg");
		this.setSize(230, 340);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(img);
		this.setTitle("计算器");
		panelMain = new JPanel(null);
		text=new JTextField("0");  
        text.setEnabled(false);  
        text.setBounds(0, 0, 205, 55);  
        text.setHorizontalAlignment(JLabel.RIGHT);  
        text.setFont(new Font("黑体",Font.PLAIN,16));  
        text.setDisabledTextColor(Color.BLACK);  
        int i;  
        num=new JButton[28];
        //前24个字符
        for(i=0;i<24;i++)  
        {  
            num[i]=new JButton(name[i]);  
            num[i].setMargin(new java.awt.Insets(0,0,0,0));  //设置按钮边框和标签之间的空白 
            num[i].setBounds(i%5*(35+7)+5, 60+i/5*(30+5)+5, 35, 29);  
            panelMain.add(num[i]);  
        }  
        //=号
        num[i]=new JButton(name[i]);  
        num[i].setMargin(new java.awt.Insets(0,0,0,0));   
        num[i].setBounds(i%5*(35+7)+5, 60+i/5*(30+5)+5, 35, 29*2+5);  
        panelMain.add(num[i]);  
        i++;  
        //0
        num[i]=new JButton(name[i]);  
        num[i].setMargin(new java.awt.Insets(0,0,0,0));   
        num[i].setBounds(i%5*(35+7)+5, 60+i/5*(30+5)+5, 35*2+7, 29);  
        panelMain.add(num[i]);  
        //.和+号
        for(i=i+1;i<name.length;i++)  
        {  
            num[i]=new JButton(name[i]);  
            num[i].setMargin(new java.awt.Insets(0,0,0,0));   
            num[i].setBounds((i+1)%5*(35+7)+5, 60+i/5*(30+5)+5, 35, 29);  
            panelMain.add(num[i]);  
        }  
        panelMain.add(text);  
        this.add(panelMain);  
        this.setVisible(true);  
    }  
	
}
