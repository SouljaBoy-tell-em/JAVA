package functional_interfaces;

public interface EasyOut<T, V> {
    V sum(T[] a);

    default void out(int number) {
        System.out.println("NUMBER: " + number);
    }
}
