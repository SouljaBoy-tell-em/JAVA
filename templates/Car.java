public class Car<T, S> extends Transport<T, S> {

    private boolean isOn;

    Car(T mass, S serialNumber, boolean isOn) {

        super(mass, serialNumber);
        this.isOn = isOn;
    }
}