package chc.test.javase.Java代码块构造方法包含继承关系的执行顺序;

public class B extends A {

    private static C c1 = new C("B静态成员");

    {
        System.out.println("HIDETAG" + "B代码块");
    }

    private C c = new C("B成员");

    static {
        System.out.println("HIDETAG" + "B静态代码块2");
    }

    static {
        System.out.println("HIDETAG" + "B静态代码块");
    }

    public B() {
        System.out.println("HIDETAG" + "B构造方法");

    }

}
