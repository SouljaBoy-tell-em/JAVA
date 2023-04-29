import java.sql.Time;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {

//        System.out.println("Main thread started...");
//        JThread jThread1 = new JThread("Thread 1");
//
//        jThread1.start();
//        try {
//
//            jThread1.join();
//        } catch (Exception e) {
//
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("Main thread finished...");



//        int i = 0;
//        for(i = 0; i < 50; i++) {
//
//            String currentThread = "thread №" + i;
//            Thread thread = new Thread(new IThread(), currentThread);
//            thread.start();
//            thread.join();
//        }



//        System.out.println("Main thread started...");
//        KThread kThread = new KThread();
//        new Thread(kThread, "KThread").start();
//
//        try {
//
//            Thread.sleep(500);
//            //kThread.off();
//            kThread.interrupt();
//            Thread.sleep(500);
//        } catch (Exception e) {
//
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("Main thread finished...");




        System.out.println("Main thread started...");
        KThread kThread = new KThread();
        new Thread(kThread, "KThread").start();

        try {

            Thread.sleep(500);
            kThread.interrupt(); // после этого isInterupted будет возвращать true;
            Thread.sleep(500);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        System.out.println("Main thread finished...");
    }

    public static class KThread extends Thread implements Runnable {

        private boolean isActive;

        public KThread() {

            this.isActive = true;
        }

        public void off() {

            this.isActive = false;
        }

        public void run() {

            System.out.printf("%s started...\n", Thread.currentThread().getName());

//            int counter = 1;
//            while(this.isActive) {
//
//                System.out.println("Loop №" + counter);
//                counter++;
//
//                try {Thread.sleep(500);}
//                catch (Exception e) {System.out.println(e.getMessage());}
//            }

            int counter = 0;
            while(!isInterrupted()) {

                System.out.println("Loop №" + counter);
                counter++;
                try {Thread.sleep(500);}
                catch (Exception e) {System.out.println(e.getMessage());}
            }

            System.out.printf("%s finished...\n", Thread.currentThread().getName());
        }
    }

    public static class JThread extends Thread {

        public JThread(String ThreadName) {super(ThreadName);}
        public void run() {

            System.out.printf("%s started...\n", Thread.currentThread().getName());

            try {

                //Thread.sleep(500);
            } catch(Exception e) {

                System.out.println(e.getMessage());
            }

            System.out.printf("%s finished...\n", Thread.currentThread().getName());
        }
    }


    public static class IThread extends Thread {

        public void run() {

            System.out.printf("%s started...\n", Thread.currentThread().getName());

            try {

                Thread.sleep(500);
            } catch(Exception e) {

                System.out.println("exception: " + e.getMessage());
            }

            System.out.printf("%s finished...\n", Thread.currentThread().getName());
        }
    }
}
