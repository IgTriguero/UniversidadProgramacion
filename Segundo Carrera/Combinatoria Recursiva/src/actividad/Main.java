package actividad;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca n -- ");
		int n = sc.nextInt();
		System.out.println(fibonacci(n));
	}

	public static int fibonacci(int n) {
		if (n <= 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
