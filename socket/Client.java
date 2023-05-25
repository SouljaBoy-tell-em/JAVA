import java.io.*;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;


public class Client {
    static final String ServerHost = "93.175.4.188";

    public Client() throws IOException {
    }

    public static void main(String[] args) throws Exception {

//        InetAddress LocalHost;
//        try(final DatagramSocket socket = new DatagramSocket()) {
//
//            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
//            LocalHost = InetAddress.getByName(socket.getLocalAddress().getHostAddress());
//        }


        File file = new File("code.txt");

        try(BufferedReader br = new BufferedReader((new FileReader(file)))) {

            String string = "";

            int i = 0;
            while((string = br.readLine()) != null) {

                Socket socket = new Socket("93.175.4.188", 1111);
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.println(string);
                printWriter.close();
                socket.close();
                TimeUnit.SECONDS.sleep(1);
                i++;
            }

            Socket amountOfStringsSocket = new Socket("93.175.4.188", 1111);
            PrintWriter amountOfStringsWriter = new PrintWriter(amountOfStringsSocket.getOutputStream());
            amountOfStringsWriter.println(i);
            amountOfStringsWriter.close();
            amountOfStringsSocket.close();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+");
    }
}
