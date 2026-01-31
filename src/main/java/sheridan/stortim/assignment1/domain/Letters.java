package sheridan.stortim.assignment1.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Letters {

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 1, max = 10, message = "Size of input has to be between 1 and 10")
    String letters;

    List<String> lettersList;

    public Letters(String userInput) {
        this.letters = userInput;
    }

    public void symbolsToSpaces() {

        Alphabet alp = new Alphabet();
        String noSymbols = "";

        for (int i = 0; i < this.letters.length(); i++) {
            String letter = this.letters.substring(i, i + 1);
            if (alp.isInAlphabet(letter)) {
                noSymbols += letter;
            }
            else {
                noSymbols += "_";
            }
        }

        this.letters = noSymbols;
    }

    public void encodeForCookies() {
        Alphabet alp = new Alphabet();
        String encode = "";

        for (int i = 0; i < this.letters.length(); i++) {
            String letter = this.letters.substring(i, i + 1);
            if (alp.isInAlphabet(letter)) {
                encode += letter;
            }
            else {
                encode += "&";
            }
        }

        this.letters = encode;
    }

    public void setUpper() {
        this.letters = this.letters.toUpperCase();
    }

    public String getLetters() {
        return this.letters;
    }

    public List<String> getList() {
        return this.lettersList;
    }

    public void initializeList() {
        this.lettersList = new ArrayList<>();

        for (int i = 0; i < this.letters.length(); i++) {
            String letter = this.letters.substring(i, i + 1);
            lettersList.add(letter);
        }
    }
}
