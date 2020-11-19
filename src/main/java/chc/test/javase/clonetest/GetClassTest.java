package chc.test.javase.clonetest;


public class GetClassTest {

    public static void main(String[] args) {
        User user = new User();
        Class<?> aClass = user.getClass();
        Class<User> bClass = User.class;
        Class<?> cClass1 = null;
        try {
             cClass1 = Class.forName("chc.test.javase.clonetest.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass);
        System.out.println(bClass);
        System.out.println(cClass1);


        try {
            User a = (User) aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
