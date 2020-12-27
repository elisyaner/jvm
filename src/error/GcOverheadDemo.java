/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package error;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yan.zhang
 * @date 2020/12/27 15:52
 */
public class GcOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i));
            }
        } catch (Throwable t) {
            System.out.println("******************i: " + i);
            t.printStackTrace();
            throw t;
        }

    }
}
