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

    public void setNumberOfRoads(int numberOfRoads) {
        this.numberOfRoads = numberOfRoads;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    static void setupSystem(Scanner scanner) {
        System.out.println("Welcome to the traffic management system!");
        System.out.println("Input the number of roads: ");
        int roads = scanner.nextInt();
        System.out.println("Input the interval: ");
        int interval = scanner.nextInt();

        TrafficLight trafficLight = new TrafficLight(roads, interval);
    }
}
