public class Truck extends Transport {

	private boolean isLoaded;
	public Engine engine = new Engine(); // нерабочий двигатель, truck проехал 10^6 км.

	public Truck(double speed, double weight, String color) {

		super(speed, weight, color);
	}


	public Truck(double speed, double weight, String color, boolean isLoaded) {

		super(speed, weight, color);
		this.isLoaded =    isLoaded;
	}

	public Truck() {

		super();
	}

	@Override // переопределение функции из родительского класса. То же самое, что virtual в С++.
	public void Show() {

		super.Show();

		if(isLoaded)
			System.out.println("loaded: yes");
		else
			System.out.println("loaded: no");
	}


	//@Override - нельзя, так как для одного и того же переписанного метода, 
	//            должно быть одинаковое количество параметров.
	public void Reset(double speed, double weight, String color, boolean isLoaded) {

		super.Reset(speed, weight, color);
		this.isLoaded = isLoaded;
	}


	public void SetLoaded(boolean isLoaded) {

		this.isLoaded = isLoaded;
	}


	// нужно реализовывать все абстрактные методы абстрактного класса. Поэтому:
	@Override
	public void ShowSpeed(double speed) {

		System.out.println("Object speed: " + speed);
	}
}