/**
 * Created by valentina on 07.06.17.
 */
public class test {
    public static void main(String[] args) {
        System.out.println(count7(771237));
    }

    public static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int count7(int n) {
        int counter = 0;

        if(n < 10) {
            if(n == 7) {
                counter++;
                return counter;
            }
        }
        return  count7(n / 10);

    }


}
