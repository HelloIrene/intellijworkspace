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
	// �˵���
	private JMenuBar bar;
	// �˵�
	private JMenu check;
	private JMenu compile;
	private JMenu help;
	private JMenu historyRecord;//ӵ���Ӳ˵�
	// �˵���
	private JMenuItem standard;
	private JMenuItem basic;
	private JMenuItem copy;
	private JMenuItem paste;
	
	private JMenuItem lookHelp;
	private JMenuItem about;
	
	//Ҳ�ǲ˵��������historyRecord��ӵ�е��ĸ��Ӳ˵�
	private JMenuItem one;
	private JMenuItem two;
	private JMenuItem three;
	private JMenuItem four;
	
	private JPanel pnl;
	private JTextField ta;

	private String name[]={"MC","MR","MS","M+","M-","��","CE","C","��","��","7","8","9"
			,"/","%","4","5","6","*","1/x","1","2","3","-","=","0",".","+"};
	
	public  MenuFrame12(){
		
		check = new JMenu("�鿴(V)");
		check.setMnemonic('V');// ��ӿ�ݼ�
		compile = new JMenu("�༭(E)");
		compile.setMnemonic('E');
		help = new JMenu("����(H)");
		help.setMnemonic('H');
		
		//�鿴������������
		standard =new JMenuItem("��׼��(T)");
		standard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));
		basic =new JMenuItem("����(B)");
		basic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
		//�༭������������
		copy =new JMenuItem("����(C)");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		paste =new JMenuItem("ճ��(P)");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
				
		check.add(standard);
		check.add(basic);
		compile.addSeparator();
		compile.add(copy);
		compile.add(paste);
		
		//��ʷ��¼ӵ���Ӳ˵�
		historyRecord = new JMenu("��ʷ��¼(H)");
		compile.addSeparator();
		compile.add(historyRecord);
		one =new JMenuItem("������ʷ��¼(I)");				
		two = new JMenuItem("�༭(E)");
		two.setAccelerator(KeyStroke.getKeyStroke("F2"));
		three = new JMenuItem("ȡ���༭(N)");
		three.setAccelerator(KeyStroke.getKeyStroke("ESCAPE"));
		four = new JMenuItem("���(L)");
		four.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK+ InputEvent.SHIFT_MASK));
		historyRecord.add(one);
		historyRecord.add(two);
		historyRecord.add(three);
		historyRecord.add(four);
		
		lookHelp = new JMenuItem("�鿴����(V)");
		lookHelp.setAccelerator(KeyStroke.getKeyStroke("F1"));
		about = new JMenuItem("���ڼ�����(A)");
				
		help.add(lookHelp);
		help.addSeparator();
		help.add(about);
		//�ı������С
		Font f = new Font("����",Font.PLAIN,16);
		UIManager.put("Button.font",f);
		
		//�ı���
		ta=new JTextField("0");
		ta.setHorizontalAlignment(JTextField.RIGHT);
		ta.setSize(270,50);
		ta.setLocation(10, 10);                                          
		//28����ť

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
		//this.setLayout(null);//�˾����ɾ����
		//this.add(btnName);//һ��������ȥadd�ؼ�
		this.setSize(295,340);
		this.setLocationRelativeTo(null);
		this.setTitle("������");
		//����ͼ��
		Toolkit kit=Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/com/zyy/day811/test2/calculator.png");
		this.setIconImage(img);
		this.setResizable(false);//���ô��岻�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MenuFrame12 menuFrame12 = new MenuFrame12();
		menuFrame12.setVisible(true);
	}
}
