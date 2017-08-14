import java.util.Scanner;

/**
 * 测试类
 *
 * @author student Ross
 */

/*
3、编写一个模拟登录的程序
需求：先编写一个用户实体类：User，拥有userId、userName、password三个属性
当用户从控制台上输入正确的用户名和密码后，把正确的用户对象保存到一个dat文件中，并且记录最后登录的用户名和登录时间到properties中
再次运行该程序，首先应该在控制台上打印：上次登录的用户名和登录时间。
 */

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        //ArrayList<User> users = test.addUser();
        Console console = new Console();
        console.getLoginInf();
        User user = test.addUser();
        System.out.println("请输入用户名");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.println("请输入密码");
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
