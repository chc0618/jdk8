package chc.test.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class Atest {
    static A a = new A();

    // http://openjdk.java.net/projects/code-tools/jol/
    // https://hg.openjdk.java.net/code-tools/jol/file/56dbba3b2c20/jol-samples/src/main/java/org/openjdk/jol/samples/JOLSample_01_Basic.java
    public static void main(String[] args) {

        // 当前jvm的信息
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

}
