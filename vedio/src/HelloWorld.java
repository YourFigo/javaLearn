import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        myPrint(5);
        myPrint(6.0f);
        myPrint(566);

        int[] arrayA = new int[] {4,5,6};
        int [] arrayB = {5,6,7  };
        System.out.println(arrayA.length);
        System.out.println(arrayA);
        String[] arrayS = {"xxx","yyy"};
        System.out.println(arrayS);

        for (int i = 0; i < arrayB.length; i++) {
            System.out.println(arrayB[i]);
        }
    }

    public static void myPrint(int num){
        System.out.println(num);
    }
    public static void myPrint(byte num){
        System.out.println("byte" + num);
    }
    public static void myPrint(short num){
        System.out.println(num);
    }
    public static void myPrint(long num){
        System.out.println(num);
    }
    public static void myPrint(float num){
        System.out.println(num);
    }


}
