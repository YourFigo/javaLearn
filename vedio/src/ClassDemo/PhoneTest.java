package ClassDemo;

public class PhoneTest {
    public static void main(String[] args) {
        Phone one = getPhone();
        System.out.println(one.brand);
        System.out.println(one.price);
        System.out.println(one.color);

        Phone two = new Phone();
        method(two);
    }

    public static Phone getPhone(){
        Phone one = new Phone();
        one.brand = "苹果";
        one.color = "黑色";
        one.price = 8848.0;
        return one;
    }

    public static void method(Phone phone){
        System.out.println(phone.brand);
        System.out.println(phone.price);
    }

}

class TelPhone extends Phone{

}
