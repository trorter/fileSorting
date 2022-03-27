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
        final RandomFileGenerator generator = new RandomFileGeneratorImpl(App.PATH + App.INPUT_FILE_NAME);
        assertDoesNotThrow(generator::generateRandomFile);
    }

}