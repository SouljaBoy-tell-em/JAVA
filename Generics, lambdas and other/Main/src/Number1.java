public class Number1<T extends java.lang.Number, V> {
    private T data;
    private V text;

    public Number1(T data, V text) {
        this.data = data;
        this.text = text;
    }

    public boolean isEqual(Number1<?, V> number) {
        System.out.println(number.getData());
        return (data.doubleValue() == number.getData().doubleValue());
    }

    public T getData() {
        return data;
    }
}
