package chc.test.javase.构造函数;

import chc.test.javase.构造函数.WithInner.Inner;

public class InheritInner extends Inner {
    InheritInner(WithInner wi) {
        wi.super();
        System.out.println("this is a constructor in InheritInner");
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
