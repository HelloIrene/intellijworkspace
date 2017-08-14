import java.io.*;
import java.sql.Timestamp;
import java.util.Properties;

/**
 * Console 类
 *
 * @author student Ross
 */

/*
3、编写一个模拟登录的程序
需求：先编写一个用户实体类：User，拥有userId、userName、password三个属性
当用户从控制台上输入正确的用户名和密码后，把正确的用户对象保存到一个dat文件中，
并且记录最后登录的用户名和登录时间到properties中
再次运行该程序，首先应该在控制台上打印：上次登录的用户名和登录时间。
 */

public class Console {

//    public void login(String name, String password, ArrayList<User> users) {
//        Iterator<User> iterator = users.iterator();
//        while (iterator.hasNext()) {
//            User temp= iterator.next();
//            if (temp.getUserName() == name && temp.getPassword() == password){
//                //跳转到记录方法
//                this.rememberUser(temp);
//            }
//        }
//        return ;
//    }

    public String login(String name, String password, User user) {
        if (name.equals(user.getUserName()) && password.equals(user.getPassword())) {
            return this.rememberUser(user);
        }
        return "密码错误";
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
        return "记录失败";
    }

    public String rememberProperties(User user) {
        Properties properties = new Properties();
        properties.setProperty("userName", user.getUserName());
        properties.setProperty("loginTime", "" + System.currentTimeMillis());
        try {
            FileWriter fw = new FileWriter("src/user.properties");
            properties.store(fw, "User Info");
            fw.close();
            return "记录成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "记录失败";
    }

    public void getLoginInf() {
        Properties properties = new Properties();
        File file = new File("src/user.properties");
        if (file.exists()) {
            try {
                properties.load(new FileReader(file));
                System.out.println("上次登录用户名：" + properties.getProperty("userName"));
                String ltr = properties.getProperty("loginTime");
                long time = Long.parseLong(ltr);
                System.out.println("上次登录时间" + new Timestamp(time));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
