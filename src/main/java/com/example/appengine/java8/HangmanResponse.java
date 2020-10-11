package com.example.appengine.java8;

public class HangmanResponse {
    public HangmanResponse(boolean wonGame, boolean match,String hiddenPhrase,boolean validGuess) {
        this.wonGame=wonGame;
        this.match=match;
        this.hiddenPhrase=hiddenPhrase;
        this.validGuess=validGuess;
    }
    public boolean wonGame;
    public boolean match;
    public boolean validGuess;
    public String hiddenPhrase;
}
