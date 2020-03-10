package tsi.javacourses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Turn {
    private SimpleIntegerProperty nr = new SimpleIntegerProperty(this, "nr");
    private SimpleStringProperty guess = new SimpleStringProperty(this, "guess");
    private SimpleIntegerProperty bulls = new SimpleIntegerProperty(this, "bulls");
    private SimpleIntegerProperty cows = new SimpleIntegerProperty(this, "cows");

    public int getNr() {
        return nr.get();
    }

    public SimpleIntegerProperty nrProperty() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr.set(nr);
    }

    public String getGuess() {
        return guess.get();
    }

    public SimpleStringProperty guessProperty() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess.set(guess);
    }

    public int getBulls() {
        return bulls.get();
    }

    public SimpleIntegerProperty bullsProperty() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls.set(bulls);
    }

    public int getCows() {
        return cows.get();
    }

    public SimpleIntegerProperty cowsProperty() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows.set(cows);
    }
}
