import java.util.Random;
import java.util.Scanner;

public class MineSweeper {   // We create the class called Minesweeper.      // Değerlendirme 5
    String[][] board;        // We determine the variables.
    String[][] revealedBoard;
    boolean[][] mines;
    boolean[][] openedPoints;
    int mineCount;
    int rowCount;
    int columnCount;
    int openedPointCount;

    public MineSweeper() {         // We create a constructor method that initializes variables.
        this.mineCount = 0;
        this.rowCount = 0;
        this.columnCount = 0;
        this.openedPointCount = 0;
    }

    public void createBoard() {     // We write our method that creates the game board.     // Değerlendirme 7
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        rowCount = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        columnCount = scanner.nextInt();

        while (rowCount < 2 || columnCount < 2) {
            System.out.println("Error: The number of rows and columns must be at least 2!");
            System.out.print("Enter the number of rows: ");
            rowCount = scanner.nextInt();

            System.out.print("Enter the number of columns: ");
            columnCount = scanner.nextInt();
        }

        this.board = new String[rowCount][columnCount];   // We initialize the arrays for the game board.
        this.revealedBoard = new String[rowCount][columnCount];
        this.mines = new boolean[rowCount][columnCount];
        this.openedPoints = new boolean[rowCount][columnCount];

        mineCount = rowCount * columnCount / 4;       // Değerlendirme 8
        Random random = new Random();
        for (int i = 0; i < mineCount; i++) {
            int randomRow, randomColumn;
            do {
                randomRow = random.nextInt(rowCount);
                randomColumn = random.nextInt(columnCount);
            } while (mines[randomRow][randomColumn]);

            mines[randomRow][randomColumn] = true;
        }
    }

    public void showBoard() {                           //We create a method to show the board to the user.
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (openedPoints[i][j]) {  // If there is a mine, it is indicated by the character '*', otherwise '-'.
                    System.out.print((mines[i][j] ? "* " : revealedBoard[i][j] + " "));
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean makeMove(int row, int column) {// We create the method that starts the game.     //Değerlendirme 6
        if (row < 0 || row >= rowCount || column < 0 || column >= columnCount) {              // Değerlendirme 10
            System.out.println("Error: Selected coordinates are out of bounds. Please choose valid coordinates.");
            return true;
        }

        if (openedPoints[row][column]) {
            System.out.println("This coordinate has already been selected. Please choose another coordinate.");
            return true;
        }

        openedPoints[row][column] = true;

        if (mines[row][column]) {                     // Değerlendirme 13
            showBoard();
            System.out.println("You hit a mine! You lost the game.");  // Değerlendirme 15
            return false;
        } else {
            int mineCount = countMines(row, column);
            revealedBoard[row][column] = String.valueOf((mineCount > 0) ? (char) (mineCount + '0') : '0');

            openedPointCount++;

            if (openedPointCount == (rowCount * columnCount) - mineCount) {     // Değerlendirme 14
                showBoard();                                                    // Değerlendirme 15
                System.out.println("Congratulations! You revealed all the points. You won the game!");
                return false;
            }

            return true;
        }
    }
    private int countMines(int row, int column) {   // We create the method that finds and collects mines around a cell.
        int mineCount = 0;
        for (int i = -1; i <= 1; i++) {                     // Değerlendirme 12
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newColumn = column + j;
                if (0 <= newRow && newRow < rowCount && 0 <= newColumn && newColumn < columnCount) {
                    if (mines[newRow][newColumn]) {
                        mineCount++;
                    }
                }
            }
        }
        return mineCount;
    }

    public static void run() {       // We run the game in this method.
        System.out.println("Welcome to the Minesweeper Game!");
        MineSweeper mineSweeper = new MineSweeper();
        mineSweeper.createBoard();

        Scanner scanner = new Scanner(System.in);
        boolean continueGame = true;

        while (continueGame) {
            System.out.println("=======================");
            System.out.println();
            mineSweeper.showBoard();
            System.out.println("=======================");

            System.out.print("Select a row: ");                   // Değerlendirme 9
            int selectedRow = scanner.nextInt();

            System.out.print("Select a column: ");
            int selectedColumn = scanner.nextInt();

            continueGame = mineSweeper.makeMove(selectedRow, selectedColumn);    // Değerlendirme 11
        }
        System.out.println();

        mineSweeper.showMinedBoard();
    }

    public void showMinedBoard() {    //We create a method for the mined board that we will show at the end of the game.
        System.out.println("Board with Mines:");
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.print((mines[i][j] ? "* " : "- "));
            }
            System.out.println();
        }
    }
}
