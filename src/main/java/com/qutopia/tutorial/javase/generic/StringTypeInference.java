package com.qutopia.tutorial.javase.generic;

/**
 * something
 *
 * @author choaklin
 * @since 0.1.0
 */
public class StringTypeInference extends TypeInference<String> {

    @Override
    public String getInfo() {
        return "String子类: " + super.getInfo();
    }

    // 错误的重载
    // public Object getInfo() {return "子类";}

    public static void main(String[] args) {
        TypeInference<String> stringTypeInference = new StringTypeInference();
        stringTypeInference.setInfo("Hello World!");
        System.out.println(stringTypeInference.getInfo());
    }
}
