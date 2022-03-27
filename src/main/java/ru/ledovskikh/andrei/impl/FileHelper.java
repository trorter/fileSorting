package ru.ledovskikh.andrei.impl;

import java.io.File;
import java.io.IOException;

/**
 * @author Andrey Ledovskikh
 */
public class FileHelper {

    private static void deleteFile(String path) throws IOException {
        final File file = new File(path);
        if (file.exists()) {
            if (!file.delete()) {
                throw new IOException("Cannot delete the file: " + path);
            }
        }
    }

    public static void checkAndRefreshFile (String path) throws IOException {
        deleteFile(path);

        if (!new File(path).createNewFile()) {
            throw new IOException("Cannot create the file: " + path);
        }
    }

    public static void replaceFiles(String newFileName, String oldFileName) throws IOException {
        deleteFile(newFileName);

        if (!new File(oldFileName).renameTo(new File(newFileName))) {
            throw new IOException("Cannot rename file: " + oldFileName
                    + " to :" + newFileName);
        }
    }
}
