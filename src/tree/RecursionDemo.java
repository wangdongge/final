package tree;

public class RecursionDemo {
    public static int factorial(int n){
        if (n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static int fb(int n){
        if (n == 1|| n == 2){
            return 1;
        }
        return fb(n - 1)+fb(n - 2);
    }

    public static void main(String[] args) {
        int result = factorial(3);
        System.out.println(result);
    }

}
