public final class Person { // final перед class - класс Person не может иметь наследников;

	public static int count; // можно использовать и private
							 // но тогда придется обращаться через
							 // функции-члены, но при этом count
							 // общий для всех;

	public static void GetCount() { // то же самое, что и с переменными;
									// статичные методы могут работать только
									// с статичными полями;

		System.out.println("Count: " + count);
	}

	final public static void info(String word) { // этот метод нельзя переопределить
												 // в классах наследниках;
		System.out.println("word: " + word);
	}
}