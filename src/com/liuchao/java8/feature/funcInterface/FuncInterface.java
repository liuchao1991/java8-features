package com.liuchao.java8.feature.funcInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 *
 * JDK 1.8之前已有的函数式接口:
 *     java.lang.Runnable
 *     java.util.concurrent.Callable
 *     java.security.PrivilegedAction
 *     java.util.Comparator
 *     java.io.FileFilter
 *     java.nio.file.PathMatcher
 *     java.lang.reflect.InvocationHandler
 *     java.beans.PropertyChangeListener
 *     java.awt.event.ActionListener
 *     javax.swing.event.ChangeListener
 *
 * @see java.util.function
 * @author liuchao
 * @date 2018/9/30 15:21
 */
public class FuncInterface {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = i -> true;
        // i 是一个参数传递到 Predicate 接口的 test 方法
        // i 如果存在则 test 方法返回 true

        System.out.println("输出所有数据:");

        eval(list, i -> true);

        // Predicate<Integer> predicate1 = i -> i % 2 == 0
        // i 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 i%2 为 0 test 方法返回 true

        System.out.println("输出所有偶数:");

        eval(list, i -> i % 2 == 0);

        // Predicate<Integer> predicate2 = i -> i > 3
        // i 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 i 大于 3 test 方法返回 true
        eval(list, i -> i > 3);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer i : list) {
            if (predicate.test(i)) {
                System.out.println(i + " ");
            }
        }
    }
}
