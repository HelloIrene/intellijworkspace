package frame;

import empDAO.EmpDAO;
import emps.T_User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

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

    private void iniButton() {
        EmpDAO empDAO = new EmpDAO();
        HashMap<String, Integer> departmentName = empDAO.getDepart();
        jButtonSearch = new JButton("搜索");
        jButtonSearch.setBounds(285, 24, 90, 28);
        jButtonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                T_User temp = empDAO.findEmp(jTextFieldWorkNo.getText());
                jTextFieldName.setText(temp.getEmpName());
                jTextFieldWork.setText(temp.getEmpJob());
                jTextFieldDate.setText(String.valueOf(temp.getEmpDate()));
                jTextFieldSal.setText(String.valueOf(temp.getEmpSal()));
                jTextFieldComm.setText(String.valueOf(temp.getEmpComm()));
                for (String getKey : departmentName.keySet()) {
                    if (departmentName.get(getKey).equals(temp.empDepart)) {
                        jComboBoxDepart.setSelectedItem(getKey);
                    }
                }
            }
        });
        this.add(jButtonSearch);
        jButtonUpdate = new JButton("更新");
        jButtonUpdate.setBounds(107, 195, 90, 28);
        jButtonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                T_User temp = new T_User();
                temp.setEmpNo(Integer.parseInt(jTextFieldWorkNo.getText()));
                temp.setEmpName(jTextFieldName.getText());
                temp.setEmpJob(jTextFieldWork.getText());
                temp.setEmpSal(Double.parseDouble(jTextFieldSal.getText()));
                temp.setEmpComm(Double.parseDouble(jTextFieldComm.getText()));
                temp.setEmpDepart(departmentName.get(jComboBoxDepart.getSelectedItem()));
                int back = empDAO.update(temp);
                if (back != 0) {
                    JOptionPane.showMessageDialog(MainFrame.this, "update success!", "Test", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "update failed!", "Test", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.add(jButtonUpdate);
        jButtonDelete = new JButton("删除");
        jButtonDelete.setBounds(202, 195, 90, 28);
        jButtonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int back = empDAO.delete(Integer.parseInt(jTextFieldWorkNo.getText()));
                if (back != 0) {
                    JOptionPane.showMessageDialog(MainFrame.this, "delete success!", "Test", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this, "delete failed!", "Test", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        this.add(jButtonDelete);
        jButtonExit = new JButton("退出");
        jButtonExit.setBounds(297, 195, 90, 28);
        jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(jButtonExit);
    }

    private void iniLable() {
        jLabel = new JLabel("工号：");
        jLabel.setFont(new Font("宋体", Font.PLAIN, 19));
        jLabel.setBounds(10, 5, 70, 60);
        this.add(jLabel);
        jLabel = new JLabel("姓名");
        jLabel.setFont(new Font("宋体", Font.PLAIN, 18));
        jLabel.setBounds(44, 50, 50, 50);
        this.add(jLabel);
        jLabel = new JLabel("职位");
        jLabel.setFont(new Font("宋体", Font.PLAIN, 18));
        jLabel.setBounds(234, 50, 50, 50);
        this.add(jLabel);
        jLabel = new JLabel("入职时间");
        jLabel.setFont(new Font("宋体", Font.PLAIN, 18));
        jLabel.setBounds(7, 95, 80, 50);
        this.add(jLabel);
        jLabel = new JLabel("基本工资");
        jLabel.setFont(new Font("宋体", Font.PLAIN, 18));
        jLabel.setBounds(197, 95, 80, 50);
        this.add(jLabel);
        jLabel = new JLabel("提成");
        jLabel.setFont(new Font("宋体", Font.PLAIN, 18));
        jLabel.setBounds(44, 140, 50, 50);
        this.add(jLabel);
        jLabel = new JLabel("部门");
        jLabel.setFont(new Font("宋体", Font.PLAIN, 18));
        jLabel.setBounds(234, 140, 50, 50);
        this.add(jLabel);
    }

    private void iniJTextField() {
        EmpDAO tempDAO = new EmpDAO();
        HashMap<String, Integer> departmentName = tempDAO.getDepart();
        jTextFieldWorkNo = new JTextField("工号");
        jTextFieldWorkNo.setBounds(60, 25, 200, 23);
        this.add(jTextFieldWorkNo);
        jTextFieldName = new JTextField("姓名");
        jTextFieldName.setBounds(85, 66, 110, 20);
        this.add(jTextFieldName);
        jTextFieldWork = new JTextField("职位");
        jTextFieldWork.setBounds(275, 66, 110, 20);
        this.add(jTextFieldWork);
        jTextFieldDate = new JTextField("入职时间");
        jTextFieldDate.setBounds(85, 112, 110, 20);
        jTextFieldDate.setEditable(false);
        this.add(jTextFieldDate);
        jTextFieldSal = new JTextField("基本工资");
        jTextFieldSal.setBounds(275, 112, 110, 20);
        this.add(jTextFieldSal);
        jTextFieldComm = new JTextField("提成");
        jTextFieldComm.setBounds(85, 157, 110, 20);
        this.add(jTextFieldComm);
        jComboBoxDepart = new JComboBox();
        jComboBoxDepart.setBounds(275, 157, 110, 20);
        Iterator iterator = departmentName.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry strMap = (HashMap.Entry) iterator.next();
            jComboBoxDepart.addItem(strMap.getKey());
        }
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
