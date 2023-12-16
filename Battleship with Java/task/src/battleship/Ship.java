package battleship;

public class Ship {

    //ships need to have the parts of their ship in an array of size ship length
    private int shipLength;
    private String[] shipSections;
    private int[] userCoordinates;

    public Ship(int shipLength, int[] userCoordinates) {
        this.shipLength = shipLength;
        this.shipSections = new String[shipLength];
        this.userCoordinates = userCoordinates;
    }

    public void printSections() {
        calculateSections();
        System.out.println("Parts:");
        for (String section : shipSections) {
            System.out.print(" " + section);
        }

    }

    //fills array shipSections with coord of each section
    public void calculateSections() {
        String x, y;
        int subtractionModifier;

        if (userCoordinates[0] == userCoordinates[2]) {
            //ship lies along x-axis
            //check if ship is running right to left
            subtractionModifier = (userCoordinates[1] > userCoordinates[3]) ?
                    -1 : 1;
            for (int i = 0; i < shipLength; i++) {
//                y = Integer.toString(userCoordinates[0]);
                y = String.valueOf((char) (userCoordinates[0] + 64));
                x = Integer.toString(userCoordinates[1] + (i * subtractionModifier));
//                x = (char) (userCoordinates[1] + (i * subtractionModifier) + 48);
                shipSections[i] = String.valueOf(y) + String.valueOf(x);
                System.out.println(shipSections[i]);
            }
        } else {
            //ship lies along y-axis
            subtractionModifier = (userCoordinates[0] > userCoordinates[2]) ?
                    -1 : 1;
            for (int i = 0; i < shipLength; i++) {
//                y = Integer.toString(userCoordinates[0] + (i * subtractionModifier) + 64);
                y = String.valueOf((char) (userCoordinates[0] + (i * subtractionModifier) + 64));
                x = Integer.toString(userCoordinates[1]);

//                x = (char) (userCoordinates[1] + 48);
                shipSections[i] = String.valueOf(y) + String.valueOf(x);
                System.out.println(shipSections[i]);
            }
        }
    }
}




//