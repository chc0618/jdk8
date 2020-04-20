package chc.test.jol;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class A {
    boolean flag = false;
    @Test
    public void test(){
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
    }
    public static void main(String[] args) {

        // 当前jvm的信息
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
    }

}
