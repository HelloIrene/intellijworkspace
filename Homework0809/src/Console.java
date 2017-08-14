import java.io.*;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Console ��
 *
 * @author student Ross
 */

/*
3����дһ��ģ���¼�ĳ���
�����ȱ�дһ���û�ʵ���ࣺUser��ӵ��userId��userName��password��������
���û��ӿ���̨��������ȷ���û���������󣬰���ȷ���û����󱣴浽һ��dat�ļ��У�
���Ҽ�¼����¼���û����͵�¼ʱ�䵽properties��
�ٴ����иó�������Ӧ���ڿ���̨�ϴ�ӡ���ϴε�¼���û����͵�¼ʱ�䡣
 */

public class Console {

//    public void login(String name, String password, ArrayList<User> users) {
//        Iterator<User> iterator = users.iterator();
//        while (iterator.hasNext()) {
//            User temp= iterator.next();
//            if (temp.getUserName() == name && temp.getPassword() == password){
//                //��ת����¼����
//                this.rememberUser(temp);
//            }
//        }
//        return ;
//    }

    public String login(String name, String password, User user) {
        if (name.equals(user.getUserName()) && password.equals(user.getPassword())) {
            return this.rememberUser(user);
        }
        return "�������";
    }

    public String rememberUser(User user) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/temp.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
            objectOutputStream.close();
            return this.rememberProperties(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "��¼ʧ��";
    }

    public String rememberProperties(User user) {
        Properties properties = new Properties();
        properties.setProperty("userName", user.getUserName());
        properties.setProperty("loginTime", "" + System.currentTimeMillis());
        try {
            FileWriter fw = new FileWriter("src/user.properties");
            properties.store(fw, "User Info");
            fw.close();
            return "��¼�ɹ�";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "��¼ʧ��";
    }

    public void getLoginInf() {
        Properties properties = new Properties();
        File file = new File("src/user.properties");
        if (file.exists()) {
            try {
                properties.load(new FileReader(file));
                System.out.println("�ϴε�¼�û�����" + properties.getProperty("userName"));
                String ltr = properties.getProperty("loginTime");
                long time = Long.parseLong(ltr);
                System.out.println("�ϴε�¼ʱ��" + new Timestamp(time));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
