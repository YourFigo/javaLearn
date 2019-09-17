package demo.mutiThread.lambda;

public class UseCalc {
    //invokeCalc方法的参数中，有Calculator接口的实现类对象
    private static void invokeCalc(int a, int b, Calculator calculator) {
        int result = calculator.calc(a, b);
        System.out.println("结果是：" + result);
    }

    public static void main(String[] args) {
        //如果我们在主方法中调用invokeCalc方法，因为invokeCalc方法中传递了Calculator接口对象作为参数
        //传统的方法进行调用时，我们需要先new一个Calculator并重写其中的calc方法
        invokeCalc(120, 130, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });
        //而用lambda表达式如下
        invokeCalc(123,130,(int a,int b)->{return a+b;});
        //lambda省略省略格式
        invokeCalc(123,130,(a,b)->a+b);
    }
}
