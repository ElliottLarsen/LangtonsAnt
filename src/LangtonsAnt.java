import java.util.Arrays;
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
        Ant ant = new Ant(board_size, ant_row, ant_column, ant_orientation, steps);
        ant.run_simulation();
    }
}

class Ant {
    int board_size, ant_row, ant_column, ant_orientation, steps;
    char ant_board[][];
    int step_counter = 0;

    Ant(int bs, int ar, int ac, int ao, int st) {
        board_size = bs;
        ant_row = ar;
        ant_column = ac;
        ant_orientation = ao;
        steps = st;
        ant_board = new char[board_size][board_size];
    }

    void draw_board() {
        // Draw the board based on the input.
        for (int i = 0; i < ant_board.length; i++) {
            Arrays.fill(ant_board[i], '-');
        }
        // Place the ant on the board.
        ant_board[ant_row][ant_column] = 'A';
    }

    void if_wrap() {
        // If the ant needs to wrap to the other side of the board, recalculate the row or column.
        if (ant_row >= board_size) {
            ant_row = ant_row % board_size;
        } else if (ant_column >= board_size) {
            ant_column = ant_column % board_size;
        } else if (ant_row < 0) {
            ant_row = ant_row + board_size;
        } else if (ant_column < 0) {
            ant_column = ant_column + board_size;
        }
    }

    void move_up() {
        // Move the ant up a space.
        step_counter += 1;
        if (ant_board[ant_row][ant_column] != '*') {
            ant_board[ant_row][ant_column] = '*';
            ant_orientation += 1;
            ant_column += 1;
            this.if_wrap();
        } else {
            ant_board[ant_row][ant_column] = '-';
            ant_orientation -=1 ;
            ant_column -= 1;
            this.if_wrap();
        }
    }

    void move_down() {
        // Move the ant down a space.
        step_counter += 1;
        if (ant_board[ant_row][ant_column] != '*') {
            ant_board[ant_row][ant_column] = '*';
            ant_orientation += 1;
            ant_column -= 1;
            this.if_wrap();
        } else {
            ant_board[ant_row][ant_column] = '-';
            ant_orientation -= 1;
            ant_column += 1;
            this.if_wrap();
        }
    }

    void move_right() {
        // Move the ant to right.
        step_counter += 1;
        if (ant_board[ant_row][ant_column] != '*') {
            ant_board[ant_row][ant_column] = '*';
            ant_orientation += 1;
            ant_row += 1;
            this.if_wrap();
        } else {
            ant_board[ant_row][ant_column] = '-';
            ant_orientation -= 1;
            ant_row -= 1;
            this.if_wrap();
        }
    }

    void move_left() {
        // Move the ant to left.
        step_counter += 1;
        if (ant_board[ant_row][ant_column] != '*') {
            ant_board[ant_row][ant_column] = '*';
            ant_orientation += 1;
            ant_row -= 1;
            this.if_wrap();
        } else {
            ant_board[ant_row][ant_column] = '-';
            ant_orientation -= 1;
            ant_row += 1;
            this.if_wrap();
        }
    }

    void print_board() {
        // Print the final board.
        for (int i = 0; i < board_size; i++) {
            String row = Arrays.toString(ant_board[i]).replace("[", "").replace("]", "").replace(", ", "");
            System.out.println(row);
        }
    }

    void run_simulation() {
        // Start and run the simulation.
        this.draw_board();
        while (step_counter < steps) {
            if (steps == 0) {
                this.print_board();
                return;
            } else if (ant_orientation % 2 == 0 && ant_orientation % 4 == 0) {
                this.move_up();
            } else if (ant_orientation % 2 == 0 && ant_orientation % 4 == 2) {
                this.move_down();
            } else if (ant_orientation % 4 == 1) {
                this.move_right();
            } else if (ant_orientation % 4 == 3) {
                this.move_left();
            }
        }
        ant_board[ant_row][ant_column] = 'A';
        this.print_board();
    }
}
