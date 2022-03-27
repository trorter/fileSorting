package ru.ledovskikh.andrei.test.impl.sorter;

import org.junit.jupiter.api.Test;
import ru.ledovskikh.andrei.App;
import ru.ledovskikh.andrei.impl.sorter.BigFileStringSorterImpl;
import ru.ledovskikh.andrei.model.sorter.BigFileStringSorter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andrey Ledovskikh
 */
class BigFileStringSorterImplTest {

    @Test
    void simpleTest() {
        final BigFileStringSorter sorter = new BigFileStringSorterImpl(
                App.PATH + App.INPUT_FILE_NAME,
                App.PATH + App.OUTPUT_FILE_NAME);
        assertDoesNotThrow(sorter::sortFile);
    }

}