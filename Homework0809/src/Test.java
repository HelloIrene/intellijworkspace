import java.util.Scanner;

/**
 * ������
 *
 * @author student Ross
 */

/*
3����дһ��ģ���¼�ĳ���
�����ȱ�дһ���û�ʵ���ࣺUser��ӵ��userId��userName��password��������
���û��ӿ���̨��������ȷ���û���������󣬰���ȷ���û����󱣴浽һ��dat�ļ��У����Ҽ�¼����¼���û����͵�¼ʱ�䵽properties��
�ٴ����иó�������Ӧ���ڿ���̨�ϴ�ӡ���ϴε�¼���û����͵�¼ʱ�䡣
 */

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        //ArrayList<User> users = test.addUser();
        Console console = new Console();
        console.getLoginInf();
        User user = test.addUser();
        System.out.println("�������û���");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.println("����������");
        String pass = scanner.nextLine();
        scanner.close();
        System.out.println(console.login(userName, pass, user));
    }

//    public ArrayList<User> addUser() {
//        ArrayList<User> userArrayList = new ArrayList<>();
//        User userOne = new User(1, "aa", "123456");
//        User userTwo = new User(2, "bb", "456789");
//        User userThree = new User(3, "cc", "789123");
//        userArrayList.add(userOne);
//        userArrayList.add(userTwo);
//        userArrayList.add(userThree);
//        return userArrayList;
//    }

    public User addUser() {
        User user = new User(1, "aa", "123456");
        return user;
    }
}
