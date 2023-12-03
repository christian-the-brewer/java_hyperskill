package traffic;

import java.util.Scanner;

public class TrafficLight {
    private int numberOfRoads, interval;

    public TrafficLight(int numberOfRoads, int interval) {
        this.numberOfRoads = numberOfRoads;
        this.interval = interval;
    }

    public int getNumberOfRoads() {
        return numberOfRoads;
    }

    public int getInterval() {
        return interval;
    }

    public void setNumberOfRoads(int roads) {
        this.numberOfRoads = roads;
    }

    public void incrementRoads(int value) {
        this.numberOfRoads += value;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    static TrafficLight setupSystem(Scanner scanner) {
        System.out.println("Welcome to the traffic management system!");
        System.out.println("Input the number of roads: ");
        int roads = scanner.nextInt();
        System.out.println("Input the interval: ");
        int interval = scanner.nextInt();

        return new TrafficLight(roads, interval);
    }

    static void menuSystem(TrafficLight trafficLight, Scanner scanner) {
        boolean menuOpen = true;
        while (menuOpen) {
            System.out.println("Menu:\n1. Add road\n2. Delete road\n3. Open System\n0. Quit");
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    trafficLight.incrementRoads(1);
                    System.out.println("Road added");
                    break;
                case 2:
                    trafficLight.incrementRoads(-1);
                    System.out.println("Road deleted");
                    break;
                case 3:
                    System.out.println("System opened");
                    break;
                case 0:
                    menuOpen = false;
                    System.out.println("Bye!");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + userInput);
            }
        }
    }
}
