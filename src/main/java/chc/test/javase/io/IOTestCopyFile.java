package chc.test.javase.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTestCopyFile {
    public static void main(String[] args) throws IOException {
        String src = "/Users/tiplet/vars/spring_boot_resource/jdk8/src/main/java/chc/test/javase/io/copyFiletess";
        String desc = "/Users/tiplet/vars/spring_boot_resource/jdk8/src/main/java/chc/test/javase/io/copyFiletess1";
        copyFile(src, desc);
    }
    public static void copyFile(String src , String desc) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);

        byte[] buffer = new byte[20 * 1024];
        int cnt;

        // read() 最多读取 buffer.length 个字节
        // 返回的是实际读取的个数
        // 返回 -1 的时候表示读到 eof，即文件尾
        while((cnt = fis.read(buffer, 0, buffer.length)) != -1 ){
            fos.write(buffer, 0 , cnt);
        }
        fis.close();
        fos.close();
    }
}
