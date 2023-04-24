import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        //File file = new File("database.txt");
        //ClearFile(file);

//        int i = 0;
//        for(i = 0; i < 10; i++)
//            record("word" + i + "\n", file);



//        String string = "word";
//        SymbolRecord(string, file);
//
//        GetInfo(file);



//        // DataOutputStream - поток вывода для примитивных данных: int, double и т.д.
//        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
//        dataOutputStream.write(("INFORMATION").getBytes());
//
//        byte[] buffer = new byte[100];
//        FileInputStream fileInputStream = new FileInputStream(file);
//        int counter = fileInputStream.read(buffer);
//        String string = buffer.toString();
//        System.out.println(string);


//        FileWriter fileWriter = new FileWriter(file);
//        fileWriter.write("print(words[len(words) - 1])\n" + "file.close()");
//        fileWriter.flush(); // после вызова flush данные точно попадают в файл;
//        fileWriter.append('S'); // посимвольное добавление;
//        fileWriter.flush();
//        fileWriter.close();
//
//        FileReader fileReader = new FileReader(file);
//        byte[] buffer = new byte[100];
//        int ch = 0;
//
//        int i = 0;
//        while((ch = fileReader.read()) != -1) {
//
//            buffer[i] = (byte)ch;
//            i++;
//        }
//
//        int k = 0;
//        for(k = 0; k < i; k++)
//            System.out.print((char)buffer[k]);


//        FileWriter fileWriter = new FileWriter(file);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        bufferedWriter.write("file = open(\"input.txt\", \"r\")\n" +
//                                 "words = file.readline().split()\n" +
//                                 "file.close()\n" +
//                                 "file = open(\"output.txt\", \"w\")\n" +
//                                 "file.write(words[len(words) - 1])\n" +
//                                 "file.close()");
//        bufferedWriter.flush();
//
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
////        ПОСИМВОЛЬНОЕ СЧИТЫВАНИЕ:
////        int ch = 0;
////        while((ch = bufferedReader.read()) != -1)
////            System.out.print((char)ch);
//
//        String currentBuffer = bufferedReader.readLine(); // построчное считывание;
//        System.out.println(currentBuffer);
//        currentBuffer = bufferedReader.readLine();
//        System.out.println(currentBuffer);


//        try(BufferedWriter bw = new BufferedWriter(new FileWriter("notes4.txt"))) // с оберткой try/catch
                                                                                    // будет вызов flush()
                                                                                    // автоматически;
//        {
//            String text = "Hello World!\nHey! Teachers! Leave the kids alone.";
//            bw.write(text);
//        }
//        catch(IOException ex){
//
//            System.out.println(ex.getMessage());
//        }



//        File ObjectFile = new File("person.dat");
//        recordObject(ObjectFile);

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.dat"))) {

            Person person = new Person((byte)20, "Alexander");
            objectOutputStream.writeObject(person);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.dat"))) {

            Person GetFromBuffer = (Person)objectInputStream.readObject();
            System.out.printf("name: %s\nage: %d\n", GetFromBuffer.name, (int)GetFromBuffer.age);
        } catch(Exception e) {

            System.out.println(e.getMessage());
        }

    }


    public static void recordObject(File ObjectFile) throws IOException{

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.dat"))) {

            Person person = new Person((byte)20, "Alexander");
            objectOutputStream.writeObject(person);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.dat"))) {

            Person GetFromBuffer = (Person)objectInputStream.readObject();
            System.out.printf("name: %s\nage: %d\n", GetFromBuffer.name, (int)GetFromBuffer.age);
        } catch(Exception e) {

            System.out.println(e.getMessage());
        }
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

//        FileInputStream fileInputStream = new FileInputStream(file);
//        byte[] buffer = new byte[100];
//
//        int counter = fileInputStream.read(buffer);
//
//        for(int i = 0; i < counter; i++)
//            System.out.print((char)buffer[i]);
//
//        fileInputStream.close();


//        String string = "INFORMATION";
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes(), 0, 3);
//        System.out.print((char)byteArrayInputStream.read());
//        System.out.print((char)byteArrayInputStream.read());
//        System.out.println((char)byteArrayInputStream.read());
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(string.length());
//        byteArrayOutputStream.write(string.getBytes());
//        System.out.println(byteArrayOutputStream);
//        System.out.println(byteArrayOutputStream.toString());
//
//
//
//        byte[] array = new byte[byteArrayOutputStream.size()];
//        array = byteArrayOutputStream.toByteArray();
//
//        for(byte i : array)
//            System.out.print(i + " ");
//
//        System.out.println();
//        for(byte i : array)
//            System.out.print((char)i + " ");
//

//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        String string = "Hello, world!";
//        byte[] buffer = string.getBytes();
//
//        try {
//
//            byteArrayOutputStream.write(buffer);
//        } catch (Exception e) {
//
//            System.out.println(e.getMessage());
//        }
//
//        byteArrayOutputStream.writeTo(fileOutputStream); // дополнительно произойдет запись string в файл database.txt
//        System.out.println(byteArrayOutputStream);

        //ByteArrayInputStream in = new ByteArrayInputStream(buffer);
        //BufferedInputStream bufferedInputStream = new BufferedInputStream(in);



//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//        String text = "Hello, world111!";
//        byte[] buffer = text.getBytes();
//        bufferedOutputStream.write(buffer);
//        //fileOutputStream.write(buffer);
//
//        //bufferedOutputStream.write(buffer, 0, buffer.length);

//        FileOutputStream fileOutputStream = new FileOutputStream(file); // поток вывода в файл(запись в файл);
//        PrintStream printStream = new PrintStream(fileOutputStream); // создание
//        printStream.println("lol");
//
//        byte[] currentBuffer = new byte[100];
//        String string = "message";
//        currentBuffer = string.getBytes();
//        printStream.println(string);
//        printStream.write(currentBuffer); // для currentBuffer вызван write(), т.к. методы print() / println()
//                                          // не принимают тип данных: byte[].
//
//        System.out.println("Record in file was finished.");


//        PrintWriter pw = new PrintWriter(System.out);
//        pw.println("dlf");
//        pw.close();
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
