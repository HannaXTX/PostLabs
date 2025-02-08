package Training;

public class Recursion {

    public static void main(String[] args) {

        System.out.println(factorial(0));
        System.out.println(exponentX(3));
        System.out.println(fibonacci(5));


    }


    public static int factorial(int n) { // n instances are pushed to stack
        if (n < 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static int exponentX(int n) { //
        if (n < 1)
            return 1;
        return 2*exponentX(n-1);

    }
    public static int fibonacci(int n) { //
        if (n < 1)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);

    }


}
