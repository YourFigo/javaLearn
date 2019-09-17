package demo.mutiThread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //1.使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //3.调用ExecutorService中的方法submit,传递线程任务(实现类),开启线程,执行run方法
        es.submit(new RunnableImpl());//pool-1-thread-1创建了一个新的线程执行
        //线程池会一直开启,使用完了线程,会自动把线程归还给线程池,线程可以继续使用
        es.submit(new RunnableImpl());//pool-1-thread-1创建了一个新的线程执行
        es.submit(new RunnableImpl());//pool-1-thread-2创建了一个新的线程执行

        //4.调用ExecutorService中的方法shutdown销毁线程池(不建议执行)
        es.shutdown();

        es.submit(new RunnableImpl());//抛异常,线程池都没有了,就不能获取线程了
    }
}
