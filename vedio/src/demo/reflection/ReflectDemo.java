package demo.reflection;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {

    @Test
    public void testClass() throws ClassNotFoundException {
        Class cls1 = Class.forName("demo.reflection.Student");
        Class cls2 = Student.class;
        Student s = new Student();
        Class cls3 = s.getClass();
        System.out.println(cls1);
        System.out.println(cls1.getName());
        Assert.assertEquals(true,cls1 == cls2);
        Assert.assertEquals(true,cls1 == cls3);
    }

    @Test
    public void testField() throws NoSuchFieldException, IllegalAccessException {
        Class cls = Student.class;
        Field[] fields = cls.getFields();
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("---------------------------------");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("---------------------------------");
        Field name = cls.getField("name");
        System.out.println(name);
        Student student = new Student();
        Object nameValue = name.get(student);
        System.out.println(nameValue);
        name.set(student,"zhangsan");
        Object nameValue2 = name.get(student);
        System.out.println(nameValue2);
        System.out.println("---------------------------------");
        Field age = cls.getDeclaredField("age");
        System.out.println(age);
    }

    @Test
    public void testConstructor() throws Exception {
        Class cls = Student.class;
        Constructor[] cons = cls.getConstructors();
        Constructor noParaCon = cls.getConstructor();
        Constructor havaParaCon = cls.getConstructor(String.class,String.class,int.class,String.class);
        for (Constructor con : cons) {
            System.out.println(con);
        }
        System.out.println("------------------------------");
        System.out.println(noParaCon);
        System.out.println("------------------------------");
        System.out.println(havaParaCon);
        System.out.println("------------------------------");
        Object student = havaParaCon.newInstance("tom","s0001",25,"男");
        System.out.println(student);
    }

    @Test
    public void testMethod() throws Exception {
        Class cls = Student.class;
        Method[] methods = cls.getMethods();
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //Assert.assertEquals(9,methods.length);  //其实把继承自Object的方法也列出来了
        System.out.println("---------------------------");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        Assert.assertEquals(10,declaredMethods.length);
        System.out.println("---------------------------");
        Method eat = cls.getDeclaredMethod("eat",String.class);
        System.out.println(eat);
        System.out.println(eat.getName());
        Student student = new Student();
        eat.setAccessible(true);
        eat.invoke(student,"薯片");
    }
}
