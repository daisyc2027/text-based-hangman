import java.util.Scanner;

public static void main() {
    Scanner sc = new Scanner(System.in);
    String[] randomWords = new String[]{"Avenue", "Awkward", "Buffalo", "Cobweb", "Duplex", "Fixable", "Galaxy", "Joyful", "Kiwi", "Luxury", "Subway", "Jazz", "Transcript", "Translation", "Waltz"};
    boolean playAgain = true;
    while (playAgain) {
        playGame(randomWords, sc);
        playAgain = sc.nextLine().equals("yes");
    }
    sc.close();
}

public static void playGame(String[] randomWords, Scanner sc) {
    String wordToGuess = randomWordGenerator().toLowerCase();
    System.out.println(wordToGuess);

    char[] guessArray = wordToGuess.toCharArray();
    int numberGuess = 11;


    String usersGuess = "_".repeat(wordToGuess.length());
    char[] usersGuessArray = usersGuess.toCharArray();
    System.out.println(usersGuess);

    System.out.println("You have 11 letter guesses. Please guess your first letter");


    while (numberGuess > 0 && !usersGuess.equals(wordToGuess)) {
        boolean letterGuessed = false;
        try {
            char letterGuess = sc.nextLine().toLowerCase().charAt(0);
            for (int i = 0; i < guessArray.length; i++) {
                if (letterGuess == guessArray[i]) {
                    usersGuessArray[i] = letterGuess;
                    letterGuessed = true;
                }
            }
            if (letterGuessed) {
                System.out.println("You guessed a letter!");
            } else {
                numberGuess--;
                System.out.println("Wrong letter, please try again. You have " + numberGuess + " tries left");
            }
            usersGuess = new String(usersGuessArray);
            System.out.println(usersGuess);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Enter a valid letter");
        }
    }
    if (usersGuess.equals(wordToGuess)) {
        System.out.println("Congrats, you guessed the word! Play again?");
    } else {
        System.out.println("The word was " + wordToGuess + ", better luck next time! Play again?");
    }

}

public static String randomWordGenerator(){
    String[] randomWords = new String[]{"Avenue", "Awkward", "Buffalo", "Cobweb", "Duplex", "Fixable", "Galaxy", "Joyful", "Kiwi", "Luxury", "Subway", "Jazz", "Transcript", "Translation", "Waltz"};
    return randomWords[(int) (Math.random()* randomWords.length-1)];
}
