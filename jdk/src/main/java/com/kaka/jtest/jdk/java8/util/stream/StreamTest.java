package com.kaka.jtest.jdk.java8.util.stream;

import com.kaka.jtest.jdk.model.Person;
import com.kaka.jtest.jdk.model.Student;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * 1. 开启流
 *      常见方法：collection.stream   parallelStream  实例方法 转换
 *      Arrays.stream(Object[]) 静态方法 转换
 *      Stream类的静态工厂方法
 *          Stream.of(Object[]), IntStream.range(int, int)，
 *          Stream.iterate(Object, UnaryOperator)   Stream.generate
 *      BufferedReader.lines(); 文件行
 *      Files类的获取文件路径列表： find(), lines(), list(), walk();
 *      Random.ints()  随机数流
 *      JDK中的许多其他流载方法，包括BitSet.stream(), Pattern.splitAsStream(java.lang.CharSequence), and JarFile.stream().
 *
 * 2. 中间操作(惰性)
 *      并不会立即执行任何过滤操作，而是创建了一个新流，当遍历时，它包含与给定谓词相匹配的初始流的元素。
 *      直到管道的终端操作被执行，管道源的遍历才会开始
 *      如：filter() flatMap() limit() map()  concat() distinct() peek() skip() sorted() parallel() sequential()
 *          unordered() flatMapTo[Double | Int | Long]  mapTo[ Double | Int | Long ]
 *
 * 3. 终端操作(产生结果)
 *      在执行终端操作之后，流管道被认为是被消耗掉的，并且不能再被使用;
 *      如果您需要再次遍历相同的数据源，您必须返回到数据源以获得一条新的stream。
 *      如：allMatch() anyMatch() collect() count() findAny() findFirst() forEach() forEachOrdered()
 *          max() min() noneMatch() reduce() toArray()
 *
 * @author shuangkaijia
 * @since 1.8
 */
public class StreamTest {

    /**
     * of()使用一组初始值生成新的 Stream。
     */
    @Test
    public void of() {
        // collect(toList())方法由 Stream里的值生成一个列表，是一个及早求值操作
        List<String> collected = Stream.of("a", "b", "c")
            .collect(toList());
        assertEquals(asList("a", "b", "c"), collected);
    }

//----------------------------------中间操作-----------------------------
    /**
     * filter 过滤集合中的数据
     * 惰性求值方法(sluggishness)：filter只描述Stream，不产生新集合
     * 判断一个操作是惰性求值还是及早求值很简单：只需看它的返回值。如果返回值是 Stream，那么是惰性求值；如果返回值是另一个值或为空，那么就是及早求值。
     * 重构：for 循环中的 if 条件语句就是一个很强的信号，可用 filter 方法替代。
     */
    @Test
    public void filter() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "AA"));
        personList.add(new Person(2, "BB"));
        personList.add(new Person(3, "CC"));
        personList.add(new Person(4, "AB"));

        // 由于使用了惰性求值，不会输出任何信息
        personList.stream()
                .filter(person -> {
                    System.out.println("----");
                    return person.getName().contains("A");
                });
    }

    /**
     * map():将一种类型的值转换成另外一种类型
     */
    @Test
    public void map() {
        Person person1 = new Person(1, "AA");
        Person person2 = new Person(2, "BB");

        List<String> collected = Stream.of(person1, person2)
            .map(person -> {
                person.setName("BB2");
                return person.getName();
            })
            .collect(toList());
        collected.stream().forEach(person -> System.out.println(person));
    }


    // ----------------------------------终止操作-------------------------------------------
    /**
     * 计算集合总数(属于内部迭代：在集合中过滤完成后，再把结果返回)
     * 及早求值方法：最终会从Stream产生值
     */
    @Test
    public void count() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "AA"));
        personList.add(new Person(2, "BB"));
        personList.add(new Person(3, "CC"));
        personList.add(new Person(4, "AB"));

        long count = personList.stream()
            .filter(person -> person.getName().contains("A"))
            .count();
        System.out.println("person的name中含有A的个数：" + count);
    }

    /**
     * 使用count方法终止流
     */
    @Test
    public void countTermination() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "AA"));
        personList.add(new Person(2, "AB"));

        // 加入一个拥有终止操作的流，如计数操作，就会被输出
        personList.stream()
                .filter(person -> {
                    System.out.println("----");
                    return person.getName().contains("A");
                })
                .count();
    }

    /**
     * flatMap 将多个stream 合并到一个Stream
     * 嵌套循环的时候可以使用
     */
    @Test
    public void flatMap() {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
        together.stream().forEach(integer -> System.out.println(integer));
    }

    /**
     * 自定义比较条件,取出最小的对象
     * min返回一个Optional对象，然后使用get方法取出Optional对象中的值
     */
    @Test
    public void min() {
        List<Student> students = asList(new Student("张三", 524),
                new Student("李四", 378),
                new Student("王五", 451));

        Student lowStudent = students.stream()
                .min(Comparator.comparing(track -> track.getScore()))
                .get();
        System.out.println(lowStudent);
    }

    /**
     * 自定义比较条件,取出最大的对象
     * min返回一个Optional对象，然后使用get方法取出Optional对象中的值
     */
    @Test
    public void max() {
        List<Student> students = asList(new Student("张三", 524),
                new Student("李四", 378),
                new Student("王五", 451));

        Student lowStudent = students.stream()
                .max(Comparator.comparing(track -> track.getScore()))
                .get();
        System.out.println(lowStudent);
    }

    /**
     * 终端操作：sum
     */
    @Test
    public void sum(){
        List<Student> students = asList(new Student("张三", 524),
            new Student("李四", 378),
            new Student("王五", 451));

        int sum = students.stream()
            .mapToInt(Student::getScore)
            .sum();
        System.out.println(sum);
    }
    /**
     * reduce中：10为初始值；acc是累加器；element是当前元素
     * reduce的返回类型为BinaryOperator
     */
    @Test
    public void reduce() {
        int count = Stream.of(1, 2, 3)
                .reduce(10, (acc, element) -> acc + element);
        System.out.println(count);
    }

    /**
     * reduce的展开
     */
    @Test
    public void reduceExtend() {
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int count = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1),
                        2),
                3);
        System.out.println(count);
    }

    /**
     * 返回一个IntStream对象
     */
    @Test
    public void mapToInt() {
        IntStream intStream = Stream.of(1, 2, 3)
                .mapToInt(integer -> integer);
        System.out.println("count:" + intStream.count());
        // intStream只能计算一次，若统计各项值使用intStream的summaryStatistics方法
//        System.out.println("sum:" + intStream.sum());
    }

    /**
     * 使用foreach修改list中的值
     */
    @Test
    public void foreach() {
        List<Student> students = asList(new Student("张三", 524),
                new Student("李四", 378),
                new Student("王五", 451));
        students.stream()
                .forEach(student -> {
                    student.setName("AA");
                    System.out.println("******");
                });
        System.out.println(students);
    }

    /**
     * forEach性能对比
     */
    @Test
    public void forEachPerformance() {
        List<Student> students = asList(new Student("张三", 524),
                new Student("李四", 378),
                new Student("王五", 451));
        Instant instant1 = Instant.now();

        forTest(students);
        Instant instant2 = Instant.now();

        forEachTest(students);
        Instant instant3 = Instant.now();

        streamForEachTest(students);
        Instant instant4 = Instant.now();

        System.out.println("原生for循环：" + Duration.between(instant1, instant2).toMillis());
        System.out.println("原生forEach：" + Duration.between(instant2, instant3).toMillis());
        System.out.println("stream的forEach：" + Duration.between(instant3, instant4).toMillis());

    }

    private void forTest(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).setName("CC");
        }

        System.out.println(studentList);
    }

    private void forEachTest(List<Student> studentList) {
        for (Student student : studentList) {
            student.setName("BB");
        }
        System.out.println(studentList);
    }

    private void streamForEachTest(List<Student> studentList) {
        studentList.stream()
                .forEach(student -> {
                    student.setName("AA");
                });
        System.out.println(studentList);
    }


    private Integer num = 1000000;

    /**
     * map性能
     * 100w以上  stream才有可能快
     */
    @Test
    public void mapPerformance() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            students.add(new Student("张三", num));
        }
        Instant instant1 = Instant.now();

        forConverterTest(students);
        Instant instant2 = Instant.now();

        mapTest(students);
        Instant instant3 = Instant.now();

        System.out.println("原生for循环：" + Duration.between(instant1, instant2).toMillis());
        System.out.println("stream的map：" + Duration.between(instant2, instant3).toMillis());

    }

    private void mapTest(List<Student> students) {
        students.stream()
                .map(Student::getName)
                .collect(toList());
    }

    private void forConverterTest(List<Student> students) {
        List<String> nameList = new ArrayList<>();
        for (Student student : students) {
            nameList.add(student.getName());
        }
    }

    @Test
    public void anyMatchTest(){
        List<Student> students = asList(new Student("张三", 524),
                new Student("李四", 378),
                new Student("王五", 451));
        boolean b = students.stream()
                .anyMatch(s -> s.getScore() > 500);
        System.out.println(b);
    }

}
