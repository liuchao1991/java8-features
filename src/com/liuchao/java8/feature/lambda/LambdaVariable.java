package com.liuchao.java8.feature.lambda;

/**
 * Lambda 变量作用域
 * lambda 表达式只能引用标记了 final 的外层局部变量，
 * 这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误
 * @author liuchao
 * @date 2018/7/2 11:16
 */
public class LambdaVariable {

    final static String salutation = "Hello! ";

    public static void main(String[] args) {
        // GreetingService greetingService = message -> salutation = "Happy!";
        GreetingService greetingService = message -> System.out.println(salutation + message);
        greetingService.sayMessage("Runoob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}

