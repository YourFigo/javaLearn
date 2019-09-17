package demo.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map  = new HashMap<>();
        map.put("李晨","范冰冰");
        map.put("小明","小红");
        map.put("来来来","哈哈哈");
        for (String key : map.keySet()){
            System.out.println(key + "=" + map.get(key));
        }

        Set<String> set = map.keySet();

        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        LinkedHashMap<String,String> linked = new LinkedHashMap<>();


    }
}
