package com.modal.common.java8;

import com.alibaba.fastjson.JSON;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by 170096 on 2018/9/27 14:06
 *
 * @author 170096
 */
public class UsePredicateAndConsumer {

    /**
     * @FunctionalInterface
     * public interface Predicate<T> {

     *  boolean test(T t);

     *  default Predicate<T> and(Predicate<? super T> other) {
     *      Objects.requireNonNull(other);
     *      return (t) -> test(t) && other.test(t);
     *  }

     *  default Predicate<T> negate() {
     *      return (t) -> !test(t);
     *  }

     *  default Predicate<T> or(Predicate<? super T> other) {
     *      Objects.requireNonNull(other);
     *      return (t) -> test(t) || other.test(t);
     *  }

     *  static <T> Predicate<T> isEqual(Object targetRef) {
     *      return (null == targetRef)
     *          ? Objects::isNull
     *          : object -> targetRef.equals(object);
     *  }
     * }
     */

    /**
     *
     * @FunctionalInterface
     * public interface Consumer<T> {

     *  void accept(T t);

     *  default Consumer<T> andThen(Consumer<? super T> after) {
     *      Objects.requireNonNull(after);
     *      return (T t) -> { accept(t); after.accept(t); };
     *  }
     * }
     */


    public static void main(String[] args) {
        testPredicate();
        testConsumer();
        testPredicateConsumer();
    }

    private static void  testPredicate(){
        Predicate<Integer> boolValue = x -> x > 5;
        System.out.println(boolValue.test(1));
        System.out.println(boolValue.test(6));
    }

    private static void testConsumer(){
        User user = new User("zm");
        //接受一个参数
        Consumer<User> userConsumer = (User user1) -> user1.setName("zmChange");
        userConsumer.accept(user);
        System.out.println(user.getName());
    }

    /**
     * 使用Predicate接口实现类的test()方法判断输入的Student对象是否拥有费用打折的资格
     * 然后使用Consumer接口的实现类更新输入的Student对象的折扣
     */
    private static void testPredicateConsumer() {
        Predicate<Student> booleanValue = t -> t.getGrade() > 8.0;
//      Consumer<Student> changeFee = student -> student.printFee();  相当于 Consumer<Student> changeFee = Student::printFee;
        Consumer<Student> changeFee = Student::printFee;

        Student student1 = new Student("Ashok1","Kumar1", 8.5);
        Student student2 = new Student("Ashok2","Kumar2", 9.5);

        updateStudentFee(student1, booleanValue, changeFee);
        System.out.println(JSON.toJSONString(student1));

        updateStudentFee(student2, t -> t.getGrade() > 9, student -> student.setFeeDiscount(0.5));
        student2.printFee();
    }

    private static void updateStudentFee(Student student, Predicate<Student> predicate, Consumer<Student> consumer){
        if (predicate.test(student)){
            consumer.accept(student);
        }
    }

}
class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
class Student {

    private String firstName;

    private String lastName;

    private Double grade;

    private Double feeDiscount = 0.8;

    private Double baseFee = 2000.0;

    Student(String firstName, String lastName, Double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    void printFee(){
        this.baseFee = feeDiscount * baseFee;
        System.out.println(this.firstName + " Fee:" + this.baseFee);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Double getFeeDiscount() {
        return feeDiscount;
    }

    public void setFeeDiscount(Double feeDiscount) {
        this.feeDiscount = feeDiscount;
    }

    public Double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(Double baseFee) {
        this.baseFee = baseFee;
    }
}
