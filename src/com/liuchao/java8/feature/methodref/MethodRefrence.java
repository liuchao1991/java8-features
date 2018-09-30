package com.liuchao.java8.feature.methodref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法引用
 *
 * @author liuchao
 * @date 2018/9/30 15:03
 */
public class MethodRefrence {

    public static void main(String[] args) {
        // 构造器引用：它的语法是Class::new
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        // 静态方法引用：它的语法是Class::static_method
        cars.forEach(Car::collide);

        // 特定类的任意对象的方法引用
        cars.forEach(Car::repair);

        // 特定对象的方法引用
        final Car cra = Car.create(Car::new);
        cars.forEach(cra::follow);

        List<String> names = new ArrayList<>();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
