package ru.ledovskikh.andrei.impl.sorter;

import ru.ledovskikh.andrei.impl.FileHelper;
import ru.ledovskikh.andrei.model.sorter.BigFileStringSorter;

import java.io.*;

/**
 * @author Andrey Ledovskikh
 */
public class BigFileStringSorterImpl implements BigFileStringSorter {

    private final String inputFilePath;
    private final String orderedFilePath;
    private final String tmpFilePath;
    private int inputFilePosition = 0;

    public BigFileStringSorterImpl(String inputFilePath, String orderedFilePath) {
        this.inputFilePath = inputFilePath;
        this.orderedFilePath = orderedFilePath;

        this.tmpFilePath="./tmp_sorted_file.txt";
    }

    @Override
    public void sortFile() throws IOException {
        FileHelper.checkAndRefreshFile(this.orderedFilePath);
        FileHelper.checkAndRefreshFile(this.tmpFilePath);

        while (true) {
            final String nextLine = readNextNileFromInputFile();
            if (nextLine == null) {
                break;
            }

            System.out.println(nextLine);

            this.inputFilePosition++;
        }
    }

    private String readNextNileFromInputFile() throws IOException {
        final BufferedReader fileReader = new BufferedReader(new FileReader(new File(this.inputFilePath)));

        String resultString = null;
        for(int i = 0; i <= this.inputFilePosition; i++) {
            resultString = fileReader.readLine();
        }

        fileReader.close();

        return resultString;
    }

}
