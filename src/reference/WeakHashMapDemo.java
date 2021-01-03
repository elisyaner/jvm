/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package reference;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author yan.zhang
 * @date 2021/1/3 11:17
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        hashMapDemo();
        System.out.println("============================");
        weakHashMapDemo();
    }

    private static void weakHashMapDemo() {
        Map<Integer, String> map = new WeakHashMap<>(8);
        Integer key = new Integer(1);
        String value = "weakHashMap";

        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        //gc后map为空
        System.gc();
        System.out.println(map);
    }

    private static void hashMapDemo() {
        HashMap<Integer, String> map = new HashMap<>(8);
        Integer key = new Integer(1);
        String value = "hashMap";

        map.put(key, value);
        System.out.println(map);

        //key 指向 Integer对象，指向Integer对象的引用被置为null，hashMap中的Entry的key是Integer对象
        //此时Integer对象并没有被gc
        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);

    }
}
