public class Main {
    public static void main(String[] args) {

        Calculate calculate1;
        Calculate calculate2;
        Calculate calculate3;

        calculate1 = (x, y) -> x + y; // фактически реализуем функцию: int calculate(x, y) { return x + y;}
        calculate2 = (x, y) -> x - y;
        calculate3 = (x, y) -> x * y;

        System.out.println("x + y: " + calculate1.calculate(10, 20));
        System.out.println("x - y: " + calculate2.calculate(10, 20));
        System.out.println("x * y: " + calculate3.calculate(10, 20));

        // в лямбда выражении можно обойтись и без параметров. Например:
//        Calculate calculate4;
//        calculate4 = ()-> 100 + 1;

        // если используется только 1 параметр, то скобки можно опустить:
//        Calculate calculate5;
//        calculate5 = x -> x * x;

        // Терминальные лямбды, которые не возвращают никакого значения:
        Printable printable;
        printable = string->System.out.println(string);
        printable.printable("LOL");


        // Лямбды с условием:
//        Divide divide = (x, y) -> {
//
//            if (y == 0)
//                return x;
//
//            else
//                return x / y;
//        };
//
//        System.out.println("x, y != 0; x / y : " + divide.divide(96, 12));
//        System.out.println("x, y == 0; x / y : " + divide.divide(96, 0));


        // Лямбда + Generic:
        CalculateGeneric<Integer> calculateGeneric1 = (x, y) -> x + y;
        System.out.println("GENERIC: x + y : " + calculateGeneric1.calculateGeneric(10, 20));

    }

    interface Calculate {

        int calculate(int x, int y);
    }

    interface Printable {

        void printable(String string);
    }

    interface Divide {

        int divide(int x, int y);
    }

    interface CalculateGeneric<T> {

        T calculateGeneric(T x, T y);
    }
}
