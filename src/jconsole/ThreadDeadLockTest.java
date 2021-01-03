/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package jconsole;

/**
 * @author yan.zhang
 * @date 2019/11/28 22:42
 */
public class ThreadDeadLockTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SyncAddRun(1, 2)).start();
            new Thread(new SyncAddRun(2, 1)).start();

        }
    }
}

class SyncAddRun implements Runnable {
    int a, b;

    public SyncAddRun(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }
}
