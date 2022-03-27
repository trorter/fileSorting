package ru.ledovskikh.andrei.impl.sorter;

import org.apache.commons.lang3.StringUtils;
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
    private int blankLineCount = 0;

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

            if (StringUtils.isEmpty(nextLine)
                    || StringUtils.isBlank(nextLine)) {
                this.blankLineCount++;
                continue;
            }

            sortLine(nextLine);

            this.inputFilePosition++;
        }
    }

    private void sortLine(String nextLine) throws IOException {
        final int insertPosition = findPositionToInputInSortedFile(nextLine);

        rewriteSortedFile(nextLine, insertPosition);
    }

    private void rewriteSortedFile(String newLine, int insertPosition) throws IOException {
        FileHelper.checkAndRefreshFile(this.tmpFilePath);

        //Write first part of the ordeder file
        final BufferedReader orderedFile = new BufferedReader(new FileReader(this.orderedFilePath));
        final FileWriter tmpFile = new FileWriter(this.tmpFilePath);

        for (int i = 0; i < insertPosition; i++) {
            tmpFile.write(orderedFile.readLine() + System.getProperty("line.separator"));
        }

        tmpFile.write(newLine + System.getProperty("line.separator"));

        for (int i = insertPosition; i < this.inputFilePosition; i++) {
            tmpFile.write(orderedFile.readLine() + System.getProperty("line.separator"));
        }

        orderedFile.close();
        tmpFile.close();

        FileHelper.replaceFiles(this.orderedFilePath, this.tmpFilePath);
    }

    private int findPositionToInputInSortedFile(String newLine) throws IOException {
        final BufferedReader fileReader = new BufferedReader(new FileReader(this.orderedFilePath));

        int i = 0;
        for(; i <= this.inputFilePosition; i++) {
            final String currentLine = fileReader.readLine();
            if (currentLine == null
                    || (newLine.compareTo(currentLine) < 0)) {
                break;
            }
        }

        fileReader.close();
        return i;
    }

    private String readNextNileFromInputFile() throws IOException {
        final BufferedReader fileReader = new BufferedReader(new FileReader(this.inputFilePath));

        String resultString = null;
        for(int i = 0; i <= this.inputFilePosition + this.blankLineCount; i++) {
            resultString = fileReader.readLine();
        }

        fileReader.close();

        return resultString;
    }

}
