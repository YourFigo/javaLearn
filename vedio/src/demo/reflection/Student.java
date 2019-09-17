package demo.reflection;

public class Student {
    public String name;
    public String stuId;
    private int age;
    private String sex;

    public Student() {
    }

    public Student(String name, String stuId, int age, String sex) {
        this.name = name;
        this.stuId = stuId;
        this.age = age;
        this.sex = sex;
    }

    private void eat(String thing){
        System.out.println("eat" + thing +" ... ");
    }

    public String getName() {
        return name;
    }

    public String getStuId() {
        return stuId;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", stuId='" + stuId + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
