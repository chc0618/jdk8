package chc.test.javase.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test {

    public void test() throws IOException {
        long startTime = System.currentTimeMillis();
        // 读入流
        FileInputStream fis = new FileInputStream("企业微信20200318024141.png");
        // 写入流
        FileOutputStream fos = new FileOutputStream("1.png");
        // 创建通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        // 分配指定大小缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(inChannel.read(byteBuffer) != -1){
            //开启读取模式
            byteBuffer.flip();
            // 将数据写入到通道中
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        inChannel.close();
        outChannel.close();
        fis.close();
        fos.close();
    }

    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.test();
    }
}
