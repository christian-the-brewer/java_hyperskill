package traffic;

import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    TrafficLight trafficLight = TrafficLight.setupSystem(scanner);
    TrafficLight.menuSystem(trafficLight, scanner);

  }

  public static void clearScreen() {
    try {
      var clearCommand = System.getProperty("os.name").contains("Windows")
              ? new ProcessBuilder("cmd", "/c", "cls")
              : new ProcessBuilder("clear");
      clearCommand.inheritIO().start().waitFor();
    }
    catch (IOException | InterruptedException e) {}
  }

}
