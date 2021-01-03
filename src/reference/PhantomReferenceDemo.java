/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author yan.zhang
 * @date 2021/1/3 12:30
 */
public class PhantomReferenceDemo {
    /**
     * 虚引用
     * 配合引用队列使用:虚/弱引用，构造器传入引用队列，在gc前，被标记gc的对象会被置入引用队列。
     * 虚引用作用主要是跟踪对象被垃圾回收的状态，仅仅提供一种确保对象被finalize之后，做某些事情的机制
     * 设置虚引用关联的唯一目的，就是在这个对象被垃圾回收的时候收到一个系统通知或后续添加进一步处理。
     * java允许使用finalize()方法在垃圾回收器将对象从内存中清除之前做必要的清理动作，相当于一种通知机制
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, queue);

        System.out.println(o1);
        //对于虚引用，get()只会返回null
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());

        System.out.println("==================");

        o1 = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());
    }

}
