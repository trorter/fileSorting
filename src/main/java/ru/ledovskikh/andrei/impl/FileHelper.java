package ru.ledovskikh.andrei.impl;

import java.io.File;
import java.io.IOException;

/**
 * @author Andrey Ledovskikh
 */
public class FileHelper {

    public static void checkAndRefreshFile (String path) throws IOException {
        final File file = new File(path);
        if (file.exists()) {
            System.out.println("File exists. Delete an existed file");
            if (!file.delete()) {
                throw new IOException("Cannot delete the file: " + path);
            }
        }

        if (!file.createNewFile()) {
            throw new IOException("Cannot create the file: " + path);
        }
    }
}
