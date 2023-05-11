import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager store = new Manager();
        store.Run();
        store.Fill_cart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter amount payed");
        double x = scanner.nextDouble();

        store.MakeOrder(x);

    }
}