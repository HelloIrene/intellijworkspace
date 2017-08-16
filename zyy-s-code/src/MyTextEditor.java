import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEdit;


import jdk.management.resource.internal.inst.ServerSocketChannelImplRMHooks;


public class MyTextEditor extends JFrame {
	private static final long serialVersionUID = -161703958049318989L;

	private JMenuBar bar;//�˵���
	
	private JMenu menuFile;//�˵����ļ�
	private JMenu mne;//�˵����༭
	private JMenu mno;//�˵�����ʽ
	private JMenu mnv;//�˵����鿴
	private JMenu mnh;//�˵�������
	
	private JMenuItem itemOpen;//�ļ��˵��²˵����
	private JMenuItem itemSaveAs;//�ļ��˵��²˵�����Ϊ
	private JMenuItem mntmn;//�ļ��˵��²˵���½�
	private JMenuItem mntms;//�ļ��˵��²˵������
	private JMenuItem mntmx;//�ļ��˵��²˵���˳�
	
	private JMenuItem mntmd;//�༭�˵��²˵��ʱ��/����
	private JMenuItem mntma;//�༭�˵��²˵��ȫѡ
	private JMenuItem mntml;//�༭�˵��²˵��ɾ��
	private JMenuItem mntmp;//�༭�˵��²˵��ճ��
	private JMenuItem mntmc;//�༭�˵��²˵������
	private JMenuItem mntmt;//�༭�˵��²˵������
	private JMenuItem mntmu;//�༭�˵��²˵������
	
	private JMenuItem mntmf;//��ʽ�˵��²˵������
	private JCheckBoxMenuItem mntmw;//��ʽ�˵��²˵���Զ�����
	private JMenuItem mntco;//��ʽ�˵��²˵���޸ı���ɫ
	
    private JCheckBoxMenuItem mntms_1;//�鿴�˵��²˵��״̬��
    
	private JMenuItem mntma_1;//�����˵��²˵�����ڼ��±�
	private JMenuItem mntmh;//�����˵��²˵���鿴����
	
	private JTextArea txt;//�ı���
	private JPanel pnlStatus;//��ʾ���������ı���
	private JLabel lblStatus;//״̬��

	private JScrollPane scrollPane; //������
	
	private String path;//���Ϊ�������õ����ü�¼�ļ�ʱ�����´򿪵�
	
	private UndoableEdit edit;  //���û�ԭ����
	private boolean canUndo = false;//��������ʹ��
	
	private Clipboard clipboard;//���С����ơ�ճ���������õ�: ���а�
	
	public MyTextEditor() {
		txt = new JTextArea();
		initMenu();
		initControls();
		initFrame();
		initRightMenu();
		Timer t = new Timer(true);
		MyTask task = new MyTask();
		t.schedule(task, 1000, 1000);
	}

	private void initControls() {		
		scrollPane = new JScrollPane(txt);
//		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		lblStatus = new JLabel(new Date().toString());
		pnlStatus = new JPanel();
		pnlStatus.setLayout(new BorderLayout());
		pnlStatus.add(lblStatus);
		pnlStatus.setVisible(false);
		getContentPane().add(scrollPane);
		getContentPane().add(pnlStatus, BorderLayout.SOUTH);
	}

	private void initMenu() {
		//����ʵ�ִ��ļ�����1
		itemOpen = new JMenuItem("��(O)");
		itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		itemOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int rst = jfc.showOpenDialog(MyTextEditor.this);
				if(rst == JFileChooser.APPROVE_OPTION){
					try {
						File file = jfc.getSelectedFile();
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String s = br.readLine();
						StringBuffer sb = new StringBuffer();
						while(s!=null){
							sb.append(s);
							sb.append(System.getProperty("line.separator"));
							s = br.readLine();
						}
						txt.setText(sb.toString());
						br.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		//����ʵ�ֽ��ļ����Ϊ����2
		itemSaveAs = new JMenuItem("���Ϊ...");		
		itemSaveAs.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = txt.getText();
				JFileChooser jfc = new JFileChooser();
				jfc.showSaveDialog(MyTextEditor.this);
				File file = jfc.getSelectedFile();
				try {
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(str);
					bw.flush();
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		//����ʵ���½��ļ�����3
		mntmn = new JMenuItem("�½�(N)");
		mntmn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		mntmn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!txt.getText().equals(" ")){
					int rst = JOptionPane.showConfirmDialog(MyTextEditor.this, "��������δ����,ȷ���½���");
					if (rst == JOptionPane.YES_OPTION) {
						txt.setText("");
					}
				}				
			}
		});
		//����ʵ�ֱ����ļ�����4
		mntms = new JMenuItem("����(S)");
		mntms.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntms.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (path == null) {
					// û���½��ļ�������£���������Ϊһ��
					String str = txt.getText();
					JFileChooser jfc = new JFileChooser();
					jfc.showSaveDialog(MyTextEditor.this);
					File file = jfc.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(str);
						bw.flush();
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {//���Ѿ��и��½��ļ�������£����������Ϊ�������ǣ������൱�ڸ�����֮ǰ���е��ļ�
					File file = new File(path);
					String str = txt.getText();
					try {
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(str);
						bw.flush();
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
				path = null;				
			}
		});
		//����ʵ���˳����±�����5
		mntmx = new JMenuItem("�˳�(X)");
		mntmx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		//"�ļ�"�˵��ļ������ܲ˵�����������(1--5)
		menuFile = new JMenu("�ļ�(F)");
		menuFile.add(mntmn);     //��"�½�"�˵�����ӵ��ļ�����
		menuFile.add(itemOpen);  //��"��"�˵�����ӵ��ļ�����
		menuFile.add(mntms);     //��"����"�˵�����ӵ��ļ�����
		menuFile.add(itemSaveAs);//��"���Ϊ"�˵�����ӵ��ļ�����
		menuFile.addSeparator(); //�ָ���
		menuFile.add(mntmx);     //��"�˳�"�˵�����ӵ��ļ�����
		
	
		//����ʵ�ֳ�������1
		mntmu = new JMenuItem("����(U)");
		mntmu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
		txt.getDocument().addUndoableEditListener(new UndoableEditListener() {
//			private UndoableEdit edit;  //���û�ԭ����
//			private boolean canUndo = false;
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				edit = e.getEdit();
				if(edit != null){
					canUndo = edit.canUndo();
				}else{
					canUndo = false;
				}				
			}
		});
		mntmu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(canUndo){
					mntmu.setEnabled(true);
					edit.undo();
				}else{
					mntmu.setEnabled(false);
				}				
			}
		});
		//����ʵ�ּ��й���2
		mntmt = new JMenuItem("����(T)");
		mntmt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		mntmt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clipboard = getToolkit().getSystemClipboard();
				StringSelection stringSelection = new StringSelection(txt.getSelectedText());
				clipboard.setContents(stringSelection, null);
				txt.replaceSelection("");
			}
		});
		//����ʵ�ָ��ƹ���3
		mntmc = new JMenuItem("����(C)");
		mntmc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		mntmc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clipboard = getToolkit().getSystemClipboard();
				StringSelection stringSelection = new StringSelection(txt.getSelectedText());
				clipboard.setContents(stringSelection, null);
			}
		});
		//����ʵ��ճ������4
		mntmp = new JMenuItem("ճ��(P)");
		mntmp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
		mntmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				java.awt.datatransfer.Transferable transferable = clipboard.getContents(this);
				java.awt.datatransfer.DataFlavor flavor = java.awt.datatransfer.DataFlavor.stringFlavor;
				if (transferable.isDataFlavorSupported(flavor)) {
					try {
						int start = txt.getSelectionStart();
						int end = txt.getSelectionEnd();
						txt.replaceRange("", start, end);
						String str;
						int n = txt.getCaretPosition();
						str = (String) transferable.getTransferData(flavor);
						txt.insert(str, n);
					} catch (Exception ee) {

					}
				}				
			}
		});
		//����ʵ��ɾ������5
		mntml = new JMenuItem("ɾ��(L)");
		mntml.setAccelerator(KeyStroke.getKeyStroke("DELETE"));// ��ӿ�ݼ�
		mntml.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txt.replaceSelection("");				
			}
		});
		//����ʵ��ȫѡ����6
		mntma = new JMenuItem("ȫѡ(A)");
		mntma.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		mntma.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txt.selectAll();				
			}
		});		
		//����ʵ��ʱ��/���ڹ���7
		mntmd = new JMenuItem("ʱ��/����(D)");
		mntmd.setAccelerator(KeyStroke.getKeyStroke("F5"));
		mntmd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txt.append(new Date().toString());			
			}
		});
		//"�༭(E)"�˵��ļ������ܲ˵�����������(1--7)
		mne = new JMenu("�༭(E)");
		mne.add(mntmu);			//��"����"�˵�����ӵ��༭����
		mne.addSeparator();     //�ָ���
		mne.add(mntmt);			//��"����"�˵�����ӵ��༭����
		mne.add(mntmc);			//��"����"�˵�����ӵ��༭����
		mne.add(mntmp);			//��"ճ��"�˵�����ӵ��༭����
		mne.add(mntml);			//��"ɾ��"�˵�����ӵ��༭����
		mne.addSeparator();     //�ָ���
		mne.add(mntma);			//��"ȫѡ"�˵�����ӵ��༭����
		mne.add(mntmd);			//��"ʱ��/����"�˵�����ӵ��༭����
		
		
		
		//����ʵ���Զ����й���1
		mntmw = new JCheckBoxMenuItem("�Զ�����(W)");
		mntmw.addActionListener(new ActionListener() {
			
			@Override
//		public void actionPerformed(ActionEvent e) {
////				mntmw.setSelected(false);// true if the button is selected, otherwise false
////				if(!txt.getLineWrap()){//��ȡ�ı����Ļ��в���
////					txt.setLineWrap(true); //�����ı����Ļ��в���If set to true the lines will be wrapped if they are too long to fit within the allocated width
////					mntmw.setSelected(true);//true if the button is selected					         
////				}else{					
////					txt.setLineWrap(false);
////					mntmw.setSelected(false);
////				}				
////			}
//		});
			public void actionPerformed(ActionEvent e) {
				if(mntmw.isSelected()){    //���ѡ�и�ѡ��
					txt.setLineWrap(true); //ִ�л��в���
					return ;               
				}
				  txt.setLineWrap(false);  //û��ѡ����ִ�л��в���
				}
			});
		//����ʵ�����幦��2
		mntmf = new JMenuItem("����(F)");
//		mntmf.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				OtherFontChooser fontChooser = new OtherFontChooser();
//				/**
//				 * ��ʾ����ѡ����showFontDialog()
//				 * Parameters:
//				 *	 owner �ϲ�������
//				 *	 Returns:
//				 *	  �����ͷ���ֵ��ʾ�û����������ѡ������ȷ����ť��ȡ����ť���ο����ೣ���ֶ�APPROVE_OPTION��CANCEL_OPTION
//				 */
//				int showValue = fontChooser.showFontDialog(MyTextEditor.this);
//				if(showValue == OtherFontChooser.APPROVE_OPTION){//�û����������ѡ������ȷ����ť
//					Font font = fontChooser.getSelectFont();//��ȡѡ�������
//					txt.setFont(font);//���������õ�JTextArea��
//				}
//			}
//		});
		//����ʵ�����ñ�����ɫ����3
		mntco = new JMenuItem("�����ı�����");
		mntco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(MyTextEditor.this, "��ɫѡ����", Color.BLACK);
				txt.setBackground(c);		
			}
		});
		//"��ʽ(O)"�˵��ļ������ܲ˵�����������(1--3)
		mno = new JMenu("��ʽ(O)");
		mno.add(mntmw);			//��"�Զ�����"�˵�����ӵ���ʽ����
		mno.add(mntmf);			//��"����"�˵�����ӵ���ʽ����
		mno.add(mntco);			//��"�����ı�����"�˵�����ӵ���ʽ����
		
		
		//����ʵ��״̬������1
		mntms_1 = new JCheckBoxMenuItem("״̬��(S)");
		mntms_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mntms_1.isSelected()){
					pnlStatus.setVisible(true);
					return ;
				}
				pnlStatus.setVisible(false);				
			}
		});
		//"�鿴(V)"�˵���1�����ܲ˵�����������(1)
		mnv = new JMenu("�鿴(V)");
		mnv.add(mntms_1);		//��"״̬��"�˵�����ӵ��鿴����
		
		
		
		//����ʵ�ֲ鿴��������1
		mntmh = new JMenuItem("�鿴����(H)");
		mntmh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MyTextEditor.this,  "�Բ��𣬴˹�����δʵ�֣�","��ʾ",JOptionPane.WARNING_MESSAGE);
				
			}
		});
		//����ʵ�ֹ��ڼ��±�����2
		mntma_1 = new JMenuItem("���ڼ��±�(A)");
		mntma_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MyTextEditor.this, 
						"<html><h3>Author��Irene<h3/>" + "<h3>School��HHIT<h3/><h3>Sno��2014122773<h3/><h3>Welcome to use!<h3/><html>");
				
			}
		});
		
		//"����(H)"�˵��ļ������ܲ˵�����������(1--2)
		mnh = new JMenu("����(H)");
		mnh.add(mntmh);			//��"�鿴����"�˵�����ӵ���������
		mnh.addSeparator();
		mnh.add(mntma_1);		//��"���ڼ��±�"�˵�����ӵ���������
		
		
		
		//���±��˵����µ�5���˵�
		bar = new JMenuBar();
		bar.add(menuFile);  //"�ļ�(F)"
		bar.add(mne);		//"�༭(E)"
		bar.add(mno);		//"��ʽ(O)"
		bar.add(mnv);		//"�鿴(V)"
		bar.add(mnh);		//"����(H)"
			
	}

	private void initFrame() {
		this.setSize(640, 480);//�����ı����С
		this.setLocationRelativeTo(null);//�˴��ڽ�������Ļ������
		this.setTitle("���±�");//ȡ����
		//����ͼ��
		Toolkit kit=Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/img/test.png");
		this.setIconImage(img);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(bar);
	}

	public void initRightMenu(){
		JPanel rightJpanel = new JPanel();//��ʾ�Ҽ��˵���
		JPopupMenu pmu = new JPopupMenu();//�Ҽ��˵�
		//����ʵ�ֳ�������1
		mntmu = new JMenuItem("����(U)");
		mntmu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		txt.getDocument().addUndoableEditListener(new UndoableEditListener() {
			// private UndoableEdit edit; //���û�ԭ����
			// private boolean canUndo = false;
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				edit = e.getEdit();
				if (edit != null) {
					canUndo = edit.canUndo();
				} else {
					canUndo = false;
				}
			}
		});
		mntmu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (canUndo) {
					mntmu.setEnabled(true);
					edit.undo();
				} else {
					mntmu.setEnabled(false);
				}
			}
		});
		// ����ʵ�ּ��й���2
		mntmt = new JMenuItem("����(T)");
		mntmt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mntmt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clipboard = getToolkit().getSystemClipboard();
				StringSelection stringSelection = new StringSelection(txt.getSelectedText());
				clipboard.setContents(stringSelection, null);
				txt.replaceSelection("");
			}
		});
		// ����ʵ�ָ��ƹ���3
		mntmc = new JMenuItem("����(C)");
		mntmc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clipboard = getToolkit().getSystemClipboard();
				StringSelection stringSelection = new StringSelection(txt.getSelectedText());
				clipboard.setContents(stringSelection, null);
			}
		});
		// ����ʵ��ճ������4
		mntmp = new JMenuItem("ճ��(P)");
		mntmp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mntmp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				java.awt.datatransfer.Transferable transferable = clipboard.getContents(this);
				java.awt.datatransfer.DataFlavor flavor = java.awt.datatransfer.DataFlavor.stringFlavor;
				if (transferable.isDataFlavorSupported(flavor)) {
					try {
						int start = txt.getSelectionStart();
						int end = txt.getSelectionEnd();
						txt.replaceRange("", start, end);
						String str;
						int n = txt.getCaretPosition();
						str = (String) transferable.getTransferData(flavor);
						txt.insert(str, n);
					} catch (Exception ee) {

					}
				}
			}
		});
		// ����ʵ��ɾ������5
		mntml = new JMenuItem("ɾ��(L)");
		mntml.setAccelerator(KeyStroke.getKeyStroke("DELETE"));// ��ӿ�ݼ�
		mntml.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txt.replaceSelection("");
			}
		});
		// ����ʵ��ȫѡ����6
		mntma = new JMenuItem("ȫѡ(A)");
		mntma.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntma.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txt.selectAll();
			}
		});

		// "�༭(E)"�˵��ļ������ܲ˵�����������(1--6)
		pmu.add(mntmu);
		pmu.addSeparator();     //�ָ���
		pmu.add(mntmt);
		pmu.add(mntmc);
		pmu.add(mntmp);
		pmu.add(mntml);
		pmu.addSeparator();
		pmu.add(mntma);
		this.Mouse(pmu);
		this.txt.setComponentPopupMenu(pmu);
	}
/*
private JMenuItem mntma;//�༭�˵��²˵��ȫѡ
	private JMenuItem mntml;//�༭�˵��²˵��ɾ��
	private JMenuItem mntmp;//�༭�˵��²˵��ճ��
	private JMenuItem mntmc;//�༭�˵��²˵������
	private JMenuItem mntmt;//�༭�˵��²˵������
	private JMenuItem mntmu;//�༭�˵��²˵������
 */
	public void checkMenuItemEnabled() {
		String selectText = txt.getSelectedText();
		if (selectText == null) {
			mntmt.setEnabled(false);
			mntmc.setEnabled(false);
			mntml.setEnabled(false);
			mntma.setEnabled(false);
		} else {
			mntmt.setEnabled(true);
			mntmc.setEnabled(true);
			mntml.setEnabled(true);
			mntma.setEnabled(true);
		}
		// ճ�����ܿ������ж�
		Transferable contents = clipboard.getContents(this);
		if (contents == null) {
			mntmp.setEnabled(false);
		} else {
			mntmp.setEnabled(true);
		}
	}// ����checkMenuItemEnabled()����

	private void Mouse(JPopupMenu jPopupMenu) {
		txt.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger())// ���ش�����¼��Ƿ�Ϊ��ƽ̨�ĵ����˵������¼�
				{
					jPopupMenu.show(e.getComponent(), e.getX(), e.getY());// ����������ߵ�����ռ��е�λ��
					// X��Y
					// ��ʾ�����˵�
				}
				checkMenuItemEnabled();// ���ü��У����ƣ�ճ����ɾ���ȹ��ܵĿ�����
				txt.requestFocus();// �༭����ȡ����
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger())// ���ش�����¼��Ƿ�Ϊ��ƽ̨�ĵ����˵������¼�
				{
					jPopupMenu.show(e.getComponent(), e.getX(), e.getY());// ����������ߵ�����ռ��е�λ��
					// X��Y
					// ��ʾ�����˵�
				}
				checkMenuItemEnabled();// ���ü��У����ƣ�ճ����ɾ���ȹ��ܵĿ�����
				txt.requestFocus();// �༭����ȡ����
			}
		});// �ı��༭��ע���Ҽ��˵��¼�����
	}
	private class MyTask extends TimerTask {

		@Override
		public void run() {
			lblStatus.setText(new Date().toString());
			System.gc();
		}

	}
}
