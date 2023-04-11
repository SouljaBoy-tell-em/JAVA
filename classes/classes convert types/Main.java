public class Main {
  
    public static void main(String[] args) {

//        Number number = new Number(100);
//        System.out.println(number.getNumber());
//
//        Initialize(number);
//        System.out.println(number.getNumber());


        Object student = new Student(2, "programming", 187, 66, 20);

        if(student instanceof Person) {

            Person person  = (Person) student;
            ((Person)person).Show();
            System.out.println("Class Student can be inctanced to Person");
            //System.out.print("\n\n\nSTUDENT: ");
            // ((Student)student).Show();
        }

        else if(student instanceof Employee) {

            System.out.println("Class Student can't be instanced to Employee");
        }

    }

    public static void Initialize(Number p) {

        p = new Number(12);
        p.number = 32;
    }

    public static void Initialize(Integer p) {

        p = 32;
    }

    public static void Initialize(String p) {

        p = "HELLO";
    }
}
