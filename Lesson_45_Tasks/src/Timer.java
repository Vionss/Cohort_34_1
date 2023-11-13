import java.util.Scanner;

public class Timer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter seconds");
        int sec = scanner.nextInt();
        startTimer(sec);




    }

    private static void startTimer(int sec) {
        for (int i = sec; i >= 0 ; i--) {
            System.out.println("Time left " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Timer is over");

    }
}
