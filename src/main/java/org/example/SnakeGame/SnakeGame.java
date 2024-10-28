package org.example.SnakeGame;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static final char EMPTY = ' ';
    private static final char SNAKE = 'O';
    private static final char FOOD = '*';
    private static final char BORDER = '#';
    private static LinkedList<int[]> snake = new LinkedList<>();
    private static int[] food = new int[2];
    private static char direction = 'R'; // R = right, L = left, U = up, D = down
    private static boolean gameOver = false;
    private static int score = 0;  // Record the score

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Instructions:\n" +
                " w - up;\n " +
                "d - right;\n " +
                "s - down;\n " +
                "a - left;");
        Scanner scanner = new Scanner(System.in);
        initializeGame();

        while (!gameOver) {
            printBoard();
            moveSnake();
            Thread.sleep(300); // Snake speed
            if (scanner.hasNext()) {
                char input = scanner.next().charAt(0);
                changeDirection(input);
            }
        }

        System.out.println("Game Over! Your final score was: " + score);
    }

    private static void initializeGame() {
        // Initialize snake at the center
        snake.add(new int[] { HEIGHT / 2, WIDTH / 2 });

        // Generate first food
        placeFood();
    }

    private static void printBoard() {
        char[][] board = new char[HEIGHT][WIDTH];

        // Fill the board with empty spaces
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i == 0 || i == HEIGHT - 1 || j == 0 || j == WIDTH - 1) {
                    board[i][j] = BORDER; // Set borders
                } else {
                    board[i][j] = EMPTY; // Empty space
                }
            }
        }

        // Place the snake on the board
        for (int[] part : snake) {
            board[part[0]][part[1]] = SNAKE;
        }

        // Place the food on the board
        board[food[0]][food[1]] = FOOD;

        // Print the board
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("Score: " + score); // Print the current score
    }

    private static void moveSnake() {
        int[] head = snake.peekFirst();
        int newHeadRow = head[0];
        int newHeadCol = head[1];

        switch (direction) {
            case 'R': newHeadCol++; break;
            case 'L': newHeadCol--; break;
            case 'U': newHeadRow--; break;
            case 'D': newHeadRow++; break;
        }

        // Check for collision with walls or self
        if (newHeadRow <= 0 || newHeadRow >= HEIGHT - 1 || newHeadCol <= 0 || newHeadCol >= WIDTH - 1 || hitsItself(newHeadRow, newHeadCol)) {
            gameOver = true;
            return;
        }

        // Move snake
        snake.addFirst(new int[] { newHeadRow, newHeadCol });

        // Check if snake has eaten food
        if (newHeadRow == food[0] && newHeadCol == food[1]) {
            score++;  // Increase score when food is eaten
            placeFood(); // Place new food
        } else {
            snake.removeLast(); // Remove the tail if no food eaten
        }
    }

    private static boolean hitsItself(int row, int col) {
        for (int[] part : snake) {
            if (part[0] == row && part[1] == col) {
                return true;
            }
        }
        return false;
    }

    private static void placeFood() {
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(HEIGHT - 2) + 1; // Ensure food is not placed on the border
            col = rand.nextInt(WIDTH - 2) + 1;
        } while (isSnake(row, col)); // Ensure food is not placed on the snake
        food[0] = row;
        food[1] = col;
    }

    private static boolean isSnake(int row, int col) {
        for (int[] part : snake) {
            if (part[0] == row && part[1] == col) {
                return true;
            }
        }
        return false;
    }

    private static void changeDirection(char input) {
        switch (input) {
            case 'w': if (direction != 'D') direction = 'U'; break; // Up
            case 's': if (direction != 'U') direction = 'D'; break; // Down
            case 'a': if (direction != 'R') direction = 'L'; break; // Left
            case 'd': if (direction != 'L') direction = 'R'; break; // Right
        }
    }
}
