package sheridan.stortim.assignment1.domain;

import java.util.*;

public class Letters {

    String letters;

    public Letters(String userInput) {
        this.letters = userInput;
    }

    public String symbolsToSpaces() {

        Alphabet alp = new Alphabet();
        String noSymbols = "";

        for (int i = 0; i < this.letters.length(); i++) {
            String letter = this.letters.substring(i, i + 1);
            if (alp.isInAlphabet(letter)) {
                noSymbols += letter;
            }
            else {
                noSymbols += " ";
            }
        }

        return noSymbols;
    }

    public String getUpper() {
        return this.letters.toUpperCase();
    }
}
