import java.util.Scanner;


public class func {

	public static void main(String[] args) {

		//out();

		// Scanner scanner = new Scanner(System.in);
		// int a = scanner.nextInt();
		// int b = scanner.nextInt();
		// System.out.println(sum(a, b));

		int[] arr = new int[]{1, 2, 3, 4, 5};
		System.out.println(sumArray(arr));
	}

	public static void out() {

		System.out.println("INFO");
	}

	public static int sum(int a, int b) {

		//System.out.printf("sum: %d\n", a + b);
		
		return a + b;
	}

	public static int sumArray(int[] arr) {

		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum += arr[i];

		return sum;
	}

}