package com.qutopia.tutorial.javase.generic;

import com.qutopia.tutorial.javase.generic.bean.Apple;
import com.qutopia.tutorial.javase.generic.bean.Fruit;
import com.qutopia.tutorial.javase.generic.bean.Pear;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的通配符
 *
 * @author choaklin
 * @since 0.1.0
 */
public class Wildcards {

    public static void test(List<? super Apple> apples) {
        apples.add(new Apple());
    }

    public static void main(String[] args) {

        // error invoke
        List<Fruit> stringList = new ArrayList<Fruit>();
        Wildcards.test(stringList);

        List fruits = new ArrayList<Apple>();
        fruits.add(new Pear());
    }
}
