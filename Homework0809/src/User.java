import java.io.Serializable;

/**
 * �û���
 *
 * @author student Ross
 */
/*
3����дһ��ģ���¼�ĳ���
�����ȱ�дһ���û�ʵ���ࣺUser��ӵ��userId��userName��password��������
���û��ӿ���̨��������ȷ���û���������󣬰���ȷ���û����󱣴浽һ��dat�ļ��У����Ҽ�¼����¼���û����͵�¼ʱ�䵽properties��
�ٴ����иó�������Ӧ���ڿ���̨�ϴ�ӡ���ϴε�¼���û����͵�¼ʱ�䡣
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
