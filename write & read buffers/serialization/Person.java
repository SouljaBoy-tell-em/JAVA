import java.io.Serializable;

public class Person implements Serializable { // нужно наследоваться от интерфеса Serializable !
    private int age;
    private String name;
    private transient double height; // transient - исключение из сериализации. Не будет сериализовываться
    public Person() {

        this.age    =      0;
        this.name   = "none";
        this.height =    0.0;
    }
    public Person(int age, String name, double height) {

        this.age    =    age;
        this.name   =   name;
        this.height = height;
    }

    public void GetPerson() {

        System.out.println("age: "  + this.age);
        System.out.println("name: " + this.name);
    }
    public String GetName() {return  this.name;}
    public int GetAge() {return this.age;}

    public double GetHeight() {return this.height;}
}
