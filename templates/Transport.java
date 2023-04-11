
public class Transport<T, S> {

    T mass;
    S serialNumber;

    public Transport(T mass, S serialNumber) {

        this.mass = mass;
        this.serialNumber = serialNumber;
    }

    public void SetTransport(T mass, S serialNumber) {

        this.mass = mass;
        this.serialNumber = serialNumber;
    }

    public void Show() {

        System.out.println("INFO:");
        System.out.println("mass: " + this.mass);
        System.out.println("serial number: " + this.serialNumber);
    }
}
