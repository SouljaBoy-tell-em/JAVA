import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 8081);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Hello");
        printWriter.println("World!");
        printWriter.println("How are you ?");

       printWriter.close();
       socket.close();
    }

}
