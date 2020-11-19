package chc.test.javase.构造函数;

import org.junit.Test;

public class 构造函数 {
    @Test
    public void test() {
        A a = new A();
    }

    @Test
    public void testC() {
        C c1 = new C();
        C c2 = new C();
        //结果,静态代码块只会调用一次，类的所有对象共享该代码块
        //一般用于类的全局信息初始化
        //静态代码块调用
        //代码块调用
        //构造方法调用
        //代码块调用
        //构造方法调用
    }
}
