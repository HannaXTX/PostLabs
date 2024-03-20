package Labs.Lab1;

import java.util.Scanner;

public class recursion {
	public static void main(String[] args) {
		System.out.println("Please enter number");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int power = 3;

		drag(n);
		
		System.out.println();
		System.out.println("\n" + power(n, power));
		System.out.println("\n" + tailpower(n, power));
		System.out.println(letterCounter("Java", 'a', 0));
		System.out.println(sumdigits(124));
		long time =System.currentTimeMillis();
		System.out.println(tailSumdigits(Integer.MAX_VALUE, 0));
		System.out.println(System.currentTimeMillis()-time);
	System.out.println(sumofsumdigit(88888));
	}

	public static void drag(int n) {
		if (n >= 0) {
			drag(n - 1);
			System.out.print(n + " ");
		}

	}

	public static int power(int n, int power) {
		if (power < 1)
			return 1;
		return n * (power(n, power - 1));
	}

	public static int tailpower(int n, int power) {
		return tailpower(n, power, 1); // HELPER METHOD INVOKED
	}

	private static int tailpower(int n, int power, int res) { // HELPER METHOD
		if (power == 0)
			return res;

		return (tailpower(n, power - 1, res * n));
	}

	public static int letterCounter(String s, char letter) {
		if (s.length() < 1)
			return 0;
		return letterCounter(s, letter, 0);
	}

	private static int letterCounter(String s, char letter, int start) {
		if (start == s.length())
			return 0;

		return letter == s.charAt(start) ? 1 + letterCounter(s, letter, ++start) : letterCounter(s, letter, ++start);
	}

	public static int sumdigits(int n) {
		if (n < 1) {
			return 0;
		} else {
			return n % 10 + sumdigits(n / 10);
		}
	}

	public static int tailSumdigits(int n, int res) {
		if (n < 1) {
			return res;
		} else {

			return tailSumdigits(n / 10, res + (n % 10));
		}
	}
	public static int sumofsumdigit(int n){
		if (n < 10)
			return n;
		
		return sumofsumdigit(n%10 +sumofsumdigit(n/10));
	
	}

	public static String reverseText(String text) {
		String[] array = text.split(" ");

		if (array.length < 1)
			return text;

		return array[array.length - 1]+ " " +reverseText(text.substring(0, text.lastIndexOf(' ')));
	}
}
