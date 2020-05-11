package org.example.demo.thread.reflect.reflect;

import sun.misc.Launcher;
import sun.misc.URLClassPath;

import java.net.URL;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description 输出启动类加载器加载的类及位置
 **/
public class DemoPrintExtUrl {
    public static void main(String[] args) {
        // 1. 获得启动类加载器的加载路径
        URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
        // 2. 从路经中获取文件名
        URL[] urLs = bootstrapClassPath.getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }

        // 3.获取当前线程的类加载器
        System.out.println("当前线程的类加载器：" + Thread.currentThread().getContextClassLoader());
    }
}
