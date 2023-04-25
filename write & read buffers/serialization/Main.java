import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        Person person = new Person(20, "KirillGuy");
//
//        File file = new File("info.txt");
//        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
//
//            ObjectOutputStream  objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(person);
//        } catch(Exception e) {
//
//            System.out.println(e.getMessage());
//        }
//
//        try(FileInputStream fileInputStream = new FileInputStream(file)) {
//
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            Person save = (Person)objectInputStream.readObject();
//            save.GetPerson();
//        } catch(Exception e) {
//
//            System.out.println(e.getMessage());
//        }

        ArrayList<Person> person = new ArrayList<>(2);
        person.add(0, new Person(20, "KirillGuy", 180.1));
        person.add(1, new Person());
        File file = new File("info.txt");

        try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
            fileOutputStream.close();


            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<Person> save = (ArrayList<Person>)objectInputStream.readObject();

            for(Person i : save) {

                System.out.println("name: "   + i.GetName());
                System.out.println("age: "    + i.GetAge());
                System.out.println("height: " + i.GetHeight());
            }
        } catch(Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
