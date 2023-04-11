public class Person {

    private double height;
    private double weight;
    private int age;

    public Person(double height, double weight, int age) {

        this.height = height;
        this.weight = weight;
        this.age    =    age;
    }

    public void Show() {

        System.out.println("height: " + height);
        System.out.println("weight: " + weight);
        System.out.println("age: "    +    age);
    }
}


