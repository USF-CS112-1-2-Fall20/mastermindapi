package com.example.appengine.java8;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


/**
 * This version of Hangman uses methods and data members
 */
public class HangmanDM implements Serializable {

    // These are the data members. They can be used in any instance method
    public String phrase="";
    public StringBuilder hiddenPhrase=null;
    public String previousGuesses="";

    public static int MAXGUESSES=6;


    /**
     * Creates a list of phrases and then randomly chooses one
     * @return the random phrase
     */
	public String randomPhrase() {
        // Read phrases from file
        // Get random phrase from list
        List<String> phraseList= new ArrayList<String>();
        phraseList.add("We dont see things as they are, we see them as we are.");
        phraseList.add("The aim of life is to live, and to live means to be aware, joyously, drunkenly, serenely, divinely aware.");
        phraseList.add("The most dangerous creation of any society is the man who has nothing to lose.");

        Random random = new Random();
        int r = random.nextInt(phraseList.size());
        phrase = phraseList.get(r);
        return phrase;
    }

    /**
     * replace all letters with *, leave all other chars same
     * @return stringbuilder version, so we can later replace * when guess right
     */
    public StringBuilder getHiddenPhrase() {
        // statement below refers to the data member "phrase"
        //    could have referred to it as "this.phrase"
        StringBuilder hiddenPhrase = new StringBuilder(phrase);

        // hide letters with asterisks in hiddenPhrase
        int i=0;
        while (i<phrase.length()) {
            if (Character.isLetter(phrase.charAt(i))) {
                hiddenPhrase.setCharAt(i,'*');
            }
            i=i+1;
        }
        return hiddenPhrase;
    }

    /**
     * get a guess from user. This is for command-line terminal. Ignore all but first char. keep asking until get valid guess
     * @return the guess
     */
    public char getGuess() {

        System.out.println("previous guesses:"+previousGuesses);
	    System.out.print("Please enter a guess:");
	    Scanner scanner = new Scanner(System.in);
        String guessS = scanner.next();
        char guess = guessS.charAt(0);  // should error check and make sure at least one letter
        while (previousGuesses.contains(guessS)) {
            System.out.println("you have already guessed that, please try a different letter");
            guessS= scanner.next();
            guess = guessS.charAt(0);
        }
	    return guess;

    }

    /**
     * find occurrences of guess in phrase, replace * in corresponding position of hidden
     * @param guess the letter guess
     * @return true if a match
     */
    public HangmanResponse processGuess(char guess) {

        boolean match=false;
        boolean wonGame=false;
        boolean validGuess=true;
        // validate guess
        if (!Character.isLetter(guess)) {
           validGuess=false;
        } else {


            int i = 0;
            while (i < phrase.length()) {
                String guessS = "" + guess;
                String phraseCharS = "" + phrase.charAt(i);
                if (guessS.equalsIgnoreCase(phraseCharS)) {
                    match = true;
                    hiddenPhrase.setCharAt(i, phrase.charAt(i));

                }
                i = i + 1;
            }

            if (hiddenPhrase.toString().equals(phrase)) {
                wonGame = true;
            }
        }
        return new HangmanResponse(wonGame,match,hiddenPhrase.toString(),validGuess);


    }
}