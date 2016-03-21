package com.qutopia.tutorial.javase.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * something
 *
 * @author choaklin
 * @since 0.1.0
 */
public class GenericMethod {

    public static <T extends Object> void copy(Collection<? extends T> src, Collection<T> dest) {
        for (T s : src) {
            dest.add(s);
        }
    }

    public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o);
        }
    }

    public static void main(String[] args) {
        Collection<String> stringCollection = new ArrayList<String>();
        String[] strings = new String[] {
                "abc", "abd", "bcd", "cda"
        };
        GenericMethod.fromArrayToCollection(strings, stringCollection);
//        System.out.println(stringCollection);
//
//        Collection<Integer> integerCollection = new ArrayList<Integer>();
//        Integer[] integers = new Integer[] {
//                111, 222, 333, 444
//        };
//        GenericMethod.fromArrayToCollection(integers, integerCollection);
//        System.out.println(integerCollection);

        Collection<Object> objectCollection = new ArrayList<Object>();
        GenericMethod.copy(stringCollection, objectCollection);
        System.out.println(objectCollection);
    }
}
