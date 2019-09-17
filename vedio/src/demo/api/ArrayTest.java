package demo.api;

import java.util.Arrays;

// java.util.Arrays 里面提供了大量的静态方法。用来实现数组的相关操作，是一个与数组相关的工具类
public class ArrayTest {
    public static void main(String[] args) {

        int[] intArray = {10,20,30};
        String intStr = Arrays.toString(intArray);
        System.out.println(intStr);
        int[] array1 = {1,6,3,2,5};
        Arrays.sort(array1);
        System.out.println(array1);
    }

}

class s extends Student{

}
