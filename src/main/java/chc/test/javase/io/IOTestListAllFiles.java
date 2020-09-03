package chc.test.javase.io;

import java.io.File;

public class IOTestListAllFiles {

    public static void main(String[] args) {
        File file = new File("/");
        listAllFiles(file);

    }

    public static void listAllFiles(File dir){
        if(dir == null || !dir.exists()){
            return;
        }
        if(dir.isFile()){
            System.out.println(dir.getName());
            return;
        }
        File[] files = dir.listFiles();
        if(files == null){
            System.out.println("发现空指针 null" + dir.getName());
            return;
        }
        for(File file : files){
            listAllFiles(file);
        }
    }
}
