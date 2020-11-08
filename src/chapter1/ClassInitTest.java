/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package chapter1;

/**
 * @author yan.zhang
 * @date 2020/11/7 14:50
 */
public class ClassInitTest {

    /**
     * 类的加载过程：loading - linking - initialization
     * 在linking过程中的prepare过程：为类变量分配内存，并且设置该类的默认初始值，即零值
     */
    static {
        number = 10;
    }

    private static int number = 2;


    /**
     * 有类变量声明的字节码文件中会存在<clinit>()方法
     * <init>()构造器
     */
    public static void main(String[] args) {
        System.out.println(number);
    }
}
