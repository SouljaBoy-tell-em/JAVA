public class Main {
  
    public static void main(String[] args) {

        Person person = new Person("Player");
        System.out.println(person.hashCode()); // некоторый хэш объекта.
                                               // но можно придумать и свою хэш-функцию:
                                               // для этого нужно определить метод hashCode в классе;

        System.out.println(person.toString()); // представление объекта в виде строки;
                                               // опять же, если нужно придумать так, как нам хочется
                                               // то определяем метод toString() в классе;
    }
}
