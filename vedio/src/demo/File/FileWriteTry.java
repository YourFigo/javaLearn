package demo.File;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTry {
    public static void main(String[] args) {

        /*FileWriter fw = null;
        try {
            fw = new FileWriter("ioDir\\fw.txt");
            fw.write("写入");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        try(FileWriter fw = new FileWriter("ioDir\\fw.txt");) {
            fw.write("写入");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
