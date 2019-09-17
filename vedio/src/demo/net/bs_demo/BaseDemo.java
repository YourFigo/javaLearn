package demo.net.bs_demo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BaseDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        Socket socket = server.accept();
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = in.read(bytes);
        System.out.println(new String(bytes,0,len));
        socket.close();
        server.close();
    }
}
