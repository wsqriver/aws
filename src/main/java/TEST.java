import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TEST {
    private static String A ="a";
    private static String B ="b";

    public static void main(String[] args) {
//        ThreadPoolExecutor.
//       // new TEST().deadLockT();
    }

    /**
     * 模拟死锁
     */
    private void deadLockT() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (A){
                    // 让线程先睡眠2s
                    try {
                        Thread.sleep(1000);
                        // 尝试获取B对象的锁
                        synchronized (B){
                            System.out.println("线程A获取到B对象");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                // 占有B对象
                synchronized (B){
                    // 尝试获取B对象的锁
                    synchronized (A){
                        System.out.println("线程B获取到A对象");
                    }
                }
            }
        }).start();
    }
}

