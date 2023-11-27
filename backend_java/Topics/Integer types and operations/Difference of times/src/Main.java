import java.util.Scanner;

class Main {
    static final int SECS_IN_HOUR = 3600;
    static final int SECS_IN_MINUTE = 60;
    public static void main(String[] args) {
        int time1 = 0, time2 = 0;
        Scanner scanner = new Scanner(System.in);
        int hours = SECS_IN_HOUR * Integer.parseInt(scanner.nextLine());
        int minutes = SECS_IN_MINUTE * Integer.parseInt(scanner.nextLine());
        int seconds = Integer.parseInt(scanner.nextLine());
        time1 = hours + minutes + seconds;
        hours = SECS_IN_HOUR * Integer.parseInt(scanner.nextLine());
        minutes = SECS_IN_MINUTE * Integer.parseInt(scanner.nextLine());
        seconds = Integer.parseInt(scanner.nextLine());
        time2 = hours + minutes + seconds;

        int difference = time2 - time1;
        System.out.println(difference);
        scanner.close();
    }
}
