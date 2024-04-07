import Exceptions.OddException;

import javax.management.timer.Timer;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws OddException, IOException, InterruptedException {
//        ActionListener actionListener = new TimePrinter();
//        Timer timer = new Timer(10000, actionListener);
//        timer.start();

//        JOptionPane.showMessageDialog(null, "Quit program ?");
//        JOptionPane.showConfirmDialog(null, "Send ?");


        Car car = new Car("ENGINE");
        Car.Bar bar = car.new Bar("GT");



//        ActionListener.Foo();
//        ActionListener timePrinter = new TimePrinter();
//        timePrinter.Foo2();




//        int[] arr = new int[5];
//        System.out.println(Arrays.toString(arr));
//        System.out.println("RESULT: "  + Foo(arr, 0));
//        System.out.println(Arrays.toString(arr));




//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
//
//        try {
//
//            if(number % 2 == 0)
//                throw new OddException(number);
//        } catch (OddException oddException) {
//            System.out.println(oddException.toString());
//        }


//    System.out.println(Arrays.toString(FinalInterface.class.getMethods()[0].getParameterTypes()));



//        byte Byte = 0;
//        byte[] bytes = new byte[20];
//        System.in.read(bytes);

//        for(int i = 0; i < bytes.length; i++)
//            System.out.print((char)bytes[i]);
//
//        System.out.println("METHOD WRITE: ");
//        System.out.write(bytes);



//        FileInputStream inputStream   = null;
//        FileOutputStream outputStream = null;
//        try {
//            inputStream  = new FileInputStream("file.txt");
//            outputStream = new FileOutputStream("output.txt");
//
//            for(int index = inputStream.read(); index != -1;) {
//                System.out.print((char) index);
//                outputStream.write(index);
//                index = inputStream.read();
//            }
//        } catch (Exception exception) {
//            System.out.println(exception.fillInStackTrace());
//        } finally {
//            try {
//                inputStream.close();
//                outputStream.close();
//            } catch (IOException exception) {
//                System.out.println(exception.fillInStackTrace());
//            }
//        }





//        try(FileInputStream inputStream = new FileInputStream("file.txt");
//            FileOutputStream outputStream = new FileOutputStream("output.txt")) {
//
//            for (int index = inputStream.read(); index != -1; ) {
//                System.out.print((char) index);
//                outputStream.write(index);
//                index = inputStream.read();
//            }
//        } catch(Exception exception) {
//            System.out.println(exception.getMessage());
//        }


//        int Int = 12;
//        double Double = 812.1213123;
//        char Char = 'c';
//        boolean Bool = true;
//
//        try(DataOutputStream outputStream =
//                    new DataOutputStream(new FileOutputStream("file.txt"))) {
//            outputStream.writeInt(Int);
//            outputStream.writeDouble(Double);
//            outputStream.writeChar(Char);
//            outputStream.writeBoolean(Bool);
//        } catch (Exception exception) {
//            System.out.println(exception.fillInStackTrace());
//        }
//
//        try(DataInputStream inputStream =
//                new DataInputStream(new FileInputStream("file.txt"))) {
//            System.out.println(inputStream.readInt());
//            System.out.println(inputStream.readDouble());
//            System.out.println(inputStream.readChar());
//            System.out.println(inputStream.readBoolean());
//        } catch (Exception exception) {
//            System.out.println(exception.fillInStackTrace());
//        }



//        double double1 = 12.12;
//        double double2 = 812.912;
//        double double3 = 128931;
//
//        try(RandomAccessFile accessFile =
//                    new RandomAccessFile("file.txt", "rw")) {
//
//            accessFile.writeDouble(double1);
//            accessFile.writeDouble(double2);
//            accessFile.writeDouble(double3);
//
//            accessFile.seek(8);
//            System.out.println("DOUBLE #2: " + accessFile.readDouble());
//        } catch (Exception exception) {
//            System.out.println(exception.fillInStackTrace());
//        }




//        try(BufferedReader bufferedReader =
//                new BufferedReader(new InputStreamReader(System.in))) {
//            for(int i = bufferedReader.read(); (char)i != '.';) {
//                System.out.print((char)i);
//                i = bufferedReader.read();
//            }
//        } catch (Throwable throwable) {
//            System.out.println(throwable.fillInStackTrace());
//        }





//        try(BufferedReader bufferedReader =
//                    new BufferedReader(new InputStreamReader(System.in))) {
//            String str;
//            while((str = bufferedReader.readLine()).equals("stop") != true) {
//                System.out.println(str);
//            }
//        } catch (Throwable throwable) {
//            System.out.println(throwable.fillInStackTrace());
//        }




//        try(PrintWriter printWriter = new PrintWriter(System.out, true)) {
//
//            int i = 10;
//            double d = 20.12;
//            printWriter.println(i);
//            printWriter.printf("%lf", d);
//
//        } catch (Throwable throwable) {
//            System.out.println(throwable.fillInStackTrace());
//        }




//        try(BufferedReader bufferedReader =
//                    new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file.txt"))) {
//
//            String str = "";
//            while(!(str = bufferedReader.readLine()).equals("stop"))
//                bufferedWriter.write(str);
//
//        } catch (Throwable throwable) {
//            System.out.println(throwable.fillInStackTrace());
//        }

//        String str = "123.23";
//        byte[] bytes = str.getBytes();
//        System.out.println(Arrays.toString(bytes));





//        MyThread myThread = new MyThread("Thread-Alex");
//        Thread thread = new Thread(myThread);
//        thread.start();
//
//        for(int i = 0; i < 50; i++) {
//            System.out.print(".");
//            Thread.sleep(100);
//        }


//        String s1 = new String("a").intern();
//        String s2 = "a";
//        System.out.println(s1 == s2);









//        MyThread myThread1 = MyThread.newInstance("MyThread1");
//        MyThread myThread2 = MyThread.newInstance("MyThread2");
//        MyThread myThread3 = MyThread.newInstance("MyThread3");
//
//        myThread1.thread.setPriority(Thread.NORM_PRIORITY + 2);
//        myThread2.thread.setPriority(Thread.MIN_PRIORITY);
//        myThread3.thread.setPriority(Thread.MIN_PRIORITY);
//
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();

//        myThread1.thread.join();
//        myThread2.thread.join();
//        myThread3.thread.join();


//        for(int index = 0; index < 50; index++) {
//            System.out.print(".");
//            Thread.sleep(100);
//        }

//        while((myThread1.thread.isAlive() && myThread2.thread.isAlive() && myThread3.thread.isAlive()));


//        myThread1.thread.join();
//        myThread2.thread.join();
//        myThread3.thread.join();
//
//        System.out.println("Main thread finished");
//        System.out.println("MY THREAD1: " + myThread1.index);
//        System.out.println("MY THREAD2: " + myThread2.index);
//        System.out.println("MY THREAD3: " + myThread3.index);



        int[] nums = {1, 2, 3, 4, 5};
        ThreadCounter threadCounter1 = new ThreadCounter("ThreadCounter1", nums);
        ThreadCounter threadCounter2 = new ThreadCounter("ThreadCounter2", nums);

    }

    private static int Foo(int[] arr, int de_numerator) {


        for(int i = 0; i < arr.length; i++)
            arr[i] = i + 1;

        try {
            switch (de_numerator) {
                case 0 -> {
                    arr[0] = arr[4] / de_numerator;
                }

                case 1 -> {
                    arr[0] = arr[77];
                }

                case 2, 3 -> {
                    arr[0] = arr[2];
                    return 100;
                }
            }

        }

        // такие исключение могут быть обработаны catch(исключение), если их
        // суперклассами являются RuntimeException или Error. В остальных случаях
        // нужно добавлять throws к методу с соответствующими исключениями, чтобы
        // можно было скомпилировать программу и только после этого определять в
        // catch исключения, которые определили после throws на уровне метода;

        // Проверяемые исключения: те, которые могут быть помещены в throws;
        // Непроверяемые исключения: остальные, т.е. суперклассом которых является Error/RuntimeException;

//        catch (ArrayIndexOutOfBoundsException exception) {
//            System.out.println(exception.fillInStackTrace());
//        }
//        catch (ArithmeticException exception) {
//            System.out.println(exception.fillInStackTrace());
//        }
//        catch (Throwable throwable) {
//            System.out.println(throwable.fillInStackTrace());
//        }

        // множенственный перехват: можно обрабатывать 2 ошибки (или более) в одном catch;
        catch (ArrayIndexOutOfBoundsException | ArithmeticException exception) {
            System.out.println(exception.fillInStackTrace());
        }

        // этот блок выполнится в любом случае:
        finally {
            System.out.println("FINALLY");
            arr[0] = 1000;
        }

        return -100;
    }
}
