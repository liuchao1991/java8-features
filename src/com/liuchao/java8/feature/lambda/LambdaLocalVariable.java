package com.liuchao.java8.feature.lambda;

/**
 * Lambda 表达式中访问外层的局部变量
 *
 * @author liuchao
 * @date 2018/7/2 14:24
 */
public class LambdaLocalVariable {

    public static void main(String[] args) {
        // lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
        // final int num = 1;
        int num = 1;

        Converter<Integer, String> c = param -> System.out.println(String.valueOf(param + num));
        c.conver(2);

        // num = 5; // Error:(16, 93) java: 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量

        String first = "";

        // 在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量
        // Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());

    }

    interface Converter<T1, T2> {
        void conver(int i);
    }

}
