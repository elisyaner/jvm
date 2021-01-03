/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package reference;

import java.lang.ref.SoftReference;

/**
 * @author yan.zhang
 * @date 2021/1/3 10:42
 */
public class SoftReferenceDemo {
    private static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());

    }

    /**
     * 产生大对象。产生oom,看jvm对softReference回收情况
     */
    private static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            //softReference.get() -->null
            System.out.println("开始打印：o1: " + o1 + " softReference: " + softReference.get());
        }


    }

    public static void main(String[] args) {
//        softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }
}
