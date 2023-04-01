import java.util.Scanner;

public class LangtonsAnt {
    public static void main(String[] args) {
        int board_size, ant_row, ant_column, ant_orientation, steps;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Langton's Ant!");
        System.out.println("Please enter a number for the size of the square board: ");
        board_size = scanner.nextInt();
        System.out.println("Please enter a number as the starting row number for the ant where 0 is the first row from the top: ");
        ant_row = scanner.nextInt();
        System.out.println("Please enter a number as the starting column number for the ant where 0 is the first column from the left: ");
        ant_column = scanner.nextInt();
        System.out.println("Please enter a number as the starting oriencation of the ant where 0 is up, 1 is right, 2 is down, and 3 is left: ");
        ant_orientation = scanner.nextInt();
        System.out.println("Lastly, please enter the number of steps the ant will take for this simulation: ");
        steps = scanner.nextInt();

        if (ant_row > board_size || ant_column > board_size || ant_orientation < 0 || ant_orientation > 3 || steps < 0) {
            System.out.println("Incorrect input received.  Exiting the program...");
            return;
        }

        // Create ant here.

    }
}

class Ant {

}
