package Teacher.Code;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyTextEditor extends JFrame {
	private static final long serialVersionUID = -161703958049318989L;

	private JMenuBar bar;
	private JMenu menuFile;
	private JMenuItem itemOpen;
	private JMenuItem itemSaveAs;

	private JTextArea txt;
	private JPanel pnlStatus;
	private JLabel lblStatus;

	private JScrollPane scrollPane; // 滚动条

	public MyTextEditor() {
		initMenu();
		initControls();
		initFrame();
		Timer t = new Timer(true);
		MyTask task = new MyTask();
		t.schedule(task, 1000, 1000);
		// SetTime st = new SetTime();
		// Thread t = new Thread(st);
		// t.start();
	}

	private void initControls() {
		txt = new JTextArea();
		txt.setLineWrap(false); // 自动换行
		scrollPane = new JScrollPane(txt);
		// scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		lblStatus = new JLabel(new Date().toString());
		pnlStatus = new JPanel();
		pnlStatus.setLayout(new BorderLayout());
		pnlStatus.add(lblStatus);

		this.add(scrollPane);
		this.add(pnlStatus, BorderLayout.SOUTH);
	}

	private void initMenu() {
		itemOpen = new JMenuItem("打开(O)");
		itemOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int rst = jfc.showOpenDialog(MyTextEditor.this);
				if (rst == JFileChooser.APPROVE_OPTION) {
					try {
						File file = jfc.getSelectedFile();
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		menuFile = new JMenu("文件(F)");
		menuFile.add(itemOpen);
		menuFile.add(itemSaveAs);

		bar = new JMenuBar();
		bar.add(menuFile);
	}

	private void initFrame() {
		this.setSize(640, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(bar);
	}

	// private class SetTime implements Runnable{
	//
	// @Override
	// public void run() {
	// while(true){
	// lblStatus.setText(new Date().toString());
	// try {
	// Thread.sleep(1000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// System.gc();
	// }
	// }
	// }

	private class MyTask extends TimerTask {
		@Override
		public void run() {
			lblStatus.setText(new Date().toString());
			System.gc();
		}

	}
}
