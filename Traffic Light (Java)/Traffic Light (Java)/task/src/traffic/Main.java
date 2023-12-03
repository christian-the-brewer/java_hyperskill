package traffic;

import java.util.Scanner;

public class Main {
  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);
    TrafficLight trafficLight = TrafficLight.setupSystem(scanner);
    TrafficLight.menuSystem(trafficLight, scanner);

  }
}
