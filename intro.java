import java.util.Scanner; // импорт "библиотеки", как в Си #include <...>
import java.util.ArrayList;


public class intro { // соответствует названию класса;

    public static void main(String[] args) { // main-function
        
        /*

        System.out.println("The 1st project"); //
        System.out.print("sdfs");
        System.out.println();
        System.out.println();

        */



        /*

        int age = 21; // создание переменных, также как в Си;
        System.out.println(age);
        age = 23;
        System.out.print(age);

        */



        /*

        int age = 12;
        System.out.println("Age: " + age);

        byte num = 127; // для этого типа данных 1 байт;
        
        */
        
        // float, double - работают также;
        //float a1 = 123.123f;
        //double a2 = 12.2312; // можно и так: a2 = 12.2312f;
        //System.out.printf("a2 = %.2f", a2);

        /* символьный тип
        
        char ch = '4';
        System.out.println(ch);

        */



        /*

        String name = "Alexander Ivan";
        System.out.println(name);

        boolean isFlag = true;
        System.out.println(isFlag);

        */



        // Класс Scanner импортировали в шапке;
        // Scanner способен считывать из консоли;
        // System.in - ввод с консоли;
        /*
        Scanner object = new Scanner(System.in);
        String str = object.nextLine(); // считать строку методом nextLine();
        System.out.println("object: " + str);
        //System.out.printf("object: %s\n", str);
        */



        /*

        Scanner object = new Scanner(System.in);
        int num = object.nextInt(); // nextInt() - метод для ввода чисел;
        System.out.println("object: " + num);
    
        */



        /*

        int num1 = 50, num2 = 12, res;
        res = num1 / num2;
        System.out.println(res);
        res += 7;
        System.out.println(res);
        res++;
        System.out.println(res);

        */



        // условные конструкции - также как в Си; (if/else/else if)
        // если одна строчка после условия, то можно не использовать фигурные скобки;
        // || - или и && - и работают также. Условия такие же как в СИ; все так же.



        /*
    
        Scanner object = new Scanner(System.in);
        String str = object.nextLine();
        System.out.println(str);

        if(str.equals("Admin")) // метод equals может сравнивать две строки;
            System.out.println("Yes");

        */

        // switch-case - работает опять же точно также, как В Си;




        /*

        // calculator:

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input 1st number: ");
        float value1 = scanner.nextFloat();
        System.out.print("Input 2nd number: ");
        float value2 = scanner.nextFloat();

        System.out.print("Input sign: ");
        char sign = scanner.next().charAt(0); // метод charAt(index) считывает символ из потока;
                                              // index - символ из потока; 
        
        System.out.println("result: ");
        switch(sign) {

            case '+':
                System.out.println(value1 + value2);
                break;

            case '-':
                System.out.println(value1 - value2);
                break;

            case '*':
                System.out.println(value1 * value2);
                break;

            case '/':
                System.out.println(value1 / value2);
                break;

            default:
                System.out.println("So operaton not found.");
        }

        */



        // циклы такие же как в С++;

        /*

        int i = 0;
        for(i = 0; i < 5; i++)
            System.out.print(i + " ");
        System.out.println();

        */

        /*

        int i = 0;
        while (i < 5) {

            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        */

        /*

        int i = 10;
        do {        // выполняется минимум 1 раз (цикл с пост-условием);

            System.out.print(i + " ");
            i++;
        } while(i < 5);
        System.out.println();

        */

        // break, continue - присуствуют также, как и в СИ;
        // break - выход из внешнего цикла, при встрече слова break;
        // continue - пропуск оставшейся части внешнего цикла, при встрече continue;



        /*

        int[] array = new int[5]; // создание массива; 
                                  // по умолчанию заполняется нулями;
        for(int i = 0; i < 5; i++)
            System.out.print(array[i] + " ");
        System.out.println();


        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 5; i++)
            array[i] = scanner.nextInt();

        for(int i = 0; i < array.length; i++) // length - свойство, для того, чтобы
                                              // узнать длину массива array;
            System.out.printf("array[%d] = %d\n", i, array[i]);

        */



        /*

        float array[] = new float[] {1f, 2f, 3.1f};
        for(int i = 0; i < array.length; i++)
            System.out.printf("array[%d] = %.0f\n", i, array[i]);

        */



        /*

        Scanner scanner = new Scanner(System.in);

        char[][] symbols = new char[5][5];
        for(int i = 0; i < symbols.length; i++)
            for(int j = 0; j < symbols.length; j++)
                symbols[i][j] = scanner.next().charAt(0);

        for(int i = 0; i < symbols.length; i++) {

            for(int j = 0; j < symbols.length; j++)
                System.out.print(symbols[i][j] + " ");
            System.out.println();
        }

        */



        /*

        // class ArrayList - как vector в С++;
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(812);
        numbers.add(2014);

        for(Integer i : numbers) { // перебор коллекции numbers;

            System.out.println(i);
        }

        System.out.println();
        numbers.add(1, 47); // add(index, number);
                            // index - индекс элемента ArrayList;
                            // number - число, которое ставим по этом индексу в ArrayList;
                            // число, которое стояло по этому индексу, сместилось на индекс вперед;

        for(Integer i : numbers)
            System.out.println(i);

        // узнать размер коллекции: numbers.size(); метод size();
        System.out.println("size: " + numbers.size());

        // получить доступ к элементу коллекции: numbers.get(index); метод get(index);
        // index - индекс элемента коллекции;
        System.out.println("size: " + numbers.get(3)); // получили 2014;


        // удаление элементов из коллекции: numbers.remove(index); метод remove(index);
        // index - индекс элемента коллекции, который хотим удалить;

        numbers.remove(2);  // удалилось 812;
        System.out.println();

        for(Integer i : numbers)
            System.out.println(i);

        // очистка всего списка: numbers.clear(); метод clear();

        numbers.clear();
        System.out.println("After clear: ");

        for(Integer i : numbers)
            System.out.println(i);

        */


        

    }
}
