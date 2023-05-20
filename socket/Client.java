import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws Exception {


        while(true) {

            Socket socket = new Socket("93.175.4.188", 8081);
            //Socket socket = new Socket("192.168.1.46", 8081);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();
            printWriter.println(string);
            printWriter.close();
            socket.close();
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
