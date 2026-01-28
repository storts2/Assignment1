package sheridan.stortim.assignment1.domain;

public class Letters {

    String letters;

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
                noSymbols += " ";
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

    public void getUpper() {
        this.letters = this.letters.toUpperCase();
    }

    public String getLetters() {
        return this.letters;
    }
}
