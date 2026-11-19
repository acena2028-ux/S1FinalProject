/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s1finalproject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author acena2028
 */
public class S1FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

// WordBank class describes the state and behavior of WordBank objects
class WordBank {
    // create new Scanner object
    Random r1 = new Random();
    // instantiate new empty word list
    static List<String> words = List.of("ACORN", "AGATE", "AMBER", "ANVIL", "ATLAS", "BADGE", "BENCH", "BISON", "BLAST", "BLAZE", 
            "BLEND", "BRICK", "CEDAR", "CHALK", "CHARM", "CLIMB", "CORAL", "CRISP", "CROWN", "DELTA", "DRIFT", "DWARF", "EAGLE", "ELBOW", 
            "EMBER", "EPOCH", "FANCY", "FJORD", "FLAME", "FLINT", "FLOCK", "FROST", "GHOST", "GIANT", "GLOBE", "HAVEN", "HEDGE", "HONEY", 
            "INDEX", "INLET", "IVORY", "JEWEL", "JOKER", "JOLLY", "KAYAK", "KNIFE", "KOALA", "LEMON", "LOTUS", "LUNAR", "MANGO", "MAPLE", 
            "MIGHT", "MIRTH", "NOBLE", "NOMAD", "NYMPH", "OASIS", "OLIVE", "ONYX", "ORBIT", "PEARL", "PILOT", "PLAZA", "PLUCK", "PRISM", 
            "QUART", "QUEST", "QUICK", "QUILT", "RIDGE", "RIVER", "ROBIN", "SHARK", "SOLAR", "SPARK", "SPICE", "STORM", "SWAMP", "THORN", 
            "TIGER", "TOPAZ", "ULTRA", "UNITY", "URBAN", "VAPOR", "VAULT", "VENUE", "VIPER", "VIVID", "WALTZ", "WHALE", "WIDOW", "WRECK", 
            "YACHT", "YEAST", "ZEBRA", "ZESTY");
    
    // Random Word Selector: selects and returns an item in the list at a randomly generated index
    public String answerSelect() {
        return words.get(r1.nextInt(0, (words.size() - 1)));
    }
}

class WordleGame {
    // instantiate variables and constants
    // guess numbers
    static final int MAX_GUESSES = 6;
    int numGuesses;
    // ANSI color strings
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String GRAY = "\u001B[37m";
    static final String RESET = "\u001B[0m";
    // answer word
    String answer;
    // create new ArrayList of previous guesses
    ArrayList<String> guesses = new ArrayList<>();
    
    
    // Constructor: creates a new Wordle game
    // takes a parameter of the answer word and sets number of guesses to 0
    public WordleGame(String answerP) {
        answer = answerP.toUpperCase();
        numGuesses = 0;
    }
    
    // Evaluate Guess: compares User's inputted word to the answer word
    // increments number of guesses
    // appropriately colors letters, appends colored word to list of previous guesses
    public void EvaluateGuess(String guessP) {
        // increment number of guesses
        numGuesses++;
        // create new String to hold word as it gets colored by letter
        String formattedGuess = "";
        // use a for loop to check each individual letter of the User's guess
        for (int i = 0; i < 5; i++) {
            // temporary String variable for each iteration contains guessP's letter at the index i
            String letter = String.valueOf(guessP.charAt(i));
            if (letter.equals(String.valueOf((answer.charAt(i))))) {
                formattedGuess += (GREEN + letter);
            } else if ((answer.indexOf(letter)) != -1) {
                formattedGuess += (YELLOW + letter);
            } else {
                formattedGuess += (GRAY + letter);
            }
        }
        // add RESET color to avoid color bleeding
        formattedGuess += RESET;
        // append formattedGuess to the end of guesses list
        guesses.add(formattedGuess);
    }
    
    // Display Round: print each item in previous guesses list on a new line, formatted
    public void DisplayRound() {
        // use for loop to print each index
        for (int i = 0; i < guesses.size(); i++) {
            System.out.println(guesses.get(i));
        }
    }
    
    // Is Game Over: if guesses = 6 OR the last guess = the answer word, end the game
    public boolean isGameOver(String lastGuess) {
        return (lastGuess.equals(answer)) || (numGuesses == 6);
    }
    
    // Accessor: returns answer word
    public String answerIs() {
        return answer;
    }
    
    // Accessor: returns number of guesses in the round
    public int numberOfGuesses() {
        return numGuesses;
    }
    
}