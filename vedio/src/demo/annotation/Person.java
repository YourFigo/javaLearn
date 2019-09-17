package demo.annotation;

public class Person {
    /**
     * 在Person这个JavaBean中使用Range注解
     */
    @Range(min = 3,max = 10)
    public String name;
    public int age;
    @Range(min = 5,max = 20)
    public String address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
