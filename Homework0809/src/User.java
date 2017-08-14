import java.io.Serializable;

/**
 * 用户类
 *
 * @author student Ross
 */
/*
3、编写一个模拟登录的程序
需求：先编写一个用户实体类：User，拥有userId、userName、password三个属性
当用户从控制台上输入正确的用户名和密码后，把正确的用户对象保存到一个dat文件中，并且记录最后登录的用户名和登录时间到properties中
再次运行该程序，首先应该在控制台上打印：上次登录的用户名和登录时间。
 */
public class User implements Serializable {
    private static final long serialVersionUID = 263150099675373622L;
    public int userId;
    public String userName;
    public String password;

    public User() {
        this(0, "", "");
    }

    public User(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
