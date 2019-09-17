package demo.File;

import java.io.File;
import java.io.FileFilter;

public class PrintDir {

    public static void main(String[] args) {
        // 创建File对象
        File dir = new File("ioDir");
        // 调用打印目录方法
        printDir(dir);
        System.out.println("---------------------------");
        printDir2(dir);
        System.out.println("---------------------------");
        printDirLambda(dir);
    }

    public static void printDir(File dir) {
        // 获取子文件和目录
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
            // 是文件,输出文件绝对路径
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
                // 是目录,输出目录绝对路径
                System.out.println("目录:" + file.getAbsolutePath());
                // 继续遍历,调用printDir,形成递归
                printDir(file);
            }
        }
    }

    public static void printDir2(File dir) {
        // 匿名内部类方式,创建过滤器子类对象
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".log")||pathname.isDirectory();
            }
        });
        // 循环打印
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
                printDir2(file);
            }
        }
    }

    public static void printDirLambda(File dir) {
        // 匿名内部类方式,创建过滤器子类对象
        File[] files = dir.listFiles(pathname->{
            return pathname.getName().endsWith(".log")||pathname.isDirectory();
        });
        //File[] files = dir.listFiles(pathname->pathname.getName().endsWith(".log")||pathname.isDirectory());
        // 循环打印
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
                printDir2(file);
            }
        }
    }
}