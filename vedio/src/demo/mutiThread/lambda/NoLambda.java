package demo.mutiThread.lambda;

public class NoLambda {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程1");
            }
        }).start();

        new Thread(()-> System.out.println("多线程2")).start();
    }
}
