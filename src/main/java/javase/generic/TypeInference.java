package javase.generic;

/**
 * 类型推断
 *
 * @author choaklin
 * @since 0.1.0
 */
public class TypeInference<T> {

    private T info;

    public TypeInference() {}

    public TypeInference(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }
    public void setInfo(T info) {
        this.info = info;
    }

    public static void main(String[] args) {
        TypeInference<String> stringTypeInference = new TypeInference("Hello World!");
        System.out.println(stringTypeInference.getInfo());

        TypeInference<Integer> integerTypeInference = new TypeInference<Integer>(1212121);
        System.out.println(integerTypeInference.getInfo());

        System.out.println(stringTypeInference.getClass() == integerTypeInference.getClass());
    }
}
