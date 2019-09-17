package demo.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"www",".baidu",".com"," good");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        ArrayList<Person> p_list = new ArrayList<>();
        Person p4 = new Person("小刚",8);
        Person p2 = new Person("小红",18);
        Person p3 = new Person("小红",19);
        Person p1 = new Person("小红",18);

        Collections.addAll(p_list,p1,p2,p3,p4);
        System.out.println(p_list);
        Collections.sort(p_list);
        System.out.println(p_list);

        ArrayList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1,4,2,5,1);
        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //return o1-o2; //升序
                return o2-o1; //降序
            }
        });
        System.out.println(list1);

    }
}
