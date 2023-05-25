import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    static final String DataBaseFile = "database.txt";
    static final String EquationFile = "equation.txt";

    public static void main(String[] args) throws Exception {

        File DataBase = new File(DataBaseFile);
        File Equation = new File(EquationFile);

//while(true) {

        ServerSocket serverSocket = new ServerSocket(1111);
        Socket input = serverSocket.accept();
        Scanner scanner = new Scanner(input.getInputStream());

        String CapacityBuffer = scanner.nextLine();
        String buffer[] = CapacityBuffer.split(" ");
        record(CapacityBuffer + " " + scanner.hashCode(), DataBase, true);
        record(buffer[1], Equation, false);

        Process process = Runtime.getRuntime().exec(new String[]{"cmd", "/c", "a"},
                null, new File("C:\\Users\\Alexander\\IdeaProjects\\Socket"));

        scanner.close();
        input.close();
        serverSocket.close();
//}
    }

    public static void record(String string, File file, boolean status) throws FileNotFoundException {

        FileOutputStream fileOutputStream = new FileOutputStream(file, status);
        byte[] buffer = string.getBytes();

        try {

            fileOutputStream.write(buffer, 0, buffer.length);
            fileOutputStream.write('\n');
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
