/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package chapter1;

/**
 * @author yan.zhang
 * @date 2020/11/7 21:34
 */
public class ParentDelegationTest {
    /**
     * 双亲委派测试
     */
    public static void main(String[] args) {
        /**
         * java.lang.String()应该被AppClassLoader所加载
         * 但由于双亲委派机制，AppClassLoader不会加载，会委派上一级类加载器加载，如果还存在上一级类加载器，进一步向上委托
         * 直到最顶层
         * 如果上一级类加载器无法完成类加载，交由子类加载器加载
         *
         * 此例中bootStrap类加载器会加载java包下的类。
         *
         * 优势：
         * 1.避免类的重复加载，相对于从顶向下的加载方式，避免了类的重复加载，一旦顶层类加载器加载后，不会委派下层类加载器去加载
         * 2.防止核心类库被篡改
         */
        String s = new java.lang.String();
    }
}
