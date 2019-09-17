package demo.api;

import com.sun.jdi.ArrayReference;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

// ArrayList有一个尖括号<>代表泛型，尖括号里是什么类型，就只能添加什么类型
// 泛型：也就是装在集合当中的所有元素，全都是统一的什么类型
// 泛型智能是引用类型，不能是基本类型
// ArrayList直接打印不是地址值，而是内容，因为经过toString()处理了
public class ArrayListTest {
    public static void main(String[] args) {
        /*
         * add(E e) 向集合中添加元素，参数类型和泛型一致
         * get(int index) 根据索引获得元素,索引从0开始
         * remove(int index) 删除并返回被删除的元素
         * size() 集合中元素的个数
         * */
//        ArrayList<String> list = new ArrayList<>();
//        System.out.println(list);
//        list.add("赵丽颖");
//        list.add("古力娜扎");
//        list.add("马尔扎哈");
//        System.out.println(list);
//        int num = list.size();
//        System.out.println(num);
//        System.out.println(list.get(2));
//        System.out.println(list.remove(1));
//        System.out.println(list.get(1));
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        //基本类型如果要使用ArrayList，要使用相应的包装类
        /*
         * byte Byte
         * short Short
         * int Integer
         * long Long
         * float Float
         * double Double
         * char Character
         * boolean Boolean
         * */
        //从JDK1.5开始，支持自动装箱（基本类型-->包装类），拆箱
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int num = random.nextInt(33) + 1;
            list.add(num);
        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


        ArrayList<Student> list1 = new ArrayList<>();
        Student one = new Student("张三", 23);
        Student two = new Student("李四", 34);
        Student three = new Student("王麻子", 4);
        Student four = new Student("赵六", 67);
        list1.add(one);
        list1.add(two);
        list1.add(three);
        list1.add(four);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
            System.out.println(list1.get(i).name + " " + list1.get(i).age);
        }

        printArrayList(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int num = random.nextInt(100);
            list2.add(num);
        }
        System.out.println(list2);
        System.out.println(function1(list2));
    }

    public static void printArrayList(ArrayList<Integer> list) {
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (i == list.size() - 1) {
                System.out.println(num + "}");
            } else {
                System.out.print(num + "@");
            }
        }
    }

    public static ArrayList<Integer> function1(ArrayList<Integer> list){
        ArrayList<Integer> listNew = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0){
                listNew.add(list.get(i));
            }
        }
        return listNew;
    }
}
