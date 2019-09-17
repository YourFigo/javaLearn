package demo.File;

import java.io.*;

public class BufferedIO {
    public static void main(String[] args) throws FileNotFoundException {
        bufferedIO();
        bufferedIOByArray();
        FileIO();
    }

    public static void FileIO() throws FileNotFoundException {
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 创建流对象
        try (
                FileInputStream fis = new FileInputStream("ioDir/wps.exe");
                FileOutputStream fos = new FileOutputStream("ioDir/copy.exe.io")
        ) {
            // 读写数据
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("普通流复制时间:" + (end - start) + " 毫秒");
    }

    public static void bufferedIO() throws FileNotFoundException {
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 创建流对象
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("ioDir/wps.exe"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("ioDir/copy.exe.buff"));
        ) {
            // 读写数据
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流复制时间:" + (end - start) + " 毫秒");
    }

    public static void bufferedIOByArray() throws FileNotFoundException {
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 创建流对象
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("ioDir/wps.exe"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("ioDir/copy.exe.buffArray"));
        ) {
            // 读写数据
            int len;
            byte[] bytes = new byte[8 * 1024];
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流使用数组复制时间:" + (end - start) + " 毫秒");
    }
}
