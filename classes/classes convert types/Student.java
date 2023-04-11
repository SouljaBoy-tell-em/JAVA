import java.util.Scanner;

public class Student extends Person implements StudentIProgress {

    private int course;
    private String special;
    private double averageScore;
    private int[] marks;

    public Student(int course, String special, double height, double weight, int age) {

        super(height, weight, age);
        this.course = course;
        this.special = special;
        this.averageScore = 0;
    }

    @Override
    public void GetScore() {

        System.out.println("Score:");

        int i = 0;
        for(i = 0; i < this.marks.length; i++)
            System.out.println(marks[i]);

        System.out.println("Average score: " + this.averageScore);
    }

    @Override
    public int[] SetScore() {

        Scanner scanner = new Scanner(System.in);

        int[] marks = new int[amountSubjects];

        int i = 0;
        for(i = 0; i < marks.length; i++) {

            marks[i] = scanner.nextInt();
            averageScore += marks[i];
        }

        this.marks = marks;
        averageScore /= marks.length;

        return marks;
    }

    @Override
    public void Show() {

        super.Show();
        System.out.println("Course: " + course);
        System.out.println("Special: " + special);
        System.out.println("Average score: " + averageScore);
        System.out.println("Marks: " + marks);
    }
}
