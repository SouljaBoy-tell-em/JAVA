import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8081);
        Socket input = serverSocket.accept();

        Scanner scanner = new Scanner(input.getInputStream());
        while(scanner.hasNext())
            System.out.println(scanner.nextLine());

        scanner.close();
        input.close();
        serverSocket.close();
    }
}
