package com.liuchao.java8.feature.lambda;

/**
 * Lambda 表达式
 * 语法格式:
 *    (parameters) -> expression
 *    (parameters) ->{ statements; }
 *
 * @author liuchao
 * @date 2018/7/2 11:06
 */
public class LambdaExpression {

    public static void main(String[] args) {

        LambdaExpression lambda = new LambdaExpression();

        // 声明类型
        MathOperation addtional = (int a, int b) -> a + b;
        // 不声明类型
        MathOperation subtraction = (a, b) -> a + b;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };
        // 没有大括号及返回语句
        MathOperation division = (a, b) -> a / b;

        System.out.println("10 + 5 = " + lambda.operation(10, 5, addtional));
        System.out.println("10 - 5 = " + lambda.operation(10, 5, subtraction));
        System.out.println("10 * 5 = " + lambda.operation(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambda.operation(10, 5, division));

        // 不用括号
        GreetingService greetingService1 = message -> System.out.println("Hello " + message);
        // 用括号
        GreetingService greetingService2 = (message) -> System.out.println("Hello " + message);

        greetingService1.sayMessage("Runoob");
        greetingService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService{
        void sayMessage(String message);
    }

    private int operation(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}
