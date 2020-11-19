package chc.test.javase.exception;

/**
 * 不要在fianlly中使用return。
 * 不要在finally中抛出异常。
 * 减轻finally的任务，不要在finally中做一些其它的事情，finally块仅仅用来释放资源是最合适的。
 * 将尽量将所有的return写在函数的最后面，而不是try … catch … finally中。
 */
public class Finally异常覆盖trycatch {
    public static void main(String[] args)
    {
        int result;
        try{
            result = foo();
        } catch (Exception e){
            System.out.println(e.getMessage());    //输出：我是finaly中的Exception
        }

        try{
            result  = bar();
        } catch (Exception e){
            System.out.println(e.getMessage());    //输出：我是finaly中的Exception
        }
    }

    //catch中的异常被抑制
    @SuppressWarnings("finally")
    public static int foo() throws Exception
    {
        try {
            int a = 5/0;
            return 1;
        }catch(ArithmeticException amExp) {
            throw new Exception("我将被忽略，因为下面的finally中抛出了新的异常");
        }finally {
            throw new Exception("我是finaly中的Exception");
        }
    }

    //try中的异常被抑制
    @SuppressWarnings("finally")
    public static int bar() throws Exception
    {
        try {
            int a = 5/0;
            return 1;
        }finally {
            throw new Exception("我是finaly中的Exception");
        }

    }
}
