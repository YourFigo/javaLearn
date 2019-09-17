package demo.File;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileInputStream fis = new FileInputStream("ioDir\\fis.txt");
        // 定义变量，保存数据
        int len;
        byte[] bytes = new byte[1024];
        // 循环读取
        while ((len = fis.read(bytes))!=-1) {
            System.out.println(new String(bytes));
        }
        // 关闭资源
        fis.close();
    }
}
