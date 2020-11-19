package chc.test.javase.构造函数;

public class WithInner {
    class Inner {
        Inner(){
            System.out.println("this is a constructor in WithInner.Inner" );
        }
    }
}
