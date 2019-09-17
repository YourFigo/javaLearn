package demo.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll);
        coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        coll.add("赵六");
        coll.add("田七");
        System.out.println(coll);
        coll.remove("赵六");
        System.out.println(coll);
        boolean b1 = coll.contains("李四");
        System.out.println("b1:" + b1);
        boolean b2 = coll.isEmpty();
        System.out.println("b2:" + b2);
        int size = coll.size();
        System.out.println("size:" + size);
        //把集合中的元素存储到数组中
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        coll.clear();
        System.out.println(coll);

        coll.add("张三");
        coll.add("李四");
        coll.add("王五");
        coll.add("赵六");
        coll.add("田七");
        Iterator<String> it = coll.iterator();
        boolean b = it.hasNext();
        System.out.println(b);
        String s = it.next();
        System.out.println(s);
        while (it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }
    }
}
