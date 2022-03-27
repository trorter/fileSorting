package ru.ledovskikh.andrei;

import ru.ledovskikh.andrei.impl.generator.RandomFileGeneratorImpl;
import ru.ledovskikh.andrei.impl.sorter.BigFileStringSorterImpl;

import java.io.IOException;
import java.time.LocalTime;

/**
 * The big files sorting machine
 *
 */
public class App {

    public static final String INPUT_FILE_NAME = "rawFile.txt";
    public static final String OUTPUT_FILE_NAME = "orderedFile.txt";
    public static final String PATH = "./";

    public static final int TOTAL_STRING_COUNT = 1000;
    public static final int MAX_WORDS_IN_ROW= 100;

    public static void main( String[] args ) throws IOException {

        System.out.println("START " + LocalTime.now());

        new RandomFileGeneratorImpl(PATH + INPUT_FILE_NAME, TOTAL_STRING_COUNT, MAX_WORDS_IN_ROW).generateRandomFile();

        System.out.println("FILE GENERATED " + LocalTime.now());

        new BigFileStringSorterImpl(
                App.PATH + App.INPUT_FILE_NAME,
                App.PATH + App.OUTPUT_FILE_NAME).sortFile();

        System.out.println("FILE SORTED " + LocalTime.now());
    }
}
