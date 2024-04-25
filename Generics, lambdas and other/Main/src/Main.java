import functional_interfaces.*;
import package1.*;

import java.io.FileNotFoundException;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Random random = new Random();
//        long number = random.nextLong(999999 - 100000 + 1) + 100000;
//        System.out.println(number);

//        Date date = new Date();
//        System.out.println(date);

//        String PRINCIPAL = "Name: [105278787699199627838], Granted Authorities: [[ROLE_USER, SCOPE_https://www.googleapis.com/auth/userinfo.email, SCOPE_https://www.googleapis.com/auth/userinfo.profile, SCOPE_openid]], User Attributes: [{at_hash=8CF1W-dHTHKI1FHO8q1k4g, sub=105278787699199627838, email_verified=true, iss=https://accounts.google.com, given_name=Александр, nonce=ce--IPbGEB786LR2CIk1yNSG0bnx8eJAX9bpkyyDHAM, picture=https://lh3.googleusercontent.com/a/ACg8ocJRxs1r2649MuzQFp2r3wKStL4y_D-JORotfalgFMqmgtLmZQ=s96-c, aud=[219924000198-jtf0fqg1mscrj0d6ebmakj7vaao20ghl.apps.googleusercontent.com], azp=219924000198-jtf0fqg1mscrj0d6ebmakj7vaao20ghl.apps.googleusercontent.com, name=Александр Зайцев, exp=2024-04-15T21:36:02Z, family_name=Зайцев, iat=2024-04-15T20:36:02Z, email=zaithevalex@gmail.com}]";
//        Parse(PRINCIPAL);



//        try(FileInputStream outputStream = new FileInputStream("images.jpeg")) {
//            byte[] bytes = outputStream.readAllBytes();
//            for(int index = 0; index < bytes.length; index++)
//                System.out.print(bytes[index] + " ");
//        } catch (Exception exception) {
//            System.out.println(exception.getMessage());
//        }


//        System.out.println(SPEED.CAR.compareTo(SPEED.TRUCK));


//        Double number = Double.parseDouble("182.57");
//        System.out.println(number.byteValue());


        // автораспаковка
//        Integer a = 122;
//        int b = a;
//        out.println(a);
//        Foo();


//        Car car = new Car();
//        Vehicle track = new Track();
//        out.println(car instanceof Car);


//        String s1 = new String("Hello, world");
//        String s2 = s1;
//        s1 = new String("zzz");
//        out.println(s1);
//        out.println(s2);



//        Number<Integer> number1 = new Number<>(5);
//        Number<Double> number2 = new Number<>(6.0);
//        out.println(number1.getData());
//        out.println(number2.getData());




//        Number1<Double, String> number1 = new Number1<>(12.09, "Hello, world!");




//        Number1<Integer, String> number = new Number1<>(13, "Hello, world !");
//        Number1<Double, String> number1 = new Number1<>(12.0, "xxx");
//        System.out.println(number.isEqual(number1));


//        Gen<A> genA = new Gen<>(new B());
//        Gen<B> genB = new Gen<>(new B());
//        Gen<C> genC = new Gen<>(new C());
//        Gen<D> genD = new Gen<>(new D());

//        TEST(genA);
//        TEST(genB);
//        TEST(genC);
        // не скомпилируется
//        TEST(genD);

//        TEST1(genD);


//        Test2("data", "text", new B());
//        Test2("data", "text", new C());
        // ошибка компиляции из-за того, что D не наследуется от А
//        Test2("data", "text", new D());


        // низкоуровневые типы:

//        Number1 number1 = new Number1(12.0, "text");
//        System.out.println(number1.getData());

        // VAR-ы:
//        var number = new Number1<Double, String>(12.0, "text");
//        out.println(number.getData().intValue());



//        final int[] number = {1, 2};
//        out.println(Arrays.toString(number));
//        EasyOut sum = (x, y) -> {
//            x += number[0];
//            number[1] = 1;
//            // нельзя: т.к. number расценивается как final
//            // number++;
//            return x + y;
//        };
//
//        out.println(Arrays.toString(number));
//        EasyOut sub = (x, y) -> x - y;
//        sum.out(sum.sum(1, 2));
//        sum.out(sub.sum(1, 2));





//        Integer[] numbers1 = {1, 2, 3, 4};
//        EasyOut<Integer, Integer> easyOut = (numbers) -> {
//            int sum = 0;
//            for(int i = 0; i < numbers.length; i++)
//                sum += numbers[i];
//            return sum;
//        };
//
////        easyOut.out(numbers1[1]);
//        easyOut.out(easyOut.sum(numbers1));


//        // ссылки могут быть только на публичные методы:
//        // т.е. мы инициализируем метод, определенный в функциональным интерефейсе
//        // посредством передачи ссылки на метод, который возвращает то же значение
//        // и содержит те же параметры, что в передаваемом в ссылку методе.
//        FIString fiString = Integer::parseInt;
//
//        Integer number = fiString.intValue("22");
//        System.out.println(number.intValue());


        // но можно создать экземпляр класса и передать от него ссылку на метод:
//        Eclass eclass = new Eclass();
//        FIString fiString1 = eclass::lol;
//        out.println(fiString1.intValue("KDSMfmsdf"));



        // Когда необходимо передать не статичный метод:
//        FClass fClass = new FClass(18);
//        FInterface fInterface = FClass::getNumber;
//        fInterface.out(fInterface.number(fClass));


        // Лямбды и ссылки на конструктор:
        FClassConstructor fClassConstructor = FClass::new;
        FClass fclass = fClassConstructor.construct(221);
        out.println(fclass.getNumber());
    }

//    private static void Parse(String principal) {
//        Pattern pattern = Pattern.compile("given_name=(?<=\\=)(\\S+)(?=[^a-zA-Z0-9])");
//        Matcher matcher = pattern.matcher(principal);
//
//        if(matcher.find())
//            System.out.println(matcher.group(1).substring(0, matcher.group(1).length() - 1));
//
//        pattern = Pattern.compile("family_name=(?<=\\=)(\\S+[^,])(?=[^a-zA-Z0-9])");
//        matcher = pattern.matcher(principal);
//
//        if(matcher.find())
//            System.out.println(matcher.group(1));
//
//        pattern = Pattern.compile("email=(?<=\\=)([a-zA-Z@_.]+)(?=[^a-zA-Z0-9])");
//        matcher = pattern.matcher(principal);
//
//        if(matcher.find())
//            System.out.println(matcher.group(1).substring(0, matcher.group(1).length()));
//    }

    @MyAnno(Foo = "example")
    public static void Foo() {
        out.println("Hello, world !");
    }

    private static void TEST(Gen<? extends A> gen) {
        out.println("Hello, world !");
    }

    private static void TEST1(Gen<? super D> gen) {
        out.println("Hello, world !");
    }

    private static <T, V, U extends Object> void Test2(T data, V text, U gen) {
        out.println("DATA: " + data.toString());
        out.println("TEXT: " + text.toString());
    }

    private static void TEST3(int[] nums) {
        out.println("LENGTH: " + nums.length);
        nums[1] = -21;
    }
}