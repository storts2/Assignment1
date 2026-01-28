package sheridan.stortim.assignment1.domain;

import java.util.*;

public class Letters {

    String letters;

    public Letters(String userInput) {
        this.letters = userInput;
    }

    public String symbolsToSpaces() {


        String noSymbols;

        for (int i = 0; i < this.letters.length(); i++) {
            String letter = this.letters.substring(i, i + 1);
        }

        return "a";
    }

    public String getUpper() {
        return this.letters.toUpperCase();
    }
}
