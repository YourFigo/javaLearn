package demo.File;


import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileWriter fw = new FileWriter("ioDir\\fw.txt");
        // 字符串转换为字节数组
        char[] chars = "java".toCharArray();

        // 写出字符数组
        fw.write(chars); // 黑马程序员

        // 写出从索引2开始，2个字节。索引2是'程'，两个字节，也就是'程序'。
        fw.write(chars,2,2); // 程序
        fw.flush();
        // 关闭资源
        fw.close();
    }
}