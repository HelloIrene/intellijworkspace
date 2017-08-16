package Teacher.Code.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class DialogFrame extends JFrame/* implements ActionListener */ {

	private static final long serialVersionUID = -9052586476251179575L;
	private JButton btnClick;
	private JButton btnClick2;
	private JPanel pnlMain;
	private JLabel lblReg;

	public JPanel getPnlMain() {
		return pnlMain;
	}

	public void setPnlMain(JPanel pnlMain) {
		this.pnlMain = pnlMain;
	}

	public DialogFrame() {
		
		lblReg = new JLabel("<html><u>ע��</u></html>");
		lblReg.setForeground(Color.BLUE);
		lblReg.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				lblReg.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblReg.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

		});
		
		btnClick = new JButton("��ɫ�Ի���");
		MyClickHandler mch = new MyClickHandler();
		btnClick.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				btnClick.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnClick.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

		});
		btnClick.addActionListener(new ActionListener() {
			// �����ڲ���
			@Override
			public void actionPerformed(ActionEvent e) {
				// ����Ҫȥ�ж��¼�Դ
				Color c = JColorChooser.showDialog(DialogFrame.this, "ѡ����ɫ", Color.BLACK);
				pnlMain.setBackground(c);
			}
		});
		btnClick2 = new JButton("��Ϣ��");
		btnClick2.addActionListener(mch);
		pnlMain = new JPanel();

		pnlMain.add(btnClick);
		pnlMain.add(btnClick2);
		pnlMain.add(lblReg);
		this.add(pnlMain);

		initFrame();
	}

	private void initFrame() {
		this.setSize(500, 300);
		// ����λ���������Ļ����������Ļ����
		this.setLocationRelativeTo(null);
		this.setTitle("���öԻ���");
		// ��ȡĬ�ϵĴ��幤���䣬����ͼ��
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/logo.png");
		this.setIconImage(img);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(DialogFrame.this, "����δ���棬Ҫ��������˳�?", "Confirm",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					// ������߼�����
					DialogFrame.this.dispose(); // �رմ���
				} else if (result == JOptionPane.NO_OPTION) {
					DialogFrame.this.dispose();
				}
			}
		});
		try {
			// UIManager.setLookAndFeel(new WindowsLookAndFeel());
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
			SwingUtilities.updateComponentTreeUI(this); // ˢ������ͼ�ν��棬�����µĹ۸�
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Override
	// public void actionPerformed(ActionEvent e) {
	// if(e.getSource()==btnClick) //��ȡ�¼�Դ
	// {
	// Color c = JColorChooser.showDialog(this, "ѡ����ɫ", Color.BLACK);
	// pnlMain.setBackground(c);
	// }
	// if(e.getSource()==btnClick2){
	// JOptionPane.showMessageDialog(this, "HAHA");
	// }
	// }

	public class MyClickHandler extends WindowAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnClick) // ��ȡ�¼�Դ
			{
				Color c = JColorChooser.showDialog(DialogFrame.this, "ѡ����ɫ", Color.BLACK);
				pnlMain.setBackground(c);
			}
			if (e.getSource() == btnClick2) {
				JOptionPane.showMessageDialog(DialogFrame.this, "HAHA");
			}
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
