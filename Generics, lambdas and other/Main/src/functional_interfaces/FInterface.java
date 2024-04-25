package functional_interfaces;

public interface FInterface {
    int number(FClass fClass);
    default void out(int number) {
        System.out.println("NUMBER: " + number);
    }
}
