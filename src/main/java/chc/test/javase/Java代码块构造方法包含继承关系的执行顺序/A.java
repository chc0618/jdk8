package chc.test.javase.Java代码块构造方法包含继承关系的执行顺序;


public class A {
    static {
        System.out.println("HIDETAG" + "A静态代码块");
    }

    private static C c = new C("A静态成员");
    private  C c1 = new C("A成员");

    {
        System.out.println("HIDETAG" + "A代码块");
    }

    static {
        System.out.println("HIDETAG" + "A静态代码块2");
    }

    public A() {
        System.out.println("HIDETAG" + "A构造方法");
    }

}
