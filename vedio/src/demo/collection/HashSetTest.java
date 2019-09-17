package demo.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        for (int i : set){
            System.out.println(i);
        }
        System.out.println("--------------------");
        System.out.println(set.hashCode());
        String s = "aaa";
        System.out.println(s.hashCode());
        String s2 = "哈哈哈";
        String s3 = "哈哈哈";
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println("----------------");

        HashSet<Person> pSet = new HashSet<>();
        Person p1 = new Person("小红",18);
        System.out.println(p1);
        Person p2 = new Person("小红",18);
        Person p3 = new Person("小红",19);
        pSet.add(p1);
        pSet.add(p2);
        pSet.add(p3);
        System.out.println(pSet);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

    }
}
