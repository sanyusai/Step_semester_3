import java.util.Scanner;

public class GuessTheNumber {

    static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tries = 0;
        boolean guessed = false;

        while (tries < maxTries && tries < guesses.length) {
            int guess = guesses[tries];
            tries++;

            if (guess > secretNumber) {
                System.out.println("Too high");
            } else if (guess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }
        }

        if (!guessed) {
            System.out.println("Out of tries — the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter secret number: ");
        int secretNumber = scanner.nextInt();

        System.out.print("Enter maximum number of tries: ");
        int maxTries = scanner.nextInt();

        int[] guesses = new int[maxTries];

        for (int i = 0; i < maxTries; i++) {
            System.out.print("Enter guess " + (i + 1) + ": ");
            guesses[i] = scanner.nextInt();
        }

        guessTheNumber(secretNumber, maxTries, guesses);

        scanner.close();
    }
}

