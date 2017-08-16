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

	private JMenuBar bar;//菜单栏
	
	private JMenu menuFile;//菜单：文件
	private JMenu mne;//菜单：编辑
	private JMenu mno;//菜单：格式
	private JMenu mnv;//菜单：查看
	private JMenu mnh;//菜单：帮助
	
	private JMenuItem itemOpen;//文件菜单下菜单项：打开
	private JMenuItem itemSaveAs;//文件菜单下菜单项：另存为
	private JMenuItem mntmn;//文件菜单下菜单项：新建
	private JMenuItem mntms;//文件菜单下菜单项：保存
	private JMenuItem mntmx;//文件菜单下菜单项：退出
	
	private JMenuItem mntmd;//编辑菜单下菜单项：时间/日期
	private JMenuItem mntma;//编辑菜单下菜单项：全选
	private JMenuItem mntml;//编辑菜单下菜单项：删除
	private JMenuItem mntmp;//编辑菜单下菜单项：粘贴
	private JMenuItem mntmc;//编辑菜单下菜单项：复制
	private JMenuItem mntmt;//编辑菜单下菜单项：剪切
	private JMenuItem mntmu;//编辑菜单下菜单项：撤销
	
	private JMenuItem mntmf;//格式菜单下菜单项：字体
	private JCheckBoxMenuItem mntmw;//格式菜单下菜单项：自动换行
	private JMenuItem mntco;//格式菜单下菜单项：修改背景色
	
    private JCheckBoxMenuItem mntms_1;//查看菜单下菜单项：状态栏
    
	private JMenuItem mntma_1;//帮助菜单下菜单项：关于记事本
	private JMenuItem mntmh;//帮助菜单下菜单项：查看帮助
	
	private JTextArea txt;//文本框
	private JPanel pnlStatus;//显示滚动条和文本域
	private JLabel lblStatus;//状态栏

	private JScrollPane scrollPane; //滚动条
	
	private String path;//另存为功能里用到：用记录文件时否是新打开的
	
	private UndoableEdit edit;  //设置还原功能
	private boolean canUndo = false;//撤销功能使用
	
	private Clipboard clipboard;//剪切、复制、粘贴功能里用到: 剪切板
	
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
		//具体实现打开文件功能1
		itemOpen = new JMenuItem("打开(O)");
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
		//具体实现将文件另存为功能2
		itemSaveAs = new JMenuItem("另存为...");		
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
		//具体实现新建文件功能3
		mntmn = new JMenuItem("新建(N)");
		mntmn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		mntmn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!txt.getText().equals(" ")){
					int rst = JOptionPane.showConfirmDialog(MyTextEditor.this, "您有任务未保存,确定新建吗？");
					if (rst == JOptionPane.YES_OPTION) {
						txt.setText("");
					}
				}				
			}
		});
		//具体实现保存文件功能4
		mntms = new JMenuItem("保存(S)");
		mntms.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntms.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (path == null) {
					// 没有新建文件的情况下，保存和另存为一样
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
				} else {//在已经有个新建文件的情况下，保存与另存为的区别是：保存相当于覆盖了之前已有的文件
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
		//具体实现退出记事本功能5
		mntmx = new JMenuItem("退出(X)");
		mntmx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		//"文件"菜单的几个功能菜单项的添加上来(1--5)
		menuFile = new JMenu("文件(F)");
		menuFile.add(mntmn);     //将"新建"菜单项添加到文件底下
		menuFile.add(itemOpen);  //将"打开"菜单项添加到文件底下
		menuFile.add(mntms);     //将"保存"菜单项添加到文件底下
		menuFile.add(itemSaveAs);//将"另存为"菜单项添加到文件底下
		menuFile.addSeparator(); //分隔线
		menuFile.add(mntmx);     //将"退出"菜单项添加到文件底下
		
	
		//具体实现撤销功能1
		mntmu = new JMenuItem("撤销(U)");
		mntmu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
		txt.getDocument().addUndoableEditListener(new UndoableEditListener() {
//			private UndoableEdit edit;  //设置还原功能
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
		//具体实现剪切功能2
		mntmt = new JMenuItem("剪切(T)");
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
		//具体实现复制功能3
		mntmc = new JMenuItem("复制(C)");
		mntmc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		mntmc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clipboard = getToolkit().getSystemClipboard();
				StringSelection stringSelection = new StringSelection(txt.getSelectedText());
				clipboard.setContents(stringSelection, null);
			}
		});
		//具体实现粘贴功能4
		mntmp = new JMenuItem("粘贴(P)");
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
		//具体实现删除功能5
		mntml = new JMenuItem("删除(L)");
		mntml.setAccelerator(KeyStroke.getKeyStroke("DELETE"));// 添加快捷键
		mntml.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txt.replaceSelection("");				
			}
		});
		//具体实现全选功能6
		mntma = new JMenuItem("全选(A)");
		mntma.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		mntma.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txt.selectAll();				
			}
		});		
		//具体实现时间/日期功能7
		mntmd = new JMenuItem("时间/日期(D)");
		mntmd.setAccelerator(KeyStroke.getKeyStroke("F5"));
		mntmd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txt.append(new Date().toString());			
			}
		});
		//"编辑(E)"菜单的几个功能菜单项的添加上来(1--7)
		mne = new JMenu("编辑(E)");
		mne.add(mntmu);			//将"撤销"菜单项添加到编辑底下
		mne.addSeparator();     //分隔线
		mne.add(mntmt);			//将"剪切"菜单项添加到编辑底下
		mne.add(mntmc);			//将"复制"菜单项添加到编辑底下
		mne.add(mntmp);			//将"粘贴"菜单项添加到编辑底下
		mne.add(mntml);			//将"删除"菜单项添加到编辑底下
		mne.addSeparator();     //分隔线
		mne.add(mntma);			//将"全选"菜单项添加到编辑底下
		mne.add(mntmd);			//将"时间/日期"菜单项添加到编辑底下
		
		
		
		//具体实现自动换行功能1
		mntmw = new JCheckBoxMenuItem("自动换行(W)");
		mntmw.addActionListener(new ActionListener() {
			
			@Override
//		public void actionPerformed(ActionEvent e) {
////				mntmw.setSelected(false);// true if the button is selected, otherwise false
////				if(!txt.getLineWrap()){//获取文本区的换行策略
////					txt.setLineWrap(true); //设置文本区的换行策略If set to true the lines will be wrapped if they are too long to fit within the allocated width
////					mntmw.setSelected(true);//true if the button is selected					         
////				}else{					
////					txt.setLineWrap(false);
////					mntmw.setSelected(false);
////				}				
////			}
//		});
			public void actionPerformed(ActionEvent e) {
				if(mntmw.isSelected()){    //如果选中复选框
					txt.setLineWrap(true); //执行换行操作
					return ;               
				}
				  txt.setLineWrap(false);  //没有选中则不执行换行操作
				}
			});
		//具体实现字体功能2
		mntmf = new JMenuItem("字体(F)");
//		mntmf.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				OtherFontChooser fontChooser = new OtherFontChooser();
//				/**
//				 * 显示字体选择器showFontDialog()
//				 * Parameters:
//				 *	 owner 上层所有者
//				 *	 Returns:
//				 *	  该整型返回值表示用户点击了字体选择器的确定按钮或取消按钮，参考本类常量字段APPROVE_OPTION和CANCEL_OPTION
//				 */
//				int showValue = fontChooser.showFontDialog(MyTextEditor.this);
//				if(showValue == OtherFontChooser.APPROVE_OPTION){//用户点击了字体选择器的确定按钮
//					Font font = fontChooser.getSelectFont();//获取选择的字体
//					txt.setFont(font);//将字体设置到JTextArea中
//				}
//			}
//		});
		//具体实现设置背景颜色功能3
		mntco = new JMenuItem("设置文本背景");
		mntco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(MyTextEditor.this, "颜色选择器", Color.BLACK);
				txt.setBackground(c);		
			}
		});
		//"格式(O)"菜单的几个功能菜单项的添加上来(1--3)
		mno = new JMenu("格式(O)");
		mno.add(mntmw);			//将"自动换行"菜单项添加到格式底下
		mno.add(mntmf);			//将"字体"菜单项添加到格式底下
		mno.add(mntco);			//将"设置文本背景"菜单项添加到格式底下
		
		
		//具体实现状态栏功能1
		mntms_1 = new JCheckBoxMenuItem("状态栏(S)");
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
		//"查看(V)"菜单的1个功能菜单项的添加上来(1)
		mnv = new JMenu("查看(V)");
		mnv.add(mntms_1);		//将"状态栏"菜单项添加到查看底下
		
		
		
		//具体实现查看帮助功能1
		mntmh = new JMenuItem("查看帮助(H)");
		mntmh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MyTextEditor.this,  "对不起，此功能尚未实现！","提示",JOptionPane.WARNING_MESSAGE);
				
			}
		});
		//具体实现关于记事本功能2
		mntma_1 = new JMenuItem("关于记事本(A)");
		mntma_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MyTextEditor.this, 
						"<html><h3>Author：Irene<h3/>" + "<h3>School：HHIT<h3/><h3>Sno：2014122773<h3/><h3>Welcome to use!<h3/><html>");
				
			}
		});
		
		//"帮助(H)"菜单的几个功能菜单项的添加上来(1--2)
		mnh = new JMenu("帮助(H)");
		mnh.add(mntmh);			//将"查看帮助"菜单项添加到帮助底下
		mnh.addSeparator();
		mnh.add(mntma_1);		//将"关于记事本"菜单项添加到帮助底下
		
		
		
		//记事本菜单栏下的5个菜单
		bar = new JMenuBar();
		bar.add(menuFile);  //"文件(F)"
		bar.add(mne);		//"编辑(E)"
		bar.add(mno);		//"格式(O)"
		bar.add(mnv);		//"查看(V)"
		bar.add(mnh);		//"帮助(H)"
			
	}

	private void initFrame() {
		this.setSize(640, 480);//设置文本框大小
		this.setLocationRelativeTo(null);//此窗口将置于屏幕的中央
		this.setTitle("记事本");//取名字
		//设置图标
		Toolkit kit=Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/img/test.png");
		this.setIconImage(img);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(bar);
	}

	public void initRightMenu(){
		JPanel rightJpanel = new JPanel();//显示右键菜单栏
		JPopupMenu pmu = new JPopupMenu();//右键菜单
		//具体实现撤销功能1
		mntmu = new JMenuItem("撤销(U)");
		mntmu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		txt.getDocument().addUndoableEditListener(new UndoableEditListener() {
			// private UndoableEdit edit; //设置还原功能
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
		// 具体实现剪切功能2
		mntmt = new JMenuItem("剪切(T)");
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
		// 具体实现复制功能3
		mntmc = new JMenuItem("复制(C)");
		mntmc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clipboard = getToolkit().getSystemClipboard();
				StringSelection stringSelection = new StringSelection(txt.getSelectedText());
				clipboard.setContents(stringSelection, null);
			}
		});
		// 具体实现粘贴功能4
		mntmp = new JMenuItem("粘贴(P)");
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
		// 具体实现删除功能5
		mntml = new JMenuItem("删除(L)");
		mntml.setAccelerator(KeyStroke.getKeyStroke("DELETE"));// 添加快捷键
		mntml.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txt.replaceSelection("");
			}
		});
		// 具体实现全选功能6
		mntma = new JMenuItem("全选(A)");
		mntma.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntma.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txt.selectAll();
			}
		});

		// "编辑(E)"菜单的几个功能菜单项的添加上来(1--6)
		pmu.add(mntmu);
		pmu.addSeparator();     //分隔线
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
private JMenuItem mntma;//编辑菜单下菜单项：全选
	private JMenuItem mntml;//编辑菜单下菜单项：删除
	private JMenuItem mntmp;//编辑菜单下菜单项：粘贴
	private JMenuItem mntmc;//编辑菜单下菜单项：复制
	private JMenuItem mntmt;//编辑菜单下菜单项：剪切
	private JMenuItem mntmu;//编辑菜单下菜单项：撤销
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
		// 粘帖功能可用性判断
		Transferable contents = clipboard.getContents(this);
		if (contents == null) {
			mntmp.setEnabled(false);
		} else {
			mntmp.setEnabled(true);
		}
	}// 方法checkMenuItemEnabled()结束

	private void Mouse(JPopupMenu jPopupMenu) {
		txt.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger())// 返回此鼠标事件是否为该平台的弹出菜单触发事件
				{
					jPopupMenu.show(e.getComponent(), e.getX(), e.getY());// 在组件调用者的坐标空间中的位置
					// X、Y
					// 显示弹出菜单
				}
				checkMenuItemEnabled();// 设置剪切，复制，粘帖，删除等功能的可用性
				txt.requestFocus();// 编辑区获取焦点
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger())// 返回此鼠标事件是否为该平台的弹出菜单触发事件
				{
					jPopupMenu.show(e.getComponent(), e.getX(), e.getY());// 在组件调用者的坐标空间中的位置
					// X、Y
					// 显示弹出菜单
				}
				checkMenuItemEnabled();// 设置剪切，复制，粘帖，删除等功能的可用性
				txt.requestFocus();// 编辑区获取焦点
			}
		});// 文本编辑区注册右键菜单事件结束
	}
	private class MyTask extends TimerTask {

		@Override
		public void run() {
			lblStatus.setText(new Date().toString());
			System.gc();
		}

	}
}
