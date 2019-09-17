package demo.api;

import java.util.Scanner;

public class ApiTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = new Scanner(System.in).next();
        System.out.println(num + " " + str);
    }

}
