package ru.ledovskikh.andrei;

import ru.ledovskikh.andrei.impl.generator.RandomFileGeneratorImpl;

import java.io.IOException;

/**
 * The big files sorting machine
 *
 */
public class App {

    public static final String INPUT_FILE_NAME = "rawFile.txt";
    public static final String OUTPUT_FILE_NAME = "orderedFile.txt";
    public static final String PATH = "./";

    public static void main( String[] args ) throws IOException {

        new RandomFileGeneratorImpl(PATH + INPUT_FILE_NAME).generateRandomFile();
    }
}
