package sheridan.stortim.assignment1.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LettersTest {

    @Test
    void getUpperSuccessful() {
        Letters letters = new Letters("a");
        letters.setUpper();

        Assertions.assertEquals("A", letters.getLetters());
    }

    @Test
    void symbolsToSpacesSuccessful() {
        Letters letters = new Letters("a*&b");
        letters.symbolsToSpaces();

        Assertions.assertEquals("a__b", letters.getLetters());
    }
}
