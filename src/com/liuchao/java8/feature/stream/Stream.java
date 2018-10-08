package com.liuchao.java8.feature.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
 *
 * +--------------------+       +------+   +------+   +---+   +-------+
 * | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
 * +--------------------+       +------+   +------+   +---+   +-------+
 *
 * 以上的流程转换为 Java 代码为:
 * 
 * List<Integer> transactionsIds =
 * widgets.stream()
 *              .filter(b -> b.getColor() == RED)
 *              .sorted((x,y) -> x.getWeight() - y.getWeight())
 *              .mapToInt(Widget::getWeight)
 *              .sum();
 *
 * @author liuchao
 * @date 2018/9/30 15:39
 */
public class Stream {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 在 Java 8 中, 集合接口有两个方法来生成流：
        // stream() − 为集合创建串行流。
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(toList());
        // parallelStream() − 为集合创建并行流。
        List<String> parallel = strings.parallelStream().filter(string -> !string.isEmpty()).collect(toList());

        // forEach
        // Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。以下代码片段使用 forEach 输出了10个随机数：
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        // map
        // map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i * i).distinct().collect(toList());

        // filter
        // filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：
        Long count = strings.stream().filter(string -> !string.isEmpty()).count();

        // limit
        // limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据：
        random.ints().limit(10).sorted().forEach(System.out::println);

        // Collectors
        // Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
        List<String> filter = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filter);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        // 统计
        // 另外，一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }
}
