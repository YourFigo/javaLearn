package demo.annotation;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class PersonTest {

    @Test
    public void testPersonRange() throws Exception {
        /**
         * 测试 isAnnotationPresent()和getAnnotation()
         */
        Field name = Person.class.getField("name");
        Field age = Person.class.getField("age");
        Field address = Person.class.getField("address");
        /**判断某个注解是否存在于Class、Field、Method或Constructor
         * Field.isAnnotationPresent(Class)
         * 这里判断 Range 注解是否存在于 Field 中*/
        Assert.assertEquals(true,name.isAnnotationPresent(Range.class));
        Assert.assertEquals(false,age.isAnnotationPresent(Range.class));
        Assert.assertEquals(true,address.isAnnotationPresent(Range.class));

        /**通过Class、Field、Method或Constructor来获取修饰它的注解
         * Field.getAnnotation(Class)
         *这里我们获取修饰 Field 的注解 Range */
        Range rangeName = name.getAnnotation(Range.class);
        System.out.println(rangeName);
        Assert.assertEquals(3,rangeName.min());
        Assert.assertEquals(10,rangeName.max());
        Range rangeAddress = address.getAnnotation(Range.class);
        System.out.println(rangeAddress);
        Assert.assertEquals(5,rangeAddress.min());
        Assert.assertEquals(20,rangeAddress.max());
        Range rangeAge = age.getAnnotation(Range.class);
        Assert.assertEquals(null,rangeAge);
    }

    /**这里，我们编写一个Person实例的检查方法，它可以检查Person实例的String字段长度是否满足@Range的定义*/
    public ArrayList<String> check(Person person) throws Exception{
        ArrayList<String> fieldList = new ArrayList<>();
        // 遍历所有Field
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@Range
            Range range = field.getAnnotation(Range.class);
            // 如果@Range存在
            if (range != null){
                // 获取Field的值
                Object fieldValue = field.get(person);
                // 如果Field的值是String，因为我们只对Person类中String类型的字段修饰了range注解
                if (fieldValue instanceof String){
                    //将Object强转为String
                    String value = (String)fieldValue;
                    //不符合Range注解的判断条件
                    if (value.length() < range.min() || value.length() > range.max()){
                        System.out.println("Illegal field: " + field.getName());
                        fieldList.add(field.getName());
                    }
                }
            }
            //如果@Range不存在，那么该Field没有注解
            else{
                System.out.println("field do not have Annotation: : " + field.getName());
            }
        }
        System.out.println(fieldList);
        return fieldList;
    }

    @Test
    public void testCheck() throws Exception {
        Person person = new Person();
        person.name = "tom";
        person.age = 23;
        person.address = "china beijing beijing";
        ArrayList actualList = check(person);
        //我们期望得到的结果是["address"]
        ArrayList expectedList = new ArrayList();
        expectedList.add("address");
        //断言通过，说明我们的测试通过
        Assert.assertEquals(expectedList,actualList);
    }

}
