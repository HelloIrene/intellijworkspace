package Notepad;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

import java.awt.datatransfer.Clipboard;

public class MyTextEditor extends JFrame {
	// UndoManager mg = new UndoManager();

	private int x;// ����λ��
	private int y;// ����λ��
	private int width;// ���
	private int height;// �߶�
	private UndoableEdit edit; // ���û�ԭ����
	private boolean canUndo = false;
	private static final long serialVersionUID = -161703958049318989L;
	private Clipboard clipboard;// ���а�
	private String path;// �ü�¼�ļ�ʱ�����´򿪵�
	private String title;// �ĵ�����
	private StringBuffer content;// ������ű��������
	private JMenuBar bar;
	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenu menuForm;
	private JMenu menuCheck;
	private JMenu menuHelp;
	// �ļ�
	private JMenuItem itemNew;
	private JMenuItem itemOpen;
	private JMenuItem itemSave;
	private JMenuItem itemSaveAs;
	private JMenuItem itemExit;
	// �༭
	private JMenuItem itemQuit;
	private JMenuItem itemCut;
	private JMenuItem itemCopy;
	private JMenuItem itemPaste;
	private JMenuItem itemDelete;
	private JMenuItem itemSelectAll;
	private JMenuItem itemTime;

	// ��ʽ
	private JMenuItem itemChangeRow;
	private JMenuItem itemFontType;
	// �鿴
	private JMenuItem itemState;
	// ����
	private JMenuItem itemAbout;

	private JTextArea txt;
	private JPanel pnlStatus;//�����������ʾ���������ı���
	private JLabel lblStatus;//�·�״̬��

	private JScrollPane scrollPane; // ������

	public MyTextEditor() {
		initControls();
		initMenu();
		initFrame();
	}

	private void initControls() {
		txt = new JTextArea();
		// txt.setLineWrap(true); // �Զ�����
		scrollPane = new JScrollPane(txt);
		// scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		lblStatus = new JLabel(new Date().toString());
		pnlStatus = new JPanel();
		pnlStatus.setLayout(new BorderLayout());
		pnlStatus.add(lblStatus);

		this.add(scrollPane);
		this.add(pnlStatus, BorderLayout.SOUTH);
		
		txt.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				// TODO Auto-generated method stub
				try {
					int pos = txt.getCaretPosition();
					// ��ȡ����
					int lineOfC = txt.getLineOfOffset(pos) + 1;
					// ��ȡ����
					int col = pos - txt.getLineStartOffset(lineOfC - 1) + 1;
					//��״̬����ʾʱ��
					//Timer t = new Timer(true);
					//MyTask task = new MyTask();
					lblStatus.setText("������"+lineOfC+"������"+col);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void initMenu() {

		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		menuFile = new JMenu("�ļ�(F)");
		menuEdit = new JMenu("�༭(E)");
		menuForm = new JMenu("��ʽ(O)");
		menuCheck = new JMenu("�鿴(V)");
		menuHelp = new JMenu("����(H)");
		;
		bar = new JMenuBar();
		itemOpen = new JMenuItem("��(O)");
		itemOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int rst = jfc.showOpenDialog(MyTextEditor.this);
				if (rst == JFileChooser.APPROVE_OPTION) {
					try {
						File file = jfc.getSelectedFile();
						title = file.getName();
						MyTextEditor.this.setTitle(title);
						path = file.getAbsolutePath();
						// System.out.println(file.getName());
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String s = br.readLine();
						StringBuffer sb = new StringBuffer();
						while (s != null) {
							sb.append(s);
							sb.append(System.getProperty("line.separator"));
							s = br.readLine();
						}
						txt.setText(sb.toString());
						br.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		itemSaveAs = new JMenuItem("���Ϊ...");
		itemSaveAs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = txt.getText();
				// System.out.println(str);
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		// �ļ�
		itemNew = new JMenuItem("�½�");
		itemNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!txt.getText().equals("")) {
					int rst = JOptionPane.showConfirmDialog(MyTextEditor.this, "��������δ����,ȷ���½���");
					if (rst == JOptionPane.YES_OPTION) {
						txt.setText("");
					}
				}
				// txt.setText("");
			}
		});
		itemSave = new JMenuItem("����");
		itemSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (path == null) {
					// Ϊ�½��ļ�������Ҳ�������Ϊ
					String str = txt.getText();
					// System.out.println(str);
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
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					File file = new File(path);
					String str = txt.getText();
					try {
						FileWriter fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(str);
						bw.flush();
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				path = null;
			}
		});
		itemExit = new JMenuItem("�˳�");
		itemExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		menuFile.add(itemOpen);
		menuFile.add(itemSaveAs);
		menuFile.add(itemNew);
		menuFile.add(itemSave);
		menuFile.add(itemExit);
		// �༭
		itemQuit = new JMenuItem("����");
		// ʵ�ֳ�������
		txt.getDocument().addUndoableEditListener(new UndoableEditListener() {
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				// TODO Auto-generated method stub
				edit = e.getEdit();
				if (edit != null) {
					canUndo = edit.canUndo();
				} else {
					canUndo = false;
				}
			}
		});

		itemQuit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (canUndo) {
					itemQuit.setEnabled(true);
					edit.undo();
				} else {
					itemQuit.setEnabled(false);
				}
			}
		});

		itemCut = new JMenuItem("����");
		itemCut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = txt.getSelectedText();
				try {
					setClipbordContent(clipboard, str);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txt.replaceSelection("");
			}
		});
		itemCopy = new JMenuItem("����");
		itemCopy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str = txt.getSelectedText();
				try {
					setClipbordContent(clipboard, str);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		itemPaste = new JMenuItem("ճ��");
		itemPaste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Transferable transferable = clipboard.getContents(this);
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
		itemDelete = new JMenuItem("ɾ��");
		itemDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txt.replaceSelection("");
			}
		});
		itemSelectAll = new JMenuItem("ȫѡ");
		itemSelectAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txt.selectAll();

			}
		});
		itemTime = new JMenuItem("ʱ��/����");
		itemTime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txt.append(new Date().toString());
			}
		});
		menuEdit.add(itemQuit);
		menuEdit.add(itemCut);
		menuEdit.add(itemCopy);
		menuEdit.add(itemPaste);
		menuEdit.add(itemDelete);
		menuEdit.add(itemSelectAll);
		menuEdit.add(itemTime);

		// ��ʽ
		itemChangeRow = new JMenuItem("�Զ�����");
		itemChangeRow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				itemChangeRow.setSelected(false);
				if (!txt.getLineWrap()) {
					txt.setLineWrap(true);
					itemChangeRow.setSelected(true);
				} else {
					txt.setLineWrap(false);
					itemChangeRow.setSelected(false);
				}
			}
		});
		itemFontType = new JMenuItem("����");
		itemFontType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// ��������ѡ��������������ΪԤ��ֵ
				MyFontChooser fontChooser = new MyFontChooser(txt.getFont());
				// ��һ������ѡ�������ڣ�����Ϊ���������ߴ��塣����һ�����ͣ�������������ʱ������ȷ������ȡ�����ɲο�MQFontChooser.APPROVE_OPTION��MQFontChooser.CANCEL_OPTION
				int returnValue = fontChooser.showFontDialog(MyTextEditor.this);
				// ������µ���ȷ����ť
				if (returnValue == MyFontChooser.APPROVE_OPTION) {
					// ��ȡѡ�������
					Font font = fontChooser.getSelectFont();
					// ���������õ�JTextArea��
					txt.setFont(font);
				}
			}
		});
		menuForm.add(itemChangeRow);
		menuForm.add(itemFontType);
		// �鿴
		itemState = new JMenuItem("״̬��");
		menuCheck.add(itemState);
		// ����
		itemAbout = new JMenuItem("����");
		itemAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(MyTextEditor.this,
						"<html><h3>���ߣ���°�<h3/>" + "<h3>ѧУ��������ѧԺ<h3/><h3>ѧ�ţ�Z09414211<h3/><h3>��Ȩ����<h3/><html>");
			}
		});

		menuHelp.add(itemAbout);
		menuHelp.add(menuFile);

		bar.add(menuFile);
		bar.add(menuEdit);
		bar.add(menuForm);
		bar.add(menuCheck);
		bar.add(menuHelp);
	}

	private void initFrame() {
		// ��������Ϣ�ж�ȡ�ϴιرյ�λ��
		Properties posGet = new Properties();
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream(new File("pos.properties")));
			posGet.load(in);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ��һ�ζ�ȡ��ʱ����Ϊû��ֵ����wei null����null������쳣�����ԼӸ��ж�
		x = posGet.getProperty("x") == null ? 0 : Integer.parseInt(posGet.getProperty("x"));
		y = posGet.getProperty("y") == null ? 0 : Integer.parseInt(posGet.getProperty("y"));
		width = posGet.getProperty("width") == null ? 0 : Integer.parseInt(posGet.getProperty("width"));
		height = posGet.getProperty("height") == null ? 0 : Integer.parseInt(posGet.getProperty("height"));
		this.setSize(width, height);
		this.setLocation(x, y);
		if (x == 0 || y == 0 || width == 0 || height == 0) {
			this.setLocation(320, 240);
			this.setSize(480, 620);
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				// Point point = MyTextEditor.this.getLocation();
				// MyTextEditor.this.get
				// int x = (int) point.getX();
				// int y = (int) point.getY();
				Container contentPane = MyTextEditor.this.getContentPane();
				Point contentPos = contentPane.getLocationOnScreen();// ����Ļ������
				Dimension size = contentPane.getSize(); // ��������Ĵ�С
				int x = (int) contentPos.getX();
				int y = (int) contentPos.getY();
				int width = (int) size.getWidth();
				int height = (int) size.getHeight();
				Properties pro = new Properties();
				pro.setProperty("x", x + "");
				pro.setProperty("y", y + "");
				pro.setProperty("width", width + "");
				pro.setProperty("height", height + "");
				FileWriter fw;
				try {
					fw = new FileWriter("pos.properties");
					pro.store(fw, "pos");
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		this.setJMenuBar(bar);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image image = kit.getImage("note.png");
		this.setIconImage(image);
		if (title == null) {
			this.setTitle("�½��ı��ĵ�-���±�");
		} else {
			this.setTitle(title);
		}
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			SwingUtilities.updateComponentTreeUI(this); // ˢ������ͼ�ν��棬�����µĹ۸�
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

//	private class MyTask extends TimerTask {
//
//		@Override
//		public void run() {
//			Date date = new Date();
//			int rows = txt.getRows();
//			int cols = txt.getColumns();
//			lblStatus.setText(date.toString() + "                " + rows + "��" + cols + "��");
//			System.gc();
//		}
//
//	}

	public void setClipbordContent(Clipboard clip, String str) throws Exception {

		Transferable trans = new StringSelection(str);
		clipboard.setContents(trans, null);
	}

}
