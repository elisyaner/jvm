/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package jvm.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yan.zhang
 * @date 2019/11/27 23:04
 */
public class MonitoringTest {
    /**
     * 内存占位符对象,一个OOMObject大小大约64KB
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
        //
        System.gc();
        Thread.sleep(10_000);
    }
}
