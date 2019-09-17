package demo.collection;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.push("www");
        System.out.println(list);
/*        for(String s : list){
            System.out.println(s);
        }*/
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(1));
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        list.pop();
        System.out.println(list);
        list.add("hhh");
        list.add("yyy");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
