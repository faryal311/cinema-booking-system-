import java.util.Scanner;

public class Bookingsystem {
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private static char[][] seats = new char[ROWS][COLUMNS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeSeats();
        int choice;

        do {
            System.out.println("\n1. Display Seats");
            System.out.println("2. Book a Seat");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                displaySeats();
            } else if (choice == 2) {
                System.out.print("Enter row (0-4): ");
                int row = scanner.nextInt();
                System.out.print("Enter column (0-4): ");
                int column = scanner.nextInt();
                if (bookSeat(row, column)) {
                    System.out.println("Seat booked successfully!");
                } else {
                    System.out.println("Booking failed. Please try again.");
                }
            } else if (choice != 3) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        System.out.println("Exiting the system. Goodbye!");
        scanner.close();
    }

    private static void initializeSeats() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                seats[i][j] = 'O';
            }
        }
    }

    private static void displaySeats() {
        System.out.println("Seating Arrangement:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean bookSeat(int row, int column) {
        if (row >= 0 && row < ROWS && column >= 0 && column < COLUMNS) {
            if (seats[row][column] == 'O') {
                seats[row][column] = 'X';
                return true;
            }
        }
        return false;
    }
}
