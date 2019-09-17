package demo.api;

public class StringTest {
    public static void main(String[] args) {
        //String的三种构造函数，底层是通过byte[]方式实现的
        // 空内容的字符串
        String str1 = new String();
        System.out.println("第一个 " + str1);

        char[] charArray = {'a', 'b', 'c'};
        String str2 = new String(charArray);
        System.out.println("第二个 " + str2);

        byte[] byteArray = {97, 98, 99};
        String str3 = new String(byteArray);
        System.out.println("第三个 " + str3);
        //直接创建
        String str4 = "hello";
        System.out.println(str4);

        //字符串常量池：直接双引号创建的字符串就在字符串常量池中
        str1 = "abc";
        str2 = "abc";
        char[] charArray1 = {'a', 'b', 'c'};
        str3 = new String(charArray1);
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);

        System.out.println(str1.equals(str3));
        System.out.println("ABc".equalsIgnoreCase("abc"));

        String str5 = "aaa,bbb,ccc";
        String[] array = str5.split(",");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        int[] num = {1, 2, 3};
        String string = function(num);
        System.out.println(string);

    }

    public static String function(int[] num) {
        String strTotal = "";
        for (int i = 0; i < num.length; i++) {
            String str = "";
            if (i == 0) {
                str = "[word".concat(num[i] + "#");
            } else if (i == num.length - 1) {
                str = "word".concat(num[i] + "]");
            } else {
                str = "word".concat(num[i] + "#");
            }
            strTotal = strTotal + str;
        }
        return strTotal;
    }
}
