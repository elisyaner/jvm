/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package chapter1;

import sun.misc.Launcher;
import sun.security.ec.CurveDB;

import java.net.URL;

/**
 * @author yan.zhang
 * @date 2020/11/7 15:56
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("---启动类加载器---");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.getPath());
        }


        System.out.println("---扩展类加载器---");
        String property = System.getProperty("java.ext.dirs");
        System.out.println(property);

        //CurveDB.class 为 C:\dev\jdk1.8.0_221\jre\lib\ext 包下的类，由扩展类加载器加载
        //sun.misc.Launcher$ExtClassLoader@4b67cf4d
        System.out.println(CurveDB.class.getClassLoader());


        //获取系统类加载器
        System.out.println("---系统类加载器---");
        System.out.println(ClassLoader.getSystemClassLoader());

    }

}
