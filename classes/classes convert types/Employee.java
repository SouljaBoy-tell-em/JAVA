public class Employee extends Person {

    private String JobTitle;
    private int experience;

    public Employee(String JobTitle, int experience, double height, double weight, int age) {

        super(height, weight, age);
        this.JobTitle   =   JobTitle;
        this.experience = experience;
    }
}
