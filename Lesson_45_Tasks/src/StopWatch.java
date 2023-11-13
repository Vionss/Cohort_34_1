import java.util.Scanner;

public class StopWatch {
    private static boolean isRunning;
    private static long start;

    public static void main(String[] args) {
        boolean isRunning;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Start/Stop");
            String command = scanner.nextLine();
            if ("start".equalsIgnoreCase(command)) {
                startTimer();
            }else if("stop".equalsIgnoreCase(command)){
                stopTimer();
            }else if("exit".equalsIgnoreCase(command)){
                break;
            }else {
                System.out.println("Wrong command");

            }
        }
        scanner.close();

    }

    private static void startTimer() {
        if (!isRunning) {
            start = System.currentTimeMillis();
            isRunning = true;
            System.out.println("Stopwatch has started");
        }else {
            System.out.println("Stopwatch is running");
        }

    }

    public static void stopTimer() {
        if (isRunning) {
            long stop = System.currentTimeMillis();
            long result = stop - start;
            isRunning = false;
            System.out.println("StopWatch stoped " + result/1000 + "sec");
        }else {
            System.out.println("Stopwatch not working");
        }
    }

}
