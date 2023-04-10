public abstract class Transport { // abstract - ключевое слово для определения абстрактного класса.
								  // Теперь мы не можем создать класс Transport в чистом виде,
	private double speed, weight; // но можем создать наследника этого класса.
	private String color;

	public Transport(double speed, double weight, String color) {

		this.speed  =  speed;
		this.weight = weight;
		this.color  =  color;
	}

	public Transport() {

		this.speed  =      0;
		this.weight =      0;
		this.color  = "none";
	}

	public void Show() {

		System.out.println("INFO:");
		System.out.printf("speed: %.1f\n",   speed);
		System.out.printf("weight: %.1f\n", weight);
		System.out.println("color: "  +      color);
	}

	public void Reset(double speed, double weight, String color) { // reset values;

		this.speed  =  speed;
		this.weight = weight;
		this.color  =  color;
	}


	// абстрактный метод: нужно описать только прототип в родительском классе,
	// потому что нет смысла описывать их, так как они никогда не будут использованы.
	public abstract void ShowSpeed(double speed);

	// вложенный класс нужен для описания какой-то части внешнего класса.
	class Engine { // двигатель

		private boolean isReady; // готовность двигателя;
		private int km; // пробег двигателя;

		public void SetValues(boolean isReady, int km) {

			this.isReady = isReady;
			this.km      =      km;
		}


		public void Info() {

			if(isReady)
				System.out.println("Engine is working now.");
			else
				System.out.println("Engine isn't working now. It went already " + km);
		}


		public void isReady(boolean isReady) {

			this.isReady = isReady;
		}
	}
}