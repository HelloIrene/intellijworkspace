import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JLabel jLabel;
    private JTextField jTextFieldWorkNo;
    private JTextField jTextFieldName;
    private JTextField jTextFieldDate;
    private JTextField jTextFieldSal;
    private JTextField jTextFieldWork;
    private JTextField jTextFieldComm;
    private JComboBox jComboBoxDepart;

    private JButton jButtonSearch;
    private JButton jButtonUpdate;
    private JButton jButtonDelete;
    private JButton jButtonExit;

    public MainFrame() {
        this.setLayout(null);
        iniFrame();
        iniLable();
        iniJTextField();
        iniButton();
    }

    private void iniButton(){
        jButtonSearch = new JButton("����");
        jButtonSearch.setBounds(285,24,90,28);
        this.add(jButtonSearch);
        jButtonUpdate = new JButton("����");
        jButtonUpdate.setBounds(107,195,90,28);
        this.add(jButtonUpdate);
        jButtonDelete =new JButton("ɾ��");
        jButtonDelete.setBounds(202,195,90,28);
        this.add(jButtonDelete);
        jButtonExit = new JButton("�˳�");
        jButtonExit.setBounds(297,195,90,28);
        this.add(jButtonExit);
    }

    private void iniLable(){
        jLabel = new JLabel("���ţ�");
        jLabel.setFont(new Font("����", Font.PLAIN, 19));
        jLabel.setBounds(10,5,70,60);
        this.add(jLabel);
        jLabel = new JLabel("����");
        jLabel.setFont(new Font("����", Font.PLAIN, 18));
        jLabel.setBounds(44,50,50,50);
        this.add(jLabel);
        jLabel = new JLabel("ְλ");
        jLabel.setFont(new Font("����", Font.PLAIN, 18));
        jLabel.setBounds(234,50,50,50);
        this.add(jLabel);
        jLabel = new JLabel("��ְʱ��");
        jLabel.setFont(new Font("����", Font.PLAIN, 18));
        jLabel.setBounds(7,95,80,50);
        this.add(jLabel);
        jLabel = new JLabel("��������");
        jLabel.setFont(new Font("����", Font.PLAIN, 18));
        jLabel.setBounds(197,95,80,50);
        this.add(jLabel);
        jLabel = new JLabel("���");
        jLabel.setFont(new Font("����", Font.PLAIN, 18));
        jLabel.setBounds(44,140,50,50);
        this.add(jLabel);
        jLabel = new JLabel("����");
        jLabel.setFont(new Font("����", Font.PLAIN, 18));
        jLabel.setBounds(234,140,50,50);
        this.add(jLabel);
    }

    private void iniJTextField(){
        jTextFieldWorkNo=new JTextField("����");
        jTextFieldWorkNo.setBounds(60,25,200,23);
        this.add(jTextFieldWorkNo);
        jTextFieldName=new JTextField("����");
        jTextFieldName.setBounds(85,66,110,20);
        this.add(jTextFieldName);
        jTextFieldWork=new JTextField("ְλ");
        jTextFieldWork.setBounds(275,66,110,20);
        this.add(jTextFieldWork);
        jTextFieldDate=new JTextField("��ְʱ��");
        jTextFieldDate.setBounds(85,112,110,20);
        jTextFieldDate.setEditable(false);
        this.add(jTextFieldDate);
        jTextFieldSal=new JTextField("��������");
        jTextFieldSal.setBounds(275,112,110,20);
        this.add(jTextFieldSal);
        jTextFieldComm=new JTextField("���");
        jTextFieldComm.setBounds(85,157,110,20);
        this.add(jTextFieldComm);
        jComboBoxDepart=new JComboBox();
        jComboBoxDepart.setBounds(275,157,110,20);
        this.add(jComboBoxDepart);
    }

    private void iniFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("img/acfun_52.png");
        this.setTitle("Emp Test");
        this.setIconImage(img);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        this.setSize(405, 270);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
