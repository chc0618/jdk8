package chc.test.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class Atest2 {

    // http://openjdk.java.net/projects/code-tools/jol/
    // https://hg.openjdk.java.net/code-tools/jol/file/56dbba3b2c20/jol-samples/src/main/java/org/openjdk/jol/samples/JOLSample_01_Basic.java
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        A a = new A();
        System.out.println("before lock");
        // 当前jvm的信息
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        synchronized (a){
            System.out.println("locking");
        }
        System.out.println("after lock");
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

    }

}
