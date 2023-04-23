import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("database.txt");
        ClearFile(file);

//        int i = 0;
//        for(i = 0; i < 10; i++)
//            record("word" + i + "\n", file);



        String string = "word";
        SymbolRecord(string, file);

        GetInfo(file);
    }


    public static void GetInfo(File file) throws IOException {

//        FileInputStream fileInputStream = new FileInputStream(file);
//        byte[] buffer = new byte[100];
//
//        int i = 0;
//        for(i = 0; ; i++) {
//
//            buffer[i] = (byte)fileInputStream.read();
//            if(buffer[i] == -1)
//                break;
//        }
//
//        String string = "";
//        for(i = 0; (i < buffer.length) && (buffer[i] != -1); i++)
//            string += (char)buffer[i];
//
//        System.out.println(string);

        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buffer = new byte[100];

        int counter = fileInputStream.read(buffer);

        for(int i = 0; i < counter; i++)
            System.out.print((char)buffer[i]);

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
