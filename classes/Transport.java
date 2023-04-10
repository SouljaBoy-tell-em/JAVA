public class Transport {

	private float speed, weight;
	private String color;
	private byte[] coordinate;


	Transport(float m_speed, float m_weight, String m_color, byte[] m_coordinate) {

		this.speed  =  m_speed; // this - объект класса, к которому применяется конструктор и другие методы;
		this.weight = m_weight;
		this.color  =  m_color;

		this.coordinate = m_coordinate;
	}

	public void Show() {

		System.out.println("speed: "  +  speed);
		System.out.println("weight: " + weight);
		System.out.println("color: "  +  color);

		for(int i = 0; i < coordinate.length; i++)
			System.out.printf("coord%d: %d\n", i + 1, coordinate[i]);
	}
}