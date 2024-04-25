package package1;

public abstract class A {

    private int sum;

    <T extends Number> A(T a) {
        sum += a.intValue();
    }
}
