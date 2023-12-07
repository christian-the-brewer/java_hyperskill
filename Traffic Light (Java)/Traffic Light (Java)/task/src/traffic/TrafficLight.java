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
        int roads = 1, interval = 1;
        System.out.println("Welcome to the traffic management system!");
        System.out.println("Input the number of roads: ");
        while (true) {
            try {
                roads = scanner.nextInt();
                if (roads > 0) {
                    break;
                } else {
                    System.out.println("Error! Incorrect Input. Try again: ");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error! Incorrect Input. Try again: ");
                scanner.nextLine();
            }
        }
        System.out.println("Input the interval: ");
        while (true) {
            try {
                interval = scanner.nextInt();
                if (interval > 0) {
                    break;
                } else {
                    System.out.println("Error! Incorrect Input. Try again: ");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error! Incorrect Input. Try again: ");
                scanner.nextLine();
            }
        }
        return new TrafficLight(roads, interval);
    }

    static void menuSystem(TrafficLight trafficLight, Scanner scanner) {
        boolean menuOpen = true;
        int userInput;
        String buffer;
        while (menuOpen) {
            System.out.println("Menu:\n1. Add road\n2. Delete road\n3. Open System\n0. Quit");
            try {
                userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        trafficLight.incrementRoads(1);
                        System.out.println("Road added");
                        buffer = scanner.nextLine();
                        break;
                    case 2:
                        trafficLight.incrementRoads(-1);
                        System.out.println("Road deleted");
                        buffer = scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("System opened");
                        buffer = scanner.nextLine();
                        break;
                    case 0:
                        menuOpen = false;
                        System.out.println("Bye!");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + userInput);
                }
            } catch (Exception e) {
                System.out.println("Incorrect option");
                buffer = scanner.nextLine();

            }
            scanner.nextLine();

        }
    }
}
