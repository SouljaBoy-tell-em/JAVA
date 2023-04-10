public class Main {

	public static void main(String[] args) {


		// внутри какого-нибудь класса можно завести переменную,
		// которая будет общей для всех объектов данного класса и
		// при обращении к ней со стороны любого объекта будет
		// выдавать одно и то же число. Например, удобно использовать
		// для подсчета объектов данного класса (в С++ такое было);

		Person person1 = new Person();
		Person person2 = new Person();
		System.out.println(person1.count);
		System.out.println(person2.count);
		person1.count = 2;
		System.out.println(person1.count);
		System.out.println(person2.count);
		person2.count = 47;
		System.out.println(person1.count);
		System.out.println(person2.count);
		Person.count = 228; // можно менять и так;
		System.out.println(person1.count);
		System.out.println(person2.count);


		Person.GetCount(); // аналогично, как с переменными;

		final int a = 10; // final - то же, что и const в Си;
	}
}