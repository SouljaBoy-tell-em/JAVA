public class Main {
    public static void main(String[] args) {

        Transport<Integer, String> transport1 = new Transport<Integer, String>(2000, "2014w");
        transport1.Show();
        Transport<Integer, Integer> transport2 = new Transport<>(2000, 1231);
        transport2.Show();
    }
}
