import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("database.txt");
        ClearFile(file);

//        int i = 0;
//        for(i = 0; i < 10; i++)
//            record("word" + i + "\n", file);



        String string = "word";
        SymbolRecord(string, file);

    }

    public static void record(String string, File file) throws FileNotFoundException {

        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        byte[] buffer = string.getBytes();

        try {

            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public static void SymbolRecord(String string, File file) throws FileNotFoundException {

        FileOutputStream clearFile = new FileOutputStream(file);
        byte[] buffer = string.getBytes();

        try {

            int i = 0;
            for(i = 0; i < buffer.length; i++) {

                clearFile.write(buffer[i]);
                clearFile.write(' ');
            }
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public static void ClearFile(File file) throws FileNotFoundException {

        FileOutputStream clearfile = new FileOutputStream(file, false);

        String string = "";
        byte[] buffer = string.getBytes();

        try {

            clearfile.write(buffer, 0, buffer.length);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }
}
