package ru.ledovskikh.andrei.test.impl.generator;

import org.junit.jupiter.api.Test;
import ru.ledovskikh.andrei.App;
import ru.ledovskikh.andrei.impl.generator.RandomFileGeneratorImpl;
import ru.ledovskikh.andrei.model.generator.RandomFileGenerator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author Andrey Ledovskikh
 */
class RandomFileGeneratorImplTest {

    @Test
    void testGenerator() {
        final RandomFileGenerator generator = new RandomFileGeneratorImpl(
                App.PATH + App.INPUT_FILE_NAME,
                App.TOTAL_STRING_COUNT,
                App.MAX_WORDS_IN_ROW);
        assertDoesNotThrow(generator::generateRandomFile);
    }

    @Test
    void testAB() {
        System.out.println("a".compareTo("b"));
        System.out.println("b".compareTo("a"));
    }

}