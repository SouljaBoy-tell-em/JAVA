public class Main {

	public static void main(String[] args) {

		

		// Car car = new Car(240.2f, 1400f, "green");
		// car.Show();

		// Truck track = new Truck(120.1f, 10500.7f, "white");
		// track.Show();
		// track.SetLoaded(true);
		// track.Show();

		// track.Reset(100f, 13999.1f, "red"); // вызывается из родительского класса;
		// track.Show();

		// track.Reset(100f, 13999.1f, "blue", false); // вызывается из класса-наследника;
		// track.Show();

		


		// если класс абстрактный, то так делать нельзя:
		// Transport car = new Transport(240.2f, 1400f, "green");
		// но можно:
		// Transport car = new Car(240.2f, 1400f, "green"); // равносильно Car car = new Car(...);
		// car.Show();
		// car.ShowSpeed(21);


		/*

		Car bmw = new Car(240.2f, 1400f, "green");
		bmw.engine.SetValues(false, 2000);
		bmw.engine.Info();

		Truck truck = new Truck(100f, 13999.1f, "red");
		truck.engine.SetValues(true, 500);
		truck.engine.Info();

		*/


		// // Анонимный класс: если мы создаем объект и этот объект обладает чем-то особенным и 
		// // таких объектов программе немного(как правило 1), то можно использовать анонимный класс,
		// // т.е. создать какой-то особенный метод прям в main-е.
		// Car car = new Car(240.2f, 1400f, "green") {

		// 	@Override
		// 	public void ShowSpeed(double speed) {

		// 		super.ShowSpeed(speed);
		// 		this.engine.isReady(true);
		// 		System.out.println("Special object");
		// 	}
		// };

		// car.ShowSpeed(228f);


		Car car = new Car(240.2f, 1400f, "green");
		car.SetLight(true);
		car.BlinkLight();
	}
}
